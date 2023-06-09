// 1. 왜 맞았는가?
// -> GROUP BY와 HAVING을 같이 쓰면 된다.
// -> 조건을 표현할때는 HAVING을 쓰면 된다. 

SELECT B.USER_ID, B.NICKNAME, SUM(A.PRICE) AS TOTAL_SALES
FROM USED_GOODS_BOARD AS A INNER JOIN USED_GOODS_USER AS B ON A.WRITER_ID = B.USER_ID WHERE A.STATUS = 'DONE' GROUP BY A.WRITER_ID HAVING TOTAL_SALES>=700000 ORDER BY TOTAL_SALES;
