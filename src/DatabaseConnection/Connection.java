package DatabaseConnection;

import com.mongodb.*;

import java.rmi.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static java.util.concurrent.TimeUnit.SECONDS;

public class Connection {


	

	public String authenticate(String email,String password ){
		try {
			
			MongoClient mongo = new MongoClient("localhost",27017);
			
			DB db = mongo.getDB("PDA");
			DBCollection user = db.getCollection("User");

			BasicDBObject andQuery = new BasicDBObject();
			List<BasicDBObject> obj = new ArrayList<BasicDBObject>();
			obj.add(new BasicDBObject("email", email));
			obj.add(new BasicDBObject("password", password));
			andQuery.put("$and", obj);
			

			DBCursor cursor = user.find(andQuery);
			mongo.close();
			if (cursor.size() == 1 )
				return "success";


		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		
		return "error";
	}
	
	public ArrayList<String> getFriends() {
		
		ArrayList<String> friends = new ArrayList<String>();
		try {
		
			MongoClient mongo = new MongoClient("localhost",27017);

			DB db = mongo.getDB("PDA");
			DBCollection coll = db.getCollection("FB");
			
			DBCursor cursor = coll.find();
			try {
			   while(cursor.hasNext()) {
			       friends.add(cursor.next().toString());
			   }
			} finally {
			   cursor.close();
			}
			

		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}

		return friends;
		
	}


}


