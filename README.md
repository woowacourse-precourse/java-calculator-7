# 🧮구현 기능 목록

## Step 1 : 요구사항 이해

### 1. 기본 구분자(쉼표, 콜론)를 사용하여 숫자들을 나누고 더하는 기능을 구현.
### 2. 커스텀 구분자를 입력받아 숫자들을 나누고 더하는 기능을 추가.
### 3. 잘못된 값 입력(숫자가 아닌 값, 음수 입력)시 예외 처리.

## Step 2 : 요구사항에 따른 기능 설계

### 1. 기본 구분자로 문자열 파싱 이후 합산.
#### 예 : "" => 0, "1,2" => 3, "1,2,3" => 6, "1,2:3" => 6

### 2. 기본 구분자 외에 커스텀 구분자 지정, 문자열 파싱 이후 합산.
#### 예 : "//;\n1;2;3"과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환

### 3. 예외 상황 처리
#### 숫자 이외의 값을 입력받거나, 음수를 입력받을 경우 IllegalArgumentException을 발생시켜 애플리케이션 종료.









