# java-calculator-precourse

입력한 문자열에서 숫자를 추출하여 더하는 계산기

## 기본 설계

### 용어

- `구분자 섹션(delimiterSection)` : 구분자 정의 접두사("//") + 커스텀 구분자 + 구분자 정의 접미사("\\n")를 총칭

### 클래스

- `Calculator` : 입력한 문자열에서 숫자를 추출하여 더하는 계산기 클래스
    - `Parser` : 사용자 입력을 파싱하는 Calculator의 내부 클래스
- `DelimiterManager` : 구분자를 관리하는 클래스

## 구현 기능

### Calculator

- `readInput()` : 입력 값을 받아 해석하고 처리합니다.
- `sum()` : 숫자형 문자의 값을 더합니다.
- `splitByDelimiters` : 구분자들을 기준으로 문자열을 쪼갭니다.
- `add()` : 지금까지 합산한 값에 인자로 들어온 값을 더합니다.
- `isNumeric` : 정규표현식을 사용해 숫자형 문자인지 확인합니다.
- `displayPrompt()` : 상수로 지정한 프롬프트 메시지를 출력합니다.
- `printSum()` : 지정한 형식으로 결과값을 출력합니다.

### Parser

- `parseString()` : 입력된 문자열이 유효한 문자열인지 검사히고 문자열을 재조립합니다.
- `hasDelimiterSection()` : 사용자 입력 문자열에 구분자 섹션이 있는지 확인합니다.
- `checkValidInput()` : 유효한 형식을 갖춘 문자열인지 확인합니다.
- `splitByDelimiterChar()` : 커스텀 구분자를 기준으로 문자열을 쪼개 커스텀 구분자를 포함하지 않은 뒤 문자열을 반환합니다.
- `compareToSuffix()` : 해당 문자열이 커스텀 구분자 정의 접미사로 시작하는지 확인합니다.

### DelimeterManager

- `getCustomDelimiter()` : 멤버 변수 customdelimiter의 getter
- `getLenOfPrefix()` : 멤버 변수 lenOfPrefix의 getter
- `getLenOfSuffix()` : 멤버 변수 lenOfSuffix의 getter
- `getDelimiters()` : 멤버 변수 delimiters의 getter
- `setCustomDelimiter()` : 멤버 변수 customdelimiter의 setter
- `addDelimeter()` : 기존의 구분자(",", ":")에 커스텀 구분자를 더합니다.
- `isDelimiterLimitExceeded` : 구분자의 최대 개수를 초과하는지 확인합니다.
- `isDelimiterExists` : 이미 존재하는 구분자("," 또는 ":")인지 확인합니다.
- `isDelimiters` : 매개변수 c가 구분자인지 확인합니다.