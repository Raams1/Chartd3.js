package com.cassandra.dao;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import com.amazonaws.util.json.JSONObject;
import com.cassandra.dao.CassandraClusterManager;

public class CassandraStoreVisitCounterDAO {

	private Session session;
	private Cluster cluster;
	private String StoreDailyVisits = "OfferDailyVisits";
	private String StoreHourlyVisits = "StoreHourlyVisits";
	private String StoreWeeklyVisits = "StoreWeeklyVisit";
	private String StoreMonthlyVisits = "StoreMonthlyVisits";
	private String StoreYearlyVisits = "StoreYearlyVisits";
	private String keyspaceName;
	private String tableName;
	com.datastax.driver.core.ResultSet results=null;

	public CassandraStoreVisitCounterDAO(String keySpace, String tableName) {

		CassandraClusterManager cassandraClusterManager = new CassandraClusterManager();
		this.cluster = cassandraClusterManager.getCluster();
		this.session = cassandraClusterManager.getSession();
		this.keyspaceName = keySpace;
		this.tableName = tableName;
	}

	public Map<String, Object> StoreVisitDayAPI(String storeID, String date,
			String stateID, String merchantID, String cityId, String typeInfo,
			String typeValue) throws ParseException {
		if (typeValue == null) {
			typeValue = "";
		}
		String query = "SELECT uv,nv,rv  FROM " + this.keyspaceName + "."
				+ this.tableName + " where e_d='" + date + "'and sto_id ='"
				+ storeID + "' and type ='" + typeInfo + "' and m_id ='"
				+ merchantID + "' and sta_id = '" + stateID + "' and c_id ='"
				+ cityId + "' and t_val='" + typeValue + "'";
		long uniquevisits = 0L, newVisits = 0L, returnVisits = 0L, totalVisits = 0L;
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("TotalVisitors", totalVisits);
		dataMap.put("NewVisitors", newVisits);
		dataMap.put("ReturnVistors", returnVisits);
		dataMap.put("UniqueVisitors", uniquevisits);
		com.datastax.driver.core.ResultSet results = this.session
				.execute(query);
		for (Row row : results) {
			uniquevisits = row.getLong("uv");
			newVisits = row.getLong("nv");
			returnVisits = row.getLong("rv");
			totalVisits = newVisits + returnVisits;
			dataMap.put("TotalVisitors", totalVisits);
			dataMap.put("NewVisitors", newVisits);
			dataMap.put("ReturnVistors", returnVisits);
			dataMap.put("UniqueVisitors", uniquevisits);
			break;
		}
	 //System.out.println(dataMap);
		
		
		
		return dataMap;
	}


	public Map<String, Object> queryStoreDayWiseVisits(String storeID,
			String startDate, String endDate, String stateID,
			String merchantID, String cityId) throws ParseException {
		Map<String, Object> dataMap=new HashMap<String, Object>();
		List<String> listOfDates = util.getDaysBetweenDates(startDate, endDate);
		Map<String, Object> resultMap = new HashMap<String, Object>();
		//resultMap.put("StoreID", storeID);
		//resultMap.put("Days", listOfDates.size());
		for (String date : listOfDates) {

			 dataMap = StoreVisitDayAPI(storeID, date,
					stateID, merchantID, cityId, StoreDailyVisits, null);

			resultMap.put(date, dataMap);

		}

		return resultMap;
	}

	

	

	

	

	
	// this should be removed . Only to be in CassandraClusterManager - Should  be called.Only in testing 
	public void close() {
		this.cluster.close();

	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		System.out.println("Should be Singleton in web application");// 104.199.133.248
		CassandraStoreVisitCounterDAO client = new CassandraStoreVisitCounterDAO(
				"test", "generic_counter");
		System.out.println("Cassandra Connection Established");
		System.out.println("Execution Started");

		System.out.println("--------------------------------------");

		// Sample Input : StoreId = macy001, Date (yyyymmdd) = 20150606 ,
		// stateid = 01, merchantid = macy , city-id = city001
		Map<String, Object> a = (client.queryStoreDayWiseVisits("H009", "20150717", "20150719", "ST01", "MERTICK20130722004850", "1"));
		System.out.println(a);
		JSONObject b=new JSONObject(a);
		System.out.println(b);
		//"H009",fromDate,toDate,"ST01","MERTICK20130722004850","1"
		
	//	(String storeID, String startDate, String endDate, String stateID, String merchantID, String cityId)

		/*System.out.println(client.queryStoreHourlyVisits("STTICK20141113162011628",
		 "20150101", "20150101", "35", "MERTICK20130722004850", "1"));*/
		
		//(String storeID, String month, String stateID, String merchantID, String cityId)
		
		
		/*System.out.println(client.queryStoreWeeklyVisits("H069", "201507",
				"ST01", "MERTICK20130722004850", "1"));*/
		//(String storeID, String month, String stateID, String merchantID, String cityId)
		
		//(String storeID,int duration, String stateID, String merchantID, String cityId)
		
		//System.out.println(client.queryStoreMonthlyVisits("H069", 3,
				//"ST01", "MERTICK20130722004850", "1"));

		/*System.out.println(client.queryStoreYearlyVisits("macy001", "2015",
				"state01", "macy", "city001"));*/

		client.close();
	}
}
