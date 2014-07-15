package DatabaseConnection;

import java.util.ArrayList;
import java.util.List;


import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.BasicDBObject;
import com.mongodb.AggregationOutput;



public class AggregationQuery {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MongoClient mongo = MongoSingleton.INSTANCE.getMongo();
		DB db = mongo.getDB("pda");
		DBCollection user = db.getCollection("friends");
		
		/*Look for just the filter, in this case where gender='female' */
		BasicDBObject query = new BasicDBObject("gender", "female"); 
		DBCursor cursor = user.find(query);
		try {
			while (cursor.hasNext()) {
				System.out.println(cursor.next());
			}

		} finally {
			cursor.close();
		}

		
		
		/*Agg queries to get Male / Female count */
		System.out.println("Male friends "+user.count(new BasicDBObject("gender","male")));
		System.out.println("Female friends  "+user.count(new BasicDBObject("gender","female")));





	}

}

