-- Сделать запросы, считающие и выводящие в понятном виде:

-- список фильмов, для каждого — с указанием общего числа посетителей за все время,
-- среднего числа зрителей за сеанс и общей суммы сборов по каждому фильму (отсортировать по убыванию прибыли).
-- Внизу таблицы должна быть строчка «итого», содержащая данные по всем фильмам сразу;

select title, count(t) as total_spectators, (count(t) / count(ms)) as avg_spectators, sum(t.ticket_price) as total_income
from movies m
         join movie_sessions ms on m.id = ms.movie_id
         join tickets t on t.movie_session_id = ms.id
group by rollup (title)
order by m.title;

-- Не знаю как дать название Итого: строке