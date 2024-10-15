# java-calculator-precourse

![img.png](img.png)

## 구현 기능 목록
- [ ] 문자열 입력 받기
- [ ] 커스텀 구분자 parsing
- [ ] 적절한 형식인지 판단하기 (exception 발생)
- [ ] 문자열에서 연산의 대상 숫자 parsing
- [ ] 덧셈 연산
- [ ] 연산의 결과 출력하기

## 객체 목록과 각 객체 별 책임
- InputController
  - 시스템으로 들어오는 input을 담당한다.
- StringPlusCalculator
  - 입력으로 들어온 input에 대해서 작업(parsing, plus etc)을 해서 결과 값을 반환하는 게산기 객체다.
- InputParser
  - input string에 대해서 parsing 작업을 담당한다.
  - 커스텀 구분자 parsing
  - 연산의 대상 숫자 parsing
-  CheckForm
  - input에 대해서 적절한 입력인지 판단하고 exception 발생을 담당한다.
- Calculation
  - 대상 연산자들에 대해서 연산 수행을 담당한다.
- PrintOutput
  - 콘솔 창에 출력하는 일을 담당한다.

## 제출 전 체크리스트