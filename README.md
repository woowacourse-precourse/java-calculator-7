# java-calculator-precourse

# 프로그램 정의

보다 명확한 기능 요구 사항을 정의하기 위해, 프로그램의 정의를 명시한다.
java-calculator은 사용자의 '간단한 정수 연산'을 도와주는 프로그램이다. 여기서 '간단한 정수 연산'이란, 사용자가 입력한 문자열에서 정수를 추출하여 해당 수에 대한 더하기 연산을 수행하는 것을 의미한다.

# 요구사항 고려

## 1. 숫자 처리

### 빈 문자열 혹은 white space의 취급

-   ""의 경우 0으로 취급한다.
-   " ", '\t', '\n' 등의 white space의 경우 어떻게 할 것인가?

### 숫자의 범위

-   정수만 가능한가? 실수도 가능한가?
-   양수만 취급할 것인가? 음수도 가능한가?
-   음수가 가능한 경우, '-'이 custom separator로 설정된다면 어떻게 처리할 것인가?
    -   case 1. 예외 발생
    -   case 2. 가능한 상황의 경우 우선적으로 부호로 처리한다
        -   이 경우 각 예외 케이스에 대한 부분이 일관적이지 않아 사용자가 혼란스러울 수 있다.
    -   case 3. '-'를 오직 separator로만 처리한다
-   int, long, BigInteger의 범위 중 무엇을 택할 것인가?

해당 프로그램은 '간단한 정수' 연산을 제공하므로, int에 해당하는 수만 다루며 Integer.parseInt() 메서드의 형식을 그대로 따른다.
int의 범위를 다루지만 예시에 주어진대로 음수는 허용하지 않으며, 숫자를 표현하는 데 쓰이는 문자는 custom separator로 선언될 수 없다.

## 2. custom separator 처리

### default separator와 custom separator의 관계

-   case 1. default separator는 항상 존재한다.
-   case 2. custom separator를 선언하는 경우 default separator는 무시된다.

default separator는 사용자가 입력하지 않았을 경우를 위해 존재한다고 정의한다. 따라서, 사용자가 custom separator를 선언하는 경우 default separator는 무시된다.

### custom separator의 범위

-   custom separator에 숫자가 포함될 수 있는가?
-   custom separator에 표준 아스키코드 외의 문자가 포함될 수 있는가? (확장된 아스키코드, UTF-8 문자 등)

숫자에 쓰이는 문자 (숫자 문자, '+')는 custom separator로 선언될 수 없다. 이외의 모든 출력 가능한 문자는 custom separator로 선언될 수 있다.

### custom separator 선언

-   문자열의 첫 시작과 custom separator 구문, 숫자 사이에 white space를 허용할 것인가?
-   separator가 중복되어 선언되는 경우 어떻게 처리할 것인가?
-   여러개를 한번에 선언 가능한가?
-   선언을 여러번 할 수 있는가?
    -   case 1. 예외 발생
    -   case 2. 최근에 선언된 custom separator를 따른다
        -   사용되지 않는 separator에 대해 명시적으로 사용자에게 알려줄 수 없으므로 사용자가 혼란스러울 수 있다.
    -   case 3. 모든 custom separator를 따른다

이 경우 프로그램이 '간단한' 사용성을 제공하는 것이 목적이므로, 한번의 선언에 하나의 separator만 허용한다. 따라서 중복되어 선언되는 케이스는 존재하지 않는다.

### 주의할 예외 처리

-   '/', '\', 'n'이 custom separator로 선언되는 경우 "///\n\n"과 같은 문자열에 대한 separator 처리가 가능해야한다.

# 요구사항 정의

프로그램은 사용자의 input 문자열에서 유효한 separator를 통해 유효한 정수를 추출하여 더한 결과를 출력한다.

## 0. input

-   입력은 "덧셈할 문자열을 입력해 주세요.\n" 이후의 문자열로 이루어진다.
-   사용자가 입력한 문자열은 크게 2가지 파트로 나뉜다. 각 파트는 모두 optional이다.
    -   custom separator 선언 부분
    -   숫자를 의미하는 부분
-   숫자를 의미하는 부분에 대해 separator로 구분된 문자열의 각 요소는 유효한 숫자만이 존재해야한다.
-   입력이 유효하지 않은 경우 IllegalArgumentException을 발생시킨다.

## 1. definition of valid separator

valid separator을 사용하여 숫자를 의미하는 부분을 나눈다.

### default separator

-   custom separator 유무와 관계 없이 default separator는 항상 존재한다.
-   쉼표(,)와 세미콜론(;)이 default separator로 설정된다.

### custom separator

-   문자열의 앞부분에만 선언이 가능하다.
-   한번의 선언만 가능하며, "//"와 "\n" 사이에 custom separator 문자 1개를 정의할 수 있다.
-   숫자를 나타내는 데 사용될 수 있는 문자 ('-', '+', 숫자 문자)를 제외한 출력 가능한 문자 모두 custom separator로 선언 가능하다.

## 2. definition of valid number

유효한 수는 출력할 결과에 사용되는 수이다.

-   숫자에 대한 유효성은 separator로 구분된 문자열의 각 요소에 대해 판단한다. 각 요소에는 유효한 숫자만이 존재해야한다.
-   숫자는 int와 Integer.parseInt() 메서드의 형식을 그대로 따른다.
    -   white space는 허용되지 않는다.
    -   숫자 앞의 1개 이상의 연속된 0은 허용된다.
    -   '+'와 '-'는 숫자의 부호를 의미하며, 부호 뒤에는 바로 숫자가 와야한다. (0도 허용된다)
    -   숫자의 범위는 int의 음이 아닌 범위 (0 ~ 2147483647)와 동일하다.

## 3. output

-   결과는 "결과 : " 다음에 오는 숫자로 표현한다.
-   유효한 숫자를 추출하여 더한 결과를 반환한다.
-   숫자를 의미하는 부분이 빈 문자열일 때, 예외를 발생시키지 않고 0을 반환한다.

# 기능 정의

## InputProcessor

separatorPart, separators, numberPart, numbers 필드를 갖고, processInput, getSeparator, getNumbers 메서드를 구현해 사용자 입력에 대한 유효성 검증 및 처리를 진행한다.

-   [x] processInput(): 사용자의 입력을 처리해 separatorPart, separators, numberPart, numbers 필드에 저장한다.
-   [x] setSeparator(): 유효한 separator인지 확인한 후, separators 필드에 저장한다.
-   [x] setNumbers(): 유효한 숫자인지 확인한 후, numbers 필드에 저장 후 반환한다.
-   [x] getNumbers(): 각 필드를 반환한다.

## StringCalculator

StringCalculator는 프로그램 전체 흐름을 관리한다. numbers, result 필드를 갖고, run, addNumbers, getResult 메서드를 구현해 입력부터 결과 반환까지의 과정이 이루어진다.

-   [x] run(): 사용자의 입력을 받아 InputProcessor에 전달, 유효한 숫자를 추출한다.
-   [x] addNumbers(): 유효한 숫자를 추출하여 더한 결과를 반환한다.
-   [x] getResult(): 저장된 결과를 반환한다.

## View

InputView, OutputView 클래스를 구현해 사용자와의 입출력을 담당한다.

-   [x] InputView: 사용자의 입력을 받아 반환한다.
-   [x] OutputView: 결과를 출력한다.
