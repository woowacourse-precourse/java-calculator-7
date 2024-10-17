
# 2024 UTC Precourse 1주차 ___ java-calculator
## 1️⃣ _ 파일 디렉토리 구조
```
------------------GUIDE---------------------

ㄴ -> Directory
* -> Parameter
- -> Method

--------------------------------------------

ㄴ src
    ㄴ main
        ㄴ java
            ㄴ calculator
                ㄴ controller
                    ㄴ CalcController
                        * calculator : make Instance to calculate
                        - void run() : Run Main WorkFlow
                ㄴ model
                    ㄴ Calculator
                        - int calcResult(String) : calculate the answer by delimiter
                ㄴ view
                    ㄴ View
                        - static String getStringFromUser() : Print announcement and Get String Input from user
                        - static void pringResultToUser() : Print answer in console 
                ㄴ Application.java

```

## 2️⃣ _ 기능 구현 리스트 
### 2024.10.16 Wed
``` 
    
    ㄴ 사용자에게 입력 받기 
        -> Implement getStringFromUser() In View Class
    ㄴ 문자열 기반으로 연산하기
        -> Implement calcResult In Calculator Class
    ㄴ 결과 출력하기 
        -> Implement pringResultToUser() In View Class


    ✅ 구현 후 느낀점 / 추가 개선사항 
    ㄴ 현재 구현 방식으로는 Model 패키지 내의 Calculator 클래스의 Method를 Static 형태로 사용해도 될거같다.
        -> 하지만 추후에 Custom Delimiter에 관한 로직이 생기면 내부 지역 변수를 만들어서 운영할 계획이여서 Static으로 구현하지 않았다.
    ㄴ 상위 calculator 패키지 하단에 Exception 패키지를 생성하고, 입력값에 대한 모든 예외 처리 Method를 Static 형태로 구현하여 사용해야겠다.
        -> 현재는 아직 예외처리 부분과 Custom Delimiter에 대한 부분이 없지만 구현 이후에는 Test Code를 작성해보아야겠다.
        
```
### 2024.10.17 Thu
``` 
    
    오늘의 구현 목표 : "역할과 구현을 분리하라"

    ㄴ Calculator Interface 구현
    ㄴ CalculatorImpl 과 CalculatorCustom으로 두 개의 Model 클래스를 Calculator Interface를 상속받아서 구현하기
    ㄴ CalculatorImpl 는 기존에 구현해둔 Calculator.Java 클래스파일의 내용과 비슷한 로직이지만 내부 parameter로 문자열로 저장하는 방식으로 변경
    ㄴ CalculatorCustomd 은 기존과는 다르게 Custom Delimiter를 기반으로 연산이 가능하도록 구현
    ㄴ 파일 디렉토리 구조 또한 UML의 형식에 맞춰서 수정하기


    ✅ 구현 후 느낀점 / 추가 개선사항 
    
        
```