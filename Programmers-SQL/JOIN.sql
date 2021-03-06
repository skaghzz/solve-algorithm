-- 없어진 기록 찾기
-- https://programmers.co.kr/learn/courses/30/lessons/59042
SELECT o.ANIMAL_ID, o.NAME
FROM ANIMAL_OUTS o LEFT JOIN ANIMAL_INS i
ON o.ANIMAL_ID = i.ANIMAL_ID
WHERE i.ANIMAL_ID IS NULL
ORDER BY i.ANIMAL_ID ASC;

-- 있었는데요 없었습니다
-- https://programmers.co.kr/learn/courses/30/lessons/59043
SELECT i.ANIMAL_ID, i.NAME
FROM ANIMAL_INS i JOIN ANIMAL_OUTS o
ON i.ANIMAL_ID = o.ANIMAL_ID
WHERE i.DATETIME > o.DATETIME
ORDER BY i.DATETIME

-- 오랜 기간 보호한 동물(1)
-- https://programmers.co.kr/learn/courses/30/lessons/59044
SELECT i.NAME, i.DATETIME
FROM ANIMAL_OUTS o RIGHT JOIN ANIMAL_INS i
ON i.ANIMAL_ID = o.ANIMAL_ID
WHERE o.ANIMAL_ID IS NULL
ORDER BY i.DATETIME
LIMIT 3;

-- 보호소에서 중성화한 동물
-- https://programmers.co.kr/learn/courses/30/lessons/59045
SELECT i.ANIMAL_ID, i.ANIMAL_TYPE, i.NAME
FROM ANIMAL_INS i JOIN ANIMAL_OUTS o
ON i.ANIMAL_ID = o.ANIMAL_ID
WHERE i.SEX_UPON_INTAKE LIKE '%Intact%'
AND (o.SEX_UPON_OUTCOME like '%Spayed%' OR o.SEX_UPON_OUTCOME like '%Neutered%')
ORDER BY i.ANIMAL_ID;