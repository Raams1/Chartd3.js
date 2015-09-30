package com.cassandra.dao;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;


// Make the class as Singleton and AutoWired
public class CassandraClusterManager {
	
	private Session session;
	private Cluster cluster;
	
	
	private String node  = "localhost";
	//private String node  = "104.199.135.120"; // IP Here. Or Load it from Util Files from Property in COnstructor.
	
	public CassandraClusterManager(){
		this.cluster = Cluster.builder().addContactPoint(node).build();
		this.session = cluster.connect();
	}
	
	public Session getSession(){
		return this.session;
	}
	public Cluster getCluster(){
		return this.cluster;
	}
	

}
