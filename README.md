# java-calculator-precourse

<br>
<br>

## Requirements

---

### 1. User

- 문자열을 입력할 수 있다. 
  - 어떤 문자열이든 입력할 수 있다.
    - 빈 문자열도 입력할 수 있다.
  - 기본 구분자를 포함하여 입력할 수 있다.
    - 기본 구분자란, 쉼표(,) 또는 콜론(:)을 의미한다.
    - 문자열 앞뒤 어디든 위치할 수 있다.
  - 커스텀 구분자를 포함아여 입력할 수 있다.
    - 커스텀 구분자란, // 와 \n 사이에 위치하는 구분자를 의미한다.
    - 문자열 바로 앞에 작성해줘야 한다. (Ex. "//;\n1;2;3")
    - Ex)  "//;\n1;2;3", "//;※\n1;※2;※3"
- 입력 결과를 콘솔에서 확인할 수 있다.
- 출력(덧셈) 결과를 콘솔에서 확인할 수 있다.

<br>

### 2. System

- 주어진 문자열에서 숫자만 파싱해야 한다.
- 다음의 경우는 0으로 간주한다.
  - 사용자가 빈 문자열을 입력했을 경우
  - 추출한 결과가 비어있을 경우
- 추출된 숫자들을 더해야 한다.
- 덧셈 결과를 사용자에게 제공해야 한다. 
- 사용자가 잘못된 입력을 했을 경우 적절한 예외를 발생시킨 후 애플리케이션을 종료한다.

<br>
<br>

## Exceptions

---

### 1. User

- 커스텀 구분자를 정의하지 않고, 커스텀 구분자를 사용한 경우
- 커스텀 구분자를 두 번 이상 사용한 경우
- 숫자 이외의 문자를 입력한 경우

<br>

### 2. System

- 파싱된 값이 음수인 경우 
- 파싱된 값이 숫자가 아닌 문자일 경우

<br>
<br>

## Main Functions

---

### CalculateSystem

|Method|Parameter| Return Type | Exception | Implementation |
|------|---------|-------------|-----------|----------------|
|sum();|x        | Integer     | -         | TODO           |

<br>

### SeparateManager

| Method                       | Parameter | Return Type  | Exception                  | Implementation |
|------------------------------|-----------|--------------|----------------------------|----------------|
| getAllDelimiters();          | x         | String       | -                          | TODO           |
| extractCustomDelimiter(x);   | String    | void         | -                          | TODO           |
| split(x);                    | String    | List<String> | -                          | TODO           |
| validateRegex(x);            | x         | void         | NotAllowedFormatException  | TODO           |

<br>

### Numbers

| Method                     | Parameter       | Return Type | Exception                   | Implementation |
|----------------------------|-----------------|-------------|-----------------------------|----------------|
| validateMinusNumber(x);    | List<Integer>   | void        | NotAllowedFormatException   | TODO           |


<br>

### InputManager

| Method                       | Parameter     | Return Type   | Exception                     | Implementation |
|------------------------------|---------------|---------------|-------------------------------|----------------|
| enterString                  | x             | List<Integer> | -                             | TODO           |
| validateCustomDelimiterCount | x             | void          | ExceedDelimiterCountException | TODO           |
| validateIntParsing           | x             | void          | CannotParsingException        | TODO           |






<br><br><br><br><br><br><br>