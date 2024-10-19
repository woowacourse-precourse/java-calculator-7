# java-calculator-precourse
---
# 구현 기능 목록
---
## \<controller>
### Controller
* `calculate`: 빈 문자열일 경우 결과값 0으로 출력히는 기능
---


## \<model>
### Calculator
* `plusCalculator`: 숫자들의 합을 구하는 기능
### Delimiter : 구분자를 관리하는 객체
### Extractor 
* `saveExtractorDto`: `ExtractorDto`를 저장하는 기능
* `saveCustomDelimiter`: 커스텀구분자를 저장하는 기능
* `extractValues`: 숫자들의 값을 추출하는 기능
* `numericErrorDiscriminator`: 입력된 값이 숫자가 아니면 에러를 발생시키는 기능
### ExtractorDto : 구분자와 숫자를 분리해서 가지고 있는 객체
### Number : 숫자객체
* `Number`: 숫자가 음수이면 에러를 발생시키는 기능
### Numbers : 숫자들을 모아둔 객체
---


## \<view>
### inputView
* `inputCalculationValue`: 계산할 문장을 입력받는 기능
### outputView
* `printResultValue`: 결과를 출력하는 기능

---
---
(참고)
## 기능 요구 사항
입력한 문자열에서 숫자를 추출하여 더하는 계산기를 구현한다.

* 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환한다.
  예: "" => 0, "1,2" => 3, "1,2,3" => 6, "1,2:3" => 6
* 앞의 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있다.
  커스텀 구분자는 문자열 앞부분의 "//"와 "\n" 사이에 위치하는 문자를 커스텀 구분자로 사용한다.
    * 예를 들어 "//;\n1;2;3"과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.

* 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.
---
## 입출력 요구 사항
입력
* 구분자와 양수로 구성된 문자열

출력
* 덧셈 결과
```
  결과 : 6
```
실행 결과 예시
```
  덧셈할 문자열을 입력해 주세요.
  1,2:3
  결과 : 6
```



