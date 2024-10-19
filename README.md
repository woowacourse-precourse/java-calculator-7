# java-calculator-precourse

## 기능 목록

### 기본 기능

- [x] 프로그램 시작 문자열을 출력한다. (`덧셈할 문자열을 입력해 주세요.`)
- [x] 사용자로부터 문자열을 입력받을 수 있다.
- [x] 입력받은 문자열을 구분자(, 와 :)를 기준으로 분리한다.
- [x] 문자열을 분리해 추출한 숫자들의 합을 구한다.
- [x] 계산 결과를 형식에 맞게 출력한다. (`결과 : <합>`)
- [x] 사용자가 커스텀 구분자를 지정할 수 있다.

### 예외 처리

- [x] 빈 문자열이 입력되었을 때, 결과값을 0으로 처리한다.
- [ ] 유효하지 않은 입력일 때 `IllegalArgumentException`을 발생시키고 종료한다.
    - [x] 숫자 또는 구분자가 아닌 문자가 포함되어있을 때
    - [x] 구분자 사이가 빈문자열일 때
    - [x] 0 또는 음수가 입력되었을 때
    - [ ] 커스텀 구분자 입력 양식이 잘못됐을 때
    - [ ] 커스텀 구분자로 .(소수점) 또는 숫자가 지정되었을 때
