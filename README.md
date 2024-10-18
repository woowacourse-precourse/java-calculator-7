# java-calculator-precourse

## 구현할 기능 목록

## 1. 입출력 기능

### 입력 기능

- 입력 구분 기능
  - 입력 문자열이 `//`으로 시작하면 커스텀 구분자로 판단
  - 유효성 검증
    - 입력 문자열이 공백으로 시작하거나 공백으로 끝나면 예외 처리

- 기본 구분자 입력 기능
  - 유효성 검증
    - 입력값이 없는 경우("") 0으로 처리
    - 입력값이 공백인 경우 예외 처리
    - `:`, `,`와 숫자를 제외한 다른 문자가 있는 경우 예외 처리
      - 음수 처리
    - 문자열의 처음 문자가 숫자가 아니면 예외 처리

- 커스텀 구분자 입력 기능
  - 유효성 검증
    - `//`와 `\n`이 문자열에 없는 경우 예외 처리
    - 커스텀 구분자가 없는 경우(`//\n`) 예외 처리
    - 커스텀 구분자와 숫자가 아닌 다른 문자가 있는 경우 예외 처리
    - 문자열 처음 문자가 `//`이 아니라면 예외 처리

- 예외 처리
  - 오입력에대한 예외 처리는 `IllegalArgumentException`을 발생 후 어플리케이션 종료

### 출력 기능

- 계산 시작 메시지 출력 기능
- 계산 결과 메시지 출력 기능