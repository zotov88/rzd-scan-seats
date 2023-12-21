drop table rzd.seats;
drop table rzd.carriages;
drop table rzd.trains;
drop table rzd.routes;
drop table rzd.users;
-- drop table rzd.roles;

insert into rzd.users(email, login, password)
values ('z@mail', 'zot', '12345');

insert into rzd.routes(city_from, city_to, date, user_id)
values ('Moscow', 'Saratov', '2023-12-12', 1);

insert into rzd.trains(name, route_id)
values ('047Й', 1);

insert into rzd.carriages(number, train_id)
values ('4', 1);

insert into rzd.seats(name, carriage_id)
values ('Low', 1),
       ('Up', 1);

delete from rzd.users
where id = 1;

create unique index users_login_idx on rzd.users(login);
drop index rzd.users_login_idx;


select *,
       min(price) over(partition by type)
from rzd.seats;

delete from rzd.routes
where id = 25;

truncate rzd.routes cascade;



delete from rzd.trains where id = 30;









