# java-calculator-precourse


# 문자열 덧셈 계산기
MVC 패턴을 적용해 구현한 문자열 덧셈 계산기

## 구현 기능 목록


### Main
* Application
  * `CalculatorController`를 통해 문자열 덧셈 계산기를 시작합니다.

### Model
* `Calculator`
  * 입력된 문자열을 구분자 기준으로 양수를 추출합니다.
  * 추출된 양수의 덧셈 연산을 진행합니다.
  * 잘못된 입력값에 대한 예외처리를 진행합니다.

### Controller
* `CalculatorController`
  * 문자열 덧셈 계산기의 흐름을 제어합니다.
  * 사용자로부터 입력받은 문자열을 `Calculator`에게 전달합니다.
  * `Calculator`를 통해 전달받은 덧셈 결과를 `OutputView`를 통해 출력한다.

### View
* InputView
  * 숫자 입력 안내 문구를 출력합니다
  * 구분자와 양수로 구성된 문자열을 입력받습니다.
* OutputView
  * 덧셈 결과를 출력합니다.