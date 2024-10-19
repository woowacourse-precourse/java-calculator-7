# First_Week Problem : 문자열 덧셈 계산기
***
## 클래스
- Calculator 덧셈 관련 모든 기능이 있는 Class

## 변수
- private No_Space_Input : 공백 제거된 Input 문자열 저장
- private List<String> Delimiter : 구분자 관리 리스트, 커스텀 구분자 추가 시 해당 리스트에 추가됨
- private String del_deli_input : Input 문자열에서 커스텀 구분자 추가 구문 제외한 문자열 저장 
- private List<String> parts : del_deli_input 문자열을 구분자로 구분한 문자열 리스트

## 기능 구현
- Calculator() 생성자 : Input된 문자열 공백 제거
- Custom_Deli() : 기본 구분자 및 Custom 구분자 추가 후 Custom 구분자 추가 구문 삭제
- split_input() : del_deli_input 문자열 구분자로 구분하기
  - escapeDelimiters() : Delimiter 구분자 리스트에 특수 기호(+,*)등의 기호가 있는 경우 일반 문자로 변환 처리
  - double_check() : .의 위치와 개수로 실수인지 아닌지 확인
- add() : parts에 있는 String형 숫자들을 합해서 출력
- isEmpty() : 아무 입력이 없는 경우 "결과 : 0" 출력
- isNegative() : 문자열에 음수값 있는경우 예외처리
- noNum() : 입력 문자열에 숫자가 없는경우 예외처리

## 고려 사항
- Input에 공백이 있는 경우 구분하기 애매하다고 판단(=공백 제거)
- 입력 문자열에 음수값이 들어온 경우와 숫자가 없는 경우는 예외 처리
- 문자열 입력이 없는 경우(결과 : 0)
- 커스텀 구분자에 숫자가 들어간 경우 : 숫자는 구분자가 될 수 없게 하고 해당 구문은 일반 문장으로 판단
  - ex) //8*\n38823 = //8*\n38823 문자열 그대로 판단하게 한다.
- 문자열에서 커스텀 구분자 추가한 경우 해당 구문은 Input 문장열에서 삭제
  - ex) //#\n382인 경우 : 구분자 # 추가 후 382로 input 문자열 변경
- 구분자로 구분 할 때 숫자가 아닌경우 예외처리(숫자에 문자함,기호가 포된경우)
- 구분자에 특수 기호들어간 경우
  - ex) + , *, /의 특수 기호는 프로그래밍에서 의미가 있는 기호 일반 문자로 취급되게 해줘야 함
- 구분했을 때 숫자가 실수인 경우도 고려

