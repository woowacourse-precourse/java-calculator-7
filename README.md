# java-calculator-precourse

# 기능 구현
- Input  
  message를 출력하고 사용자로부터 입력을 받는다.
  - print  
  `덧셈할 문자열을 입력해 주세요.`를 출력한다.
  - input  
    사용자로부터 입력을 받아 `String`을 반환한다.
- Parser  
  `String` 문자열을 구분자로 나누고 `String` 배열로 바꾼다.
  - replace
    - 문자열에서 특수문자를 모두 `;`로 바꾼다.
  - split
    - `;`를 기준으로 문자열을 분리하여 `String` 배열로 바꾼다.
- Validate  
  `String` 배열에 적합하지 않은 문자열이 있는지 검사한다.
  - validate  
    배열에 숫자 이외 문자가 있을 시 `IllegalArgumentException`를 발생시킨다.
- Char2Num  
  `String` 문자열 배열을 `Long` 배열로 바꾼다.
  - convert
    - 문자열 배열을 숫자(`Long`) 배열로 바꾼다.
  - isEmpty
    - 빈 배열의 경우 `true`, 그렇지 않으면 `false`를 반환한다.
  - zeroArray
    - 빈 배열의 경우 숫자 `0`가 하나 있는 배열을 반환한다.
- Summation
  `Long` 배열의 모든 요소의 합을 구한다.
  - sum  
  배열의 합을 구하고 숫자(`Long`)을 반환한다.
- Output  
  message와 함께 값을 출력한다.
  - print  
    숫자(`Long`)를 받아 `결과 : `와 함께 출력한다.