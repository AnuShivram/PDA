import requests
import json
import sys
from pymongo import MongoClient

base_url = 'https://graph.facebook.com/me'


ACCESS_TOKEN=''+sys.argv[1]

# Get 1['friends'] likes for 1['friends'] friends
fields = ''+sys.argv[2]

url = '%s?fields=%s&access_token=%s' % (base_url, fields, ACCESS_TOKEN,)

# This API is HTTP-based and could be requested in the browser,
# with a command line utlity like curl, or using just about
# any programming language by making a request to the URL.
# Click the hyperlink that appears in your notebook output
# when you execute this code cell to see for yourself...
#print url

# Interpret the response as JSON and convert back
# to Python data structures

content = requests.get(url).json()
total = []
#print content['friends']['data']
#content=json.dumps(contentf)
#content=json.loads(contentd)
##content=json.load(contentf)
#
#print  content['friends']['data']

contentl=content['friends']['data']


client = MongoClient('localhost',27017)
db = client.pda
tab = db.friends


for loadobj in contentl:
     tab.insert(loadobj)    

#while content['friends']['data'] is not []:
#    nextlink = content['friends']['paging']['next']
#    print nextlink
#    content = requests.get(nextlink).json()
#    print content




## Pretty-print the JSON and display it
#print json.dumps(content,indent=1)
#
## Connect to MongoDB and load into it
#
#
