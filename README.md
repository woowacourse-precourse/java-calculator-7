# 1주차 미션 - 문자열 덧셈 계산기

---
Github: https://github.com/sso9594/java-calculator-7.git

Notion: https://bit.ly/403pBxN
## 📝기능 구현 목록

---
### 문자열 입력 기능
- camp.nextstep.edu.missionutils에서 제공하는 Console API를 사용하여 구현해야 한다.
    - 사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.

---
### 커스텀 구분자 등록 기능
- 커스텀 구분자 `//{커스텀_구분자}\n` 를 가지고 있는지 확인하고 구분자로 등록한다.

---
### 문자열 검사 기능
- 다음 경우들을 체크하는 검사기를 만든다.
    - 숫자 앞에 구분자가 없는 경우
        - 기본 구분자와 커스텀 구분자 모두 없는 경우
    - 구분자 뒤에 숫자가 없는 경우
        - ex) `:,1`

---
### 숫자 추출 기능
- 구분자를 기준으로 숫자를 추출

---
### 덧셈 연산 기능
- 추출한 숫자를 덧셈

---
### 결과값 출력 기능
- 덧셈 결과 출력

---
### 예외 처리 기능
- 문자열 검사 기능에서 통과하지 못한 요청은 예외 처리
    - `IllegalArgumentException`을 발생하고 애플리케이션을 종료한다.