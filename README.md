# java-calculator-precourse

### view
  - [ ] InputView 클래스를 구현한다.
    - [ ] 사용자의 입력을 받는 getUserInput 메서드를 구현한다.
  - [ ] OutputView 클래스를 구현한다.
    - [ ] 계산 결과를 출력하는 printResult 메서드를 구현한다.
### validator
  - [ ] InputValidator 클래스를 구현한다.
    - [ ] 사용자의 입력에 대해 검증하는 코드를 작성한다.
    - [ ] 다양한 예외 상황을 고려하여, IllegalArgumentException를 던진다.
### controller
  - [ ] CalculatorOperation 클래스를 구현한다.
    - [ ] view.InputView을 통해 사용자로부터 입력을 받는다.
        - [ ] validator.InputValidator를 사용하여 입력에 대해 검증한다.
        - [ ] 올바른 입력이 아닐 경우, IllegalArgumentException을 발생시킨 후 애플리케이션을 종료시킨다.
        - [ ] 정상 입력일 경우, 아래의 핵심 로직을 수행하는 단계로 넘어간다.
    - [ ]입력을 기반으로 service 패키지의 핵심 로직을 순차적으로 수행한다.
      - [ ] service.StringSplit의 findCustomDelimeter 메서드를 호출한다.
      - [ ] service.StringSplit의 splitAndSaveOperands 메서드를 호출한다.
      - [ ] service.StringCalculate calculate 메서드를 호출한다.
    - [ ] service.StringCalculate의 fetchResult 메서드를 통해 계산 결과를 얻고, OutputView로 전달한다.
### model
  - [ ] Calculator 클래스를 구현한다.
    - [ ] 피연산자들에 대한 operands, 연산 결과에 대한 result를 멤버변수로 갖는다.
    - [ ] service.StringSplit의 saveOperands 메서드를 통해 피연산자를 입력받기 위해, setOperands 메서드를 구현한다.
    - [ ] 피연산자들을 더하여 결과 저장하는 saveResult 메서드를 구현한다.
    - [ ] 결과를 return하기 위해 getResult 메서드를 구현한다.
  - [ ] Delimiter 클래스를 구현한다.
    - [ ] 구분자들에 대한 delimiters를 멤버변수로 갖는다. 쉼표(,)와 콜론(:)을 기본 구분자로 설정한다.
    - [ ] 커스텀 구분자가 존재하는 경우가 있으니, 구분자 목록에 구분자를 추가하는 addCustomDelimiter 메서드를 구현한다.
### service
  - [ ] StringSplit 클래스를 구현한다.
    - [ ] 커스텀 구분자의 존재 여부를 파악하여 model.Delimiter에 저장하는 findCustomDelimiter 메서드를 구현한다.
    - [ ] splitOperands -> convertOperandsToInt -> saveOperands을 순차적으로 호출하는 splitAndSaveOperands 메서드를 구현한다.
      - [ ] model.Delimeter에 저장된 구분자들을 기준으로 피연산자를 구분하는 splitOperands 메서드를 구현한다.
      - [ ] 구분한 피연산자들을 정수로 변환하는 convertOperandsToInt 메서드를 구현한다.
      - [ ] 정수로 변환한 피연산자들을 model.Calculator에 저장하는 saveOperands 메서드를 구현한다.
  - [ ] StringCalculate 클래스를 구현한다.
    - [ ] model.Calculator의 연산 메서드를 호출하는 calculate 메서드를 구현한다.
    - [ ] model.Calculator에서 연산 결과를 받아와 return하는 fetchResult 메서드를 구현한다.