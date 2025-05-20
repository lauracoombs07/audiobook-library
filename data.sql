INSERT INTO public.genre (id, genre) VALUES (1, 'Fiction');
INSERT INTO public.genre (id, genre) VALUES (2, 'Historical Fiction');
INSERT INTO public.genre (id, genre) VALUES (3, 'Classic Literature');
INSERT INTO public.genre (id, genre) VALUES (4, 'Non-Fiction');
INSERT INTO public.genre (id, genre) VALUES (5, 'Religious');

INSERT INTO public.author (id, created_dt, first_name, last_modified_dt, last_name) VALUES (2, '2025-05-15 17:06:26.363', 'Alexia', NULL, 'Coombs');
INSERT INTO public.author (id, created_dt, first_name, last_modified_dt, last_name) VALUES (3, '2025-05-15 17:07:11.462', 'Stephen', NULL, 'Fry');
INSERT INTO public.author (id, created_dt, first_name, last_modified_dt, last_name) VALUES (4, '2025-05-15 17:07:27.396', 'Jack', NULL, 'Carr');
INSERT INTO public.author (id, created_dt, first_name, last_modified_dt, last_name) VALUES (5, '2025-05-15 17:07:52.479', 'Charles', NULL, 'Dickens');


INSERT INTO public.narrator (id, created_dt, first_name, last_modified_dt, last_name) VALUES (1, '2025-05-15 17:32:43.568', 'Stephen', NULL, 'Fry');
INSERT INTO public.narrator (id, created_dt, first_name, last_modified_dt, last_name) VALUES (2, '2025-05-15 17:33:28.394', 'Brene', NULL, 'Brown');
INSERT INTO public.narrator (id, created_dt, first_name, last_modified_dt, last_name) VALUES (3, '2025-05-15 17:40:44.245', 'Brene', NULL, 'Brown');

INSERT INTO public.owner (id, created_dt, first_name, last_modified_dt, last_name, source) VALUES (1, '2025-05-15 17:48:23', 'Laura', NULL, 'Coombs', NULL);
INSERT INTO public.owner (id, created_dt, first_name, last_modified_dt, last_name, source) VALUES (2, '2025-05-15 17:48:23', 'Emily', NULL, 'Chambers', NULL);
INSERT INTO public.owner (id, created_dt, first_name, last_modified_dt, last_name, source) VALUES (3, '2025-05-15 17:48:23', 'Debbie', NULL, 'Egbert', NULL);
INSERT INTO public.owner (id, created_dt, first_name, last_modified_dt, last_name, source) VALUES (4, '2025-05-15 17:48:23', 'Ashlyn', NULL, 'Warren', NULL);

INSERT INTO public.series (id, series_name, total_count) VALUES (1, 'Mythos', 4);
INSERT INTO public.series (id, series_name, total_count) VALUES (2, 'Fablehaven', 5);






INSERT INTO public.audiobook (id, audiobook_title, created_dt, description, duration, last_modified_dt, series_installment, fk_genre_id, fk_owner_id, fk_series_id) VALUES (1, 'Troy', '2025-05-15 08:33:48.681', 'Greek Mythology', '12:30:00', '2025-05-15 17:58:12.014', '3', 1, 1, 1);
INSERT INTO public.audiobook (id, audiobook_title, created_dt, description, duration, last_modified_dt, series_installment, fk_genre_id, fk_owner_id, fk_series_id) VALUES (2, 'Mythos', '2025-05-15 18:00:22.052', 'Greek Mythology', '12:30:00', NULL, '1', 1, 1, 1);
INSERT INTO public.audiobook (id, audiobook_title, created_dt, description, duration, last_modified_dt, series_installment, fk_genre_id, fk_owner_id, fk_series_id) VALUES (3, 'Heroes', '2025-05-15 18:00:51.848', 'Greek Mythology', '12:30:00', NULL, '2', 1, 1, 1);
INSERT INTO public.audiobook (id, audiobook_title, created_dt, description, duration, last_modified_dt, series_installment, fk_genre_id, fk_owner_id, fk_series_id) VALUES (4, 'Odyssey', '2025-05-15 18:01:07.327', 'Greek Mythology', '12:30:00', NULL, '4', 1, 1, 1);

INSERT INTO public.audiobook_narrator (audiobook_id, narrator_id) VALUES (2, 1);
INSERT INTO public.audiobook_narrator (audiobook_id, narrator_id) VALUES (3, 1);
INSERT INTO public.audiobook_narrator (audiobook_id, narrator_id) VALUES (4, 1);
INSERT INTO public.audiobook_narrator (audiobook_id, narrator_id) VALUES (1, 1);

INSERT INTO public.audiobook_author (audiobook_id, author_id) VALUES (2, 3);
INSERT INTO public.audiobook_author (audiobook_id, author_id) VALUES (3, 3);
INSERT INTO public.audiobook_author (audiobook_id, author_id) VALUES (4, 3);
INSERT INTO public.audiobook_author (audiobook_id, author_id) VALUES (1, 3);
