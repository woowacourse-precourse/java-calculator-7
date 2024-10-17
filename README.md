# java-calculator-precourse

입력 문자열을 받아서 합계를 계산.빈 문자열인 경우 0 반환.

입력 문자열에서 구분자를 추출하고,숫자 부분을 분리.

커스텀 구분자를 추출.기본 구분자는 쉼표와 콜론.

숫자 부분을 추출.

분리된 숫자들을 합산.

문자열을 정수로 변환하고,음수인 경우 예외를 발생.

# refactor
목표: OCP, SRP 원칙을 지키자

Application : 계산기 실행 클래스
StringCalculator: 문자열 덧셈 계산기
DelimiterExtractor: 문자열에서 구분자를 추출하는 책임을 갖는 클래스.
NumberExtractor: 구분자로 분리된 숫자 부분을 처리하는 클래스.
UserInputParser: 입력 파싱
StringNumberParser: 숫자 파싱
AppConfig: 의존성 주입을 책임

디렉토리 구조는?
책임 별로 나누어 구분한다.

calculator/
├── Application.java // 실행 클래스
├── calculator/ // 계산 관련 클래스
├── parsing/ // 파싱 관련 클래스
├── delimiter/ // 구분자 관련 클래스
├── config/ // 의존성 관련 클래스

StringCalculator
다른 연산도 지원해야할 때 - 인터페이스 도입

DelimiterExtractor
추가적인 구분자 처리 방식이 필요할 때 - 구분자 추출 방식이 변경될 가능성이 낮다고 생각함.

StringNumberParser
추가적인 숫자를 파싱하는 방식이 필요할 때 -  파싱 방식 변경될 가능성이 낮다고 생각함.
