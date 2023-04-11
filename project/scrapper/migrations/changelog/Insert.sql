insert into "user" (chat_id, username, first_name, last_name)
values (1, 'testUser42', 'test', 'SAM'),
       (2, 'testUser34', 'test', 'SAM'),
       (3, 'testUser65', 'test', 'SAM'),
       (4, 'testUser45', 'test', 'SAM'),
       (5, 'testUser523', 'test', 'SAM'),
       (6, 'testUser645', 'test', 'SAM'),
       (7, 'testUser7452', 'test', 'SAM'),
       (8, 'testUser44562', 'test', 'SAM'),
       (9, 'testUser423452', 'test', 'SAM'),
       (10, 'testUser2', 'test', 'SAM');

insert into "link" (url, updated_at)
values ('https://stackoverflow.com/questions/14141266/postgresql-foreign-key-on-delete-cascade', '2022-05-19 15:13:27'),
       ('https://github.com/linus/doctest','2022-01-31 13:13:50'),
       ('https://github.com/lwbeamer/point-on-area','2021-12-22 22:34:25'),
       ('https://stackoverflow.com/questions/2336692/java-multiple-class-declarations-in-one-file','2023-03-27 09:58:45');

insert into "user_link" (link_id, chat_id)
values (1,1),
       (1,2),
       (1,3),
       (1,3),
       (2,4),
       (2,5),
       (2,6),
       (2,7),
       (3,1),
       (3,2),
       (3,72);