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

DROP TABLE APS.CUST_TRAN;
CREATE TABLE IF NOT EXISTS APS.CUST_TRAN(
    transactionId TIMESTAMP DEFAULT CURRENT_TIMESTAMP, 
    customerNumber INT, 
    transactionType CHAR(02), 
    transactionAmount DOUBLE, 
    transactionSource CHAR(05),
    transactionStatus CHAR(10),
    PRIMARY KEY(transactionId,customerNumber),
    FOREIGN KEY(customerNumber) 
            REFERENCES APS.CUST_DETL(customerNumber)
);

DROP TABLE APS.CUST_ACCOUNT;

CREATE TABLE IF NOT EXISTS APS.CUST_ACCOUNT(
    customerNumber INT, 
    accountNumber  INT, 
    accountCatgorie CHAR(10), 
    currentBalance  DOUBLE,
    createTimestamp TIMESTAMP,
    PRIMARY KEY(customerNumber,accountNumber,accountCatgorie),
    FOREIGN KEY(customerNumber) 
            REFERENCES APS.CUST_DETL(customerNumber)
)
;
DROP TABLE APS.CUST_CREDITCARD;

CREATE TABLE IF NOT EXISTS APS.CUST_CREDITCARD(
    customerNumber INT, 
    creditcardNumber  INT, 
    currentLimit DOUBLE, 
    maxLimit  DOUBLE,
    createTimestamp TIMESTAMP,
    PRIMARY KEY(customerNumber,creditcardNumber),
    FOREIGN KEY(customerNumber) 
            REFERENCES APS.CUST_DETL(customerNumber)
)

call APS.UPDATE_CUST_DETL();
call APS.UPDATE_CUST_ACCOUNT();

select CONCAT(customerLastName, ' ', customerFirstName) as customerName from APS.CUST_DETL

SELECT * FROM APS.CUST_DETL

DELETE FROM APS.CUST_DETL
 WHERE customerLastName IS NULL;
