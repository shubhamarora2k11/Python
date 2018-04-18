# -*- coding: utf-8 -*-
"""
Created on Wed Apr 18 21:17:49 2018

@author: Shubham Arora
"""

import pandas as pd
import re

def replace_main(dataframe1):
    dataframe2=dataframe1
    i=0
    for row in dataframe1['short_description']:
             replaced = re.sub('(\w+(\-||)\w+\.\w+\.[a-z0-9.]*)', '' , row ) 
             replaced = re.sub('on\s\w+-\w+', '' , row ) 
             
             replaced = re.sub('[0-9]', '', replaced ) 
             replaced = re.sub('((\w+||)\@vm-_.+\@)', '', replaced ) 
             replaced = re.sub('(\.\/.+)', '', replaced ) 
             replaced = re.sub("[\"_'()%:.,/<\\\>=#\]\[-]", ' ', replaced ) 
             replaced = re.sub("\s[A-Za-z]\Z", ' ', replaced ) 
             replaced = re.sub("\s[A-Za-z]\s", ' ', replaced ) 
             replaced = re.sub("\s\s+", ' ', replaced ) 
             replaced = replaced.lower()
             replaced = re.sub('database\s.+\sstatus\sis', 'database status', replaced ) 
             replaced = re.sub('host\s\w+.+\sis unreachable', 'host is unreachable', replaced ) 
             replaced = re.sub('.+\sping\sdevice\savailability', 'ping device availability', replaced ) 
             replaced = re.sub('.+\svmware vcenter', 'vmware vcenter', replaced ) 
             
             dataframe2['short_description'][i]= replaced
             i+=1
            
    return dataframe2

def main():
    dataframe1 = pd.read_csv("FileName.csv") 
    dataframe2= replace_main(dataframe1)
    print(dataframe2['short_description'])

main()
