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

-- matrículas
INSERT INTO tb_enrollment(user_id, offer_id, enroll_Moment, refund_Moment, available, only_Update) VALUES (1,1, TIMESTAMP WITH TIME ZONE '2020-12-20T13:00:00Z',null, true, false);
INSERT INTO tb_enrollment(user_id, offer_id, enroll_Moment, refund_Moment, available, only_Update) VALUES (2,1, TIMESTAMP WITH TIME ZONE '2020-12-20T15:00:00Z',null, true, false);

-- aulas
INSERT INTO tb_lesson(title, position, section_id) VALUES('Aula 01 - Cap 01',1, 1);
INSERT INTO tb_lesson(title, position, section_id) VALUES('Aula 02 - Cap 01',2, 1);
INSERT INTO tb_lesson(title, position, section_id) VALUES('Aula 03 - Cap 01',3, 1);
INSERT INTO tb_lesson(title, position, section_id) VALUES('Tarefa 01 - Cap 01',4, 1);

-- conteúdos
INSERT INTO tb_content(text_content, video_Uri, id) VALUES ('Conteúdo Aula 01', 'https://learn.devsuperior.com/offers/58/resource/295/sections/1076?item=12899', 1)
INSERT INTO tb_content(text_content, video_Uri, id) VALUES ('Conteúdo Aula 02', 'https://learn.devsuperior.com/offers/58/resource/295/sections/1076?item=12899', 2)
INSERT INTO tb_content(text_content, video_Uri, id) VALUES ('Conteúdo Aula 03', 'https://learn.devsuperior.com/offers/58/resource/295/sections/1076?item=12899', 3)

-- tarefas
INSERT INTO tb_task(description, question_Count, approval_Count, weight, due_Date, id) VALUES ('Fazer trabalho do Cap 01', 5, 4, 1.0, TIMESTAMP WITH TIME ZONE '2020-12-25T13:00:00Z', 4);

-- lições completadas
INSERT INTO tb_lessons_done(lesson_id, user_id, offer_id) VALUES (1, 1, 1);
INSERT INTO tb_lessons_done(lesson_id, user_id, offer_id) VALUES (2, 1, 1);


-- notificações
INSERT INTO tb_notification (text, moment, read, route, user_id) VALUES ('Primeiro feedback de tarefa: favor revisar', TIMESTAMP WITH TIME ZONE '2020-12-10T13:00:00Z', true, '/offers/1/resource/1/sections/1', 1);
INSERT INTO tb_notification (text, moment, read, route, user_id) VALUES ('Segundo feedback: favor revisar', TIMESTAMP WITH TIME ZONE '2020-12-12T13:00:00Z', true, '/offers/1/resource/1/sections/1', 1);
INSERT INTO tb_notification (text, moment, read, route, user_id) VALUES ('Terceiro feedback: favor revisar', TIMESTAMP WITH TIME ZONE '2020-12-14T13:00:00Z', true, '/offers/1/resource/1/sections/1', 1);

-- entregas
INSERT INTO tb_deliver (uri, moment, status, feedback, correct_Count, lesson_id, user_id, offer_id) VALUES ('https://github.com/LiniiS/dslearn-bootcamp', TIMESTAMP WITH TIME ZONE '2020-12-10T10:00:00Z', 0, null, null, 4, 1, 1);

-- topicos
INSERT INTO tb_topic (title, body, moment, author_id, offer_id, lesson_id) VALUES ('Título do tópico 01', 'Corpo do tópico 01', TIMESTAMP WITH TIME ZONE '2020-12-12T13:00:00Z', 1, 1, 1);
INSERT INTO tb_topic (title, body, moment, author_id, offer_id, lesson_id) VALUES ('Título do tópico 02', 'Corpo do tópico 02', TIMESTAMP WITH TIME ZONE '2020-12-13T13:00:00Z', 2, 1, 1);
INSERT INTO tb_topic (title, body, moment, author_id, offer_id, lesson_id) VALUES ('Título do tópico 03', 'Corpo do tópico 03', TIMESTAMP WITH TIME ZONE '2020-12-14T13:00:00Z', 2, 1, 1);
INSERT INTO tb_topic (title, body, moment, author_id, offer_id, lesson_id) VALUES ('Título do tópico 04', 'Corpo do tópico 04', TIMESTAMP WITH TIME ZONE '2020-12-15T13:00:00Z', 1, 1, 2);
INSERT INTO tb_topic (title, body, moment, author_id, offer_id, lesson_id) VALUES ('Título do tópico 05', 'Corpo do tópico 05', TIMESTAMP WITH TIME ZONE '2020-12-16T13:00:00Z', 1, 1, 2);
INSERT INTO tb_topic (title, body, moment, author_id, offer_id, lesson_id) VALUES ('Título do tópico 06', 'Corpo do tópico 06', TIMESTAMP WITH TIME ZONE '2020-12-17T13:00:00Z', 2, 1, 3);

-- likes dos tópicos
INSERT INTO tb_topic_likes (topic_id, user_id) VALUES (1, 2);
INSERT INTO tb_topic_likes (topic_id, user_id) VALUES (2, 1);

-- respostas
INSERT INTO tb_reply (body, moment, topic_id, author_id) VALUES ('Tente reiniciar o computador', TIMESTAMP WITH TIME ZONE '2020-12-15T13:00:00Z', 1, 2);
INSERT INTO tb_reply (body, moment, topic_id, author_id) VALUES ('Deu certo, valeu!', TIMESTAMP WITH TIME ZONE '2020-12-20T13:00:00Z', 1, 1);

-- likes das respotas
INSERT INTO tb_reply_likes (reply_id, user_id) VALUES (1, 1);
