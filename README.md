# java-calculator-precourse

### 구현할 기능 목록
#### 1. 사용자 입력을 받는 기능
- camp.nextstep.edu.missionutils에서 제공하는 Console API를 사용.
- readLine() 메소드를 이용하여 사용자 입력을 받는다.
- try catch 구문을 사용하여 잘못된 값을 입력할 경우 예외를 발생시키고 프로그램을 종료시킨다.

#### 2. 빈 문자열 또는 null 시 0 반환 기능
- 사용자 입력을 받은 후 해당 입력이 null이나 빈 문자열일 경우 0을 반환.

#### 3. 입력 문자열 구분 기능(default)
- 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열일 때 해당 구분자를 기준으로 문자를 분리.
- 분리된 문자가 계산 가능한 숫자인지 확인해야 함.
- 올바른 숫자인 경우 구분자로 구분된 숫자들 배열에 저장.

#### 4. 숫자 추출 후 합산 기능
- 배열에 저장된 숫자(문자열 형태)를 정수형으로 형변환 후 모두 더한다.

#### 5. 입력 문자열 구분 기능(custom)
- 문자열 앞에 "//"와 "\n"사이에 있는 문자를 커스텀 구분자로 사용.
- 문자열이 "//"로 시작하는 지 확인 후 이후 "\n"이 나오는 인덱스를 확인하여 사이에 만들어진 구분자를 기존 구분자에 추가한다.
- 이후 default 구분 방법이랑 똑같이 동작함.


### Application 클래스
- main 함수가 위치한 클래스
- 사용자로부터 받은 문자열과 결과를 출력함
- StringAddCalcultor의 splitInput메소드 호출하여 결과값 받아옴

### StringAddCalculator 클래스
#### public static int splitInput(String input) 메소드
- Application 클래스에 결과값 계산하여 넘겨줌

#### private static boolean isNullOrEmpty(String input) 메소드
- input값이 null or 빈 문자열이라면 True를 리턴

#### private static String[] splitString(String input) 메소드
- 기본 구분자를 , 와 |로 정해서 문자열로 만들어 놓음
- 만약 커스텀 구분자가 나타날 경우 해당 구분자도 기본 구분자에 추가함

#### private static void wrongInputFormat(int delimiterIndex) 메소드
- 구분자 지정 형식이 올바르지 않은 경우 프로그램 종료

#### private static int arrayEmptyStringCheck(String number) 메소드
- 구분자로 구분한 배열 속 원소들이 빈 문자열 혹은 null이라면 0으로 변환
- 숫자라면 숫자로 변환

#### private static int sumNumbers(String[] numbers) 메소드
- 배열에 저장된 값을 더하는 메소드 
- 배열에 저장된 값이 빈 문자열, null인 경우 0을 더함
- 배열에 저장된 값이 checkNumber함수를 통해 확인 가능

#### private static int checkNumber(String number) 메소드
- number가 숫자라면 문자열을 숫자로 바꾸어주고, 숫자가 아니라면 throw를 통해 프로그램을 종료시킴

#### private static void negativeNumberCheck(int num) 메소드
- 음수 입력 시 프로그램 종료