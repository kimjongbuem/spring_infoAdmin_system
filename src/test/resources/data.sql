insert into person(id, name, age, blood ,birthday_year,birthday_month,birthday_day) values(1, 'kjb', 26, 'B', 1996, 3, 7);
insert into person(id, name, age, blood ,birthday_year,birthday_month,birthday_day)  values(2, 'kej', 24, 'O', 1996, 3, 25);
insert into person(id, name, age, blood ,birthday_year,birthday_month,birthday_day)   values(3, 'kcb', 54, 'B', 1968, 2, 14);
insert into person(id, name, age, blood ,birthday_year,birthday_month,birthday_day)  values(4, 'ims', 52, 'A', 1970, 12, 28);
insert into person(id, name, age, blood ,birthday_year,birthday_month,birthday_day)  values(5, 'igy', 53, 'A', 1969, 12, 24);
insert into person(id, name, age, blood ,birthday_year,birthday_month,birthday_day)  values(6, 'kez', 24, 'AB', 1998, 4, 23);
insert into person(id, name, age, blood ,birthday_year,birthday_month,birthday_day)  values(7, 'cjh', 26, 'B', 1996, 3 , 8);

insert into block(id, name) values(1, 'kjb');
insert into block(id, name) values(2, 'cjh');

update person set block_id = 1 where id = 1;
update person set block_id = 2 where id = 7;