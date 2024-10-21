# java-calculator-precourse

## 과제 기능 요구사항
1.쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환한다.
   
예: "" => 0, "1,2" => 3, "1,2,3" => 6, "1,2:3" => 6 

2.앞의 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 "//"와 "\n" 사이에 위치하는 문자를 커스텀 구분자로 사용한다.

예를 들어 "//;\n1;2;3"과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.

3.사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.

## 문자열 계산기 기능 목록
1. 빈 문자열을 받는 경우에 0 을 반환한다.
2. 쉼표 또는 콜론으로 구분된 숫자들의 합을 반환한다.
3. 커스텀 구분자를 지원한다.
4. 잘못된 입력값이 들어온 경우 예외를 발생시킨다.
