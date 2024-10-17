# java-calculator-precourse

## [ 1차 기능 구현 목록]

#### 수정 일시 : 2024. 10. 16 오전 10시

1. ‘덧셈할 문자열을 입력해주세요‘ 문구 출력
2. 사용자 입력 : Console.readLine 사용
3. 입력 예외 처리 : IllegalArgumentException

- 기준 1. 기본 구분자와 양수로 이루어져있는가
- 기준 2. 커스텀 구분자가 //와 \n 사이에 정의되어있는가
- 예외 1. 음수가 존재하는 경우
- 예외 2. 기본 구분자가 아닌 구분자가 존재하고, //와 \n 사이에 정의되지 않은 경우
- 예외 3. 커스텀 구분자가 정의되었으나, 해당 구분자 외에 다른 구분자가 포함된 경우
- 예외 4. //와 \\n 사이에 커스텀 구분자가 정의되지 않은 경우
- 예외 5. 구분자 하나만 입력된 경우

4. 덧셈 계산하기

- split : 기본 구분자 혹은 커스텀 구분자를 기준으로 split하여 문자열 배열 생성
- 문자열 배열의 원소를 정수로 변환
- 정수로 변환한 원소들을 모두 덧셈
- 문자열이 숫자 하나일 때 해당 숫자를 반환

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

4. util

- UserInputValidator : 사용자의 문자열 입력의 유효성을 검증

5. constants

- Constants : StringCalculator, StringValidator, 그 외 테스트 클래스에서 사용되는 상수 정의

## [2차 기능 구현]

#### 수정 일시 : 2024. 10. 17 오후 11시

1. 현재 StringCalculator의 역할

- input 확인 : 빈 문자열 / 커스텀 구분자 포함 / 기본 구분자 포함 / 숫자 하나
- 덧셈 계산 : 커스텀 구분자인 경우와 기본 구분자인 경우의 계산이 서로 다름
- 문자열 split

2. StringCalculator는 덧셈 계산만 담당하도록 변경. 이름도 Calculator로 변경

3. 작업 순서

- Console.readlLine
- 커스텀 구분자 포함 input / 기본 구분자 포함 input / 유효하지 않은 input
- split해서 Calculator로 넘기기

4. 자료형 변경

- int 덧셈 -> Long 덧셈으로 변경 (int의 범위를 넘을 경우 대비)
- 기본 구분자 ,와 :는 String -> Character로 변경

## 패키지 설계

1. view

- InputView : ‘덧셈할 문자열을 입력해주세요‘ 문구 출력
- ResultView : 계산 결과 출력

2. domain

- StringCalculator : 구분자로부터 숫자를 분리하여 덧셈 계산
- InputTypeSorter : 사용자의 입력 유형을 구분
- Input : 공통 유효성 검증 정의
- BasicDelimiterInput : 유효성 검증, long형 배열 생성
- CustomDelimiterInput : 유효성 검증, long형 배열 생성

3. controller

- StringCalculatorController : InputView, StringCalculator, ResultView가 순서에 따라 동작하도록 함

4. util

- UserInputValidator : 사용자의 문자열 입력의 유효성을 검증
- StringUtil : 문자열 split하여 문자열 배열 생성

5. constants

- Constants : StringCalculator, StringValidator, 그 외 테스트 클래스에서 사용되는 상수 정의