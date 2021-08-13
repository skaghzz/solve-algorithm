-- 고양이와 개는 몇 마리 있을까
-- https://programmers.co.kr/learn/courses/30/lessons/59040
SELECT  ANIMAL_TYPE
       ,COUNT(*)
FROM ANIMAL_INS
GROUP BY  ANIMAL_TYPE
ORDER BY ANIMAL_TYPE ASC ;

-- 동명 동물 수 찾기
-- https://programmers.co.kr/learn/courses/30/lessons/59041
SELECT  NAME
       ,COUNT(*)
FROM ANIMAL_INS
WHERE NAME IS NOT NULL
GROUP BY  NAME
HAVING COUNT(*) >= 2
ORDER BY NAME ;

-- 입양 시각 구하기（1）
-- https://programmers.co.kr/learn/courses/30/lessons/59412
SELECT  hour(DATETIME) AS HOUR
       ,COUNT(*)       AS COUNT
FROM ANIMAL_OUTS
GROUP BY  HOUR
HAVING HOUR BETWEEN 9 AND 20
ORDER BY HOUR ;

-- 입양 시각 구하기（2）
-- https://programmers.co.kr/learn/courses/30/lessons/59413
SET @time=-1;

SELECT  @time:=@time+1
       ,(
SELECT  COUNT(*)
FROM ANIMAL_OUTS
WHERE hour(datetime)=@time )
FROM ANIMAL_OUTS
WHERE @time<23
ORDER BY @time