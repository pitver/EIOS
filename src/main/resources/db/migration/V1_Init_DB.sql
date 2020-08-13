insert into usr (usr_type,id,active,first_name,last_name,password, patronymic, login)
    values ('user', 1,true,'admin','admin', '123','admin''admin','admin');

insert into user_role (user_id, roles)
    values (1, 'USER'), (1, 'ADMIN');