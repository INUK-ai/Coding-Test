-- 코드를 입력하세요
WITH FOOD_PRODUCE AS (
    SELECT PRODUCT_ID, SUM(AMOUNT) AS TOTAL_AMOUNT
    FROM FOOD_ORDER
    WHERE PRODUCE_DATE LIKE '2022-05%'
    GROUP BY PRODUCT_ID
)

SELECT A.PRODUCT_ID, A.PRODUCT_NAME, (A.PRICE * B.TOTAL_AMOUNT) AS TOTAL_SALES
FROM FOOD_PRODUCT A
JOIN FOOD_PRODUCE B ON A.PRODUCT_ID = B.PRODUCT_ID
ORDER BY TOTAL_SALES DESC, PRODUCT_ID