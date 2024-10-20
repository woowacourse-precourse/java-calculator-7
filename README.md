# java-calculator-precourse

구현한 기능 정리
1. controller
   (1)UserApiController.java
    - Application에서 입력받은 데이터를 모델 객체 UserInputData에 저장
    - 입력을 service로 전달 후 유효성을 판단해주면 유효성에 따라 계산을 진행하거나 에러 메세지를 띄우는 메서드 호출
    - 모델 객체 ExtractionData에 저장된 구분자를 가져옴
    (2)UserRequestController.java
    - 잘못된 입력이 들어오는 경우 View의 에러 메세지를 띄우는 메서드 호출
    - 올바른 입력이 들어오는 경우 View의 결과값을 화면에 띄우는 메서드 호출
2. model
   (1)UserInputData.java
    -user가 입력한 문자열을 저장하는 저장소로, 저장된 값을 Controller를 통해 관리 가능
   (2)ExtractionData.java
    -기본 구분자들의 목록을 저장하는 객체
3. service
   (1)Service.java
    -유효성을 판단하는 클래스와 계산과 관련된 클래스를 분리시켜 놓았음, 두 개의 클래스에서 사용하는 커스텀을 구분하는 구분자들을 상수로 선언
   (2)NumValidService.java
    -들어온 문자열의 유효성을 판단하는 클래스, 즉 입력 방식이 잘 못 된 경우 계산을 진행하지 않고 에러메세지를 띄움
    -문자열이 커스텀 구분자를 포함하면 *커스텀 구분자를 생성하는 방식이 옳은지 *커스텀 구분자가 숫자는 아닌지 *커스텀 구분자 외의 다른 문자열이 포함되어 있는지를 확인함
    -커스텀 구분자를 포함하고 있지 않다면 기본 구분자 객체를 가져와 *기본 구분자 외의 숫자가 아닌 문자열이 들어가있는지 판단
   (3)CalculateService.java
    -계산을 진행하기 전 커스텀 구분자가 있다고 판단된 경우 커스텀 구분자를 추출하는 메서드
    -구분자들을 제외한 숫자들을 덧셈하여 반환하는 메서드
4. view
   (1)UserViewResponse.java
    -유저에게 전달된 값, 즉 에러 메세지이거나 계산된 결과를 화면에 띄워주는 메서드들
5. Application
    -입력을 받기전 "덧셈할 문자열을 입력해 주세요."를 화면에 띄우고, 입력받은 값을 Controller로 전달함