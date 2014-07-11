package DatabaseConnection;

import com.mongodb.MongoClient;

public enum MongoSingleton {
	INSTANCE;

	private MongoClient mongo;

	public MongoClient getMongo() {
		return mongo;
	}

	private MongoSingleton() {
		try {
			mongo = new MongoClient("localhost",27017);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
}