# java-calculator-precourse


# 기능 목록



## Calculate


### 구분자 : 쉼표(,) 또는 콜론(:)
- 구분자를 기준으로 분리한 각 숫자의 합을 반환

**possible error**
- IllegalArgumentException
  - 구분자를 기준으로 분리 후 숫자 이외의 값이 발견되었을 경우 (NumberFormatException)
  - 숫자의 값이 음수일 경우


### 구분자 : 문자열 앞부분의 "//"와 "\n" 사이에 위치하는 문자
- 커스텀 구분자를 기준으로 분리한 각 숫자의 합을 반환
- "//"와 "\n" 사이에는 커스텀 구분자 한 글자만이 올 수 있다고 가정
- 커스텀 구분자를 사용할 때는 기존 구분자 쉼표(,)와 콜론(:)은 적용되지 않음

**possible error**
- IllegalArgumentException
  - 커스텀 구분자를 사용할 수 있는 입력의 형식이 아닐 경우
  - 구분자를 기준으로 분리 후 숫자 이외의 값이 발견되었을 경우 (NumberFormatException)
  - 숫자의 값이 음수일 경우



# 테스트 케이스


- "" : 0
- "1" : 1
- "-1,2,3" : IllegalArgumentException(음수 허용 x)
- "//;\\n1" : 1
- "1,2,3" : 6
- "//-\\n2-3-4" : 9



