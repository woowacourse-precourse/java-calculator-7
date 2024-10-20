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

#### checkForErrors ✅ 
- IllegalArgumentException 발생되는 case 생각해 보기.
  - 알파벳이 있을 때 - 기본 구분자 외 특수 구분자를 특수기호 중 하나로 지정하고, 알파벳은 오류 처리
  - 정규표현식으로 알파벳이 있는지 확인 python(re.sub[^a-zA-Z])

  - input : inputString, 구분자 array
  - 특수 구분자를 제외한 알파벳이 있다면, 에러를 발생시킨다. 
  - 추가 : 구분자를 제외한 모든 특수기호가 있으면 에러를 발생시킨다. (음수 기호'-'도 제외)
  - return : void


#### checkSpecialDelimiter ✅
- 기능
  - input : 입력 받은 문자열
  - 특수 구분자관련 문자열을 파악
  - output : Stirng "//(특수구분자)\n"

#### getDelimiter ✅
- 기능
  - input : 문자열
  - 기본적인 구분자(쉼표, 콜론)을 배열에 넣어준다.
  - checkSpecialDelimiter 에서 특수 구분자가 있는지 확인한다.
    - 있다면, 특수 구분자를 빼내기 위해 getSpecialDelimiter를 사용
  - output : 특수 구분자 or null

#### getSpecialDelimiter ✅
- 기능
  - input : Stirng "//(특수구분자)\n"
  - .substring을 활용해서 특수구분자만 빼낸다.
  - return : 특수 구분자.
  
#### changeInputStr ✅
- 기능
  - input : Stirng "//(특수구분자)\n" 와 입력 받은 문자열
  - return : 특수 구분자를 제외한 문자열


#### splitDelimiterAddNum ✅
- 더 빠르고 간단하지만, 구분자가 두개 일 땐 다른 방법을 사용해야함 
- 기능 
  - input : inputString 과 구분자 array
  - inputString에서 char을 하나씩 꺼내서 구분자 array에 들어가 있는지 없는지를 확인한다. 
    - 없다면 새로운 스트링에 담아두고 
    - 있다면 이전 스트링을 숫자로 변경 후 int형에 더해준다.
    - 이렇게 해도 남는다면 오류 발생 시켜야 함
  - return : 숫자를 다 더한 값 