# java-calculator-precourse

구현할 기능 목록
1. 사용자의 입력을 받는 기능
   - 사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용
   - 사용자가 아무런 입력을 하지 않을 경우 IllegalArgumentException

2. 커스텀 구분자를 지정했는지 판단하고, 지정했다면 구분자를 추가하는 기능
   - 사용자가 커스텀 구분자 지정 형식을 지키지 않을 경우 IllegalArgumentException

3. 입력한 문자열에서 숫자를 추출하는 기능
   - 사용자의 입력이 잘못된 경우(음수, 구분자 이외에 다른 문자열 입력) IllegalArgumentException

4. 입력한 값을 모두 더하는 기능

5. 결과를 출력하는 기능