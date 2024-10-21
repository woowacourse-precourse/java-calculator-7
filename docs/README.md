# 기능 목록

## Service

### 1. CalculateService

목적 : 계산 로직 프로세스를 담당한다.

- methods :
- int calculate

### 2. OperatorService

목적 : 문자열 내 구분자와 관련된 로직을 처리한다.

- methods :
- void indexingOperators
- void validateOperator
- String extractCustomOperators

### 3. OperandService

목적 : 문자열 내 피연산자와 관련된 로직을 처리한다.

- methods :
- void indexingOperands
- int saveOperand

### 7. Validator

- methods : validateLetterContain

## Controller

### 6. CalculateController

- methods :
- int calculate

## Exception

### 11. ErrorCode

- attributes : INVALID_INPUT, INVALID_OPERATOR

### 12. CustomException

- attributes : ErrorCode

# 스스로 정의한 케이스

- 문자 입력값은 허용하지 않는다.
- 구분자는 단일 기호만 허용한다.
- 양수는 2자리 이상을 허용한다.
- 커스텀 구분자는 문자열 중간에서도 정의할 수 있다.

