# First_Week Problem : 문자열 덧셈 계산기
***
## 클래스
- Calculator 덧셈 관련 모든 기능이 있는 Class

## 변수
- private No_Space_Input : 공백 제거된 Input 문자열 저장
- private List<String> Delimiter : 구분자 관리 리스트, 커스텀 구분자 추가 시 해당 리스트에 추가됨
- private String del_deli_input : Input 문자열에서 커스텀 구분자 추가 구문 제외한 문자열 저장 

## 기능 구현
- Calculator() 생성자 : Input된 문자열 공백 제거
- Custom_Deli() : 기본 구문자 및 Custom 구분자 추가 후 Custom 구분자 추가 구문 삭제 
- print() : 진행된 상황 출력

## 고려 사항
- Input에 공백이 있는 경우 구분하기 애매하다고 판단(=공백 제거)
- 문자열 입력이 없는 경우와 숫자가 없는 경우 출력 구현(결과 : 0)
- 문자열에서 커스텀 구분자 추가한 경우 해당 구문은 Input 문장열에서 삭제
  - ex) //#\n382인 경우 : 커스텀 구분자 # 추가 후 382로 input 문자열 변경

## 진행 사항
- ~~Calculator의 생성자의 private 변수까지 전달 잘 되는지 확인~~
- 커스텀 구분자 구분 문자열이 있을 때 구분 문자 리스트에 추가 되는지 확인
- 커스텀 구분자 구분 문자열이 기존에 입력된 문자열에서 삭제가 되고 del_deli_input에 저장되는지