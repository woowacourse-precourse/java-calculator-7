# 기능 요구사항 정리 및 리펙토링 정리

## 기능 요구사항 정리
- Application의 main()에서 사용자에게 덧셈할 문자열인 String input을 입력받아 매개변수로 전달해 문자열에서 숫자를 추출하여 더해 정수형 결과 값 반환하는 calculateSum() 메서드 작성.
- 주어진 문자열에서 커스텀 구분자가 있으면 추출하는 extractCustomSeparator() 메서드 작성.
- 입력 문자열을 매개변수로 입력받고 커스텀 구분자 선언 부분 제거한 문자열 반환하는 removeDeclarePart() 메서드 작성.
- 커스텀 구분자와 커스텀 구분자를 매개변수로 받아 구분자들 제거한 문자열 배열로 반환하는 removeSeparators() 메서드 작성.
- 구분자 제거한 문자열 배열을 매개변수로 받아 정수형 리스트로 바꿔 반환하는 parseStringToInteger() 메서드 작성.
- 바뀐 정수형들끼리 더해 정수합을 반환하는 sumInteger() 메서드 작성.
- 숫자에 대한 에외처리를 하는 checkNumberException() 메서드 작성.
- 커스텀 구분자에 대한 예외처리를 하는 checkSeparatorException() 메서드 작성.

## MVC 폴더 구조
- controller: 사용자의 요청을 받아서 적절한 Service로 전달하고, 결과를 받아서 View에 전달.
- service: 애플리케이션의 핵심 비즈니스 로직을 구현합니다. Controller에서 받은 요청을 처리하고, 필요에 따라 여러 Domain 객체나 Validator와 상호작용.
- domain: 애플리케이션의 핵심 데이터 모델과 해당 데이터에 관련된 로직을 정의.
- view: 사용자에게 데이터를 보여주고, 사용자로부터 입력을 받는 역할.
- validator: 사용자 입력의 유효성을 검사.
- factory: 객체들을 하나의 팩토리 클래스에서 관리하게 하여 객체 생성을 담당.

