# java-calculator-precourse

## 기능목록

### [문자열 입력]

- 덧셈할 문자열을 입력받는다. (이때, 공백이라면 0을 반환)

### [문자열 분리]

- 문자열에서 기본 구분자 (',' 또는 ':')를 분리한 후, 피연산자를 배열에 저장
  - **예외)** 기본구분자 (',' 또는 ':')로 구분되지않으면 예외를 발생
- 문자열에서 커스텀 구분자 분리한 후, 피연산자를 배열에 저장
  - **예외)** 커스텀 구분자가 형식에(//커스텀구분자\n) 맞지 않으면 예외를 발생

### [숫자 합산]

- 배열에서 값을 추출해 정수로 변환 후 모두 더한다
  - **예외)** 피연산자가 음수일 경우
  - **예외)** 피연산자가 숫자로만 이루어져있는지 검증

### [MVC패턴]

### Controller

- CalculatorController

### Model

- Calculator
  - 문자열이 기본구분자 or 커스텀구분자로 이루어져있는지 확인후
  - 구분자를 기준으로 숫자들을 모두 합산

### Util

- Constants
- ErrorMessages

### View

- InputView
  - 문자열 입력받음
- OutputView
  - 덧셈 결과값 출력
