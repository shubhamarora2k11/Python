import re

string = "Host GBBR-FS01P.corp.u4agr.com: 10.44.8.130 is unreachable."
replaced_string = re.sub('(\w+\-\w+\.\w+\.[a-z0-9.]*)', '', string)

print (replaced_string) 
