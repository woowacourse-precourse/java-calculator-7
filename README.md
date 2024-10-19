# java-calculator-precourse

⚡️ 구현할 기능 목록
-------
### 1. 숫자 입력 받기
  - "덧셈할 문자열을 입력해 주세요." 출력
  - input 받기 (camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.)
### 2. 기본구분자
  - ,|: 기본구분자로 등록
  - 문자열에서 split()사용해서 추출
### 3. 커스텀구분자
  - 문자열 앞부분에 "//" 확인
  - "\\n" 로 끝나는지 확인 (\n 이 줄바꿈이 아닌 문자열로 인식되어야함)
  - 커스텀구분자 +2 한 숫자 추출
  - 커스텀구분자 | 이용해서 기본구분자 뒤에 더해주기
### 4. 추출한 숫자 더하기
  - 추출된 숫자 문자열로 추출되므로 이를 int형으로 변환
  - 변환한 숫자 더하기
### 5. 결과 반환
  - "결과 : " + result,totalsum
### 6. 예외처리
IllegalArgumentException 을 발생후 종료
  - c1) 문자열에 숫자가 없을 경우 -> 0
  - c2) 입력이 빈 문자열일 경우 -> 0
  - c3) 문자열에 음수 포함한 경우 ->  IllegalArgumentException 을 발생후 종료
  - c4)
