# java-calculator-precourse

## 기능 목록

### 1. 사용자로부터 문자열 입력받는다. (input 패키지)

- [x] 입력 전 메시지를 출력하고, 문자열을 입력받는 기능(getInput)

### 2. 입력받은 문자열의 유효성을 검증한다. (validate 패키지)

- [x] 입력받은 문자열의 유효성을 검증하는 기능(validateInput)
  - 입력받은 문자열이 null이거나 빈 경우 IllegalArgumentException을 던진다.
  - 입력받은 문자열이 "//"로 시작하지 않으면 IllegalArgumentException을 던진다.
  - 입력받은 문자열에 "\n"이 없으면 IllegalArgumentException을 던진다.

### 3. "\n"을 기준으로 입력받은 문자열을 2개로 나눈다 (split 패키지)

- [x] "\n"앞에 있는 구분자들을 가진 문자열을 추출하는 기능 (getFrontString)
  - 문자열은 처음으로 나오는 "\n"을 기준으로 나눈다.
  - 앞 문자열의 시작 부분인 '//'를 제거하여 리턴한다.
  - '//'와 '\n' 사이가 빈 문자열일 경우, ""를 리턴한다.
- [x] "\n"뒤에 있는 계산해야 하는 문자열을 추출하는 기능 (getBackString)
  - 문자열은 처음으로 나오는 "\n"을 기준으로 나눈다.
  - "\n" 뒷 부분이 빈 문자열이면 ""를 리턴해야 한다.

### 4. 구분자로 구성된 문자열을 검증한다. (validate 패키지)

- [x] 구분자를 가진 문자열을 검증하는 기능 (validateFrontString)
  - 구분자를 가진 문자열에 숫자가 있으면 IllegalArgumentException을 던진다.

### 5. 계산해야 하는 문자열을 검증한다. (validate 패키지)

- [x] 계산해야 하는 문자열의 유효성을 검증하는 기능(validateBackString)
  - 계산해야 하는 문자열에 숫자, 커스텀 구분자 외 다른 문자가 있으면 IllegalArgumentException을 던진다.

### 6. 계산해야 하는 문자열에서 숫자만 추출하여 배열을 만든다. (split 패키지)

- [x] 구분자를 기준으로 문자열을 끊고 배열을 만드는 기능 (splitStringBySeparator)
  - 구분자는 정규 표현식으로 표현되어야 한다.
  - 끊은 문자열은 숫자로 변환되어야 한다.
- [x] 문자열을 숫자로 만드는 기능 (stringToNumber)
  - 빈 문자열 ""은 0으로 변환되어야 한다.

### 7. 숫자를 더한다. (calculate 패키지)

- [ ] 배열을 순회하며 숫자 요소들을 더하는 기능
- [ ] 결과를 출력하는 기능

---

## package 구조

```
calculator
  ├── input
  │   └── StringInput.java
  ├── split
  │   ├── StringSplit.java
  │   └── NumberSplit.java
  ├── validate
  │   └── StringValidate.java
  └── calculate
      └── Calculator.java
```
