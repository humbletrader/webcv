create database cvdb;

create user 'cvdbuser' identified by 'secretofcvdbuser';

grant select on cvdb.* to cvdbuser;
grant insert on cvdb.* to cvdbuser;
grant delete on cvdb.* to cvdbuser;
grant update on cvdb.* to cvdbuser;
