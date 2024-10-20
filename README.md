# java-calculator-precourse

## 구현할 구현 목록

1. 문자열 입력 받기
    - `camp.nextstep.edu.missionutils.Console` 라이브러리를 통해 제공되는 `readLine()` 메소드를 사용하여 문자열 입력 받기
2. 구분자를 기준으로 문자열을 나누어 문자열 배열에 담기
   - `,`와 `:` 구분자를 기준으로 `String` 객체 메소드인 `split()`를 통해 문자열을 나누어 문자열 배열에 담기
3. 문자열 배열의 값을 정수형으로 형변환하여 합 구하기
   - 문자열 배열에 담긴 문자형 숫자를 `Integer.parseInt()` 메소드를 통해 정수형으로 형변환 해주고, 변환된 정수형 데이터를 복합 대입 연산자 `+=`로 합 구하기
4. 커스텀 구분자 식별하여 커스텀 구분자로도 문자열을 나눌 수 있게 하기
   - `Pattern.complie()` 메소드와 `Pattern` 객체의 `macher()` 메소드를 통해 정규표현식으로 커스텀 구분자 식별하기
   - `Matcher` 객체의 `find()` 함수로 커스텀 구분자가 있다면 `group()` 메소드로 구분자와 계산할 문자열을 나누어 위의 기능을 수행하기
5. 잘못된 값을 입력 받았을 경우 `IllegalArgumentException` 발생시키기
   - 음수 혹은 잘못된 값을 입력 받았을 때, `throw`로 `IllegalArgumentException` 예외 던지기