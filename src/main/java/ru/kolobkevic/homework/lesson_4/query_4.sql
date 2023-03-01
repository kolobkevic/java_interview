-- Сделать запросы, считающие и выводящие в понятном виде:

-- число посетителей и кассовые сборы, сгруппированные по времени начала фильма:
-- с 9 до 15, с 15 до 18, с 18 до 21, с 21 до 00:00 (сколько посетителей пришло с 9 до 15 часов и т.д.).

select count(t) as total_spectators, sum(t.ticket_price) as total_income
from movies m
         join movie_sessions ms on m.id = ms.movie_id
         join tickets t on t.movie_session_id = ms.id

group by date_trunc('hour', ms.started_at) between '09:00' and '14:59',
         date_trunc('hour', ms.started_at) between '15:00' and '17:59',
         date_trunc('hour', ms.started_at) between '18:00' and '20:59',
         date_trunc('hour', ms.started_at) between '21:00' and '23:59';

-- Не получается дать название строке, чтобы было красиво