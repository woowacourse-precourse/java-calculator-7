# java-calculator-precourse

## [1차 기능 구현 목록]
1. ‘덧셈할 문자열을 입력해주세요‘ 문구 출력
2. 사용자 입력 : Console.readLine 사용
3. 입력 예외 처리 : IllegalArgumentException
  - 기준 1. 기본 구분자와 양수로 이루어져있는가
  - 기준 2. 커스텀 구분자가 //와 \n 사이에 정의되어있는가
  - 예외 1. 음수가 존재하는 경우
  - 예외 2. 기본 구분자가 아닌 구분자가 존재하고, //와 \n 사이에 정의되지 않은 경우

4. 덧셈 계산
  - split : 기본 구분자 혹은 커스텀 구분자를 기준으로 split하여 문자열 배열 생성
  - 문자열 배열의 원소를 정수로 변환
  - 정수로 변환한 원소들을 모두 덧셈

5. '결과 : ' 문구 출력
6. 실제 덧셈 계산 결과 출력

## [패키지 설계]
1. view
  - InputView : ‘덧셈할 문자열을 입력해주세요‘ 문구 출력
  - ResultView : 계산 결과 출력

2. domain
  - StringCalculator : 구분자로부터 숫자를 분리하여 덧셈 계산

3. controller
  - StringCalculatorController : InputView, StringCalculator, ResultView가 순서에 따라 동작하도록 함