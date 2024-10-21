# java-calculator-precourse

## 구현할 기능 목록

### Application  
프로그램 진입, 계산기 실행 클래스
### Model
#### Calculator 
추출된 숫자들을 덧셈 계산하는 클래스
#### StringSplitter
입력된 문자열에서 기본 구분자와 커스텀 구분자를 기준으로 숫자를 추출하는 기능

### Util
#### InputValidator
입력 받은 문자열이 규칙에 맞는지 확인하는 클래스
- 문자열이 올바른 형식인지 검증
- 입력된 문자열이 빈 값인지 확인
- 커스텀 구분자가 있는지 확인
- 커스텀 구분자가 올바른 형식인지 검증
- 커스텀 구분자의 길이가 1인지 확인

### Controller
#### CalculatorController
InputView에서 입력을 받고, Calculator를 통해 계산을 수행한 후, 결과를 OutputView로 출력하는 클래스

### View
#### InputView
사용자로부터 문자열 입력 받는 클래스
#### OutputView
계산 결과를 출력하는 클래스
