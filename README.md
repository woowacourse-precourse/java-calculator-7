# java-calculator-precourse

## 구현할 기능 목록

1. 문자열을 입력받는다.
2. 문자열 앞에 커스텀 구분자가 있는지 확인하고 처리한다.
    - 커스텀 구분자가 있다면 구분자 목록에 추가한다.
    - 커스텀 구분자가 없다면 기본 구분자 목록을 사용한다.
3. 커스텀 구분자가 있을 경우, 해당 부분을 잘라낸다.
4. 문자열에서 구분자와 숫자를 분리한다.
    - 숫자들로만 정상적으로 분리가 되었다면 `sum`에 더한다.
    - 숫자가 아닌 예외 경우가 포함된다면 `IllegalArgumentException`을 발생시킨다.
5. 최종적으로 `sum` 값을 반환한다.

## 1차 기능별 구현 객체 설정

1. **Calculator**
    - 문자열을 입력받아 계산을 수행하고, 결과를 반환한다.

2. **CustomDelimiterParser**
    - 문자열 앞부분에 커스텀 구분자가 있는지 확인하고, 구분자를 처리한다.
    - 커스텀 구분자를 제거한 문자열을 반환한다.

3. **DelimiterChecker**
    - 문자열에서 구분자와 숫자를 분리하고 숫자 배열을 리턴한다.

## 예외상황
1. CustomDelimiterParser
    - 커스텀 구분자가 문자가 아닌 문자열인 경우 예외를 터트린다. 
2. DelimiterChecker
    - 숫자가 아닌 문자가 포함되어 있는 경우 예외를 터트린다.
    - 정수로 변화할 수 없는 숫자가 들어와도 예외를 터트린다.
    - 구분자가 연속으로 들어오면 예외를 터트린다.
    - 음수가 들어왔을 때 -를 음수가 아닌 잘못된 구분자로 인식해야한다.


## 2차 구현
1. 객체지향으로 전환
   - Calculator : 계산기
   - Delimiter : 구분자
   - Number : 숫자
   - CustomDelimiterParser : 커스텀 구분자 파서 (인터페이스)
     - SingleCustomDelimiterParser : 단일 커스텀 구분자 파서 (구현체)
   - DelimiterSplitter : 구분자 분리기
   - Adder : 덧셈기 (인터페이스)
     - PositiveAdder : 양수 덧셈기 (구현체)
   - AppConfig : 객체 생성 및 의존성 주입