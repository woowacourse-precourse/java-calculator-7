# java-calculator-precourse

## 기능 목록

- 문자열 입력
- 커스텀 구분자 저장
- 구분자로 문자열에서 숫자 추출
- 숫자 합 계산
- 결과 반환

## 고려할 점

1. 중간에 있는 공백은 0인가 아닌가?
    - 중간 공백은 제외
    - ex) 1,,3 &rightarrow; ,, 커스텀 구분자가 없으면 예외처리
2. 맨앞, 맨뒤에 있는 구분자는 어떻게 처리하나?
    - 예외 처리 (구분자는 숫자 사이에만 존재)
3. 구분자가 연속 2개 있을때 ( .. ,, :: ) 처리
    - , 공백 , 로 처리? or ,,를 하나의 구분자로 처리? &rightarrow; ,,를 하나의 구분자로 처리
4. // \n 구분자도 허용?
    - \n가 구분자 &rightarrow; //123\n4,5 이면 숫자는 구분자?
    - 숫자 구분자 비허용 &rightarrow; // \n 사이가 숫자인지 아닌지 구분 하는 과정 필요
    - //;2,3\n4 이면? &rightarrow; // \n 사이를 한글자씩 검사해서 숫자인지 확인
    - //\n\n 이면 \n 구분자인가 공백이 구분자인가 &rightarrow; 너무 모호하다.. // \n 구분자는 비허용

## 목표

1. One level of indentation per method 지켜보기
2. 변수명, 메서드명 신중하게 지어보기
3. 메서드마다 테스트 작성