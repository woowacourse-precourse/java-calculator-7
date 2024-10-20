# java-calculator-precourse

**입력 처리**
1. 문자열 형태의 입력을 받는다.
   1. 입력은 Request DTO에 담아 Controller로 전달한다.
2. 입력이 `null`이거나 빈 문자열인 경우 `IllegalArgumentException`을 발생시킨다.

**입력 검증**
1. 입력이 숫자가 아닌 경우 예외를 발생시킨다.
2. 입력이 연산자가 아닌 경우 예외를 발생시킵니다.
3. 입력이 숫자와 연산자로만 이루어진 문자열이 아닌 경우 예외를 발생시킵니다.

**구분자 추출**
1. HashSet을 사용하여 구분자를 저장하는 공간을 만든다.
2. 입력 문자열의 앞부분에서 //로 시작하여 \n으로 끝나는 부분을 확인하여 커스텀 구분자를 set에 저장한다.
3. 기본 구분자 (콤마(,)와 콜론(:)) 을 set에 추가한다.

**숫자 추출 및 계산**
1. 입력 문자열을 구분자로 나누어 숫자 문자열 배열을 만든다.
2. 숫자 문자열을 숫자로 변환하여 덧셈 계산한다.
3. 변환이 실패할 경우 예외를 발생시킨다.

**결과 처리**
1. 합계는 Controller에서 Response DTO에 담아 View로 전달한다.
2. 합계를 출력한다.