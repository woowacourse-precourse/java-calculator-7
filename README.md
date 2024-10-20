
## 문자열 덧셈 계산기
이 프로그램은 사용자로부터 문자열을 입력받아, 그 안에 포함된 숫자들을 추출하여 합계를 계산하는 문자열 덧셈 계산기입니다. 다양한 구분자를 지원하며, 커스텀 구분자를 지정하여 유연하게 숫자를 파싱할 수 있습니다.


## 목차
- 프로그램 개요
- 프로그램 흐름
- 메서드 설명
- main 메서드
- readInput 메서드 => 사용자 입력받기 
- extractDelimiter 메서드 => 구분자 추출 
- extractNumbers 메서드  => 숫자 부분 추출 
- splitNumbers 메서드 => 숫자 문자열 분리 
- calculateSum 메서드 = > 숫자 변환 및 합계 계산 
- parseNumber 메서드 = > 문자열을 숫자로 변환 
- validateNegative 메서드 => 음수 확인 
- printResult 메서드 => 결과 출력 

## 프로그램 흐름
1. 사용자 입력 받기:  문자열을 입력받습니다.
 
2. 구분자 추출:    입력 문자열에서 커스텀 구분자를 추출합니다.
 
3. 숫자 부분 추출:    구분자 선언을 제외한 실제 숫자 부분을 추출합니다.
 
4. 숫자 문자열 분리:   구분자를 사용하여 숫자 문자열을 분리합니다.
 
5. 숫자 변환 및 합계 계산:    문자열을 숫자로 변환하고 합계를 계산합니다.
 
6. 결과 출력:     계산된 합계를 출력합니다.

## 프로그램 작동 원리
   1. 입력 처리:
   프로그램은 먼저 사용자로부터 문자열을 입력받습니다.
   커스텀 구분자를 사용하는 경우, 첫 줄에 구분자를 입력하고, 둘째 줄에 숫자들을 입력합니다.

   2.구분자 설정:
   입력된 문자열이 //로 시작하면 커스텀 구분자를 사용합니다.
   그렇지 않으면 기본 구분자(,, :)를 사용합니다.

   3.숫자 추출 및 분리:
   구분자를 기준으로 입력 문자열을 분리하여 숫자 문자열 배열을 만듭니다.

   4. 숫자 변환 및 검증:
   각 문자열을 정수로 변환합니다.
   변환 과정에서 숫자가 아닌 값이 있으면 예외를 발생시킵니다.
   음수가 포함되어 있으면 예외를 발생시킵니다.

   5. 합계 계산:
   변환된 정수들을 합산하여 결과를 계산합니다.

   6.결과 출력:
   계산된 합계를 출력합니다.


## 예외 처리
- 입력 형식 오류:
커스텀 구분자를 사용하는데 개행 문자가 없을 경우 IllegalArgumentException을 발생시킵니다.
- 숫자가 아닌 값 포함:
숫자로 변환할 수 없는 값이 포함되어 있으면 예외를 발생시킵니다.
- 음수 포함:
음수 값이 포함되어 있으면 예외를 발생시킵니다.
- 예외 발생 시 처리:
main 메서드에서 예외를 캐치하여 예외 메시지를 출력합니다.
프로그램이 예외로 인해 강제로 종료되지 않고, 사용자에게 오류 원인을 알려줍니다.

## 예시
-덧셈할 문자열을 입력해주세요

1,2:3

결과: 6

-덧셈할 문자열을 입력해주세요

//abc  (커스텀 구분자가 \n인데 이부분이 console에서는 계행으로 인식되니까 //abc\n1abc2abc3 을 => //abc엔터 1abc2abc4로 입력해야함 ) 

1abc2abc4

결과 : 7

