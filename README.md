## 기능 목록
1) InputView
- 문자열 입력 기능

2) OutPutView
- 계산 결과 값을 출력

3) StringParser
- "/" 와 "\n" 사이에있는 커스텀 구분자가 있는지 판별
- 커스텀 구분자가 있을시 기본 구분자인 쉼표(,), 콜론(:)와 커스텀 구분자로 숫자 분리
- 커스텀 구분자가 없을시 기본 구분자만으로 분리

4) Calculator
- StringParser에서 반환받은 숫자들을 더한다.

5) Validator
- 입력 문자열과 구분자 형식이 올바르지 않을 경우 IllegalArgumentException을 발생시킨다
- 문자열이 숫자가 아닐 경우 IllegalArgumentException을 발생시킨다

