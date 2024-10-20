# java-calculator-precourse

## 기능 요구 사항
1. 쉼표 또는 콜론 :을 구분자로 가지는 문자열을 전달하는 경우에
구분자를 기준으로 숫자의 합을 반환하는 기능
2. 앞에 지정되어 있는 구분자 이외에 커스텀 구분자를 지정할 수 있다.
커스텀 구분자는 문자열 앞부분의 //와 \n 사이에 위치하는 문자를 지정하는 기능.
3. 사용자가 잘못된 값(형식에 맞지 않는 값)을 입력할 경우의 예외 처리

### 예외 세세하게 나누기
1. null 값 여부 확인 || "" 값 여부 확인
2. 구분자와 양수로 구성되어야 함. 구분자는 문자만 가능.

### 의문점
1. calculator 에서 에러 터지는게 맞나? 
2. validator.isInvalidFormat(numbers.replace(customDelimiter, ",")
3. 지금 StringAddCalculator 가 너무 많은 책임이 있지 않나?
4. 정규식에서 쓰는 연산자('.','*','{','}' 등등) 은 문자가 아닌가? 되어야 하지 않을까?
5. isInvalidFormat 과 isInvalidFormatCustomPattern 의 로직 중복
