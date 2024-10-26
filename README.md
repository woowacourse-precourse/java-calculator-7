# java-calculator-precourse

## 아키텍처
![아키텍처](https://github.com/user-attachments/assets/7797f508-0e39-4aaf-8091-6ef21ca3645f)

## 기능

### Input (Interface) => 프로그램 전체 흐름 컨트롤
- 문자열을 입력받고 결과를 전달하는 인터페이스
- 클라이언트와 직접적으로 맞닿아있는 인터페이스
- 프로그램 전체 흐름을 컨트롤하는 인터페이스
- 메서드: int inputStr()

### InputFactory (Class)
- Input 인터페이스의 구현체 객체를 생성하는 클래스
- 정적 팩터리 메서드로 Input 인터페이스의 구현체(InputImpl)의 생성자의 매개변수에 Validate 인터페이스와 Choose 인터페이스의 구현체를 넘겨주어서 Input 인터페이스의 구현체에 의존성 주입

### InputImpl (Class) => 프로그램 전체 흐름 컨트롤
- 외부에서 주입받은 의존성(인터페이스): Validate, Choose
1. Validate 인터페이스의 isValid 메서드로 문자열의 유효성을 검사. false를 리턴받으면 IllegalArgumentException 예외 발생 후 프로그램 종료
2. Choose 인터페이스의 chooseStrategy 메서드로 문자열을 분석하여 기본 구분자와 커스텀 구분자 중 어떤 것을 사용하는지 판단한 후, 적절한 전략(Divide 인터페이스)을 선택하여 반환받음
3. 반환받은 Divide 인터페이스의 divideNumbers로 문자열에서 숫자들을 분리하여 숫자 배열을 반환받음
4. 반환받은 숫자 배열의 합을 최종적으로 클라이언트 코드로 반환

### Validate (Interface)
- 매개변수로 받은 문자열의 유효성을 검사하는 인터페이스
- 메서드: boolean isValid(String)

### ValidateImpl (Class)
- 유효하지 않은 문자열(ex. 음수 기호 사용)이라면 해당 구현체의 메서드에서 false를 리턴하여 InputImpl에서 예외를 발생
- 문자열이 빈 문자열이면 true 리턴
- 문자열에 Separator의 CUSTOM 요소("//", "\\n")가 모두 포함되어 있다면 true를 리턴
- 문자열에 Separator의 BASIC 요소(",", ":")가 하나라도 포함되어 있다면 true를 리턴
- 문자열이 숫자로만 이루어져 있다면 true를 리턴

### Separator (Enum)
- 기본 구분자와 커스텀 구분자를 구분하는 enum 클래스
- BASIC(",", ":"), CUSTOM("//", "\\n")
- 매개변수로 받은 문자열이 BASIC 요소 중에 하나라도 포함되어 있다면 true를 리턴하는 메서드 선언
- 매개변수로 받은 문자열이 CUSTOM 요소를 둘 다 사용할 경우 true를 리턴하는 메서드 선언
- 구분자 문자열들을 리턴하는 메서드 선언

### Choose (Interface)
- 매개변수의 문자열을 분석하여 기본 구분자와 커스텀 구분자 중 어떤 것을 사용하는지 판단한 후, 적절한 전략(Divide 인터페이스)을 선택하여 반환하는 메서드를 가지는 인터페이스
- 메서드: Divide chooseStrategy(String)

### ChooseImpl (Class)
- 문자열이 커스텀 구분자를 가지고 있다면, 커스텀 구분자로 문자열을 나누는 전략 리턴
- 그렇지 않다면, 기본 구분자로 문자열을 나누는 전략 리턴

### Divide (Interface)
- 매개변수의 문자열의 숫자를 특정 구분자로 나누는 인터페이스
- 메서드: int[] divideNumbers(String), default int[] toIntArr(String[])

### BasicDivide (Class)
- 매개변수의 문자열의 숫자를 기본 구분자로 나누는 인터페이스
1. 기본 구분자 중 한 가지라도 가지고 있다면, 기본 구분자로 숫자들을 분리하여 문자열 배열에 추가
2. 비어있는 문자열이라면, 문자열 배열에 0 추가
3. 문자열이 숫자로만 구성되어 있다면, 문자열 배열에 문자열을 그대로 추가
- 이후 문자열 배열을 숫자 배열로 변경하여 반환

### CustomDivide (Class)
- 매개변수의 문자열의 숫자를 커스텀 구분자로 나누는 인터페이스
- 커스텀 구분자로 숫자들을 분리하여 문자열 배열에 추가
- 이후 문자열 배열을 숫자 배열로 변경하여 반환

## SOLID 원칙 적용
- 단일 책임 원칙 (SRP): 각 클래스는 하나의 책임만 가지도록 설계하여 코드의 가독성과 유지보수성을 높임
- 개방-폐쇄 원칙 (OCP): 인터페이스를 통해 기능을 정의하고, 구현체는 외부에 노출되지 않도록 하여 기존 코드를 수정하지 않고도 새로운 기능 추가 가능
- 리스코프 치환 원칙 (LSP): 인터페이스를 통해 정의된 기능을 구현체가 제공할 수 있도록 하여 클라이언트가 특정 구현체에 의존하지 않고도 기능을 제대로 활용 가능
- 인터페이스 분리 원칙 (ISP): 클라이언트는 필요한 인터페이스만 의존하게 하여 복잡한 의존성을 줄임
- 의존 역전 원칙 (DIP): 구현체가 아닌 인터페이스에 의존하도록 하여 코드의 유연성을 높임. 클라이언트는 구체적인 구현에 의존하지 않고 인터페이스에만 의존

클래스의 책임을 분산시켜 단일 책임 원칙(SRP)을 준수하고, 인터페이스를 공개하며 구현체는 은닉하여 개방-폐쇄 원칙(OCP)을 적용하였다. 이를 통해 코드가 인터페이스에만 의존하도록 설계했다.(의존 역전 원칙, DIP)
이러한 설계를 통해 인터페이스에만 의존하더라도 구현체의 기능을 효과적으로 활용할 수 있다.(리스코프 치환 원칙, LSP) 또한, 클라이언트는 Input 인터페이스 하나에만 의존함으로써 인터페이스 분리 원칙(ISP)을 따르면서도 원하는 결과를 쉽게 얻을 수 있다.

https://agi1004.tistory.com/99
