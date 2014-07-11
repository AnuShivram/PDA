import requests
import json
import sys
from pymongo import MongoClient

base_url = 'https://graph.facebook.com/me'


ACCESS_TOKEN=''+sys.argv[1]




# Get 10 likes for 10 friends
fields = ''+sys.argv[2]

url = '%s?fields=%s&access_token=%s' % (base_url, fields, ACCESS_TOKEN,)

# This API is HTTP-based and could be requested in the browser,
# with a command line utlity like curl, or using just about
# any programming language by making a request to the URL.
# Click the hyperlink that appears in your notebook output
# when you execute this code cell to see for yourself...
print url

# Interpret the response as JSON and convert back
# to Python data structures
content = requests.get(url).json()



# Pretty-print the JSON and display it
# print json.dumps(content,indent=1)


client = MongoClient('localhost',27017)
db = client.pda
tab = db.posts
tab.insert(content)

