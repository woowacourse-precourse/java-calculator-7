# java-calculator-precourse

문자열 덧셈 계산기 기능 구현
1. 문자열 입력받기
- camp.nextstep.edu.missionutils.Console 라이브러리의 readLine() 활용
- 잘못된 값 입력시 IllegalArgumentException 발생하는 try~catch 구문 작성
- 입력받은 문자열을 지역변수로 저장


2. 문자열을 구분자로 구분하여 합을 구하는 메서드 작성
- 문자열을 매개변수로 받아 총합을 반환하는 SplitSum 메서드 작성
- 빈문자열 / 쉼표(,) 또는 콜론(:)으로 구분 / 커스텀 구분자로 구분 / 예외처리 조건문 작성
- 구분한 문자열에서 숫자만 추출
- 구분한 문자열을 숫자로 변환
- 변환한 숫자를 합하여 반환
