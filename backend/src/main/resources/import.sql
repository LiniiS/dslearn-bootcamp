INSERT INTO tb_user (name, email, password) VALUES ('Alex Brown', 'alex@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (name, email, password) VALUES ('Bob Brown', 'bob@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (name, email, password) VALUES ('Maria Green', 'maria@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');

INSERT INTO tb_role (authority) VALUES ('ROLE_STUDENT');
INSERT INTO tb_role (authority) VALUES ('ROLE_INSTRUCTOR');
INSERT INTO tb_role (authority) VALUES ('ROLE_ADMIN');

-- Alex -> estudante
INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
-- Bob -> estudante & instrutor
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 2);
-- Maria -> estudante & instrutor & admin
INSERT INTO tb_user_role (user_id, role_id) VALUES (3, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (3, 2);
INSERT INTO tb_user_role (user_id, role_id) VALUES (3, 3);

-- converte o camel case pra snake case
INSERT INTO tb_course (name, img_Uri, img_Gray_Uri) VALUES ('Bootcamp Html', 'https://via.placeholder.com/300/008000', 'https://via.placeholder.com/300');

--instant usar o mesmo padrão que vale para o h2, postgrees -> ISO8601
INSERT INTO tb_offer (edition, start_Moment, end_Moment, course_id) VALUES ('1.0',TIMESTAMP WITH TIME ZONE '2020-11-20T03:00:00Z',TIMESTAMP WITH TIME ZONE '2021-11-20T03:00:00',1);
INSERT INTO tb_offer (edition, start_Moment, end_Moment, course_id) VALUES ('2.0',TIMESTAMP WITH TIME ZONE '2020-12-20T03:00:00Z',TIMESTAMP WITH TIME ZONE '2021-12-20T03:00:00',1);

-- recursos 
INSERT INTO tb_resource (title, description, position, img_Uri, type, offer_id) VALUES ('Trilha HTML', 'Trilha principal do curso', 1, 'https://via.placeholder.com/300', 1, 1);
INSERT INTO tb_resource (title, description, position, img_Uri, type, offer_id) VALUES ('Forum', 'Tire suas dúvidas', 2, 'https://via.placeholder.com/300', 2, 1);
INSERT INTO tb_resource (title, description, position, img_Uri, type, offer_id) VALUES ('Lives', 'Lives exclusivas para as turmas', 3, 'https://via.placeholder.com/300', 0, 1);

-- seções
INSERT INTO tb_section (title, description, position, img_Uri, resource_id, prequisite_id) VALUES ('Capítulo 1', 'Neste capítulo vamos começar', 1, 'https://via.placeholder.com/300/008000', 1, null);
INSERT INTO tb_section (title, description, position, img_Uri, resource_id, prequisite_id) VALUES ('Capítulo 2', 'Neste capítulo vamos continuar', 2, 'https://via.placeholder.com/300/008000', 1, 1);
INSERT INTO tb_section (title, description, position, img_Uri, resource_id, prequisite_id) VALUES ('Capítulo 3', 'Neste capítulo vamos finalizar', 3, 'https://via.placeholder.com/300/008000', 1, 2);