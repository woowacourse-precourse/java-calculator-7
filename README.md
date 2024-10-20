# java-calculator-precourse

<기능 구현 순서>

1. 입력값 받기
   예외처리 : 입력값(input)이 비어있는 경우 IllegalArgumentException 발생

2. Custom구분자 추출
   : 기본구분자 외에 Custom구분자가 있는 경우, 분리 후 구분자(Separator) 리스트에 넣음

3. 구분자를 기준으로 숫자 분리
   : List<String> separator에 있는 구분자들을 이용해 분리. 숫자만 배열에 담음

4. 숫자가 양수(0 이상의 숫자)인지 검증
   : 0이나 음수인 경우 IllegalArgumentException 발생

5. 숫자끼리 덧셈

6. 결과 반환