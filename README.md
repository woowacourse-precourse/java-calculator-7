# java-calculator-precourse

목표: 입력한 문자열에서 숫자를 추출하여 더하는 계산기를 구현하기

기능목록
1. 사용자로부터 문자열 입력 받기
- Console.readLine()을 사용하여 입력

2. 문자가 없거나 빈 문자열이 입력되었을 때 0을 반환

3. 문자열을 콤마와 콜론(, or :)으로 나누어 전달
- String split(",|:") 메서드를 사용하여 문자열을 분리

4. 커스텀 구분자가 있는 경우
- 문자열 앞부분이 "//"와 "\n" 문자 사이의 커스텀 구분자로 문자열을 분리
- 구분된 수는 각 수의 합을 반환한다

5. 음수이거나 숫자가 아닌 값을 예외 처리
- 예외된 값을 입력 시 IllegalArgumentException을 사용하여 프로그램 종료 처리

6. 사용자로부터 값을 입력받기

7. 계산 결과 출력