# java-calculator-precourse

## 기능 목록

### 입력
- [X] 사용자에게 문자열을 입력하라는 문구를 전달한다. - InputView#readLine
- [X] 덧셈에 사용될 구분자가 포함된 문자열을 입력 받는다. - InputView#readLine

### 문자열 전처리
- [X] 커스텀 구분자가 존재하는지 검사한다. - InputValidator#isExistCustomSeparator
- [X] 커스텀 구분자가 있는 경우
  - [X] 문자열 속에서 "//"와 "\n" 사이에 존재하는 구분자를 찾는다. - InputValidator#getCustomSeparator
  - [X] 문자열 속에서 커스텀 구분자 정보를 제거한다. - InputValidator#removeSeparatorInfo
  - [X] 구분자 리스트를 1개의 문자열로 변환한다. - InputValidator#convertString
  - [X] 커스텀 구분자와 기본 구분자를 사용해서 숫자를 분리한다. - InputValidator#separate
- [X] 커스텀 구분자가 없는 경우
  - [X] 기본 구분자를 사용해서 숫자를 분리한다. - InputValidator#separate

### 숫자 유효성 검사
- [X] 분리된 숫자가 모두 양수인지 검사한다. - NumberValidator#isPositiveNumber

### 계산기
- [X] 분리된 숫자를 모두 더한다. - Calculator#add

### 출력
- [X] "결과 : result" 형식으로 계산된 덧셈 결과를 출력한다. - OutputView#printResult

### 컨트롤러
- [X] 기본 구분자(쉼표, 콜론)를 설정한다. - CalculatorController#initBasicSeparators
- [X] 기본 구분자와 커스텀 구분자를 하나로 합친다. - CalculatorController#getTotalSeparator
- [X] 덧셈 계산기를 실행한다. - CalculatorController#start