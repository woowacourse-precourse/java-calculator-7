# java-calculator-precourse
 - - -
### 기능 요구 사항

- sumString
    - 문자열을 전달받고 구분자를 기준으로 분리한 각 숫자의 합을 반환하는 기능
    - 기본 구분자로 으로 쉼표(,) 또는 콜론(;)을 가짐
    - "//"와 "\n"을 통한 커스텀 구분자 지정 기능
    - 사용자가 잘못된 값을 입력하는 경우 IllegalArgumentException을 발생시킨 후 종료하는 기능

 - - -

### 프로그래밍 요구 사항

- 프로그램 실행의 시작점은 Application의 main() 이어야 함
- build.gradle 파일 변경 불가, 제공된 라이브러리 이외의 외부 라이브러리 사용 불가
- 프로그램 종료 시 System.exit() 를 호출하지 않음
- 파일이나 패키지 등의 이름을 바꾸거나 이동하지 않음

 - - -

### 라이브러리

- camp.nextstep.edu.missionutils에서 제공하는 Console API를 사용하여 구현해야 함
    - 사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine() 을 활용 