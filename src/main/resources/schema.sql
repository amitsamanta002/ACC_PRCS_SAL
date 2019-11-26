create table ANA_PSN_INFO
(
   ID integer not null,
   ACC_NUM char(12) not null,
   ACC_HLDR_NME varchar(500) not null,
   ACC_HLDR_ADDR varchar(1000) not null,
   primary key(ID)
);