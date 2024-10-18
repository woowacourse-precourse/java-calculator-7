# java-calculator-precourse

### 기능1. 사용자 입력을 받는 UserInput 클래스

+ **userInput()** 을 호출하여 Console.readLine()으로 사용자에게 입력을 받고 그 입력을 구분자를 기준으로 잘라내어 String[] 배열에 저장 후 return

+ return을 하기 전, **isValid()** 를 호출하여 입력이 올바른 형식으로 이루어졌는지 확인. 잘못된 문자열이 입력된 경우 IllegalArgumentException을 발생시키고 애플리케이션을 종료함

### 기능2. 입력받은 String[]에서 숫자를 더해주는 SumNumbers 클래스

+ **sum(String[] strList)** 를 호출하여 String[] 배열에 있는 숫자를 모두 더해줌.
