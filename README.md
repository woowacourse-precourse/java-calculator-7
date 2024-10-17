# java-calculator-precourse

### 기능 목록

1. **Application**
    - 컨트롤러를 통해 프로그램 실행
    - 컨트롤러를 통해 프로그램 종료(System.exit()를 호출하지 않는다.)

2. **Calculator**
    - 계산 실행
    - 계산 종료
      
3. **Input**
    - 문자열 입력 받기
        - `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용
    - 사용자가 잘못된 값을 입력한 경우 ‘IllegalArgumentException’ 발생시키고 종료
        - 기본 구분자[쉼표, 콜론], 커스텀 구분자와 양수가 입력되었는지 검사
        - 커스텀 구분자 검사 시, 문자열 앞 부분인지 "//"와 "\n" 사이에 위치하는 문자인지 검사
          
4. **Calculation**
    - 구분자를 통해 문자열을 슬라이싱
    - 슬라이싱 후 정수로 형변환(공백이라면 0으로)
    - 변환된 정수들을 모두 더 함
      
5. **Output**
    - 덧셈 결과 출력
