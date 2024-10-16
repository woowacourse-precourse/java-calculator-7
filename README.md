# java-calculator-precourse

# 구현할 기능 목록

## 입력

- [ ] 게임 시작 메시지 출력
- [ ] 문자열 입력

## 출력

- [ ] 덧셈 결과 출력

## 기능

- [ ] 쉼표(,) 또는 콜론(:)을 구분자로 설정
- [ ] "//"와 "\n" 사이에 위치하는 문자를 커스텀 구분자로 설정
- [ ] 구분자 기준으로 문자열 분리
- [ ] 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생
    - [ ] 커스텀 구분자로 설정하는 문자열이 "//" "구분자 문자열" "\n"의 순서가 아니게 입력될 때
    - [ ] 구분자와 커스텀 문자열을 등록하는 문자열 이외의 문자열이 입력될 때
- [ ] 합산된 결과값 계산

### Main

- Application
    - [ ] `CalculatorController`를 통해 계산기를 실행

### Model

- Calculator (계산기)
    - [X] 계산 결과값을 출력
- DelimiterManager (구분자 매니저)
    - [ ] "//"와 "\n" 사이에 위치하는 문자를 커스텀 구분자로 등록
    - [ ] 커스텀 구분자로 설정하는 문자열이 "//" "구분자 문자열" "\n"의 순서가 아니게 입력됐다면 IllegalArgumentException을 발생
- StringSplitter (문자열 분할기)
    - [ ] 구분자를 기준으로 문자열 분리
    - [ ] 구분자와 커스텀 문자열을 등록하는 문자열 이외의 문자열이 입력됐다면 IllegalArgumentException을 발생

### View

- InputView (사용자의 입력을 받는 UI)
    - [ ] 게임 시작 메시지 출력
    - [ ] 문자열 입력
- OutputView (결과를 출력하는 UI)
    - [ ] 덧셈 결과 출력

### Controller

- CalculatorController
    - [ ] `InputView`로부터 사용자의 입력을 받아 계산기 로직을 수행
    - [ ] `OutputView`를 통해 계산 결과를 출력

### Enum

- Separator (구분자)
    - [ ] 쉼표(,)와 콜론(:)을 구분자로 등록