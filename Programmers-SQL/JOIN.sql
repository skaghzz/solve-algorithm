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