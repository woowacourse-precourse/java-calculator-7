# java-calculator-precourse

## 기능 목록
1. ```camp.nextstep.edu.missionutils.Console```의 ```readLine()```으로 입력을 받는다.
2. 입력이 없거나 빈 문자열인 경우 0을 반환한다.
3. 기본 구분자로 구분한다. 기본 구분자는 쉼표(,) 또는 콜론(:)이다.
4. 커스텀 구분자로 구분한다. 커스텀 구분자는 문자열 앞부분의 "//"와 "\n" 사이에 위치하는 문자를 커스텀 구분자로 사용한다.
5. 구분된 숫자를 합산한다.
6. 양수가 아닌 경우 예외 처리 한다. IllegalArgumentException을 발생시킨 후 애플리케이션을 종료한다.
7. 테스트 코드를 작성한다.

## 구현 계획
- 메인 함수가 될 CalculatorController 클래스를 생성한다.
- 메인 로직을 작성할 CalculatorService 클래스를 생성한다.
- StringParser 클래스에 구분자에 의한 문자열 파싱을 구현한다.
- Calculator 클래스에 분리된 숫자들의 덧셈을 구현한다.
- Validator 클래스에 값이 유효한지 검증하는 메소드를 구현한다.

1. ```camp.nextstep.edu.missionutils.Console```의 ```readLine()```으로 입력을 받는다.
   - CalculatorController 클래스에 calculator 메소드를 생성하여 입력을 받는다.
   - CalculatorService 클래스의 calculator 메소드를 호출하며 입력을 인자로 넘겨준다.
2. 입력이 없거나 빈 문자열인 경우 0을 반환한다.
   - CalculatorService 클래스의 calculator 메소드에서 조건문을 사용하여 처리한다.
3. 기본 구분자로 구분한다. 기본 구분자는 쉼표(,) 또는 콜론(:)이다.
   - StringParser 클래스에 쉼표 또는 콜론으로 문자열을 구분하는 메소드를 구현한다.
   - split 메소드를 사용해 구분한다.
   - 구분된 숫자들의 배열을 반환한다.
4. 커스텀 구분자로 구분한다. 커스텀 구분자는 문자열 앞부분의 "//"와 "\n" 사이에 위치하는 문자를 커스텀 구분자로 사용한다.
   - StringParser 클래스에 커스텀 구분자로 구분하는 메소드를 구현한다.
   - startWith 메소드를 사용해 "//"로 시작하는 문자열인지 확인한다.
   - indexOf와 substring 메소드를 사용하여 커스텀 구분자를 찾는다.
   - split 메소드를 사용해 구분한다.
   - 구분된 숫자들의 배열을 반환한다.
5. 구분된 숫자를 합산한다.
   - stream의 mapToInt와 sum 메소드를 사용해 문자형으로 된 숫자를 숫자형으로 반환하고 합을 계산한다.
   - 값을 반환하여 CalculatorController 클래스에 calculator 메소드에서 출력한다.
6. 양수가 아닌 문자가 있는 경우 예외 처리 한다. IllegalArgumentException을 발생시킨 후 애플리케이션을 종료한다.
   - 0 혹은 음수가 있는 경우
   - 구분자 사이에 숫자가 아닌 문자가 있는 경우
   - Validator 클래스에 검증하는 메소드를 만들어 CalculatorService에서 문자열 파싱 후 호출해 검증한다.
7. 테스트 코드를 작성한다.