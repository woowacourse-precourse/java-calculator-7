## 미션 1 - 문자열 덧셈 계산기

### 구현 기능 목록

#### 예외 처리 클래스 (CalculatorException)
- 잘못된 데이터가 들어오는 경우 IllegalArgumentException 발생 후 종료
  1. 커스텀 구분자 입력이 옳바르지 않는 경우
  2. 숫자 문자열에 숫자가 아닌 임의의 값이 입력된 경우 
  3. 옳바르지 않은 커스텀 구분자 형식인 경우

#### 구분자 형식 판별 클래스 (InputValidator)

- 기본 구분자 형식 제공
  - isDefaultDelimiter()
- 커스텀 구분자 형식 제공
  - isCustomDelimiter()
- 입력된 커스텀 구분자 반환
  - getCustomDelimiterPattern()
- 입력 형식 판단 및 잘못된 입력 예외 처리
  - validate()

#### 입력 받은 문자열에서 구분자와 숫자를 분리 후 숫자를 더해 결과 반환하는 클래스 (NumberParser)
- 구분자와 분별 및 숫자를 더하는 통합 메서드 제공
  - add() 메서드 흐름
    1. 기본 입력, 커스텀 입력, 입력 형식 판단
       - getParsedInput()
    2. 커스텀 구분자 포함
       - parseCustomInput() 커스텀 구분자와 숫자 부분을 분리 추출
       - splitDelimiters() 커스텀 구분자에 분리 및 정규 표현식 인식 오류로 인한 이스케이프 문자 추가 코드
       - validateNumbers() 숫자부분에 등록되지 않은 구분자가 존재하면 예외처리
    3. 구분자를 이용해 숫자 분리 및 숫자 덧셈 결과 반환
       - sum() 구분자 기준으로 숫자를 분리해 더한 결과를 반환
    