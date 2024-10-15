# java-calculator-precourse

## 기능 요구 사항
입력한 문자열에서 숫자를 추출하여 더하는 계산기를 구현한다.

- 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환한다.
  - 예: "" => 0, "1,2" => 3, "1,2,3" => 6, "1,2:3" => 6
- 앞의 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 "//"와 "\n" 사이에 위치하는 문자를 커스텀 구분자로 사용한다.
  - 예를 들어 "//;\n1;2;3"과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.
- 입력은 구분자와 양수로 구성된 문자열이어야 된다.

## To-dos
- [x] ""를 입력했을 때, 0을 반환하게 하라
- [x] 10을 입력했을 때, 10을 반환하게 하라
- [x] "1,2,3"을 입력했을 때, 6을 반환하게 하라
- [x] "1,2:3"을 입력했을 때, 6을 반환하게 하라
- [x] 입력하는 문자열 앞에 커스텀 구분자를 지정하게 하라
- [ ] 예외 처리
  - [ ] 문자열 안에 공백이 있는 경우, IllegalArgumentException 을 발생시켜라
