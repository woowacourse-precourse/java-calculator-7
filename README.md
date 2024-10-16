# 기능 요구사항 정리 및 리펙토링 정리

## 1. 기능 요구사항 정리
- Application의 main()에서 사용자에게 덧셈할 문자열인 String input을 입력받아 매개변수로 전달해 문자열에서 숫자를 추출하여 더해 정수형 결과 값 반환하는 calculateSum() 메서드 작성.
- 주어진 문자열에서 커스텀 구분자가 있으면 추출하는 extractCustomSeparator() 메서드 작성.
- 입력 문자열을 매개변수로 입력받고 커스텀 구분자 선언 부분 제거한 문자열 반환하는 removeDeclarePart() 메서드 작성.
- 커스텀 구분자와 커스텀 구분자를 매개변수로 받아 구분자들 제거한 문자열 배열로 반환하는 removeSeparators() 메서드 작성.
- 구분자 제거한 문자열 배열을 매개변수로 받아 정수형 리스트로 바꿔 반환하는 parseStringToInteger() 메서드 작성.
- 바뀐 정수형들끼리 더해 정수합을 반환하는 sumInteger() 메서드 작성.
- 숫자에 대한 에외처리를 하는 checkNumberException() 메서드 작성.
- 커스텀 구분자에 대한 예외처리를 하는 checkSeparatorException() 메서드 작성.

## 2. 리펙토링 정리
- checkNumberException() 메서드 제거 후 해당 예외처리 역할을 parseStringToInteger() 메서드 안에서 try-catch 문으로 처리.
- main() 메서드에 try-catch 문 추가.
- 공백 문자+정수로 이루어진(ex:4, 3,2) 경우도 정상처리하기 위해 parseStringToInteger() 에 number.trim() 메서드 추가.