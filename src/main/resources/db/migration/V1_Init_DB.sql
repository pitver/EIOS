INSERT INTO eios.usr
(usr_type,
id,
active,
email,
first_name,
last_name,
password,
patronymic,
login)
VALUES
('user',
1,
true,
'admin@admin',
'admin',
'admin',
'$2y$12$ztdS6dUZT3j.A0xdR41hGeGWed/eV36LVorr/NpzIdOKq49xksvaq',
'admin',
'admin');



INSERT INTO eios.user_role
(user_id,roles)
VALUES
(1,'ADMIN');
