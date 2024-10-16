# java-calculator-precourse
-----
# 👷기능 요구사항 정의
## Util
### Validator (입력 체크)
- 잘못된 입력인 경우 IllegalArgumentException 발생
~~- 입력이 empty~~
- 숫자 없이 구분자 (입력의 시작 위치)
  - 커스텀 구분자를 설정하는 경우면 OK
  - 그 외 Exception 
- 숫자가 없는 경우
- 잘못된 커스텀 구분자
- 커스텀 구분자 지정 없이 커스텀 구분자 사용
## Model
### Operator (입력 받은 문자열)
- 사용자로부터 받은 입력을 구분자로 나누어진 정제된 문자열로 변경하여 저장
### Calculator (계산기)
- 현재의 미션에서는 덧셈만 수행
- 정제된 문자열을 순서에 따라 덧셈 연산
-----
## View
### InputView
- 사용자의 입력을 받는 클래스
### OutputView
- 계산 결과를 출력
-----
## Controller
### CalculatorController
- 계산기를 실행한다.
- Operator에서 발생 한 예외 처리 (종료)


