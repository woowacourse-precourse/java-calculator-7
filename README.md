# java-calculator-precourse

# 문자열 덧셈 계산기
문자열 덧셈 계산기는 문자열을 입력받고, 입력한 문자열에서 숫자를 추출하여 더하는 계산기입니다.

쉼표(,) 또는 콜론(:)을 구분자로 하여 분리한 각 ___양수___ 의 합을 출력합니다.

기본 구분자 외에 "//"와 "\n" 사이의 문자를 커스텀 구분자로 지정하여 사용할 수 있습니다.

## 구현할 기능 목록
### Calculator 클래스
핵심적인 계산을 담당하는 클래스
* calculate 함수
  * 구분자로 하여 분리된 양수의 합을 반환하는 함수

### Seperator 클래스
구분자를 저장하는 클래스
* seperateNumbers 함수
  * 구분자를 기준으로 양수를 분리하여 리스트를 반환
  * 잘못된 입력 값이 있을 때 IllegalArgumentException이 발생

### Application 클래스(메인 클래스)
* main 함수
  * 문자열을 입력받고 Seperator 클래스와 Calculator 클래스를 통해 각 숫자의 합을 출력

## 프로젝트 의존성
* JDK 21
* mission-utils:1.2.0
