#Replace COLUMN_NAME with your column
#Replace FILENAME with your csv filename
#Replace REGEX with your requirements like (\w+(\-||)\w+\.\w+\.[a-z0-9.]*)

import pandas as pd
import re

def replace_main(dataframe1):
    dataframe2=dataframe1
    i=0
    for row in dataframe1['COLUMN_NAME']: 
             replaced = re.sub('REGEX', 'REPLACE_WITH', row) 
             dataframe2['COLUMN_NAME'][i]= replaced
             i+=1
    return dataframe

def main():
    dataframe1 = pd.read_csv("FILE_NAME.csv") 
    dataframe2= replace_main(dataframe1)
    print(dataframe2['COLUMN_NAME'])

main()

