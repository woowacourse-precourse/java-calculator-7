# java-calculator-precourse

## 기능 목록

``
핵심 기능: 입력한 문자열에서 숫자를 추출하여 더하는 계산기를 구현한다.
``
- [ ] 사용자의 입력을 받는다.
- [x] 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환한다.
    - [x] 빈 값이 들어올 경우 0을 반환한다.
    - [x] 공백만 들어올 경우 IllegalArgumentException을 발생한다.
    - [x] 숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.
- [x] 앞의 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 "//"와 "\n" 사이에 위치하는 문자를 커스텀 구분자로 사용한다.
    - 예를 들어 "//;\n1;2;3"과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
- [x] 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.