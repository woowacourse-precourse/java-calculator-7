# java-calculator-precourse

## 구현할 기능 목록

1. 입력 안내 문구와 문자열 입력받는 기능
2. 입력받은 문자열 중 **커스텀 구분자**를 찾는 기능
    1. **커스텀 구분자**: ``//`` 와 ``\n`` 사이의 문자
3. 입력받은 문자열을 구분자(`,`, `:`)와 **커스텀 구분자**로 나누어 숫자 배열을 만드는 기능
    1. 숫자가 아닐 경우 `IllegalArgumentException`에러 발생
    2. 구분자를 제외하고 음수가 입력된 경우 `IllegalArgumentException`에러 발생
    3. 공백("")일 경우 0으로 계산
4. 구분된 숫자를 계산하는 기능
5. 결과를 출력하는 기능