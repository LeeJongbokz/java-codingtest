// 왜 맞았는가?
// 1. 날짜는 ORDER BY로 정렬 가능하다
// 2. 상위 n개 레코드는 LIMIT으로 조정할 수 있다. 

SELECT NAME FROM ANIMAL_INS ORDER BY DATETIME LIMIT 1;
