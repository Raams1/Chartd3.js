package com.beignjava.guys.constants;

public class AppLogConstants {

	public static final String INSTALL_APP_EVENT_LOG = "/event";
	public static final String UPDATE_APP_EVENT_LOG = "/rest/app/update";
	public static final String UNINSTALL_APP_EVENT_LOG = "/rest/app/uninstall";
	public static final String POSTBACK_REQUEST="/hostname/something/callback/{affiliate_id}?";
	
	
	public static final String DAILY_APP_LOG_TOPIC_NAME1="StoreVisit_dev";
	public static final String DAILY_APP_LOG_TOPIC_NAME2= "SensorVisit_dev";
	public static final String DAILY_APP_LOG_TOPIC_NAME3= "OfferView_dev";
	public static final String DAILY_APP_LOG_TOPIC_NAME4="OfferSubscribe_dev";
	
	
	public static final String DAILY_APP_LOG_TOPIC_NAME="dailyEvents";
	public static final String INSTALL_APP_LOG_TOPIC_NAME="installEvents";
	public static final String UNINSTALL_APP_LOG_TOPIC_NAME="UninstallEvents";
	public static final String POSTBACK_TOPIC_NAME="postbacka";
	
	public static final String KAFKA_BROKER_URL="kafka:9092";
	public static final String SERIALIZER_CLASS="kafka.serializer.StringEncoder";
	public static final String REQUEST_REQUIRED_ACKS="1";
	
	
	
	
}
