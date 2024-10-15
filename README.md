# java-calculator-precourse


# 문자열 덧셈 계산기
MVC 패턴을 적용해 구현한 문자열 덧셈 계산기

## 구현 기능 목록


### Main
* Application
  * `CalculatorController`를 통해 문자열 덧셈 계산기를 시작합니다.

### Model
* `Calculator`
  * 양수의 덧셈 연산을 진행합니다.

### Controller
* `CalculatorController`
  * 문자열 덧셈 계산기의 흐름을 제어합니다.
  * `InputView`를 통해 입력받은 문자열을 구분자 기준으로 파싱합니다.
  * 파싱된 문자열을 정수로 변환합니다.
  * 정수 배열을 `Calculator`에게 전달합니다.
  * `Calculator`를 통해 전달받은 덧셈 결과를 `OutputView`를 통해 출력한다.

### View
* InputView
  * 숫자 입력 안내 문구를 출력합니다
  * 구분자와 양수로 구성된 문자열을 입력받습니다.
* OutputView
  * 덧셈 결과를 출력합니다.