# java-calculator 기능 목록

## v0 : 문자열 덧셈 계산기 기능 구현

- [X] I/O 기능
- [X] 기본 구분자(, 또는 :) 덧셈 기능
- [X] 커스텀 구분자 덧셈 기능

## v1 :SRP(단일 책임 원칙)을 준수하도록 리팩토링

### Application

- [X] 안내문구를 출력한다.
- [X] 사용자로부터 readLine()를 통해 숫자를 입력 받는다.
- [X] StringCalculator 객체로부터 계산 결과를 받는다.
- [X] 계산 결과를 출력한다.

### StringCalculator

- [X] DelimiterParser 객체로부터 파싱된 토큰 배열을 받는다.
- [X] 토큰을 숫자로 변환한다.
- [X] 숫자들의 합을 계산한다.

### DelimiterParser

- [X] 기본 구분자/커스텀 구분자 사용여부를 판별한다.
- [X] 기본 구분자(, 또는 :) 사용 시, 문자열을 토큰 배열로 변환한다.
- [X] 커스텀 구분자 사용 시, 커스텀 구분자를 추출하여 문자열을 토큰 배열로 변환한다.
- [X] 문자열을 토큰 배열로 변환 시, 문자열에 대한 유효성을 검증한다.

## v2 : 도메인 객체 도입으로 유효성 검증 로직 분리

### Application

- [ ] 안내문구를 출력한다.
- [ ] 사용자로부터 숫자를 입력받아 Input 객체를 생성한다.
- [ ] StringCalculator에 Parser 객체를 전달하여 계산을 수행한 뒤, CalcResult 객체를 받는다.
- [ ] CalcResult로부터 계산 결과를 출력한다.

### StringCalculator

- [ ] Input 객체에 포함된 문자열이 비어 있는 경우 0을 반환하고, 그렇지 않으면 덧셈 계산을 수행한다.
- [ ] Input 객체를 DelimiterInputFactory를 통해 DelimiterInput 객체로 변환한다.
- [ ] Parser 객체에 Input을 입력하여 파싱을 수행한 뒤, TokenList 객체를 받는다.
- [ ] TokenList에서 각 토큰을 정수로 변환한 후 합산하여 CalcResult 객체에 담아 반환한다.

### Parser

- [ ] DelimiterInput 객체에서 구분자 패턴과 입력 문자열을 가져온다.
- [ ] 구분자에 따라 문자열을 분리한 후 TokenList 객체로 반환한다.

### Input

- [ ] 입력된 문자열이 빈 문자열이거나 커스텀 구분자가 포함된 빈 입력인지 확인한다.

### DelimiterInput

- [ ] 입력된 문자열이 구분자 패턴에 맞는 유효한 형식인지 검증한다.

### DelimiterInputFactory

- [ ] 입력된 문자열에 따라 기본 구분자 또는 커스텀 구분자를 사용하는 DelimiterInput 객체를 생성한다.
- [ ] 입력된 Input 객체가 커스텀 구분자를 포함하는지 확인한다.

### DefaultDelimiterInput

- [ ] 기본 구분자를 사용하여 DelimiterInput을 초기화한다.

### CustomDelimiterInput

- [ ] 커스텀 구분자와 입력 문자열을 추출하여 DelimiterInput을 초기화한다.
- [ ] 입력 문자열이 유효한 커스텀 구분자 패턴을 따르는지 검증한다.

### TokenList

- [ ] 파싱된 문자열 토큰을 List로 저장하고 관리한다.

### CalcResult

- [ ] 계산 결과를 저장한다.