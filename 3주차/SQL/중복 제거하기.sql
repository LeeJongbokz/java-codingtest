// 1.왜 맞았는가?
// -> DISTINCT를 COUNT안에 써야 한다.

SELECT COUNT(DISTINCT NAME) AS count FROM ANIMAL_INS WHERE NAME IS NOT NULL;
