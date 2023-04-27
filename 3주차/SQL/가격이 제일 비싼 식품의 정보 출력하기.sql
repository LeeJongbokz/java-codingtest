// 1. 왜 맞았는가? 
// -> 서브쿼리를 사용했다.
// -> 서브쿼리에 대해서 공부해야겠다. 

SELECT * FROM FOOD_PRODUCT WHERE PRICE = (SELECT MAX(PRICE) FROM FOOD_PRODUCT);
