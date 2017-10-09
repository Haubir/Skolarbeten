import os, ijson, glob, errno
from pprint import pprint


files_path = '/home/ubuntu/Lab-3/Skolarbeten/Cloud_Lab-3/data/'
files = os.listdir(files_path)

files_retweeted_json = ijson.items(files, 'retweeted')
not_retweeted = (false_r for false_r in files_retweeted_json if false_r == 'false')

def load_json(filename, attribute):
	with open(filename, attribute) as fd:
		parser = ijson.parse(fd)
		ret = {'builders': {}}
		for prefix, event, value in parser:
			if (prefix, event) == ('builders', 'map_key'):
				buildername = value
				ret['builders'][buildername] = {}
			elif prefix.endswith('.shortname'):
				ret['builders'][buildername]['shortname'] = value

		return ret

#for file in files:
#	file_json = ijson.loads(file)
#	print file_json['retweeted']
#	if file_json[u'retweeted'].lower() == u'true'
#		retweeted.append(file)



print(len(files))
print("count of un-retweeted tweets: " + len(not_retweeted))
