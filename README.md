# 프리코스 1주차 미션 - 문자열 덧셈 계산기

> 우아한테크코스 7기 1주차 미션, 문자열 덧셈 계산기를 구현한 저장소입니다.

&nbsp;

![Java](https://img.shields.io/badge/Java-17-orange)

&nbsp;

# 🏂 전체적인 흐름
1. 사용자로부터 문자열을 입력받는다.
2. 구분자 형식에 대하여 확인한다.
3. 잘못된 값을 입력한 경우 에러를 발생시킨 후 종료한다.
4. 입력받은 문자열에서 구분자를 기준으로 분리한 각 숫자의 합을 출력한다.

```
덧셈할 문자열을 입력해 주세요.
1,2:3
결과 : 6
```

&nbsp;

# 🥇 1주차 미션 목표
1. MVC 패턴을 생각하며 설계하자
2. 메소드가 하나의 일을 수행하도록 설계하자

&nbsp;

# 🔧 구현할 기능 목록

- [✅] 덧셈할 문자열을 입력 받는 문구를 출력한다.
- [✅] 사용자로부터 문자열을 입력받는다.
    - [✅] 양의 정수만 포함되었는지 확인한다.
    - [✅] 올바른 구분자만 포함되었는지 확인한다. `( , or : )`
    - [✅] 커스텀 구분자의 시작 문자열이 포함되었는지 확인한다. 
    - [✅] 커스텀 구분자 형식을 검증한다.
- [✅] 잘못된 값이 입력된 경우, `IllegalArgumentException` 을 발생시킨 후 종료한다.
- [✅] 구분자를 기준으로 숫자만 분리한다.
- [✅] 각 숫자의 합을 구한다.
- [✅] 결과를 출력한다.

&nbsp;

# 💣 에외에 대한 에러와 검증

### 문자열 입력 및 기본 구분자
- 음수, 0 이 포함된 문자열을 입력할 경우 -> `[ERROR] 문자열에 양의 정수만 포함되어야합니다.`
- 기본 구분자(쉼표, 콜론) 이외에 다른 문자(공백 포함)가 포함된 경우 -> `[ERROR] 기본 구분자와 일치하지 않는 문자가 존재합니다.`
---
- 아무것도 입력하지 않은 경우 **ex) ""** -> 허용
- 기본 구분자가 연속으로 사용된 경우 **ex) ,,,,,:** -> 허용

### 커스텀 구분자
- "//"와 "\n" 사이에 문자열이 위치할 경우 -> `[ERROR] 잘못된 커스텀 구분자 형식입니다.`
- "//"와 "\n" 사이에 아무것도 입력하지 않은 경우 **ex) //\n** -> `[ERROR] 잘못된 커스텀 구분자 형식입니다.`
---
- 기본 구분자와 커스텀 구분자 모두 포함된 경우 **ex) //;\n1;2,3** -> 허용
- "//"와 "\n" 사이에 " " 공백이 포함된 경우 **ex) // \n** -> 허용

&nbsp;

# 🗂️ 패키지 구조

### **view**
- InputView
  * readUserInput() - 사용자 입력
- OutputView
  * showResultMessage() - 결과 출력

### **constants**
- DelimiterEnum
  * getValue() - 열거형 상수값 반환
- ExceptionMessage
  * format() - 에러 메세지 반환

### **model**
- Calculate
  * calculateTotalSum() - 리스트에 담긴 숫자들의 총 합을 반환
- Parser 
  * toInt() - 문자열 리스트를 정수형 리스트로 형변환
- DelimiterValidator
  * customDelimiterAddCalculator() - 커스텀 구분자 유효성 검증
  * defaultDelimiterAddCalculator() - 기본 구분자 유효성 검증
  * splitByCustomDelimiter() - 구분자를 기준으로 숫자를 분리해 배열에 저장 및 유효성 검증
- InputValidator
  * isCheckEmpty() - 문자열에 공백이 포함되었는지 확인 ( 공백 = 0 )
  * isContainZero() -  "0" 값이 포함되었는지 확인
  * isContainMinus() - 음수값이 존재하는지 확인

### **controller**
- Controller
  * calculate() - 적절한 구분자에 따라 계산을 수행하고 합계를 반환
  * run() - 전체 흐름 관리

- Application
  * main() - 실행

&nbsp;

# 🥊 시행착오
1. 0을 처리하는 로직을 짤 때 처음에는 문자열을 받자마자 0이 존재하면 예외처리를 해주면 되겠다고 생각해서 코드를 작성했습니다. 하지만 10, 20, 100 등 두 자릿수 값으로 넘어가서 0 이 포함된 숫자까지 예외로 처리하고 있음을 깨달았습니다. 그래서 0이 존재할 때 예외처리 하는 로직을 구분자 기준 분리가 끝나서 배열에 집어넣은 후 처리해주는 방식으로 변경해줌으로써 해결할 수 있었습니다.
