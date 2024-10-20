# 프리코스 1주차 - 문자열 계산기

---
## 기능 요구 사항
- 쉼표(,) 또는 콜론(:)을 기본 구분자로 가짐
- 기본 구분자 외에 커스텀 구분자를 지정할 수 있음
  - 예: 
    - "" => 0 
    - "1,2" => 3 
    - "1,2,3" => 6 
    - "1,2:3" => 6
  - "//" 와 "\n" 사이에 위치하는 문자를 커스텀 구분자로 사용
    - "//;\n1;2;3" => 6
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킴
  - 음수
  - 숫자가 아닐 때
  - 기본 구분자가 아닌 경우

## 프로그래밍 요구 사항
- JDK 버전 : JDK 21 이상에서 실행
- 프로그램 실행 시작점 : 'Application'의 'main()'이다.
- 프로그램 종료 시 System.exit()를 호출하지 않음

## 라이브러리
- camp.nextstep.edumissionutils에서 제공하는 Console Api를 사용해야 한다.
  - 사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()를 활용한다.

