create database cvdb;

create appUser 'cvdbuser' identified by 'secretofcvdbuser';

grant select on cvdb.* to cvdbuser;
grant insert on cvdb.* to cvdbuser;
grant delete on cvdb.* to cvdbuser;
grant update on cvdb.* to cvdbuser;


drop table if exists certification CASCADE;
drop table if exists certification_users CASCADE;
drop table if exists company CASCADE;
drop table if exists experience CASCADE;
drop table if exists appUser CASCADE;
drop table if exists user_certifications CASCADE;
drop sequence if exists hibernate_sequence;
create sequence hibernate_sequence start with 1 increment by 1;
create table certification (id integer not null, certification_name varchar(255), primary key (id));
create table certification_users (certification_id integer not null, users_id integer not null, primary key (certification_id, users_id));
create table company (id integer not null, name varchar(255), primary key (id));
create table experience (id integer not null, end date, job_title varchar(255), start date, company_id integer, user_id integer, primary key (id));
create table appUser (id integer not null, first_name varchar(255), last_name varchar(255), photo_link varchar(255), username varchar(255), primary key (id));
create table user_certifications (user_id integer not null, certifications_id integer not null, primary key (user_id, certifications_id));
alter table certification_users add constraint FKh9y8gwcl7k45sje598fqi39wo foreign key (users_id) references appUser;
alter table certification_users add constraint FKb9rqw1y30dbjln11i49h7dm15 foreign key (certification_id) references certification;
alter table experience add constraint FKfnhfue8bjghnfyjqrxnlgndso foreign key (company_id) references company;
alter table experience add constraint FK41lup37auw1bvwwqpgn0blbic foreign key (user_id) references appUser;
alter table user_certifications add constraint FK56brfswi9d588waexxkvcg044 foreign key (certifications_id) references certification;
alter table user_certifications add constraint FKa0hui5lh4nflm8oojgvcg4ewc foreign key (user_id) references appUser;

