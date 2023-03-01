-- У фильма, который идет в кинотеатре, есть название, длительность (пусть будет 60, 90 или 120 минут),
-- цена билета (в разное время и дни может быть разной),
-- время начала сеанса (один фильм может быть показан несколько раз в разное время и с разной ценой билета).
-- Есть информация о купленных билетах (номер билета, на какой сеанс).

-- Задания:
-- Составить грамотную нормализованную схему хранения этих данных в БД.
-- Внести в нее 4–5 фильмов, расписание на один день и несколько проданных билетов.


DROP TABLE IF EXISTS movies CASCADE;
DROP TABLE IF EXISTS tickets CASCADE;
DROP TABLE IF EXISTS movie_sessions CASCADE;


CREATE TABLE movies
(
    id         BIGSERIAL PRIMARY KEY,
    title      VARCHAR(255),
    duration   TIME WITHOUT TIME ZONE NOT NULL,

    created_at TIMESTAMP DEFAULT current_timestamp,
    updated_at TIMESTAMP DEFAULT current_timestamp
);

CREATE TABLE movie_sessions
(
    id         BIGSERIAL PRIMARY KEY,
    movie_id   BIGINT                 NOT NULL REFERENCES movies,
    started_at TIME WITHOUT TIME ZONE NOT NULL,

    created_at TIMESTAMP DEFAULT current_timestamp,
    updated_at TIMESTAMP DEFAULT current_timestamp
);

CREATE TABLE tickets
(
    id               BIGSERIAL PRIMARY KEY,
    ticket_price     REAL NOT NULL,
    movie_session_id BIGINT REFERENCES movie_sessions,

    created_at       TIMESTAMP DEFAULT current_timestamp,
    updated_at       TIMESTAMP DEFAULT current_timestamp
);

INSERT INTO movies(title, duration)
VALUES ('Чебурашка', '02:00'),
       ('Праведник', '01:30'),
       ('О чем говорят мужчины', '01:30'),
       ('Кот в сапогах', '01:00'),
       ('Аватар', '02:00');

INSERT INTO movie_sessions(movie_id, started_at)
VALUES (1, '09:00'),
       (1, '11:30'),
       (1, '13:00'),
       (1, '15:00'),
       (1, '17:00'),
       (1, '20:00'),
       (2, '12:00'),
       (2, '17:00'),
       (2, '22:00'),
       (3, '16:00'),
       (3, '19:00'),
       (4, '14:00'),
       (5, '16:00'),
       (5, '21:00');

INSERT INTO tickets(ticket_price, movie_session_id)
VALUES (100, 9),
       (100, 11),
       (200, 12),
       (250, 5),
       (350, 6),
       (500, 13);