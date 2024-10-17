# java-calculator-precourse

## 1. IO

**입출력에 관한 기능**

### input()

`camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용하여 입력 구현

- 구분자와 양수로 구성된 문자열

### output()

입출력 요구사항에 맞게 출력 구현

- 덧셈 결과

```
덧셈할 문자열을 입력해 주세요.
1,2:3
결과 : 6
```

---

## 2. Logic

**로직에 관한 기능**

### checkDelimiter()

기본/커스텀 구분자를 체크하는 함수

### getNum()

숫자를 추출하는 함수

### calculate()

계산하는 함수

---

## 3. Exception

### 공통 구분자 예외

- 숫자 혹은 `//`로 시작하지 않는 문자열

### 기본 구분자 예외

- `,`, `:` 외의 구분자

### 커스텀 구분자 예외

- 올바르지 않은 커스텀 구분자 형식
- 기본/커스텀 외의 구분자