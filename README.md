# java-calculator-precourse


# 문자열 덧셈 계산기
MVC 패턴을 적용해 구현한 문자열 덧셈 계산기

## 구현 기능 목록


### Main
* Application
  * `CalculatorController`를 통해 문자열 덧셈 계산기를 시작합니다.

### Model
* `Calculator`
  * 양수의 덧셈 연산을 진행합니다

### Controller
* `CalculatorController`
  * 문자열 덧셈 계산기의 흐름을 제어합니다.
  * `InputView`를 통해 입력받은 문자열을 입력받습니다.
  * 입력받은 문자열을 `SeparateNumber`에게 전달하여 정제합니다.
  * 정제된 양수 `List`를 `Calculator`에게 전달합니다.
  * `Calculator`를 통해 전달받은 덧셈 결과를 `OutputView`를 통해 출력합니다.

### View
* `InputView`
  * 숫자 입력 안내 문구를 출력합니다
  * 구분자와 정수로 구성된 문자열을 입력받습니다.
* `OutputView`
  * 덧셈 결과를 출력합니다.

### Util
* exception
  * 잘못된 입력에 대한 예외 메세지를 enum으로 관리합니다
  * 상황에 맞는 예외처리 클래스를 IllegalArgumentException 클래스를 상속받은 정적 중첩 클래스로 관리합니다.
* refine
  * 입력값에 대한 검증을 처리합니다.
  * 구분자를 추출합니다.
  * 구분자를 통해서 양수를 추출합니다.