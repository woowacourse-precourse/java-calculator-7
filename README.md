# java-calculator-precourse

## 1. 문자열 덧셈 계산기 소개

문자열 덧셈 계산기는 입력된 문자열에서 숫자를 추출하고, 다양한 구분자(쉼표, 콜론, 커스텀 구분자)를 사용하여 숫자들의 합을 계산하는 프로그램입니다. 입력 값이 없는 경우 0을 반환하며, 음수가 입력되면 예외를
발생시킵니다. 사용자는 직접 구분자를 지정할 수 있으며, 지정하지 않으면 기본 구분자인 쉼표(,)와 콜론(:)을 사용합니다.

## 2. 패키지 목록 (클래스 포함)

```  
 src
 ├── main
 │   └── java
 │       └── calculator
 │           ├── model
 │           │   ├── Calculator.java                // 계산 로직에 대한 인터페이스
 │           │   ├── CalculatorImpl.java            // 문자열 덧셈 로직을 처리하는 구현 클래스
 │           │   ├── InputValidator.java            // 입력값의 유효성을 검증하는 클래스
 │           │   └── DelimiterParser.java           // 구분자를 처리하는 클래스
 │           ├── controller
 │           │   └── CalculatorController.java      // 컨트롤러 클래스
 │           ├── view
 │           │    ├── CalculatorView.java           // 사용자 입력과 출력을 담당하는 인터페이스
 │           │    └── CalculatorViewImpl.java       // 사용자 입력과 출력을 처리하는 구현 클래스
 │           └── config
 │           │    └── AppConfig.java                // 객체 생성 및 의존성 주입을 담당하는 클래스
 │           └── util
 │               └── Constants.java                 // 공통 상수를 정의한 클래스
 └── test
     └── java
         └── calculator
             ├── model
             │   ├── CalculatorTest.java            // Calculator 클래스의 테스트 코드
             │   ├── InputValidatorTest.java        // InputValidator 클래스의 테스트 코드
             │   └── DelimiterParserTest.java       // DelimiterParser 클래스의 테스트 코드
             └── controller
                 └── CalculatorControllerTest.java  // CalculatorController 테스트 코드
```

## 3. 기능 목록

1. **빈 문자열 또는 null 입력 시 0을 반환**
    * 빈 문자열이나 null을 입력할 경우 결과 값으로 0을 반환한다.
2. **쉼표(,) 또는 콜론(:)을 구분자로 사용**
    * 쉼표 또는 콜론으로 구분된 숫자들을 분리하고 그 합을 반환한다.
3. **커스텀 구분자 지원**
    * “//” 와 “\n” 사이에 위치한 커스텀 구분자를 사용하여 숫자들을 분리하고 그 합을 반환한다.
4. **음수를 입력하면 예외 발생**
    * 음수를 입력할 경우 IllegalArgumentException 예외를 발생시킨다.
5. **입력값이 숫자가 아닌 경우 예외 발생**
    * 숫자가 아닌 값이 입력되면 IllegalArgumentException 예외를 발생시킨다.
6. **구분자에 따른 숫자 덧셈 로직 구현**
    * 다양한 구분자에 따라 숫자를 추출하고 합산하는 기능을 구현한다.
7. **결과 출력 기능 구현**
    * 계산 결과를 콘솔에 출력한다.

## 4. 실행 결과 예시

```
덧셈할 문자열을 입력해 주세요.  
""  
결과 : 0

덧셈할 문자열을 입력해 주세요.  
1,2,3  
결과 : 6

덧셈할 문자열을 입력해 주세요.  
1:2:3  
결과 : 6

덧셈할 문자열을 입력해 주세요.  
//;\n1;2;3  
결과 : 6

덧셈할 문자열을 입력해 주세요.  
1,-2,3  
예외 : IllegalArgumentException: Negative numbers not allowed: -2

덧셈할 문자열을 입력해 주세요.  
1,A,3  
예외 : IllegalArgumentException: Invalid input: A
```

## 5. 테스트 목록

1. **빈 문자열 또는 null 입력 시 0을 반환**
    * 입력이 "" 또는 null일 때 0을 반환하는지 테스트.
2. **쉼표(,) 또는 콜론(:) 구분자로 구분된 숫자들의 합 계산**
    * 입력 값이 "1,2,3" 또는 "1:2:3"일 때 올바른 합(6)이 반환되는지 테스트.
3. **커스텀 구분자를 사용한 계산**
    * //;\n1;2;3와 같은 커스텀 구분자가 주어졌을 때 올바른 합(6)이 반환되는지 테스트.
4. **음수 입력 시 IllegalArgumentException 발생**
    * 음수 입력 시 IllegalArgumentException이 발생하는지 테스트.
5. **숫자가 아닌 값 입력 시 IllegalArgumentException 발생**
    * 숫자가 아닌 값이 입력되었을 때 IllegalArgumentException이 발생하는지 테스트.
6. **다양한 입력에 따른 계산 결과 검증**
    * 다양한 숫자 조합이 주어졌을 때 그 합이 올바르게 계산되는지 테스트.

