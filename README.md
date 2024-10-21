# java-calculator-precourse

## 클래스 설명
### Controller
- CalculatorController
  - run(): 프로그램 실행.
  - inputString(): 사용자로부터 입력을 받고, 입력값을 Calculator 객체로 전달.
  - outputResult(): 계산 결과 출력.
### Model
- Calculator
  - sum(): 문자열이 비어 있거나 null일 경우 0 반환. 문자열을 구분자로 나누어 숫자 합산.
  - split(): 입력 문자열을 커스텀 구분자 또는 기본 구분자로 분리. 
  - validatePositive(): 음수일 경우 예외를 던지며, 정상적인 숫자일 경우 그 값 반환.
### View
- InputView
  - getInput(): 콘솔에서 입력된 문자열 반환.
- OutputView
  - printInputMessage(): 입력 안내 메시지 출력.
  - printAnswerMessage(): 계산 결과 출력.
### Util
- Constants
  - OUTPUT_SUM_TEXT: 입력 안내 메시지 ("덧셈할 문자열을 입력해 주세요.")
  - OUTPUT_ANSWER: 결과 출력 메시지 ("결과 : ")
  - PATTERN_TEXT: 커스텀 구분자를 위한 정규식 패턴 (//(.)\\n(.*))
- ErrorMessages
  - ERROR_NUMBER_TYPE: 음수 입력 오류 메시지 ("음수가 입력되었습니다.")
  - ERROR_INPUT: 잘못된 입력 오류 메시지 ("잘못된 입력입니다.")

## 기능 목록

1. 문자열 입력
- [x] 덧셈 할 문자열을 입력받는다.
- [x] 입력 값이 비어있거나 null 이면 0을 반환한다.

2. 패턴 분석
- [x] 문자열에 //(.)\\n 패턴이 있다면 커스텀 구분자 분리 메소드로 간다.
- [x] 없다면 기분 구분자 분리로.

3. 문자열 분리
- [x] 커스텀 구분자 분리
  - [x] Matcher 의 첫 번째 그룹을 구분자로, 두 번째 그룹을 나눌 문자열로 선언한다.
  - [x] 문자열을 분리해 String 배열에 삽입한다.

- [x] 기본 구분자 분리
  - [x] 쉼표, 콜론을 사용해 문자열을 분리해 String 배열에 삽입한다.

3. 숫자 합산
- [x] String 배열에서 값을 하나씩 꺼내 int 형으로 변환 후 모두 더한 값을 반환한다.
    - [x] 변환한 값이 음수라면 `IllegalArgumentException`을 발생시키고 프로그램을 종료한다.
    - [x] 잘못된 값이 입력되면 `IllegalArgumentException`을 발생시키고 프로그램을 종료한다.
    - [x] 모두 더한 최종 결과는 `"결과 : 0"` 형식으로 출력한다.
