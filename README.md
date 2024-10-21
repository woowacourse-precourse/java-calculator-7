# java-calculator-precourse

# 최초 문제풀이

- Application class의 main 함수
    - 사용자 입력을 받는다.
    - Calculator 클래스의 add 함수를 호출한다.
    - 결과를 출력한다.


- Calculator 클래스
    - 문자열 분리 및 합계 계산
    - 예외처리

---

# Refactoring

### 주요 목적

- Package 구조화
- 클래스 분리
- 단일 책임 원칙 준수
- 예외 처리 클래스 추가
- 테스트 코드 추가
- 예외처리 정리 및 추가

## 1. Parser

문자열(사용자 입력)을 파싱 처리

## 2. Validator

커스텀 구분자 유효성 검사

## 3. Calculator

숫자들의 총합을 계산

## 3. Exception

예외 사항 정의 및 처리 클래스

---

### 1. 입력

- [x] 덧셈할 문자열을 입력해 주세요.
- [x] 사용자로부터 문자열을 입력받는다.
- [x] 입력받은 문자열이 빈 문자열일 경우 0을 반환한다.

### 2. 문자열 분리 및 합산

- [x] 문자열을 쉼표(,) 또는 콜론(:)을 기준으로 분리하고 분리한 숫자의 합을 반환한다.
- [x] 커스텀 구분자가 지정된 경우 해당 구분자를 사용하여 숫자의 합을 계산한다.

### 3. 출력

- [x] "결과 : 결과값" 형태로 출력한다.

### 4. 예외처리

- [x] 음수가 포함된 경우 IllegalArgumentException 예외를 발생시킨다.
- [x] 숫자 이외의 값이 포함된 경우 IllegalArgumentException 예외를 발생시킨다.
- [x] 커스텀 구분자가 숫자인 경우 IllegalArgumentException 예외를 발생시킨다.
- [x] 커스텀 구분자의 길이가 1이 아닌 경우 IllegalArgumentException 예외를 발생시킨다.
- [x] 커스텀 구분자가 기본 구분자와 중복되는 경우 IllegalArgumentException 예외를 발생시킨다.
- [x] 계산 결과가 표현 범위를 초과하는 경우 IllegalArgumentException 예외를 발생시킨다.

