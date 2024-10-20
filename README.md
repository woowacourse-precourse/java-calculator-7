# java-calculator-precourse

# 구현할 기능 목록

## 🗂️ Model

### StringCalculator (문자열 계산기)

- [x]  문자열을 처리한다.
    - [x]  빈 문자열인 경우 0을 반환한다.
    - [x]  문자열을 파싱하고 숫자 리스트를 생성한다.
    - [x]  파싱된 숫자 리스트의 합을 반환한다.

### InputParser (입력 파서)

- [x]  문자열을 파싱하여 구분자에 따라 숫자 부분을 분리한다.
    - [x]  구분자 추출기로 문자열에서 구분자를 추출한다.
    - [x]  구분자 추출기로 문자열에서 숫자 부분을 추출한다.
    - [x]  구분자에 따라 숫자를 분리한 리스트를 반환한다.

### DelimiterExtractor (구분자 추출기)

- [x]  구분자를 추출한다.
    - [x]  기본 구분자(쉼표, 콜론)를 구분자로 반환한다.
    - [x]  커스텀 구분자가 있는 경우 기본 구분자(쉼표, 콜론)와 같이 반환한다.
    - [x]  `-`와 같이 음수로 계산될 수 있는 특수한 커스텀 구분자를 처리한다.
    - [x]  `//[구분자]\\n` 형식의 커스텀 구분자가 없는 경우, 예외를 발생시킨다.
- [x]  숫자 부분을 추출한다.
    - [x]  기본 구분자 처리 시 전체 문자열을 반환한다.
    - [x]  커스텀 구분자가 있는 경우 커스텀 구분자를 처리한 문자열을 반환한다.
    - [x]  `//[구분자]\\n` 형식의 커스텀 구분자가 없는 경우, 예외를 발생시킨다.

### SumCalculator (합계 계산기)

- [x]  숫자의 합계를 계산한다.
    - [x]  빈 문자열은 0으로 처리한다.
    - [x]  숫자의 유효성을 검사하고 파싱한다.

### NumberValidator (숫자 유효성 검사기)

- [x]  숫자 유효성을 검사한다.
    - [x]  숫자 문자열을 정수로 변환한다.
    - [x]  숫자가 음수인 경우, 예외를 발생시킨다.
    - [x]  잘못된 입력인 경우, 예외를 발생시킨다.


## 👀 View

### CalculatorView (계산기 뷰)

- [x]  사용자로부터 문자열을 입력 받는다.
- [x]  계산 결과를 출력한다.

## 🕹️ Controller

### CalculatorController (계산기 컨트롤러)

- [ ]  입력된 문자열을 처리하여 계산 결과를 반환한다.

## ⚠️ Exception

### InvalidInputException (예외 처리)

- [x]  잘못된 입력과 관련된 예외를 모아서 처리한다. 
