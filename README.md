# java-calculator-precourse

# 문자열 덧셈 계산기

## 기능 소개

- 입력된 문자열에서 숫자를 추출하여 더한 값을 출력하는 서비스

## 패키지 구조

- domain
    - Calculator
    - Number
    - Operations

- view
    - InputHandler
    - InputView
    - OutputView

## 기능 목록

- [x] 추출한 숫자를 더하기 - Operations#add()

### 입력

- [x] 구분자와 양수로 구성된 문자열 입력 - InputView#readNumbers()
    - [x] 커스텀 구분자가 있는지 확인 - InputHandler#isCustomDelimiter()
    - [x] 입력 받은 값이 숫자가 아닌 경우 예외처리 - Number#validateNumber()
    - [x] 입력 받은 숫자가 양수가 아닌 경우 예외처리 - Number#checkPositive()

### 출력

- [x] 더한 결과값 출력 - OutputView#printResult()