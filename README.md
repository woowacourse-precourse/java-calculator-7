# java-calculator-precourse

---
## 기능 요구 사항
입력한 문자열에서 숫자를 추출하여 더하는 계산기를 구현한다. 

- 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환한다.
  - 예: "" => 0, "1,2" => 3, "1,2,3" => 6, "1,2:3" => 6
- 앞의 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 "//"와 "\n" 사이에 위치하는 문자를 커스텀 구분자로 사용한다.
  - 예를 들어 "//;\n1;2;3"과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.


## 구현할 기능 목록 

###  Basic 함수 구현 1차

#### Solution 함수 
- 기능 
  - 빈 문장일 경우 0을 반환 
  - 특별 구분자를 확인하는 함수 getSpecialDelimiter- 리팩토링 필요 
  - 에러를 확인하는 함수 checkForErrors - 추가 case를 생각해 봐야함
  - String 과 구분자를 사용해서 문자를 나눠서 숫자로 더하는 함수 splitByDelimiter - 리팩토링 필요 

#### checkForErrors
- IllegalArgumentException 발생되는 case 생각해 보기.  
  - 알파벳이 있을 때 - 기본 구분자 외 특수 구분자를 특수기호 중 하나로 지정하고, 알파벳은 오류 처리
  - 정규표현식으로 알파벳이 있는지 확인 python(re.sub[^a-zA-Z])

  - 구분자와 특수 구분자를 제외한 모든 특수기호가 잇다면, 에러를 발생시킨다. 
  - 특수 구분자를 제외한 알파벳이 있다면, 에러를 발생시킨다. 
  
#### getSpecialDelimiter 
- 기능 
  - input : 문자열 
  - 특수구분자가 있는지 확인한는 함수 
  - "//"와 "\n" 가 있는지 확인하고, 하나라도 없으면 그냥 바로 반환 
  - 둘다 있으면, 그 사이의 값을 확인한다. -> 어떻게? 파이썬 같은 경우 in으로 파악은 가능한데 
  - return : 특수 구분자.

#### splitByDelimiter
- 기능 
  - input : String Array (입력 문자열), String Array (구분자)
  - 구분자를 기준으로 반복문을 진행 
    - 입력 문자열의 배열의 길이를 조건으로 
      - 길이가 0이면 바로 숫자합를 반환 
      - 길이가 1이면, splitString 함수를 사용하여 문자열 배열과 숫자합을 반환 받는다. 
      - 길이가 1 이상이면, splitArray에 넣어준다. 
  - return : 수의 합 

#### splitString (가제)
- 기능 
  - 문자열과 구분자 하나를 받아 구분자로 문자열을 나누는 기능을 하는 함수 
  - 결과물를 convertAndSumWithRemainder 에 넣어준다.
  - input : String 문자열, String 구분자
  - return : 문자열.split(구분자)

#### splitArray 
- 기능 
  - 문자열 Array와 구분자 하나를 받아서 문자열 array를 반복한다. 
  - input : String 문자열 Array, 구분자
  - 문자열을 반복하여, 구분자와 문자열의 원소 하나를 splitString으로 넣어준다.
  - output : 
#### convertAndSumWithRemainder 
- 기능 
  - array를 받아서 반복한다. 
  - 숫자면 다 더해준다. 
  - 나머지는 Array에 넣어준다. 
  - input : split 후 return array 
  - output : 숫자와 array 


