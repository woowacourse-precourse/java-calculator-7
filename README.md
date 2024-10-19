# java-calculator-precourse

# 구현할 기능 목록

## 입력

- [X] 게임 시작 메시지 출력
- [X] 문자열 입력

## 출력

- [X] 덧셈 결과 출력

## 기능

- [X] "//"와 "\n" 사이에 위치하는 문자를 커스텀 구분자로 설정
- [X] 구분자 기준으로 문자열 분리
- [X] 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생
    - [X] 커스텀 구분자로 설정하는 문자열이 "//" "구분자 문자열" "\n"의 순서가 아니게 입력될 때
    - [X] 구분자와 커스텀 문자열을 등록하는 문자열 이외의 문자열이 입력될 때
- [X] 합산된 결과값 계산

### Main

- Application
    - [ ] `CalculatorController`를 통해 계산기를 실행

### Model

- Calculator (계산기)
    - [X] 계산 결과값을 출력
- Validator (유효성 검사기)
    - [X] 구분자가 하나의 문자가 아니면 IllegalArgumentException을 발생
    - [X] 잘못된 커스텀 구분자 형식이면 IllegalArgumentException을 발생
    - [X] 숫자로 변활될 수 없는 값이 있으면 IllegalArgumentException을 발생
    - [X] 입력 문자열이 비어 있으면 IllegalArgumentException을 발생
    - [X] 구분자 리스트가 비어 있으면 IllegalArgumentException을 발생
    - [X] 음수가 사용되었을 때 IllegalArgumentException을 발생
- DelimiterManager (구분자 매니저)
    - [X] "//"와 "\n" 사이에 위치하는 문자를 커스텀 구분자로 등록
    - [X] 커스텀 구분자로 설정하는 문자열이 "//" "구분자 문자열" "\n"의 순서가 아니게 입력됐다면 IllegalArgumentException을 발생
- StringSplitter (문자열 분할기)
    - [X] 구분자를 기준으로 문자열 분리
    - [X] 구분자와 커스텀 문자열을 등록하는 문자열 이외의 문자열이 입력됐다면 IllegalArgumentException을 발생
    - [X] 구분자로 등록되지 않았는데, '-'가 들어오면 IllegalArgumentException을 발생

### View

- InputView (사용자의 입력을 받는 UI)
    - [X] 게임 시작 메시지 출력
    - [X] 문자열 입력
- OutputView (결과를 출력하는 UI)
    - [X] 덧셈 결과 출력

### Controller

- CalculatorController
    - [ ] `InputView`로부터 사용자의 입력을 받아 계산기 로직을 수행
    - [ ] `OutputView`를 통해 계산 결과를 출력

### Enum

- Separator (구분자)
    - [X] 쉼표(,)와 콜론(:)을 구분자로 등록
- CustomDelimiterPattern (구분자 검증 패턴)
    - [X] "//"와 "\n"을 구분자 검증 패턴으로 등록