// 1. 왜 맞았는가?
// -> DATE_FORMAT을 통해서 데이트 포맷 출력 양식을 잘 변환해주었다. 
// -> MONTH를 통해서 월을 잘 추출해주었다.
// -> GENDER = 'W' 조건을 추가해주었다.
// -> TNLO IS NOT NULL 조건을 추가해주었다.
// -> ORDER BY 절을 통해서 잘 정렬해주었다. 

SELECT MEMBER_ID, MEMBER_NAME, GENDER, DATE_FORMAT(DATE_OF_BIRTH, "%Y-%m-%d") AS DATE_OF_BIRTH FROM MEMBER_PROFILE WHERE GENDER = 'W' AND MONTH(DATE_OF_BIRTH) = '03' AND TLNO IS NOT NULL ORDER BY MEMBER_ID;
