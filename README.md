# java-calculator-precourse

### 기능 목록

1. **Application**
    - Calculator를 통해 프로그램 실행
    - Calculator를 통해 프로그램 종료(System.exit()를 호출하지 않는다.)

2. **Calculator**
    - 계산 실행
    - 계산 종료
      
3. **Input**
    - 문자열 입력 받기
        - `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용
          
    - 사용자가 잘못된 값을 입력한 경우 ‘IllegalArgumentException’ 발생시키고 종료
        1) 기본 구분자 입력 검증 기능
           - 유효한 구분자인지
           - 연속된 구분자를 사용하였는지
           - 마지막을 숫자가 아닌 구분자로 입력하였는지
           
        2) 커스텀 구분자 입력 검증 기능
           - 커스텀 구분자를 지정하는 문자가 앞에 있는지
           - 커스텀 구분자를 포함하여 유효한 구분자인지
           - 연속된 구분자를 사용하였는지
           - 마지막을 숫자가 아닌 구분자로 입력하였는지
          
4. **Calculation**
   1) 계산 기능
    - 입력 타입에 따른 구분자로 문자열을 슬라이싱(공백이라면 0으로)
    - 슬라이싱 후 정수로 형 변환, 변환된 정수들을 모두 더 함
      
6. **Output**
    - 입력 요구 문자열 출력
    - 덧셈 결과 출력
  
7. **InputData**
    - 계산 시 필요한 정보를 담은 데이터 정의

8. **InputType**
    - 사용자 입력에 따른 enum 타입 정의
