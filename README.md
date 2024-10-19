# java-calculator-precourse

---

## 구현 기능 목록

    1. `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용하여 사용자의 값을 입력받는다.
        a. "덧셈할 문자열을 입력해 주세요.\n"을 출력한다.

    2. 입력된 값을 검증한다.
        a. 입력이 가능한 값은 `양수`, `구분자`뿐이다.
        b. 구분자는 기본적으로 ","(쉼표)와 ":"(콜론)을 갖는다.
        c. 입력값의 시작이 "//"일 경우 "\n" 사이의 문자는 커스텀 구분자가 된다.
        d. 사용자가 잘못된 값을 입력하면 `IllegalArgumentException`을 발생시키고 앱을 종료시킨다.

    3. 덧셈을 진행한다.
        a. 결과값을 위한 변수를 생성한다.
        b. 구분자가 나오기 전까지의 숫자는 문자열로 생각하고 합쳐서 진행한다.
        c. 구분자가 나온다면 지금까지의 숫자를 결과값에 더한다.
        d. 마지막이 숫자인 경우 구분자가 없으므로 따로 덧셈을 진행한다.

    4. 결과값을 반환한다.
        a. "결과 : n"의 형식으로 반환한다.

## 테스트 기능 목록

    1. UserInput 테스트
        a. testValidInput: 기본 구분자를 사용한 정상적인 입력값을 확인한다.
        b. testValidCustomSeparatorInput: 커스텀 구분자를 입력한 경우를 확인한다.
        c. testEmptyInput: 빈 문자열을 입력한 경우 `IllegalArgumentException`이 발생하는지 확인한다.
        d. testInvalidInputWrongSeparator: 구분자 이외의 문자를 입력한 경우 `IllegalArgumentException`이 발생하는지 확인한다.

    2. Caculator 테스트
        a. testCalculateValidInput: 기본 구분자를 사용해 계산 결과를 확인한다.
        b. testCalculateWithCustomSeparator: 커스텀 구분자를 사용해 계산 결과를 확인한다.
        c. testCalculateWithInvalidInput: 구분자가 아닌 문자가 들어간 경우 `IllegalArgumentException`이 발생하는지 확인한다.

    3. UserOutput 테스트
        a. 올바른 출력을 하는지 확인한다.

    -> 단위 테스트의 어려움으로 인해 통합 테스트로 진행