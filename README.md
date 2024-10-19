# java-calculator-precourse

## 📝기능 목록

### 사용자 문자열 입력 기능

- [ ] 계산기 시작 안내 문자열 `덧셈할 문자열을 입력해 주세요.` 상수화

- [ ] 계산기 시작 안내 문자열 출력

- [ ] 입력 받기

    - [ ] `camp.nextstep.edu.missionutils.Console`의 readLine() 활용

### 구분자 설정 기능

- [ ] 커스텀 구분자 사용여부 확인 기능
- [ ] 기본 구분자 설정 기능
- [ ] 커스텀 구분자 설정 기능
    - [ ] 구분자 추출 함수
        - [ ] 구분자로 숫자가 들어왔을 경우 `IllegalArgumentException` 발생 ex. "//6\n1"
        - [ ] 구분자가 하나의 문자가 아닌 경우 `IllegalArgumentException` 발생 ex. "//^^\n1^^2"

### 숫자 추출 기능

- [ ] 구분자 기준 문자열 추출
    - [ ] 구분자가 문자열을 올바르게 분리하지 못하는 경우 `IllegalArgumentException` 발생 ex. "1,", ":"
- [ ] 추출 문자열 숫자로 변환
    - [ ] 숫자 이외 문자가 섞인 경우 `IllegalArgumentException` 발생 ex. "b"
    - [ ] 숫자가 Integer 범위를 넘어갈 경우 `IllegalArgumentException` 발생 ex. "2147483648"

### 계산 기능

- [ ] 특별한 케이스의 계산 기능
- [ ] 일반적인 케이스의 덧셈 기능
    - [ ] 숫자의 합이 Integer 범위를 넘어갈 경우 `IllegalArgumentException` 발생

### 계산 결과를 출력하는 기능

- [ ] 계산기 결과 문자열 `결과 : ` 상수화
- [ ] 계산기 결과 문자열 출력