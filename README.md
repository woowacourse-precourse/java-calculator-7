# java-calculator-precourse

# 기능구현
## 1. 이스케이프 문자 확인, 콘솔로 입력 시에 \n 아 문자열로 인식되는지 아니면 \ 과 n 으로 인식 되는지 확인.

   1-1. 콘솔에서 입력시에 따로 인식한다는 것을 확인 > 커스텀 구분자에 대한 조건을 보니 \n 이 한 번에 인식되게끔 만들어야 가능함 > 콘솔 입력에서 \n 부분이  한 글자로 인식되게끔 하기 

## 2. StringAddCalculator 클래스 제작

   2-1. 입력을 받고 최종 계산하는 Calculator (public) 메서드 제작 
   
   2-2. 문자열 숫자를 정수로 바꿔주는 StringToInt 메서드 제작
   
   2-3  문자열 배열을 숫자로 바꿔 총 합산해주는 CalculateSum 메서드 제작 (음수 있을 시 예외 처리)
   
   2-4. 기본 구분자를 반환하는 findStandardDelimiter() 메서드 제작
   
   2-5. 기본 구분자를 이용한 문자열에서 문자열 숫자 배열을 반환하는 메서드 extractNumbersForStandard 제작
   
   2-6. 커스텀 구분자를 찾아내는 findCustomDelimiter 메서드 제작.

   2-7 커스텀 구분자를 사용한 문자열에서 문자열 숫자로 이루어진 배열을 반환하는 extractNumbersForCustom 메서드 제작  
