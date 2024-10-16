# java-calculator-precourse

### 기능 목록

- [x] 입력한 문자열에서 숫자 추출
- [x] 덧셈 결과 출력
- [x] 커스텀 구분자 지정 입력 처리
- [x] 예외 처리 및 에러 핸들링

---

### 코드 설명

1. 사용자에게 입력을 받음
```java
    System.out.println("덧셈할 문자열을 입력해 주세요.");
    String inputText = Console.readLine();
```

2. 기본 구분자 정규표현식 구성 및 커스텀 구분자 파싱 (다중 커스텀 구분자 허용)   
   (replaceAll의 마지막 결과는 덧셈을 할 숫자이므로 제거)
```java
    String delimiterRegex = "[,:]";
    String customDelimiterRegex = "//(.*?)\\\\n";
    String[] customDelimiters = inputText
            .replaceAll(customDelimiterRegex, "$1 ")
            .split(" ");
    customDelimiters = Arrays.copyOfRange(customDelimiters, 0, customDelimiters.length - 1);
```

3. 커스텀 구분자가 존재할 경우, 기본 구분자와 커스텀 구분자를 정규표현식으로 병합  
    (커스텀 구분자를 제거한 문자열로 변경)
```java
    if (customDelimiters.length > 0) {
        delimiterRegex = String.format("(%s|%s)", delimiterRegex, String.join("|", customDelimiters));
        inputText = inputText.replaceAll(customDelimiterRegex, "");
    }
```

4. 입력값이 유효한지 확인 후, 예외 처리  
   (커스텀 구분자,':',';')로 숫자가 구분 되어있는지, 문자 형식이 맞는지 확인)
```java
    String expressionRegex = String.format("^(%s)*(([0-9]+)%s)*[0-9]+$", customDelimiterRegex, delimiterRegex);
    if (!inputText.matches(expressionRegex)) {
        throw new IllegalArgumentException("입력 값이 올바르지 않습니다.");
    }
```

5. 더해야 할 값들을 정수로 변경 및 덧셈, 결과 출력
```java
    Integer sum = Arrays.stream(inputText.split(delimiterRegex))
        .map(Integer::parseInt)
        .reduce(Integer::sum)
        .orElse(0);
    
    System.out.printf("결과 : %d\n", sum);
```

---

<details>
<summary>전체 구현 코드</summary>

```java
   public static void main(String[] args) {
    // TODO: 프로그램 구현
    System.out.println("덧셈할 문자열을 입력해 주세요.");
    String inputText = Console.readLine();

    String delimiterRegex = "[,:]";
    String customDelimiterRegex = "//(.*?)\\\\n";
    String[] customDelimiters = inputText
            .replaceAll(customDelimiterRegex, "$1 ")
            .split(" ");
    customDelimiters = Arrays.copyOfRange(customDelimiters, 0, customDelimiters.length - 1);

    if (customDelimiters.length > 0) {
        delimiterRegex = String.format("(%s|%s)", delimiterRegex, String.join("|", customDelimiters));
        inputText = inputText.replaceAll(customDelimiterRegex, "");
    }

    String expressionRegex = String.format("^(%s)*(([0-9]+)%s)*[0-9]+$", customDelimiterRegex, delimiterRegex);
    if (!inputText.matches(expressionRegex)) {
        throw new IllegalArgumentException("입력 값이 올바르지 않습니다.");
    }

    Integer sum = Arrays.stream(inputText.split(delimiterRegex))
            .map(Integer::parseInt)
            .reduce(Integer::sum)
            .orElse(0);
    
    System.out.printf("결과 : %d\n", sum);
    
}

```
</details>