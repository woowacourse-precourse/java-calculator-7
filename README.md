# java-calculator-precourse

## 📝 기능 목록
1. 양수로 구성된 문자열 입력 받기
    - **예외처리**: 구분자 기준으로 분리 후 문자열, 음수, 공백, 빈 문자열이 있을 경우 -> 자연수가 아닌 경우로 통합
2. 커스텀 구분자 여부 확인
    - **예외처리**: `"//"`와 `"\n"` 사이에 공백이 있을 경우
    - **예외처리**: `"//"`와 `"\n"` 사이에 빈 문자열이 있을 경우
    - **예외처리**: `"//"`와 `"\n"` 사이에 숫자가 있을 경우
    - **예외처리**: `"//"`와 `"\n"` 둘 다 없거나 둘 중 하나만 있을 경우
3. 결과 출력

## Use Case 시나리오
### 기본 흐름

| **단계** | **사용자**                            | **시스템**                                    |
|---------|------------------------------------|--------------------------------------------------|
| 1       | 사용자가 양수로 구성된 문자열을 입력한다.     | 시스템이 입력된 문자열을 확인한다.                                             |
| 2       | -                                 | 시스템이 커스텀 구분자 여부 확인한다.                                               |
| 3       | 사용자가 결과를 확인한다.   | 시스템이 계산 결과를 출력한다.        |

### 대체 흐름 및 예외 흐름

| **조건**                   | **시스템 반응**                                       |
|--------------------------|-----------------------------------------------------|
| 문자열이 자연수로 구성되어 있지 않는 경우   | 애플리케이션을 종료시킨다.   |
| 커스텀 구분자 입력이 올바르지 않는 경우     | 애플리케이션을 종료시킨다.    |


## Use Case  다이어그램
![첫주차미션_유스케이스_다이어그램](https://github.com/user-attachments/assets/f0f818d0-6ee7-40fc-bb6d-8f81956f2dec)

## MVC
🔵 **Model**

### Calculator
👉 입력받은 숫자 문자열 배열을 합산하는 클래스

**- 메서드**  
`String plus(String[] splitedNumbers)`: 분할된 숫자들의 합산한 결과 구하기

### CustomDelimiter
👉 사용자로부터 입력받은 수식에서 커스텀 구분자를 처리하는 클래스

**- 필드**  
`String formula`: 사용자로부터 입력받은 수식 문자열

**- 생성자**  
`CustomDelimiter(String formula)`: 수식 문자열을 초기화하기

**- 메서드**  
`String getFormula()`: 수식 문자열을 반환하기  
`String getCustomDelimiter()`: 커스텀 구분자를 추출하기
`Integer checkCustomDelimiter()`: 커스텀 구분자의 위치를 반환하기  
`String getNumbersPart()`: 수식에서 연산부분만을 추출하기

### Splitter
👉 수식 문자열을 구분자를 기준으로 분할하는 클래스

**- 필드**  
`String[] splittedNumbers`: 분할된 숫자 문자열 배열

**- 생성자**  
`Splitter(CustomDelimiter customDelimiter)`: 숫자 문자열 배열을 초기화하기

**- 메서드**  
`String[] getSplittedNumbers()`: 분할된 숫자 문자열 배열을 반환하기  
`String[] splitNumbers(CustomDelimiter customDelimiter)`: 구분자 기준으로 수식 문자열을 분할하기

---

🟡 **View**

### InputView
👉 사용자로부터 입력을 받는 클래스

**- 상수 필드**  
`USER_NUMBERS`: "덧셈할 문자열을 입력해 주세요."

**- 메서드**  
`String readUserNumbers()`: 사용자로부터 수식 문자열을 입력받기

### OutputView
👉 계산 결과를 출력하는 클래스

**- 상수 필드**  
`RESULT_MESSAGE`: "결과 : "

**- 메서드**  
`void printSumToUser(String sumOfNumbers)`: 계산 결과를 출력하기

---

🔴 **Validation**

### Validator
👉 입력값의 유효성을 검사하는 클래스

**- 상수 필드**  
`INVALID_OPERAND`: "피연산자가 잘못 입력되었습니다."  
`INVALID_CUSTOM_DELIMITER`: "커스텀 구분자가 정상적으로 입력되지 않았습니다."

**- 메서드**  
`int parseNumber(String token)`: 0 이하의 수나 숫자가 아닌 경우 예외를 발생시키기  
`void isValidDelimiter(String delimiter)`: 커스텀 구분자가 숫자를 포함할 경우 예외를 발생시키기  
`void isThereSeparator(int delimiterEndIndex)`: 커스텀 구분자의 종료 문자가 없는 경우 예외를 발생시키기  

---