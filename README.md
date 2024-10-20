# String Addition Calculator

![Generic badge](https://img.shields.io/badge/precourse-week1-green.svg)
![Generic badge](https://img.shields.io/badge/JDK-21-blue.svg)

## Function list
- [x] 입력한 문자열에 커스텀 구분자 지정 패턴이 존재하는지 확인하는 기능


- [x] 입력한 문자열에서 커스텀 구분자와 숫자+구분자로 이루어진 문자열을 추출하는 기능
    * 커스텀 구분자 지정 패턴이 존재할 때 호출
    * 입력한 문자열이 올바른 형식인지 검사(`java.util.regex` 라이브러리 활용)
    * 입력한 문자열이 올바른 형식이 아니라면 `IllegalArgumentException` 던지기


- [x] 커스텀 구분자를 추가하는 기능


- [x] 구분자와 숫자로 구성된 문자열을 구분자를 기준으로 나누는 기능
    * 커스텀 구분자가 존재하는 지 확인, 만약 커스텀 구분자가 존재한다면 업데이트된 구분자를 기준으로 문자열 나누기


- [x] 문자열로 표현된 숫자를 `Integer`로 parsing 하는 기능
    * 문자열로 표현된 숫자가 아닌 값이 입력되었을 때, `NumberFormatException`을 던지고, `NumberFormatException`을 catch 구문으로 받아서 `IllegalArgumentException` 던지기


- [x] 구분자와 숫자로 구성된 문자열에서 모든 숫자를 덧셈한 값을 구하는 기능
