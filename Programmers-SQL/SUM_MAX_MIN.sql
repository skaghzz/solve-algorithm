-- 최댓값 구하기
-- https://programmers.co.kr/learn/courses/30/lessons/59415
SELECT  MAX(DATETIME)
FROM ANIMAL_INS ;

-- 최솟값 구하기
-- https://programmers.co.kr/learn/courses/30/lessons/59038
SELECT  MIN(DATETIME)
FROM ANIMAL_INS ;

-- 동물 수 구하기
-- https://programmers.co.kr/learn/courses/30/lessons/59406
SELECT  COUNT(*)
FROM ANIMAL_INS ;

-- 중복 제거하기
-- https://programmers.co.kr/learn/courses/30/lessons/59408
SELECT  COUNT(DISTINCT NAME)
FROM ANIMAL_INS ;