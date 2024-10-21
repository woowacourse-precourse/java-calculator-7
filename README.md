# java-calculator-precourse
(입력한 문자열에서 숫자를 추출하여 더하는 계산기 구현)



1. 쉼표(,) 또는 콜론(;)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환
   (빈 문자열 혹은 null 입력 시 0 반환)<br><br>
2. 앞의 기본 구분자(쉼표,콜론) 외에 커스텀 구분자를 지정 가능
   (커스텀 구분자는 문자열 앞부분의 "//"와 "\n" 사이에 위치하는 문자를 커스텀 구분자로 사용)<br><br>
3. 사용자가 잘못된 값을 입력한 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료 <br><br>