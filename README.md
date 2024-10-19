# java-calculator-precourse

-----
# 기능 목록

----

## Calculate

----
### 구분자 : 쉼표(,) 또는 콜론(:)
- 구분자를 기준으로 분리한 각 숫자의 합을 반환
- 음수 값이 포함된 입력일 시 예외처리(IllegalArgumentException)

----
## [String Custom Seperation]
### 구분자 : 문자열 앞부분의 "//"와 "\n" 사이에 위치하는 문자
- 커스텀 구분자를 기준으로 분리한 각 숫자의 합을 반환
- 음수 값이 포함된 입력일 시 예외처리(IllegalArgumentException)

----
# 테스트 케이스

----
- "" : 0
- "-1,2,3" : IllegalArgumentException(음수 허용 x)
- "//;\n1" : 1
- "1,2,3" : 6
- "//-\n2-3-4" : 9

----

