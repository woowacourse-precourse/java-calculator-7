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
- Solution 
  - 문자열을 받아 아무것도 없으면 0을 바로 return 한다.  
  - 문자열을 받아서 에러를 확인한다. - checkForErrors()
  - 문자열에서 특수 구분자를 찾아 array에 추가한다. - addSeparator() 
  - 문자열과 구분자 array를 넘겨준 후 return으로 숫자 배열을 받는다.
  - 숫자 배열을 더해주고 결과를 낸다.

- extractNumbers
  - 문자열과 구분자 배열을 받아 구분자를 반복하여 숫자들을 반환 받는다. - splitString
  - 더 상세하게 만들어야함. 1차
  - 숫자들로만 이루어진 배열을 받아 더해준다. - addNumArray() - python은 sum(list) 함수가 있는데 찾아보자.
    - input 문자열, 구분자 array
    - return 숫자 

- splitString (가제)
  - 문자열과 구분자 하나를 받아 구분자로 문자열을 나누는 기능을 하는 함수 
    - input : String 문자열, String 구분자
    - return : 문자열.split(구분자)

- checkForErrors
  - IllegalArgumentException 발생 시키기 
    - 에러 발생 상황 
      - 알파벳이 있을 때 - 기본 구분자 외 특수 구분자를 특수기호 중 하나로 지정하고, 알파벳은 오류 처리
      - 정규표현식으로 알파벳이 있는지 확인 python(re.sub[^a-zA-Z])
      
    - 에러 발생 시키는 코드
      - throw new IllegalArgumentException
    - input : 문자열 
    - return : 문자열 or Error 발생 

- addSeparator
  - getSpecialSeparator 에 값을 넣고 특수 구분자가 있다면 array에 넣고 return 하거나, 없으면 바로 return 
  - input : 문자열, 구분자 array 
  - output : 문자열, 구분자 array
  
- getSpecialSeparator
  - 특수 구분자를 찾아내는 함수 
    - input : 문자열 
    - return : 특수 구분자 or false 

