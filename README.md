# java-calculator-precourse

mvc 패턴으로 구현을 한다

1. domain 패키지
    1) Number 클래스 - 문자열에서 추출한 숫자를 저장하는 객체
        * validateNumber 함수 - 입력된 숫자의 유효성을 체크하는 함수
    2) Result 클래스 - 덧셈 결과를 저장하는 객체 
2. view 패키지
    1) InputView 클래스
        * readBuffer 함수 - 문자열을 사용자로부터 입력 받는 함수
        * validateInput 함수 - 입력된 문자열의 유효성을 체크하는 함수
    2) OutputView 클래스
        * writeSumResult 함수 - 덧셈의 결과를 출력하는 함수 
    
3. controller 패키지
    1) CalculatorController 클래스
        * run 함수 - 전반적인 시스템 구동을 돕는 메소드/ InputView 로 사용자 입력을 받고 Calculator Service 로 계산해서 OutputView 로 결과 출력
4. service 패키지
    1) CalculatorService 클래스
        * tokenize 함수 - 입력 받은 문자열에서 구분자를 기준으로 숫자를 추출하는 메소드
        * sum 함수 - 모든 숫자들을 더해서 결과를 반환하는 함수