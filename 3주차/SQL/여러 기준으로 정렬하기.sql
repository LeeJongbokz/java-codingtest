// 왜 맞았는가?
// 1. 2가지 정렬 조건을 동시에 사용할 수 있다.
// 2. 역으로 정렬하려면 DESC를 붙여준다. 

SELECT ANIMAL_ID, NAME, DATETIME FROM ANIMAL_INS ORDER BY NAME, DATETIME DESC; 
