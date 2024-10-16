# 제목 없음

# 기능 목록

| **Package** | **Class** |
| --- | --- |
| 💬 **view** | **InputView** |
|  | **OutputView** |
| 💾 **domain** | **InputStringSeparator** |
|  | **SumCalculator** |
| 🎮 **Controller** | **CalculatorController** |

## 💬 **view**

### **InputView**

- 사용자의 입력을 받음

### **OutputView**

- 시작 메시지 출력함
- 결과를 출력함

## 💾 **domain**

< 문자열 특징 >
• 기본 구분자(, :)를 가지는 문자열 || 커스텀 구분자를 가지는 문자열을
• 커스텀 구분자는 문자열 앞부분의 "//"와 "\n" 사이에 위치하는 문자

### **InputStringSeparator**

- 사용자의 입력을 저장함
- 커스텀 구분자를 분리함
- 구분자를 기준으로 숫자를 분리함

- 사용자가 입력한 문자열의 유효성 검사함 후 예외처리
  - //와 \n 가 두 개가 다 있는지 || 둘다 없는지 검사
    → //가 있다면 이거로 시작하는지 검사
  - 숫자는 양수 인지 검사

- 다음은 자동으로 예외처리 되서 구현을 안함
  → **NumberFormatException**으로 처리됨
  - 숫자 이외에 다른 것을 것을 입력했는지 검사
  - 따로 커스텀 구분자 지정없이 다른 구분자를 사용하여 입력할 때

### **SumCalculator**

- 숫자를 추출함
- 숫자를 더함

## 🎮 Controller

### **CalculatorController**

- 계산을 시작함
