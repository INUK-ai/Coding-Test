-- 코드를 입력하세요
SELECT O.ANIMAL_ID, O.ANIMAL_TYPE, O.NAME
FROM ANIMAL_OUTS O
LEFT JOIN ANIMAL_INS I ON O.ANIMAL_ID = I.ANIMAL_ID
WHERE I.SEX_UPON_INTAKE LIKE '%Intact%'
    AND O.SEX_UPON_OUTCOME NOT LIKE '%Intact%'
ORDER BY O.ANIMAL_ID