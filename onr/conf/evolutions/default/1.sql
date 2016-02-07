# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table login (
  email                     varchar(255),
  password                  varchar(255))
;




# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table login;

SET FOREIGN_KEY_CHECKS=1;

