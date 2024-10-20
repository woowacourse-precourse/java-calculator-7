#  <우테코 프리코스 1주차>: java-calculator-precourse


# <구현할 기능 목록>
### [ 클래스 단위 ]
- ### Calculator
  - #### 총합 연산
  - #### 숫자 예외처리 (IllegalArgumentException)
    - ####  음수 판단
    - ####  숫자 아닌 값 판단 
  

- ### CalculatorController 
  - #### 흐름 관리
    - #### SeparatorHandler - 구분자를 기준으로 문자열 -> 배열 
    - #### InputHandler - 배열 유효성 검증
    - #### calculator -  합 결과 리턴 

- ### InputHandler
  - #### 문자열 입력 처리
    - #### Console.readLine()로 입력 받기
  - #### 입력 형식 예외처리(IllegalArgumentException)
    - #### null / empty() 경우, 예외처리 
    - #### 구분자로 나눈 배열에 숫자가 없는 경우, 예외처리   


- ### SeparatorHandler
  - #### 입력 문자열을 배열로 변환 및 값 리턴
  - #### 커스텀 구분자 여부 판단
  - #### 구분자 초기화
  - #### 커스텀 구분자 입력 길이 예외처리 (한 문자만 가능)

- ### OutputHandler
  - #### 더하기 연산 결과 출력