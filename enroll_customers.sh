#!/bin/bash
echo " Customer 1"
curl -k --request POST \
--url http://localhost:8080/AccountService/addCustomerDetails \
--header 'content-type: application/json' \
--data '{"customerId": "John1234","firstName": "John","lastName": "Dave",	"balance": "3000","accountNumber": "1111"}'
		  
echo " Customer 2"
curl -k --request POST \
--url http://localhost:8080/AccountService/addCustomerDetails \
--header 'content-type: application/json' \
--data '{"customerId": "Alice1234","firstName": "Alice","lastName": "Johnson",	"balance": "5000","accountNumber": "1221"'
	
	
echo " Customer 3"
curl -k --request POST \
--url http://localhost:8080/AccountService/addCustomerDetails \
--header 'content-type: application/json' \
--data '{"customerId": "Joy1234","firstName": "Joy","lastName": "Greene",	"balance": "7500","accountNumber": "1145"'
	
echo " Customer 4"
curl -k --request POST \
--url http://localhost:8080/AccountService/addCustomerDetails \
--header 'content-type: application/json' \
--data '{"customerId": "Bob1234","firstName": "Bob","lastName": "Dave",	"balance": "3500","accountNumber": "2211"'
	
echo " Customer 5"
curl -k --request POST \
--url http://localhost:8080/AccountService/addCustomerDetails \
--header 'content-type: application/json' \
--data '{"customerId": "Tywin1234","firstName": "Tywin","lastName": "Dave",	"balance": "3007","accountNumber": "1911"'
	
echo " Customer 6"
curl -k --request POST \
--url http://localhost:8080/AccountService/addCustomerDetails \
--header 'content-type: application/json' \
--data '{"customerId": "Richard1234","firstName": "Richard","lastName": "Davis",	"balance": "30000","accountNumber": "1561"'
	
echo " Customer 7"
curl -k --request POST \
--url http://localhost:8080/AccountService/addCustomerDetails \
--header 'content-type: application/json' \
--data '{"customerId": "Claire1234","firstName": "Claire","lastName": "Ross",	"balance": "3070","accountNumber": "8761"'
	
echo " Customer 8"
curl -k --request POST \
--url http://localhost:8080/AccountService/addCustomerDetails \
--header 'content-type: application/json' \
--data '{"customerId": "Dona1234","firstName": "Dona","lastName": "Specter",	"balance": "3090","accountNumber": "8911"'
	
echo " Customer 9"
curl -k --request POST \
--url http://localhost:8080/AccountService/addCustomerDetails \
--header 'content-type: application/json' \
--data '{"customerId": "Luis1234","firstName": "Luis","lastName": "Litt",	"balance": "9000","accountNumber": "6511"'
	
echo " Customer 10"
curl -k --request POST \
--url http://localhost:8080/AccountService/addCustomerDetails \
--header 'content-type: application/json' \
--data '{"customerId": "Bryan1234","firstName": "Bryan","lastName": "Dave",	"balance": "4000","accountNumber": "1911"'
	