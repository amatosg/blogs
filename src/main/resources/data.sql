insert into author (name, email, phone, birthdate) values ('Mario Vargas Llosa', 'mario@gmail.com','999999999', '1936-03-28');
insert into author (name, email, phone, birthdate) values ('Pepito Perez', 'pepe@gmail.com','999999999', '1936-03-28');
insert into author (name, email, phone, birthdate) values ('Ani Espinoza', 'ani@gmail.com','999999999', '1996-04-18');

insert into blog (name, description, url, status, author_id) values ('Blog de Mario 1', 'este es el blog de mario 1','https://mario.com', 'activo', 1);
insert into blog (name, description, url, status, author_id) values ('Blog de Mario 2', 'este es el blog de mario 2','https://mario.com', 'inactivo', 1);
insert into blog (name, description, url, status, author_id) values ('Blog de Mario 3', 'este es el blog de mario 3','https://mario.com', 'activo', 1);
insert into blog (name, description, url, status, author_id) values ('Blog de Pepito 1', 'este es el blog de Pepito 1','https://pepito.com', 'activo', 2);
insert into blog (name, description, url, status, author_id) values ('Blog de Pepito 1', 'este es el blog de Pepito 1','https://pepito.com', 'activo', 2);
insert into blog (name, description, url, status, author_id) values ('Blog de Ani 1', 'este es el blog de Ani 1','https://ani.com', 'activo', 3);
insert into blog (name, description, url, status, author_id) values ('Blog de Ani 2', 'este es el blog de Ani 2','https://ani.com', 'activo', 3);

insert into post (title, date, status, content, blog_id) values ('Mi primer post', NOW(), 'publicado','Este es mi primer post y no estoy seguro del contenido', 1);
insert into post (title, date, status, content, blog_id) values ('Mi primer post', NOW(), 'publicado','Este es mi primer post y no estoy seguro del contenido', 2);
insert into post (title, date, status, content, blog_id) values ('Mi segundo post', NOW(), 'publicado','Este es mi primer post y no estoy seguro del contenido', 2);
insert into post (title, date, status, content, blog_id) values ('Mi primer post', NOW(), 'borrador','Este es mi primer post y no estoy seguro del contenido', 3);
insert into post (title, date, status, content, blog_id) values ('Mi primer post', NOW(), 'publicado','Este es mi primer post y no estoy seguro del contenido', 4);
insert into post (title, date, status, content, blog_id) values ('Mi primer post', NOW(), 'publicado','Este es mi primer post y no estoy seguro del contenido', 5);
insert into post (title, date, status, content, blog_id) values ('Mi primer post', NOW(), 'publicado','Este es mi primer post y no estoy seguro del contenido', 7);

insert into comment (date, name, status, comment, post_id) values (NOW(), 'Comentador 1', 'activo', 'este es un comentario', 1);
insert into comment (date, name, status, comment, post_id) values (NOW(), 'Comentador 1', 'activo', 'este es un comentario', 1);
insert into comment (date, name, status, comment, post_id) values (NOW(), 'Comentador 1', 'activo', 'este es un comentario', 2);
insert into comment (date, name, status, comment, post_id) values (NOW(), 'Comentador 1', 'activo', 'este es un comentario', 2);
insert into comment (date, name, status, comment, post_id) values (NOW(), 'Comentador 1', 'activo', 'este es un comentario', 3);
insert into comment (date, name, status, comment, post_id) values (NOW(), 'Comentador 1', 'activo', 'este es un comentario', 5);
insert into comment (date, name, status, comment, post_id) values (NOW(), 'Comentador 1', 'activo', 'este es un comentario', 5);
insert into comment (date, name, status, comment, post_id) values (NOW(), 'Comentador 1', 'activo', 'este es un comentario', 5);
insert into comment (date, name, status, comment, post_id) values (NOW(), 'Comentador 1', 'activo', 'este es un comentario', 6);
insert into comment (date, name, status, comment, post_id) values (NOW(), 'Comentador 1', 'activo', 'este es un comentario', 7);
insert into comment (date, name, status, comment, post_id) values (NOW(), 'Comentador 1', 'activo', 'este es un comentario', 7);
insert into comment (date, name, status, comment, post_id) values (NOW(), 'Comentador 1', 'activo', 'este es un comentario', 7);
insert into comment (date, name, status, comment, post_id) values (NOW(), 'Comentador 1', 'activo', 'este es un comentario', 7);