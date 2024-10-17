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
### Model
#### Calculator
👉 **입력 받은 숫자로 구성된 문자열을 계산하기 위한 클래스**
- **Field**
  - `numbers` : 입력받은 숫자로 구성된 문자열

- **Method**
  - `calculator()` : 생성자
  - `plus()` : 모든 숫자 더하기
  - `checkSeparator()` : 구분자 여부 확인하기

### View
#### InputView
👉 **입력을 받기 위한 클래스**
- **Field**
  - `USER_NUMBERS` : "덧셈할 문자열을 입력해 주세요."

- **Method**
  - `readUserNumbers()` : 숫자로 구성된 문자열 입력 받기
#### OutputView
👉 **출력하기 위한 클래스**
- **Field**
  - `RESULT_MESSAGE` : "결과 : "

- **Method**
  - `printSumToUser()` : 계산 결과를 출력하기

### Controller
#### MainController
👉 **전체 시스템에서 사용자의 요청을 처리하고, 모델과 상호작용을 위한 클래스**
- **Method**
  - `start()` : 애플리케이션 시작하기
  - `readUserNumbers()` : 사용자로부터 입력 받기
  - `calculate()` : 입력 받은 숫자를 계산하기
  - `printSumToUser()` : 계산 결과를 사용자에게 출력하기

### Validation
#### InputValidator  
👉 **예외를 확인하기 위한 클래스**
- **Field**
  - `NON_NATURAL_NUMBER` : "자연수가 아닙니다."
  - `INVALID_CUSTOM_DELIMITER` : "커스텀 구분자가 정상적으로 입력되지 않았습니다."

- **Method**
  - `validateNaturalNumber()` : 사용자가 제시한 문자열 유효성 검사
  - `validateCustomDelimiter()` : 사용자가 제시한 커스텀 구분자 유효성 검사
