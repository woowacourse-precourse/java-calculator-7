# java-calculator-precourse

### view
  - [x] InputView 클래스를 구현한다.
    - [x] 사용자의 입력을 받는 getUserInput 메서드를 구현한다.
  - [x] OutputView 클래스를 구현한다.
    - [x] 계산 결과를 출력하는 printResult 메서드를 구현한다.
### validator
  - [x] InputValidator 클래스를 구현한다.
    - [x] 사용자 입력에 대해 검증하는 코드를 작성한다.
### controller
  - [x] CalculatorOperation 클래스를 구현한다.
    - [x] 로직을 순차적으로 수행하는 operateCalculator 메서드를 생성한다.
      - [x] view.InputView을 통해 사용자로부터 입력을 받는다.
      - [x] 예외 발생 상황을 추적한다.
        - [x] validator.InputValidator를 사용하여 입력에 대해 검증한다.
        - [x] 올바른 입력이 아닐 경우, IllegalArgumentException을 throw한다.
      - [x] 입력을 기반으로 service 패키지의 핵심 로직을 순차적으로 수행한다.
        - [x] splitDelimiterAndOperand 메서드를 통해 구분자와 피연산자에 대한 처리를 진행한다.
          - [x] service.StringSplit의 preprocessDelimiter 메서드를 호출한다.
          - [x] service.StringSplit의 splitAndSaveOperands 메서드를 호출한다.
        - [x] calculateAndGetResult 메서드를 통해 계산을 하고 결과를 받아온다.
          - [x] service.StringCalculate calculate 메서드를 호출한다.
          - [x] service.StringCalculate의 fetchResult 메서드를 통해 계산 결과를 얻고, OutputView로 전달한다.
### model
  - [x] Calculator 클래스를 구현한다.
    - [x] 피연산자들에 대한 operands, 연산 결과에 대한 result를 멤버변수로 갖는다.
    - [x] service.StringSplit의 saveOperands 메서드를 통해 피연산자를 입력받기 위해, setOperands 메서드를 구현한다.
    - [x] 피연산자들을 더하여 결과 저장하는 saveResult 메서드를 구현한다.
    - [x] 결과를 return하기 위해 getResult 메서드를 구현한다.
  - [x] Delimiter 클래스를 구현한다.
    - [x] 구분자들에 대한 delimiters를 멤버변수로 갖는다. 쉼표(,)와 콜론(:)을 기본 구분자로 설정한다.
    - [x] 커스텀 구분자가 존재하는 경우가 있으니, 구분자 목록에 구분자를 추가하는 addCustomDelimiter 메서드를 구현한다.
    - [x] service.StringSplit에서 구분자를 기준으로 나누게 하기 위해서, delimiters를 return하는 getDelimiters 메서드를 구현한다.
### service
  - [x] StringSplit 클래스를 구현한다.
    - [x] 커스텀 연산자에 대한 전처리를 하는 preprocessDelimiter 메서드를 구현한다.
      - [x] 커스텀 구분자의 존재 여부를 파악하여 model.Delimiter에 저장하는 findCustomDelimiter 메서드를 수행한다.
      - [x] 커스텀 구분자와 관련된 문자열 (// ~ \n) 부분을 떼어내는 takeOffCustomDelimiter 메서드를 수행한다.
    - [x] splitOperands -> convertOperandsToInt -> saveOperands을 순차적으로 호출하는 splitAndSaveOperands 메서드를 구현한다.
      - [x] model.Delimeter에 저장된 구분자들을 기준으로 피연산자를 구분하는 splitOperands 메서드를 구현한다.
      - [x] 구분한 피연산자들을 정수로 변환하는 convertOperandsToInt 메서드를 구현한다.
      - [x] 정수로 변환한 피연산자들을 model.Calculator에 저장하는 saveOperands 메서드를 구현한다.
  - [x] StringCalculate 클래스를 구현한다.
    - [x] model.Calculator의 연산 메서드를 호출하는 calculate 메서드를 구현한다.
    - [x] model.Calculator에서 연산 결과를 받아와 return하는 fetchResult 메서드를 구현한다.