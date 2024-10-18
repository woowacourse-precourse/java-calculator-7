# java-calculator-precourse

## 요구사항
1. 입력 값 추출하기
    - camp.nextstep.edu.missionutils.Console의 readLine() 사용
2. 입력된 문자열 구분
   - 쉼표(,)또는 콜론(:)으로 문자열 분리 
   * 입력된 문자열 중 커스텀 구분자가 있을 경우 세미 콜론으로 취급한다
     - 커스텀 구분자 : 문자열 앞부분의 "//"와 "\n" 사이에 위치하는 문자를 커스텀 구분자로 사용
     - ex) "//;\n1;2;3"과 같이 입력될 경우 커스텀 구분자는 세미콜론(;)으로 결과값은 6
4. 사용자가 잘못된 값 입력 시 IllegalArgumentException을 발생시킨 후 애플리케이션 종료

## 구현 기능
1. 입력 값 추출
    - [] camp.nextstep.edu.missionutils.Console의 readLine() 사용
    - [] 빈 문자열로 들어올 경우 0으로 처리
2. 입력된 문자열 분리
    - [] 쉼표(,) 또는 세미콜론(;)으로 문자열 분리
    - [] 커스텀 구분자("//"과 "\n" 사이의 문자)로 문자열 분리 
3. 사용자가 잘못된 입력할 경우 IllegalArgumentException 발생
    - [] 숫자가 아닐 경우
    - [] 양수가 아닐 경우
    - [] 예외 발생시 애플리케이션 종료