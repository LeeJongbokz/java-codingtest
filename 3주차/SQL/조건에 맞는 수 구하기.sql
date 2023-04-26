// 1. 왜 맞았는가?
// -> 연도는 YEAR()으로 나타낼 수 있다.
// -> 연도를 검사할 때는 = 으로 검사해야 한다
// -> 전체 수는 COUNT(*)로 하고, AS 를 통해서 칼럼명을 바꿔줄 수 있다. 

SELECT COUNT(*) AS USERS FROM USER_INFO WHERE AGE >= 20 AND AGE <=29 AND YEAR(JOINED) = '2021';
