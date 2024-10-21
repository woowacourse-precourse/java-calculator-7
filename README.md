# java-calculator-precourse

# Calculator Class

## 기능
이 프로그램은 `String input`을 입력받아 **Calculator Class**를 통해 입력된 문자열에서 구분자를 추출하고, 숫자들을 분리하여 그 합을 계산하는 기능을 구현합니다. 구분자는 기본 쉼표(`,`)와 콜론(`:`) 외에도 사용자가 원하는 구분자를 사용할 수 있으며, 입력값에 따라 동적으로 처리됩니다.

## 메소드
### 1. getCustomSeparator(String input)
- 입력된 `input` 문자열에서 커스텀 구분자를 추출하는 메소드입니다. 커스텀 구분자는 문자열의 맨 앞부분에 `//`로 시작하고 그 뒤에 오는 구분자와 `\n`을 기준으로 처리됩니다.
- 구분자를 추출한 후, 그 구분자로 나머지 문자열을 분리하여 `numString`으로 반환합니다.

### 2. getSum(String numString)
- `numString`에서 지정된 구분자를 기준으로 숫자들을 분리하고, 그 숫자들의 합을 계산합니다.
- 잘못된 형식의 입력이 주어진 경우, 예외를 발생시키며, 입력값에 적합한 숫자들의 합을 반환하는 것을 목표로 합니다.

## 사용 예시
```java
Calculator calculator = new Calculator();
String input = "//;\n1;2;3";
String numString = calculator.getCustomSeparator(input);
int sum = calculator.getSum(numString);

System.out.println("결과: " + sum);  // 출력: 결과: 6
