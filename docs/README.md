# 프리코스 1주차 문자열 계산기

<br>
<br>
<br>

## 프로젝트 구조

### presentation
* CalculatorController : 유저에게 문자열 입력받음
* Validator : 입력에 대해 유효성 검사

### business
* CalculatorService : 문자열을 전달받아 변환 후 연산
* Validator : 문자열 유효성 검사
* dto : Controller 와 Service 간 데이터 전송을 위한 패키지

### common
* Constant : Controller와 Service의 상수를 관리