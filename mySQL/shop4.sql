-- PPT Oracle 4 p.44

use shop4

-- 1. member table과 bbs table의 inner join하시오.(조인 조건 bbs의 writer, member의 id)

select *
from `member` m, bbs b  
where m.id = b.writer


-- 2. member table과 bbs table의 left outer join하시오.(조인 조건 bbs의 writer, member의 id)

select *
from `member` m 
left outer join  bbs b
on (m.id = b.writer)

-- 3. member table과 bbs table의 right outer join하시오.(조인 조건 bbs의 writer, member의 id)

select *
from `member` m 
right outer join  bbs b
on (m.id = b.writer)

select *
from product p , company c 
where p.company  = c.id

select *
from product p
left outer join company c 
on (p.company = c.id)
