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
			
			MongoClient mongo = MongoSingleton.INSTANCE.getMongo();
			DB db = mongo.getDB("PDA");
			DBCollection user = db.getCollection("User");

			BasicDBObject andQuery = new BasicDBObject();
			List<BasicDBObject> obj = new ArrayList<BasicDBObject>();
			
			obj.add(new BasicDBObject("email", email));
			obj.add(new BasicDBObject("password", password));
			andQuery.put("$and", obj);
			
			DBCursor cursor = user.find(andQuery);
			if (cursor.size() == 1 )
				return "success";

		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
				
		return "error";
	}
	
	public ArrayList<String> getAboutme() {
		
		ArrayList<String> friends = new ArrayList<String>();
		try {
		
			MongoClient mongo = MongoSingleton.INSTANCE.getMongo();
         	DB db = mongo.getDB("PDA");
			DBCollection coll = db.getCollection("Facebook");
			
			DBCursor cursor = coll.find();
			try {
			   while(cursor.hasNext()) {
			       friends.add(cursor.next().toString());
			       System.out.println(cursor.next().toMap());
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


