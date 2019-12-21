CREATE DATABASE APS;

CREATE TABLE IF NOT EXISTS APS.CUST_DETL(
    customerNumber INT AUTO_INCREMENT,
    customerLastName VARCHAR(50), 
    customerFirstName VARCHAR(60), 
    phone VARCHAR(10), 
    addressLine1 CHAR(150),
    addressLine2 CHAR(150),
    city VARCHAR(50),
    state VARCHAR(50),
    postalCode CHAR(06),
    country VARCHAR(150),
    email VARCHAR(250),
    PRIMARY KEY(customerNumber)
);

CREATE TABLE IF NOT EXISTS APS.CUST_TRAN(
    transactionId TIMESTAMP DEFAULT CURRENT_TIMESTAMP, 
    customerNumber INT, 
    transactionType CHAR(02), 
    transactionAmount DOUBLE, 
    transactionSource CHAR(05),
    transactionStatus CHAR(10),
    PRIMARY KEY(transactionId,customerNumber),
    FOREIGN KEY(customerNumber) 
            REFERENCES classicmodels.customers(customerNumber)
)

CREATE TABLE IF NOT EXISTS APS.CUST_ACCOUNT(
    customerNumber INT, 
    accountNumber  INT, 
    accountCatgorie CHAR(10), 
    currentBalance  DOUBLE,
    createTimestamp TIMESTAMP,
    PRIMARY KEY(customerNumber,accountNumber,accountCatgorie),
    FOREIGN KEY(customerNumber) 
            REFERENCES classicmodels.customers(customerNumber)
)
;
CREATE TABLE IF NOT EXISTS APS.CUST_CREDITCARD(
    customerNumber INT, 
    creditcardNumber  INT, 
    currentLimit DOUBLE, 
    maxLimit  DOUBLE,
    createTimestamp TIMESTAMP,
    PRIMARY KEY(customerNumber,creditcardNumber),
    FOREIGN KEY(customerNumber) 
            REFERENCES classicmodels.customers(customerNumber)
)
