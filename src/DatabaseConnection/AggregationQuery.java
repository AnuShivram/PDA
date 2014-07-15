// create our pipeline operations, first with the $match
DBObject match = new BasicDBObject("$match", new BasicDBObject("type", "airfare"));

// build the $projection operation
DBObject fields = new BasicDBObject("gender", 1);
fields.put("countr", 1);
fields.put("_id", 0);
DBObject project = new BasicDBObject("$project", fields );

// Now the $group operation
DBObject groupFields = new BasicDBObject( "_id", "$gender");
groupFields.put("count", new BasicDBObject( "$cnt", "$countr"));
DBObject group = new BasicDBObject("$group", groupFields);

// Finally the $sort operation
DBObject sort = new BasicDBObject("$sort", new BasicDBObject("countr", -1));

// run aggregation
List<DBObject> pipeline = Arrays.asList(project, group, sort);
AggregationOutput output = coll.aggregate(pipeline);
