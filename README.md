# java-calculator-precourse

## 기능 요구 사항

숫자 추출
- ,(쉼표) 또는 :(콜론)을 구분자를 갖는 문자열을 전달받는 경우 구분자를 기준으로 숫자를 분리한다.
- 기본 구분자(쉼표, 콜론)외에 커스텀 구분자를 지정할 수 있다.
  - 문자열 앞부분의 "//"와 "\n" 사이에 위치하는 문자를 커스텀 구분자로 사용한다.

더하는 계산기
- 분리한 각 숫자의 합을 반환한다.

입력
- 덧셈할 문자열을 입력받는다.
- 사용자가 잘못된 값을 입력하는 경우 IllegalArgumentException 을 발생시킨 후 프로그램을 종료한다.

출력
- 계산기에서 반환한 숫자의 합을 출력한다.