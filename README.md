# 기능 요구사항 정리

## 1. 문제풀이 기본 요구사항 정리
- Application의 main()에서 사용자에게 덧셈할 문자열인 String input을 입력받아 매개변수로 전달해 문자열에서 숫자를 추출하여 더해 정수형 결과 값 반환하는 calculateSum() 메서드 작성.
- 주어진 문자열에서 커스텀 구분자가 있으면 추출하는 extractCustomSeparator() 메서드 작성.
- 커스텀 구분자를 매개변수로 입력받고 구분자들 제거한 문자열 반환하는 removeSeparator() 메서드 작성.
- 구분자 제거한 문자열을 매개변수로 받아 정수형으로 바꿔 반환하는 parseStringToInteger() 메서드 작성.
- 바뀐 정수형들끼리 더해 정수합을 반환하는 sumInteger() 메서드 작성.
- 입력값에 대한 에외처리를 하는 checkException() 메서드 작성.