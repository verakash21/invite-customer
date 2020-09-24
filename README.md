# invite-customer
Java Maven Project

# ABOUT PROJECT
Creates an invitation list of customer within 100KM of given location from a txt file containing all the required information in json format.

The project is written in Java language and built using Apache Maven.
TO build this project I have used Java 1.8 and Apache Maven 3.6.3 (cecedd343002696d0abb50b32b541b8a6ba2883f).

The project builds a fat jar of 124KB which includes all the dependencies. This allows to skip giving path of each jar seperately.

Arguments to be passed.
 -i,--input <arg>    input file path
 -o,--output <arg>   output file

Input file: List of customer records sperated by newline. Each line is a json string of customer recods like this: {"latitude": "52.986375", "user_id": 12, "name": "Christina McArdle", "longitude": "-6.043701"}

Ouput File: List of customer within 100KM range of this location(53.339428, -6.257664) sorted by user_id (ascending). 

# To RUN THIS PROJECT
#Go to project home directory:
cd invite-customer/

#To install maven project with tests run command: 
mvn clean install

#To install maven project without running test run command:
mvn clean install -DskipTests

#Once build succeeds run following command to execute code (change the input file path):
java -cp target\invite-customer-0.0.1-SNAPSHOT-jar-with-dependencies.jar com.intercom.invite.customer.core.CustomerList -i customers.txt -o filteredList.txt

# Demo
customers.txt contains potential list of customer and the program gives the filtered list of customer in output.txt file.

\invite-customer>java -cp target\invite-customer-0.0.1-SNAPSHOT-jar-with-dependencies.jar com.intercom.invite.customer.core.CustomerList -i customers.txt -o output.txt

Sep 24, 2020 1:37:21 PM com.intercom.invite.customer.core.CustomerList processCustomerList
INFO: Processing File customers.txt

Sep 24, 2020 1:37:21 PM com.intercom.invite.customer.utils.OutputWriter storeMapToFile
INFO: Storing output in file output.txt

Sep 24, 2020 1:37:21 PM com.intercom.invite.customer.core.CustomerList main
INFO: Execution Finished.
