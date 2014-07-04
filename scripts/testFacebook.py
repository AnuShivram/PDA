import requests
import json
import sys

base_url = 'https://graph.facebook.com/me'


#ACCESS_TOKEN='250848248435335|mNpexGjKJ9um-xU5Vbr65O_kHKQ' 
#ACCESS_TOKEN='CAADkJSi9kocBAGPdKseCn9kebsjfEZAXlTZAOIvURPP3pU3xObZBW8HPI0tQhNdmGJOZBxkbZAWrRZCbMSpLaaiOwnZCZClzwFbuqXUZAZCX6fpvjGtjdSACHOEwYXf3lqnrJZAVKOIqRZA9uv2sjGl0jBkZCyEgLZBJKpf8hZBVzFW6hhHebe2e0EOjxMzxXDIZCIIMVONokeY5Kyb99gZDZD'
ACCESS_TOKEN='CAACEdEose0cBAEaYZCxZBdpbchTg6neZAiM8v2WCTqA2lKYb4LFnZCUAzdQFnWWVRhFcMPWjAcV9FNJEbmAQ3AfsklWf6IEZAkczsGxdG3hDBlGEcttNgJKeiMzyLfSeRGZCHhtOUln4NIpm9kLHZBOcHBnA2vTmTFwvm3ZBZB1HP9gclpavZAZC8cZAiGdAlMv5xkZCHThBZCvFq16wZDZD'

# Get 10 likes for 10 friends
fields = ''+sys.argv[1]

url = '%s?fields=%s&access_token=%s' % \
    (base_url, fields, ACCESS_TOKEN,)

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
print json.dumps(content,indent=1)
