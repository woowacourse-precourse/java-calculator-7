# java-calculator-precourse

**구현할 기능 목록**

1. 입력
    1. “덧셈할 문자열을 입력해 주세요.”를 출력
    2. `camp.nextstep.edu.missionutils.Console.readLine()` 를 입력으로 설정
2. 출력
    1. “결과 : “ 와 계산 결과 출력
3. 계산 내용을 저장
    1. 객체로 저장
4. 커스텀 문자열 처리
    1. 커스텀 문자열을 기본 문자열의 구분자가 포함된 문자열로 변경
5. 유효성 확인
    1. 커스텀 구분자가 포함된 문자열과 기본 구분자가 포함된 문자열 구분
    2. 유효하지 않은 문자열은 `IllegalArgumentException` 발생
6. 계산 실행
    1. 문자열을 구분자로 잘라 숫자만 더하기