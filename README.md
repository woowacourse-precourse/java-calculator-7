# java-calculator-precourse

# 메소드 구현

입력 문자열을 받아서 합계를 계산.빈 문자열인 경우 0 반환.

입력 문자열에서 구분자를 추출하고,숫자 부분을 분리.

커스텀 구분자를 추출.기본 구분자는 쉼표와 콜론.

숫자 부분을 추출.

분리된 숫자들을 합산.

문자열을 정수로 변환하고,음수인 경우 예외를 발생.

# 이유

엄청나게 큰 숫자는? → BigInteger 참조형이라 성능은 느리겠지만 계산기이기 때문에 큰 수도 지원해야한다. 그리고 성능차이는 그리 크지 않을듯 → 덧셈만 하는 간단한 계산기 이니까 long으로도 충분히 가능할듯 메모리 효율성과 연산 성능 부분에서 long이 낫다.

커스텀 구분자를 사용해도 기존의 구분자로 입력받아 처리하는 경우 → 완료

null이 입력된다면? 사용자가 입력하기 때문에 null은 발생하지않는다 그러나 테스트에서 null 전달이 가능하고 추후 확장될 경우 대비하여 null체크를 한다.

공백은 어떻게 할것인가 → 계산기 이므로 정확성이 요구되기 때문에 예외처리
그렇다면 뒤의 공백은 → 예외처리
공백 그대로 문자열을 받아 파싱하기 때문에 NumberFormatException

기본형이면 오버플로우 주의해야함 → Math.addExact 로 예외처리.

커스텀 구분자와 숫자가 같으면 기능이 동작 안됨
이 경우 //3\n43536 은 구분자로 3을 사용했지만 //3\n333은 3이 구분자인지 숫자인지 알 수 없다. 따라서 예외처리가 필요하다
구분자와 같은 숫자를 입력받은 경우 예외처리

→ 숫자 사이에 구분자가 연속해서 있는 경우는 예외로 처리해야할까
계산기같이 정확성이 중요한 것들은 여러개의 구분자를 예외처리해야한다고 생각함. → 완

커스텀 구분자와 기본 구분자를 같이 사용 못함 → 완

매우 긴 입력 문자열을 입력하거나 → long형이라 괜찮다 parseNumber 메서드에서NumberFormatException 에 처리됨.

연속적인 큰 수를 입력 → 입력길이 제한



# refactor
목표: OCP, SRP 원칙을 지키자

Application : 계산기 실행 클래스
StringCalculator: 문자열 덧셈 계산기
DelimiterExtractor: 문자열에서 구분자를 추출하는 책임을 갖는 클래스.
NumberExtractor: 구분자로 분리된 숫자 부분을 처리하는 클래스.
UserInputParser: 입력 파싱
StringNumberParser: 숫자 파싱
AppConfig: 의존성 주입을 책임
CalculatorService: 계산과 입출력 통합
PositiveNumber: 원시 값 포장
InputString: 문자열 포장
Numbers: 일급 컬렉션


디렉토리 구조는?
책임 별로 나누어 구분한다.


└── calculator/
    ├── Application.java
    ├── calculator/ // 계산관련
    ├── parsing/ // 파싱 관련
    ├── delimiter/ // 구분자 관련
    ├── config/ // 의존성 관련
    ├── model/ // 객체 관련
    └── io/ // 입출력 관련

StringCalculator
다른 연산도 지원해야할 때 - 인터페이스 도입

DelimiterExtractor
추가적인 구분자 처리 방식이 필요할 때 - 구분자 추출 방식이 변경될 가능성이 낮다고 생각함.

StringNumberParser
추가적인 숫자를 파싱하는 방식이 필요할 때 -  파싱 방식 변경될 가능성이 낮다고 생각함.

---

Application클래스
현재 메인 클래스는 프로그램 실행,초기화 및 입출력을 담당한다. ocp와 srp원칙을 따르기 위해서는 입출력 역할을 다른 클래스가 가지는것이 좋을것 같다. 콘솔입출력이 아닌 다른 방식의 입출력으로 바뀔 경우 기존의 코드를 고치지 않고 가능하게 하는것이 좋을것같다.

그렇다면 입출력은 Appconfig클래스에서 관리하는것이 좋을까?
입출력 서비스와 계산기 서비스를 분리하는것이 좋을까?
프로젝트의 복잡도가 그리 높지 않기때문에 한번에 관리해도 괜찮다고 생각한다.
실제 계산기처럼 느껴지게 하려면 아무래도 Appconfig 클래스가 책임이 많아지다보니 srp원칙을 지키기가 어렵다.

덧셈이 아닌 다른 기능의 추가 가능성이 있다고 생각하여 그에 따른 입출력 코드의 수정도 이루어질것이라고 생각하기 때문에 구현체만 바꿀수 있도록 구현하였다.

메인 메서드에서 모든 객체를 직접 생성하고 의존성을 관리하게 되면, 코드가 길어진다.
계산과 입출력 통합하고 메인은 간결하게 유지하는 것이 좋을것같다.

---

Console이 수정이 가능한지 알 수 없기 때문에 try-with-resources 구문을 사용하지 않았다.
수정이 가능하다면 try (Console console = new Console()) 같이 사용할 수 있다.  CalculatorService 에 구현을 해도 되지만 리소스 객체가 아닌 서비스 객체이기 때문에 적합하지 않다고 판단했다.

일급 컬렉션에 내부에 합을 구하는 로직이 들어가는게 좋을까?
데이터의 불변성을 위해 사용하는 것이므로 외부로는 빼지 않는것이 좋을것같다. 그렇게 되면 합연산이 아닌 다른 연산에 대한 확장성이 떨어진다. 불변성에 문제없도록 하면 외부에서 처리해도 되지않을까?
