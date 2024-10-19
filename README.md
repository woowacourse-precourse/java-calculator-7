# java-calculator-precourse

## ㅁ문자열 덧셈 계산기
### [ 기능 목록 ]

1. 정의  
   a. 입력한 문자열에서 숫자를 추출하고, 더하는 계산기를 구현한다.


2. 기능  
   a. **기본 조건**: ' , ' or " : "를 기준으로 분리하여 합  
   b. **커스텀 구분자** : 문자열 앞부분의 "//"와 "\n"사이에 위치한 문자를 커스텀 구분자로 사용  
   ㄴ> ex) "//;\n1;2;3"에서 " ; "이 커스텀 구분자  
   c. **에러기능**: 사용자가 잘못된 값 입력한 경우 "IllegalArgumentException" 발생시킨 후 App 종료
