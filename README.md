# java-calculator-precourse

## 기능 목록

1. **문자열 입력 받기** ('ConsoleIO.getInput')
    - 콘솔로부터 문자열을 입력 받는 기능을 구현합니다.

2. **빈 문자열 처리** ('StringAdder.add')
    - 사용자가 빈 문자열을 입력할 경우, 0을 반환하는 기능을 구현합니다.

3. **구분자 추출하기** ('StringAdder.extractDelimiter')
    - 기본 구분자(','와 ':') 또는 커스텀 구분자를 문자열에서 추출하는 기능을 구현합니다.

4. **커스텀 구분자 지정 부분 이후의 숫자 문자열 부분만 추출하기** ('StringAdder.removeDelimiterSection')
    - '//(커스텀 구분자)\n' 이후의 숫자 문자열만 추출하는 기능을 구현합니다.

5. **구분자를 기준으로 숫자를 추출하기** ('StringAdder.splitNumbers')
    - 덧셈할 숫자를 얻어내기 위해 구분자를 기준으로 숫자만 추출하는 기능을 구현합니다.
   
6. **음수 검증** ('InputValidator.validate')
    - 입력된 숫자 중 음수가 포함되어 있을 경우, IllegalArgumentException을 던지는 기능을 구현합니다.

7. **잘못된 입력 검증** ('InputValidator.validate')
    - 숫자가 아닌 입력이 포함된 경우, IllegalArgumentException을 던지는 기능을 구현합니다.

8. **숫자 더하기** ('StringAdder.sumNumbers')
    - 추출된 숫자를 더하는 기능을 구현합니다.

9. **결과 출력** ('ConsoleIO.printResult')
    - 계산된 결과를 콘솔에 출력하는 기능을 구현합니다.


## 클래스별 역할
- **StringAdder**: 문자열을 받아 구분자를 기준으로 숫자를 추출하고, 덧셈을 수행하는 클래스입니다.
- **InputValidator**: 입력된 문자열이 올바른지 검증합니다.
- **ConsoleIO**: 콘솔로부터 입력을 받고 결과를 출력합니다.