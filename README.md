# java-calculator-precourse

* 덧셈 계산기
  문자열 입력
  기본 구분자 : 쉼표(,) 또는 콜론(:)
  커스텀 구분자 지정 가능, "//"와 "\n" 사이 위치하는 기호

* 사용자 입력 예외사항
  1.0 또는 음수 입력
  2.문자 입력
  예외사항의 경우 IllegalArgumentException을 발생시키고 종료

* 기능 구현 - MVC 모델 적용
  -calculator-
  -controller-
  CalculatorController : 계산기 객체 생성, 호출해 덧셈 수행
  -service-
  CalculatorService : 구분자와 숫자를 나누어서 리스트에 저장
  -model-
  Calculator : 덧셈 계산기 정의
  -view-
  InputView : 사용자 입력 클래스
  OutputView : 출력 클래스
  -exception-
  UserErrorMessage : 사용자 입력 예외사항에 출력할 메시지 정의