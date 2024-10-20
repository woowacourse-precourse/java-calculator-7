# java-calculator-precourse

# 기능 구현 목록

* * *

## 문자열 입력

**Console.readline()으로 사용자에게 입력을 받는다.**

## 문자열 검사

**문자열이 유효한 문자열인지 검사한다. 유효하지 않다면 IllegalArgumentException 처리한다.**

+ 커스텀 구분자가 있는 문자열인지 아닌지 검사
    + Boolean hasCustomSeparator(String)
+ 커스텀 구분자가 유효한지 검사
    + Boolean isValidSeparator(Character)
+ 구분자로 등록되어있지 않은 것을 사용중인지 검사
    + Boolean isRegisteredSeparator(Character)

## 문자열 파싱

**유효한 문자열에 대해서 구분자를 기준으로 나누어진 숫자들을 파싱하여 리스트로 반환한다**

+ 커스텀 구분자 유무에 따른 시작 위치 판단
    + Integer getStartIndex(Boolean)
+ StringBuilder를 사용해 숫자들을 파싱
    + List<> parsingString(String)

## 계산기

**파싱한 숫자 리스트를 계산하여 결과를 도출해준다**

+ List내 모든 값을 더해 반환해줌
    + Integer addList(List<>)
