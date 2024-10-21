# java-calculator-precourse


# 🖩 문자열 덧셈 계산기


## 기능 목록


1. "덧셈할 문자열을 입력해 주세요."를 출력하는 기능
2. 사용자에게 문자열 입력받는 기능
    - 아무런 값도 입력되지 않았을 때는 0을 출력한다.
    - 음수를 입력받을시 예외로 처리한다.
    - 기본 구분자 -> `,`, `:`
    - 커스텀 구분자는 `//`와 `\n` 사이에 위치하는 문자이다.
    - 잘못된 값을 입력할 경우는 `IllegalArgumentException` 발생시킨 후 종료되어야 한다.
3. 커스텀 구분자가 있는지 확인하는 기능
4. 커스텀 구분자가 있다면, 커스텀 구분자를 추출하고 문자열에서 계산해야 할 부분만 추출하는 기능
5. 커스텀 구분자가 있다면 구분자로 지정하는 기능
7. 문자열을 구분자를 기준으로 구분하는 기능
8. 구분된 문자열들을 정수형으로 변환하는 기능
9. 정수형으로 변환된 각 숫자의 총합을 구하는 기능
10. 구해진 총합을 출력하는 기능


## 배울 내용


- 객체 지향 프로그래밍
- 객체 지향 생활 체조 9가지 원칙
- java 구현 능력
- test code
- 예외 처리
- mvc 동작 구조


# 클래스 및 구조 설계


├───.gradle
│   ├───8.7
│   │   ├───checksums
│   │   ├───dependencies-accessors
│   │   ├───executionHistory
│   │   ├───expanded
│   │   ├───fileChanges
│   │   ├───fileHashes
│   │   └───vcsMetadata
│   ├───buildOutputCleanup
│   └───vcs-1
├───.idea
│   └───inspectionProfiles
├───gradle
│   └───wrapper
├───out
│   ├───production
│   │   └───classes
│   │       └───calculator
│   │           ├───controller
│   │           ├───model
│   │           └───view
│   └───test
│       └───classes
│           └───calculator
└───src
    ├───main
    │   └───java
    │       └───calculator
    │           ├───controller
    │           ├───model
    │           └───view
    └───test
        └───java
            └───calculator



## 예외 처리


- **입력 예외**:
    - input이 null일 경우 IllegalArgumentException 발생.
    - validateNonNegative(int number): number가 음수일 경우 IllegalArgumentException 발생.
    - validateIsNumber(String token): token이 숫자로 변환할 수 없을 경우 IllegalArgumentException 발생.

- **분리자 예외**:
    - validateCustomDelimiter(String input): 구분자 형식이 올바르지 않을 경우 IllegalArgumentException 발생.
    - validateInputEndsWithNumber(String input, String activeSeparator): 입력이 구분자로 끝날 경우 IllegalArgumentException 발생.
    - validateNoConsecutiveDelimiters(String input, String separator): 연속된 구분자가 있을 경우 IllegalArgumentException 발생
    - -validateCustomDelimiterLength(String customSeparator): 구분자의 길이가 1자 가 아닌 경우 IllegalArgumentException 발생.
    - validateOnlyCustomDelimiterUsed(String input): 기본 구분자와 커스텀 구분자가 혼용될 경우 IllegalArgumentException 발생.

## 추가로 발생할 수 있는 문제상황?


1. 커스텀 구분자와 기본 구분자를 혼용해서 사용해도 되는가?
    - `앞의 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있다.` 외에 지정이니 기본 구분자에 더해 사용할 수 있는 커스텀 구분자를 추가하는 것이 맞다고 생각함.
2. 숫자가 들어가지 않은 구분자 사이 `, ,` 잘못된 입력으로 처리할 것인가? 0으로 처리할 것인가?
    - 0을 입력하고 싶었다면, 0을 넣어야만 처리해주는 것이 프로그램 의도가 명확해진다.
3. 커스텀 구분자가 숫자인 경우 검증 추가

README.md ver 2.0
