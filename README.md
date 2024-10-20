# java-calculator-precourse

## 기능 목록
- Application 클래스의 main 메소드
  - readLine()을 이용해 덧셈할 문자열을 입력받아 Calculator.add()에 전달하고 결과값을 출력한다.
    (IllegalArgumentException이 발생한 경우, 프로그램을 종료한다.)
  - 결과값이 정수 형태인 경우, 정수로 변환하여 출력한다.
- Calculator 클래스의 add 메소드
  - input이 null인 경우 IllegalArgumentException을 던진다.
  - 빈 문자열이 주어지면 0을 반환한다.
  - 이외의 경우 tokenize 메소드를 호출해 입력값을 토큰화하고, sum 메소드를 호출해 토큰들의 합을 반환한다.
- Calculator 클래스의 tokenize 메소드
  - 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달받는 경우, 구분자를 기준으로 문자열을 토큰화하여 문자열 배열 형태로 반환한다.
  - 커스텀 구분자(“//“와 “\n” 사이에 위치한 문자)가 지정되는 경우, 해당 구분자를 기준으로 문자열을 토큰화하여 문자열 배열 형태로 반환한다.
  - 이외의 경우, 잘못된 입력값으로 판단하고 IllegalArgumentException을 던진다.
- Calculator 클래스의 sum 메소드
  - 토큰화된 문자열의 각 토큰을 숫자로 변환한다.
  - 변환된 토큰들이 양수값인 경우, 그 합을 계산하여 반환한다.
  - 변환된 토큰들이 양수값이 아닌 경우, 잘못된 입력값으로 판단하고 IllegalArgumentException을 던진다.