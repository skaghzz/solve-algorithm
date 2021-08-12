-- 모든 레코드 조회하기
-- https://programmers.co.kr/learn/courses/30/lessons/59034
SELECT * FROM ANIMAL_INS ORDER BY ANIMAL_ID
;

-- 역순 정렬하기
-- https://programmers.co.kr/learn/courses/30/lessons/59035
SELECT NAME, DATETIME FROM ANIMAL_INS ORDER BY ANIMAL_ID DESC
;

-- 아픈 동물 찾기
-- https://programmers.co.kr/learn/courses/30/lessons/59036
SELECT ANIMAL_ID, NAME FROM ANIMAL_INS WHERE INTAKE_CONDITION = "Sick" ORDER BY ANIMAL_ID
;

-- 어린 동물 찾기
-- https://programmers.co.kr/learn/courses/30/lessons/59037
SELECT ANIMAL_ID, NAME FROM ANIMAL_INS WHERE INTAKE_CONDITION <> "Aged"
;