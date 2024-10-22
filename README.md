# java-calculator-precourse

## 기능 목록

### 1. calculate 패키지

- [x] 배열을 순회하며 숫자 요소들을 더하는 기능 (getNumSum)
- [x] 결과를 출력하는 기능 (printResult)

### 2. input 패키지

- [x] 입력 전 메시지를 출력하고, 문자열을 입력받는 기능(getInput)

### 3. split 패키지

- [x] 구분자를 가진 문자열을 추출하는 기능 (getSeparator)
  - isInputStartWithSlash, validateNewLineInput 을 만족할 때
    - 문자열은 처음으로 나오는 "\n" or "\\n"을 기준으로 나눈다.
    - 앞 문자열의 시작 부분인 "//"를 제거하여 리턴한다.
    - "//"와 "\n" 또는 "//"와 "\\n" 사이가 빈 문자열일 경우, ""를 리턴한다.
    - 기본 구분자 ",", ":"를 추가로 등록한다.
  - 그 외 경우
    - 기본 구분자 ",", ":"를 구분자로 등록한다.
- [x] 계산해야 하는 문자열을 추출하는 기능 (getCalFormula)
  - "\n" or "\\n"을 기준으로 문자열이 나눠질 때
    - 문자열은 처음으로 나오는 "\n" or "\\n"을 기준으로 나눈다.
    - "\n" or "\\n" 뒷 부분이 빈 문자열이면 ""를 리턴해야 한다.
    - 해당 문자열을 계산식으로 등록한다.
  - 그 외 경우
    - 해당 문자열을 계산식으로 등록한다.
- [x] 구분자를 기준으로 문자열을 끊고 배열을 만드는 기능 (splitCalFormulaBySeparator)
  - 구분자는 정규 표현식으로 표현되어야 한다.
  - 끊은 문자열은 숫자로 변환되어야 한다.
- [x] 문자열을 숫자로 만드는 기능 (stringToNum)
  - 빈 문자열 ""은 0으로 변환되어야 한다.

### 4. validate 패키지

- [x] 입력받은 문자열이 null인지 검증하는 기능 (validateNotNullInput)
- [x] 입력받은 문자열이 "//"로 시작하는지 확인하는 기능 (isInputStartWithSlash)
- [x] 입력받은 문자열이 "//"로 시작하는 경우, 입력받은 문자열에 "\n"이나 "\\n"이 있는지 검증하는 기능 (validateNewLineInput)
  - "\n"은 개행문자이다.
  - "\\n"은 "\\"가 먼저 처리되어 이스케이프 문자인 "\"와 "n"으로 변환된다.
- [x] 구분자를 가진 문자열을 검증하는 기능 (validateSeparator)
  - 구분자를 가진 문자열에 숫자가 있는지 확인한다.
- [x] 계산해야 하는 문자열의 유효성을 검증하는 기능(validateCalFormula)
  - 계산해야 하는 문자열이 빈 경우,
  - 계산해야 하는 문자열에 숫자, 구분자 외 다른 문자가 있는지 확인한다.

---

## package 구조

```
calculator
  ├── input
  │   └── StringInput.java
  ├── split
  │   └── StringSplit.java
  ├── validate
  │   └── StringValidate.java
  └── calculate
      └── Calculator.java
```
