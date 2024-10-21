# java-calculator-precourse

#문자열 덧셈 계산기

## 프로젝트 설명
이 프로젝트는 입력한 문자열에서 숫자를 추출하여 더하는 
문자열 덧셈 계산기를 구현하는 것이 과제입니다.


##구현할 기능 목록

1. 문자열 입력 받기
	사용자는 콘솔을 통해 덧셈할 숫자들이 포함된 문자열을 입력할 수 있습니다.
2. 기본 구분자 사용 (쉼표, 콜론)
	기본 구분자로 쉼표(,)와 콜론(:)을 사용하여 입력된 문자열을 분리하고, 분리된 숫자들을 더합니다.
3. 커스텀 구분자 지정
	//구분자\n 형식으로 커스텀 구분자를 설정할 수 있습니다.
	커스텀 구분자는 하나의 문자만 사용할 수 있으며, 기본 구분자 대신 사용됩니다.
4. 음수 예외 처리
	음수가 입력되면 IllegalArgumentException을 발생시키며, 에러 메시지로 "음수는 입력할 수 없습니다: 음수값"을 출력합니다.
5. 잘못된 숫자 형식 예외 처리
	숫자 형식이 잘못된 경우 IllegalArgumentException을 발생시키며, 에러 메시지로 "잘못된 숫자 형식입니다: 입력값"을 출력합니다.
6. 빈 문자열 처리
	빈 문자열을 입력한 경우 합계는 0을 반환합니다.
7. 결과 출력
	입력된 문자열에 대한 계산 결과를 콘솔에 출력합니다.
