-- Сделать запросы, считающие и выводящие в понятном виде:

-- ошибки в расписании (фильмы накладываются друг на друга), отсортированные по возрастанию времени.
-- Выводить надо колонки «фильм 1», «время начала», «длительность», «фильм 2», «время начала», «длительность»;

select title, count(t) as total_spectators, sum(t.ticket_price) as total_income
from movies m
         join movie_sessions ms on m.id = ms.movie_id
         join tickets t on t.movie_session_id = ms.id
group by rollup (title)
order by m.title;