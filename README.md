
# 2024 UTC Precourse 1주차 ___ java-calculator
## 1️⃣ _ 파일 디렉토리 구조
```
------------------GUIDE---------------------

ㄴ -> Directory
- -> Parameter
+ -> Method

--------------------------------------------
/src/main/java/calculator
    │
    ├── Application.java
    ├── controller/
    │     └── CalculatorController.java  // Controll Main Work Flow
    │           + run() : void
    ├── dto/
    │     └── CalculatorDTO.java  // Controll the UserInput String and Delimiter
    │           - str : string
    │           - delim : string
    │           - custom : boolean  
    │           + getStr() : string
    │           + getDelim() : string
    │           + hasCustomDelim() : boolean
    ├── service/
    │     ├── CalculatorConfig.java // Constructor by DTO
    │     │     + getCalculatorService(CalculatorDTO:CalculatorDTO) : CalculatorService
    │     ├── CalculatorService.java <<Interface>>   // Seperate Role By Delimiter
    │     │     + calculate(CalculatorDTO:CalculatorDTO) : int
    │     ├── CalculatorServiceImpl.java  // Default Delimiter
    │     │     + calculate(CalculatorDTO:CalculatorDTO) : int
    │     └── CalculatorServiceCustomImpl.java  // Custom Delimiter
    │           + calculate(CalculatorDTO:CalculatorDTO) : int
    ├── view/
    │     └── ConsoleView.java  // Show Announcement & getStringFromUser
    │           + getStringFromUser() : string
    │           + pringResultToUser() : void
    └── util/
          └── ExceptionUtil.java // Implement Static Method to check Runtime Exception
        

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
    ㄴ 기존의 Model을 하나만 구성하는 것에 비해 각각의 Calculator가 계산을 한다는 역할은 동일하지만 세부 역할을 분할하였다.
        ㄴ 확실히 인터페이스로 역할을 지정하고, 각각의 대상에 따라서 클래스를 따로 작성하니 뭔가 더 효율적으로 분리되어서 로직을 작성할 수 있었다.
    ㄴ Calculate Method를 작성하면서 생각보다 오류 처리가 많이 발생한다는 것을 느꼈다. 
        ㄴ 특히 커스텀 구분자의 경우 특수문자가 구분자로 들어오면 정규식에서 이스케이프 처리를 하지않으면 문제가 생기는 것을 파악했다.
        ㄴ 추가적으로 커스텀 구분자가 있는 경우에는 기존의 Default 구분자는 역할을 하지 않을 것인지에 대한 고민을 해보아야겠다.
    
        
```
### 2024.10.18 Fri
``` 
    
    오늘의 구현 목표 : "책임을 분리하라"

    ㄴ File Directory Structure 수정
        ㄴ 기존 Model 패키지를 DTO와 Service로 나누어 관리 
        ㄴ UML 관련 작성 오류가 있어서 수정 및 표현 방식 수정
        ㄴ 예외 처리와 관련된 Static Method를 구현할 Util 패키지 및 클래스 생성
    ㄴ 기초적인 예외 처리에 대한 Static Method 설정하기
    ㄴ Service 내부에 config를 두어 직접 인스턴스를 만들지않고 입력값에 따라 유동적으로 인스턴스를 생성하도록 한다.
    ㄴ 최대한 역할과 구현을 나누고 그것이 직접적으로 구현체에 의존하지 않도록 구성하려고 노력한다.


    ✅ 구현 후 느낀점 / 추가 개선사항 
    ㄴ 처음에는 MVC 패턴만을 이용하려고 헀지만 뭔가 더욱 객체화 하기 위해서 Model을 DTO와 그에 대한 Service 로직으로 다시 구성했다.
        ㄴ 그 과정에서 CalculatorService를 타겟에 맞춰서 자동으로 생성되도록 CalculatorConfig를 static method 형태로 구성해서 제작시에 자동으로 선정되도록 하였다.
    ㄴ 작년 2023 우아한 테크코스에서 예외처리를 할 때에는 비지니스 로직 내에서 예외가 발생하도록 작성하였다.
        ㄴ 하지만 올해는 따로 Util이라는 패키지 아래 예외의 책임을 전적으로 담당하는 클래스를 만들어서 작성하였다.
        ㄴ 프로그램의 효율 측면에서 본다면 오히려 내부 로직에서 하는것이 빠를 수 있겠지만, 전적으로 역할과 책임을 분리하기로 하였다.
    ㄴ Exception 클래스를 작성하면서 한번에 DTO 객체를 받아 연산 전에 예외가 발생하는지 확인하는지 작성했지만 역할을 작은 단위로 쪼갤 수 없었다.
        ㄴ 남은 기간동안 예외 처리 또한 Service와 같이 추상 개체를 만들고 각각의 상황에 따라 자동으로 대응하도록 바꿔볼 계획이다.
        ㄴ 또한 아직까지는 발견하지 않은 다양한 예외들에 대한 케이스를 고민해보아야한다.
    ㄴ 한가지 의문점은 Custom 구분자가 있는 경우에도 , : 이 2개의 기본 구분자로도 분리를 해야하는지에 대해서 고민중이다.
    
        
```