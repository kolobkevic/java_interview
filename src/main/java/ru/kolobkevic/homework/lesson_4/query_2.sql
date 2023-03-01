-- Сделать запросы, считающие и выводящие в понятном виде:

-- перерывы 30 минут и более между фильмами — выводить по уменьшению длительности перерыва.
-- Колонки «фильм 1», «время начала», «длительность», «время начала второго фильма», «длительность перерыва»;

-- select title, ms.started_at, duration
-- from movie_sessions ms
--          join movies m on m.id = ms.movie_id
--          join movie_sessions ms2 on ms2.id <> ms.id
-- where (ms2.started_at - ms.started_at) >= '02:30'
-- group by title, ms.started_at, duration
-- order by ms.started_at;

select title, ms.started_at, duration, ms2.started_at, ms2.started_at - ms.started_at - m.duration as diff
from movie_sessions ms
         join movies m on m.id = ms.movie_id
         join movie_sessions ms2 on (ms2.started_at - ms.started_at - m.duration) >= '00:30'
order by ms.started_at;

-- Не понимаю как выполнить запрос, чтобы сравнивались только два подряд идущих сеанса