# 미션 1 - 문자열 덧셈 계산기 🧮

### 학습 목표

- `Git`, `GitHub`, `IDE` 환경에 익숙해진다.
- `Java` 언어를 사용하여 간단한 문제를 해결한다.
- `JUnit5`를 사용하여 단위 테스트를 작성하며 테스트 관련 함수와 어노테이션을 활용하는 방법을 익힌다.
- `Exception`과 `Error`의 차이를 이해하고 내용을 정리한다.

## 문제 분석

> 입력한 문자열에서 숫자를 추출하여 더하는 계산기를 구현한다.

1. 입력값 처리

    - 기본 형식: 쉼표 또는 콜론을 구분자로 사용하는 문자열
        - ex) `1,2:3`, `1,2,3`, `1:2:3`
    - 커스텀 구분자 이용 형식
        - `//`와 `\n` 사이에 위치한 문자열을 커스텀 구분자로 사용한다.
            - ex) `//;\n1;2;3` -> `;`를 구분자로 사용
    - 잘못된 값 처리 (구분자를 기준으로 나눴을 때)
        - `IllegalArgumentException`을 발생하고 애플리케이션은 종료된다.
            1. 0
            2. 음수
            3. 숫자가 아닌 값

2. 숫자의 범위

    - 정해진 숫자의 범위가 없기 때문에 `Long` 타입으로 처리
    - Long 타입의 범위가 벗어나는 경우 `BigInteger`를 사용하여 처리

3. 출력값 처리
    - 입력한 문자열이 문제가 없는 경우, 숫자의 합을 반환한다.

## 설계

먼저 구동되는 애플리케이션을 만들고 리팩토링을 진행한다. 클래스와 메소드를 분리 한 이후 테스트를 작성한다.

### Parser

1. `StringParser`
    - 인터페이스
    - 문자열을 파싱하는 기능을 담당한다. -> `parse()`
    - 문자열을 숫자로 변환하는 기능을 담당한다. -> `parseToInt()`
2. `DefaultStringParser`
    - `StringParser`를 구현한 클래스
    - **쉼표**와 **콜론**을 구분자로 사용하는 문자열을 파싱하는 기능을 담당한다.
3. `CustomStringParser`
    - `StringParser`를 구현한 클래스
    - 커스텀 구분자를 사용하는 문자열을 파싱하는 기능을 담당한다.
    - `regex`를 이용한다.

### Validator

1. `InputValidator`
    - 입력값이 유효한지 검사하는 기능을 담당한다.
    - regex를 이용한다.
2. `NumberValidator`
    - 숫자가 유효한지 검사하는 기능을 담당한다.

### View

1. `InputView`
    - 사용자 입력을 받는 기능을 담당한다.
    - `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용
2. `OutputView`
    - 출력하는 기능을 담당한다.

### Calculator

1. `StringAdditionCalculator`
    - 숫자들을 더하는 기능을 담당한다.
    - `StringParser`를 사용하여 문자열을 파싱한다.

### Exception

1. `InvalidInputException`
    - 입력값이 유효하지 않은 경우 발생하는 예외
    - `IllegalArgumentException`을 상속받는다.

### Controller

1. `StringAdditionController`
    - `InputValidator`를 사용하여 입력값을 검사한다.
    - `InputView`와 `OutputView`를 사용하여 사용자와 상호작용한다.
    - `StringAdditionCalculator`를 사용하여 계산을 수행한다.
    - `run()`
        - 로직을 처리한다.

### Application

1. `Controller`의 `run()`을 실행한다.

### 클래스 다이어그램

<img src="https://github.com/user-attachments/assets/658ed659-43f4-4330-89ca-2d58ef0c15c4" width="700" alt="image">

### 기능 목록

- [ ] **입력 문자열 파싱**
    - [ ] 기본 구분자(쉼표 `,` 및 콜론 `:`)로 문자열을 분리한다.
    - [ ] 커스텀 구분자가 있는 경우, `//`와 `\n` 사이에 있는 구분자를 사용하여 문자열을 분리한다.

- [ ] **빈 문자열 처리**
    - [ ] 빈 문자열이 입력된 경우, 결과는 0을 반환한다.

- [ ] **숫자 변환 및 덧셈 계산**
    - [ ] 분리된 문자열을 숫자로 변환하고 그 합을 계산하여 반환한다.

- [ ] **유효성 검사**
    - [ ] 문자열에 포함된 값이 양수가 아닌 경우(음수 또는 숫자가 아닌 값) `IllegalArgumentException`을 발생시킨다.

- [ ] **출력**
    - [ ] 계산된 결과를 출력한다.

- [ ] **예외 처리**
    - [ ] 잘못된 값이 입력된 경우 `IllegalArgumentException`을 발생시키고, 프로그램을 종료한다.

