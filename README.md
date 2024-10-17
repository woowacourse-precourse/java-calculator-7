# java-calculator-precourse
입력한 문자열에서 숫자를 추출하여 더하는 계산기

## 기본 설계

### 클래스
- `Calculator` : 입력한 문자열에서 숫자를 추출하여 더하는 계산기의 메인 클래스
- `Parser` : 사용자 입력을 파싱하는 클래스
- `DelimeterManager` : 구분자를 관리하는 클래스
## 구현 기능

### Calculator
- `sum()` : 유효한 양수를 기존의 값에 더합니다. (불변 객체 반환)
- `printSum()`: 결과값을 출력합니다.

### Parser
- `isValidString()` : 입력된 문자열이 유효한 문자열인지 검사합니다.

### DelimeterManager
- `addDelimeter()` : 기존의 구분자(",", ":")에 커스텀 구분자를 더합니다.
- `getDelimiters()` : 구분자 배열을 반환합니다.