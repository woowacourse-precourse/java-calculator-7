# java-calculator-precourse

### 📝기능 목록
- [X] 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환한다.
- [X] 앞의 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 "//"와 "\n" 사이에 위치하는 문자를 커스텀 구분자로 사용한다.
- [X] 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.

### 📝기능 목록
최대한 MVC 패턴을 적용하여 구현하였다. 

#### Application
* `CalculatorController`를 통해 문자열 덧셈 계산기를 시작한다.

#### View
* `InputView`와 `OutputView`를 통해 문자열을 입력받고 결과를 출력한다.

#### Controller
* `CalculateController`에서 Token의 tokenizer 메서드를 불러와 입력 값을 정수형 List에 저장한다.
* `Calculate`의 메서드를 호출해 List에 저장된 합을 구한다.

#### Model
* `Tokenizer`: 정규표현식을 이용해 해당 식이 기본값인지 사용자 지정인지 판단 후 List에 저장
* `Calculator`: List에 저장된 정수들의 합 반환

### 📝검증 목록
- [X] 기본(,|:) 구분자 검증
- [X] 커스텀 구분자 검증
- [X] 빈 문자열 검증
- [X] 음수를 입력받았을 경우 검증