# java-calculator-precourse

## 기능 요구 사항

<aside>
  🧮 입력한 문자열에서 숫자를 추출하여 더하는 계산기를 구현한다.
</aside>

- 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환한다.
  - 예: "" => 0, "1,2" => 3, "1,2,3" => 6, "1,2:3" => 6
- 앞의 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 "//"와 "\n" 사이에 위치하는 문자를 커스텀 구분자로 사용한다.
  - 예를 들어 "//;\n1;2;3"과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.

---

## 입/출력 요구 사항

### **입력**

- 구분자와 양수로 구성된 문자열

### **출력**

- 덧셈 결과

```java
결과 : 6
```

### 실행 결과 예시

```java
덧셈할 문자열을 입력해 주세요.
1,2:3
결과 : 6
```

---

## 구현 계획

큰 Class를 InputStringParser, ListValidator, ListCalculator, Calculator로 구분한다.

주요 기능은 다음과 같다.

- InputStringParser

  → input String을 숫자 List로 반환한다.

- ListValidator

  → 숫자 List의 값이 유효한지 검사한다.

- ListCalculator

  → 숫자 List의 sum을 계산한다.

- Calculator

  → 위 세 component를 이용하여 input string으로부터 계산 결과를 도출한다.


## Class 구현 계획

1. InputStrignParser
  - List<Long> `parse`(String input)

    → 아래 메서드를 활용하여 string을 List<Long>으로 변환하여 return한다.

  - List<Long> `convertStringToList`(String input, String regex)

    → String을 regex을 바탕으로 split해서 return한다.

  - String `createDelimiterRegex`(String input)

    → String을 regex에서 사용가능한 형태로 변환해서 return 한다.

  - String `removeCustomDelimiterFromOriginal` (String input)

    → String중에서 customDelimiter가 있다면 제거해서 return한다.

  - Optional<String> `extractCustomDelimiter`(String input)

    → String중에서 customDelimiter를 찾아 Optional<String>으로 return한다.

    만약, customDelimiter가 없다면 Optional.empty를 return한다.

  - Matcher `getCustomDelimiterMatcher`(String input)

    → Pattern class를 이용해 RegexCustomDelimter를 찾아 Matcher타입으로 return한다.


2. ListValidator
  - void static `validatePositiveNumberList`(List<Long> list)

    → list에 0 혹은 음수가 있으면 IllegalArgumentException을 throw한다.


3. ListCalculator
  - long `calculate`(List<Long> input)

    → list의 sum을 long타입으로 return 한다.

4. Calculator
  - long `calculate`(String input)

    → 위의 세 class를 이용하여 input을 받아서 input의 sum을 반환한다.