/*==============================================================*/
/* DBMS name:      ORACLE Version 10gR2                         */
/* Created on:     2021/1/12 11:25:57                           */
/*==============================================================*/


alter table customer_order
   drop constraint FK_CUSTOMER_REFERENCE_CUSTOMER;

alter table customer_order
   drop constraint FK_CUSTOMER_REFERENCE_ORDERS;

alter table orders
   drop constraint FK_ORDERS_REFERENCE_FLIGHT;

drop table customer cascade constraints;

drop table customer_order cascade constraints;

drop table flight cascade constraints;

drop table orders cascade constraints;

/*==============================================================*/
/* Table: customer                                              */
/*==============================================================*/
create table customer  (
   customer_id          VARCHAR2(32)                    not null,
   customer_type        VARCHAR2(10),
   name                 VARCHAR2(20),
   phone                VARCHAR2(20),
   card_id              VARCHAR2(18),
   birthday             DATE,
   constraint PK_CUSTOMER primary key (customer_id)
);

/*==============================================================*/
/* Table: customer_order                                        */
/*==============================================================*/
create table customer_order  (
   customer_id          VARCHAR2(32),
   order_id             VARCHAR2(32)
);

/*==============================================================*/
/* Table: flight                                                */
/*==============================================================*/
create table flight  (
   flight_id            VARCHAR2(32)                    not null,
   plane_type           VARCHAR2(20),
   seats_no             VARCHAR2(20),
   total_seats_num      NUMBER(3),
   departure_airport    VARCHAR2(30),
   destination_airport  VARCHAR2(30),
   departure_time       VARCHAR2(20),
   constraint PK_FLIGHT primary key (flight_id)
);

/*==============================================================*/
/* Table: orders                                                */
/*==============================================================*/
create table orders  (
   order_id             VARCHAR2(32)                    not null,
   flight_id            VARCHAR2(32),
   jpjg                 NUMBER(7,2),
   air_port_tax         NUMBER(7,2),
   ryf                  NUMBER(7,2),
   hkzhx                NUMBER(7,2),
   jptgx                NUMBER(7,2),
   yhq                  NUMBER(7,2),
   hszj                 NUMBER(7,2),
   constraint PK_ORDERS primary key (order_id)
);

alter table customer_order
   add constraint FK_CUSTOMER_REFERENCE_CUSTOMER foreign key (customer_id)
      references customer (customer_id);

alter table customer_order
   add constraint FK_CUSTOMER_REFERENCE_ORDERS foreign key (order_id)
      references orders (order_id);

alter table orders
   add constraint FK_ORDERS_REFERENCE_FLIGHT foreign key (flight_id)
      references flight (flight_id);

