-- 고양이와 개는 몇 마리 있을까
-- https://programmers.co.kr/learn/courses/30/lessons/59040
SELECT ANIMAL_TYPE, COUNT(*) FROM ANIMAL_INS GROUP BY ANIMAL_TYPE ORDER BY ANIMAL_TYPE ASC
;

-- 동명 동물 수 찾기
-- https://programmers.co.kr/learn/courses/30/lessons/59041
SELECT NAME, COUNT(*) FROM ANIMAL_INS WHERE NAME IS NOT NULL GROUP BY NAME HAVING COUNT(*) >= 2 ORDER BY NAME
;