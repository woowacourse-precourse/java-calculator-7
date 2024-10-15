# java-calculator-precourse

## 구현할 기능 목록

### - 기본 구분자를 정의하기
### - 특정 문자열을 입력받기. 단, 문자열을 입력 받기 전 "덧셈할 문자열을 입력해 주세요."라는 문구를 출력
### - 입력 받은 문자열의 **커스텀 구분자** 존재를 확인하고 **커스텀 구분자**가 존재 시 이를 구분자 목록에 추가
### - 문자열을 구분자를 기준으로 Split 후 Split 된 문자열을 저장.
### - 문자열이 구분자와 양수로 구성되어 있지 않다면 IllegalArgumentException을 발생시킨 후 프로그램을 종료
### - 저장 된 양수 문자열을 모두 더한다.
### - 덧셈 결과를 출력한다. 출력 형식은 "결과 : $덧셈결과"
### - 입력 받은 문자열이 공백일 시 0을 출력