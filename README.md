# java-calculator-precourse

# <우테코 프리코스 1주차> 

## -구현할 기능 목록-

## [ 클래스 단위 ]
- ### Calculator 
  - #### 숫자 예외처리 
    - #### (음수 / Int형이 아닌 값) 발생 시, IllegalArgumentException
  - #### 숫자 더하기 연산 및 값 리턴 

- ### CalculatorController 
  - #### 커스텀 구분자 입력 예외처리
    - #### 구분자 오류 발생 시, (IllegalArgumentException)
      - #### 긴 경우, "//;;;;\n1;2;3"
      - #### 없는 경우, "//\n1;2;3"
      - #### 형식이 틀린 경우, ";\n1;2;3"
      - #### 데이터가 없는 경우, "//;\n"
        
  - #### 기본 구분자(: ,) / 커스텀 구분자 세팅
  - #### 입력 문자열을 Int 배열로 변환 및 값 리턴

- ### InputHandler
  - #### 입력 형식 예외처리
    - #### (NULL / 입력 형식 오류) 발생 시, IllegalArgumentException
  - #### 문자열 입력 처리
    - #### 입력을 받아서 Controller에 전달 

- ### OutputHandler
  - #### 더하기 연산 결과 출력