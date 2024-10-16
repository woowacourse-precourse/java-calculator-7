# java-calculator-precourse

## 기능 목록

- 사용자로부터 문자열을 입력받는 기능
    - 사용자의 입력은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용


- 기본 구분자를 통해 숫자를 추출하는 기능
    - 기본 구분자는 쉼표(,)와 콜론(,)이다.


- 커스텀 구분자 지원 기능
    - 커스텀 구분자는 입력 문자열 앞부분에 "//"와 "\n" 사이에 위치하는 문자를 커스텀 구분자로 사용한다.


- 구분자로 구분된 숫자들을 더하는 기능


- 덧셈 결과를 출력하는 기능
    - 출력 형식 : "결과 : {결과값}"


- 예외 처리 기능
    - 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션 종료
    - 구분자가 없는 문자열인 경우
    - 잘못된 구분자를 사용한 경우
    - 구분자 뒤에 숫자가 없는 경우
    - 문자열에 숫자가 없거나 문자가 포함된 경우
    - 음수를 입력한 경우