# java-calculator-precourse

## 계획 (기능)

### 1. 간단하게 돌아가는 프로그램 작성

- 사용자로부터 입력받기
- 입력받은 문자열을 파싱하기
    - 커스텀 구분자 파싱하기
    - 숫자 파싱하기
- 숫자 더하기

### 2. 숫자 유형 확장하기

- 실수 허용하기

### 3. 리팩터링

- `lexer`, `parser` 분리하기

## Sequence

### `SimpleParser` (`Stream`과 `RegEx`를 통해 구현)

```mermaid
sequenceDiagram
    actor U as User
    box rgba(50, 150, 150, 0.5)
        participant M as Main
        participant P as Parser
    end

    U ->>+ M: numbers with or without delimiters
    M ->>+ P: parse user input
    P -->>- M: numbers
    M -->>- U: sum of the numbers
```

### `MyParser` (`Parser`와 `Lexer` 분리)

```mermaid
sequenceDiagram
    actor U as User
    box rgba(50, 150, 150, 0.5)
        participant M as Main
        participant P as Parser
        participant L as Lexer
    end

    U ->>+ M: numbers with or without delimiters
    M ->>+ P: parse user input
    loop until get all tokens
        P ->>+ L: get next token
        L -->>- P: token
    end
    P -->>- M: numbers
    M -->>- U: sum of the numbers
```

## 파서 성능 비교

> 테스트 방법은 [`src/test/java/calculator/PerformanceTest`](https://github.com/goldentrash/java-calculator-7/blob/whitepiano/src/test/java/calculator/PerformanceTest.java)를 참고하세요.

![image](https://github.com/user-attachments/assets/3551c557-6538-49a2-a8d6-d554d861ed06)
