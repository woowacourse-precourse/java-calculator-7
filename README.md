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

3. 여러 유형의 Input 클래스를 만들고 사용자가 입력한 문자열을 InputTypeSorter가 확인하여 알맞은 Input 클래스에 할당하도록 변경

4. 각 Input 클래스는 자신만의 방법으로 문자열을 Long 배열로 변환하여 Calculator로 넘김

5. 작업 흐름

- InputView가 '덧셈할 문자열을 입력해주세요' 출력
- 사용자 입력 : Console.readlLine
- InputTypeSorter에 사용자 입력을 넘기고, 알맞은 Input 클래스에 작업 할당
- Input 클래스가 문자열을 Long형 배열로 만듦 (이 때, 문자열 split은 StringUtil이 담당)
- Long형 배열이 Calculator로 넘어가, Calculator는 Long 덧셈 결과를 반환
- ResultView가 계산 결과 출력

6. 자료형 변경

- int 덧셈 -> Long 덧셈으로 변경 (int의 범위를 넘을 경우 대비)

## 패키지 설계

1. view

- InputView : ‘덧셈할 문자열을 입력해주세요‘ 문구 출력
- ResultView : 계산 결과 출력

2. domain

- Calculator : 구분자로부터 숫자를 분리하여 덧셈 계산
- input
    * InputTypeSorter : 사용자의 Input 유형을 구분
    * Input : 추상 클래스. Long형 배열을 만드는 추상 메소드 정의
    * BasicInput : 기본 구분자가 포함된 문자열. 유효성 검증, long형 배열 생성
    * CustomInput : 커스텀 구분자를 정의하는 문자들이 포함된 문자열. 유효성 검증, long형 배열 생성
    * EmptyInput : 빈 문자열. 유효성 검증, long형 배열 생성
    * OtherInput : 이외 문자열

3. controller

- StringCalculatorController : InputView, StringCalculator, ResultView가 순서에 따라 동작하도록 함

4. util

- UserInputValidator : 사용자의 문자열 입력의 유효성을 검증
- StringUtil : 문자열 split하여 문자열 배열 생성

5. constants

- InValidInputConstants : 잘못된 문자열이 입력되었을 때 유형에 알맞은 출력 문구 정의