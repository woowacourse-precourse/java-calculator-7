# 프리코스 미션1 문자열 덧셈 계산기


## 기능 요구 사항
### 입력한 문자열에서 숫자를 추출하여 더하는 계산기 구현
- 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환
- 앞의 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 "//"와 "\n" 사이에 위치하는 문자를 커스텀 구분자로 사용
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 종료

## 고민해봐야 할 사항
- 자연수의 범위가 주어지지 않음
  - 기본적으로 long으로 구현하기
  - long의 범위가 넘어간다면, BigInteger로 처리하는 방법 구상해보기
- 커스텀 구분자가 주어졌을때, ','와 ':'은 그대로 구분자의 역할을 하는가
- 커스텀 구분자로 숫자가 입력될때의 예외처리 하기
- 커스텀 구분자의 길이는 1로 가정하고 풀이하고, 이외의 상황에는 예외처리 하기

## 구현 기능 목록
- [ ] 문자열 입력 기능
- [ ] 결과 출력 기능
- [ ] 커스텀 구분자 처리
- [ ] 문자열 구분자를 기준으로 숫자 파싱
- [ ] 숫자들의 합 반환
- [ ] 잘못된 값 입력 시 IllegalArgumentException 발생

## 프로그램 설계
### Domain
- Calculator
  - 덧셈 연산을 수행하는 domain
    - add() -> 덧셈 수행
    - getResult() -> 계산 결과 반환
  
### view
- InputView 
  - 인터페이스
    - readLine() -> 입력 메서드
- ConsoleInputView
  - InputView의 구현 클래스
    - readLine() -> camp.nextstep.edu.missionutils.Console.readLine()을 사용하여 사용자의 입력을 받음
- OutputView
  - 인터페이스
    - print() -> 출력 메서드
- StandardOutputView
  - OutputView의 구현 클래스
    - print() -> 자바의 표준 출력인 System.out.println()을 사용하여 출력
### Controller
- StringAddCalculatorController
  - 스트링 계산과 관련된 요청을 처리하는 Controller
    - stringAdd() -> 스트링 덧셈 요청을 받고 처리하는 메서드
### Service
- StringAddCalculatorService
  - 스트링 계산과 관련된 로직을 처리하는 Service
    - add() -> 입력된 문자열을 받아 파싱하고 계산을 수행하고 결과를 반환
    - stringAdd() -> 파싱된 문자열 배열을 받아 처리하고 최종 결과를 계산
    - stringParse() -> 입력된 문자열을 받아, 커스텀 구분자를 사용하는지 여부에 따라 적절한 parser를 선택해 문자열을 파싱
### Util
- StandardStringParser
  - 표준 구분자(',', ':')를 기준으로 문자열을 파싱을 담당하는 클래스
    - split() -> 입력된 문자열에서 표준 구분자를 기준으로 문자열을 파싱
- CustomStringParser
  - 커스텀 구분자("//","\n")와 표준 구분자를 기준으로 문자열 파싱을 담당하는 클래스
    - split() -> 입력된 문자열에서 커스텀 및 표준 구분자를 기준으로 문자열을 파싱
    - hasCustomSeparator() -> 문자열에 커스텀 구분자가 존재하는지 유무를 판별
    - getCustomSeparator() -> 커스텀 문자열을 파싱하여 가져옴