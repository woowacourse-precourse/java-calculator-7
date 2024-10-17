# java-calculator-precourse

## 기능 목록

### 1. 사용자로부터 문자열 입력받는다. (input 패키지)

- [x] 입력 전 메시지를 출력하고, 문자열을 입력받는 기능(getInput)
- [x] 입력받은 문자열의 유효성을 검증하는 기능(validateInput)
  - 입력받은 문자열이 null이거나 빈 경우 IllegalArgumentException을 던진다.
  - 입력받은 문자열이 "//"로 시작하지 않으면 IllegalArgumentException을 던진다.
  - 입력받은 문자열에 "\n"이 없으면 IllegalArgumentException을 던진다.

### 2. "\n"을 기준으로 입력받은 문자열을 2개로 나눈다 (split 패키지)

- [ ] "\n"앞에 있는 구분자들을 가진 문자열을 추출하는 기능
- [ ] "\n"뒤에 있는 계산해야 하는 문자열을 추출하는 기능

### 3. 커스텀 구분자 정하기 (split 패키지)

- [ ] 구분자를 가진 문자열 내에 숫자가 있으면 IllegalArgumentException을 던지는 기능
- [ ] "//"와 "\n"사이에 있는 문자들을 각각 커스텀 구분자로 등록하는 기능

### 4. 숫자를 추출해야 하는 문자열을 검증한다. (validate 패키지)

- [ ] 문자열에 숫자, 커스텀 구분자 외 다른 문자가 있으면 IllegalArgumentException을 던지는 기능
- [ ] 문자열 내 커스텀 구분자가 연속해서 나온 곳이 있으면 IllegalArgumentException을 던지는 기능
- [ ] 문자열의 시작과 끝이 숫자가 아니면 IllegalArgumentException을 던지는 기능

### 5. 숫자 추출하여 배열을 만든다. (split 패키지)

- [ ] 커스텀 구분자를 기준으로 문자열을 끊고 숫자로 변환해 배열을 만드는 기능

### 6. 숫자를 더한다. (calculate 패키지)

- [ ] 배열을 순회하며 숫자 요소들을 더하는 기능
- [ ] 결과를 출력하는 기능

---

## package 구조

```
calculator
  ├── input
  │   └── stringInput.java
  ├── split
  │   ├── stringSplitter.java
  │   ├── separatorExtractor.java
  │   └── numberExtractor.java
  ├── validate
  │   └── stringValidator.java
  └── calculate
      └── Calculator.java
```
