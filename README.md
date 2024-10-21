# java-calculator-precourse

## 기능 목록

1. 입력 받기
- 사용자로부터 문자열을 입력 받는 기능
- amp.nextstep.edu.missionutils.Console의 readLine()을 활용

2. 기본 구분자로 문자열 분리
- 입력 받은 문자열에서 쉽표(,)와 콜론(:)을 구분자로 사용하여 문자열을 분리
- 분리된 문자열에서 숫자만 추출하여 리스트로 반환

3. 커스텀 구분자 처리
- 입력 문자열 시작 부분에 "//"와 "\n" 사이에 커스텀 구분자가 지정되어 있는지 확인
- 지정된 커스텀 구분자를 사용하여 문자열 분리

4. 숫자 합 계산
- 분리된 숫자들의 합을 계산

5. 예외 처리
- 숫자가 아닌 값이 입력되었을 경우 IllegalArgumentException 발생
- 빈 문자열이 입력되었을 경우 IllegalArgumentException 발생
- 음수가 입력되었을 경우 IllegalArgumentException 발생
- 예외 발생 시 애플리케이션 종료

6. 결과 출력
- 최종 계산된 합을 출력