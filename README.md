# 프리코스 1주차 - 문자열 덧셈 계산기

## 기능 요구사항
### 입력한 문자열에서 숫자를 추출하여 더하는 계산기를 구현한다.
- 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환한다.
  - 예: "" => 0, "1,2" => 3, "1,2,3" => 6, "1,2:3" => 6
- 앞의 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 "//"와 "\n" 사이에 위치하는 문자를 커스텀 구분자로 사용한다.
  - 예를 들어 "//;\n1;2;3"과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.

## 구현해야 할 기능 목록
- 문자열 입력 처리   
   - [ ] 사용자로부터 문자열을 입력받는다. 
   - [ ] 입력된 문자열은 기본 구분자(쉼표 ,와 콜론 :)를 기준으로 분리한다.
     
- 숫자 추출 및 합산   
   - [ ] 입력된 문자열에서 숫자를 추출한다.
   - [ ] 추출된 숫자의 합을 계산하여 반환한다.

- 커스텀 구분자 지원   
   - [ ] 문자열 앞 부분의 "//"와 "\n" 사이에 위치한 문자를 커스텀 구분자로 사용한다.
   - [ ] 해당 커스텀 구분자를 사용하여 문자열을 분리한다.

- 예외 처리   
   - [ ] 잘못된 입력(구분자와 양수가 아닌 값)이 들어올 경우 IllegalArgumentException을 발생시킨다.
   - [ ] 예외 발생 시 프로그램은 종료된다.

- 결과 출력   
   - [ ] 계산된 결과를 사용자에게 출력한다.

## 주의해야 할 점
- camp.nextstep.edu.missionutils.Console의 readLine() 메소드를 사용하여 입력을 받는다.
- System.exit()를 호출하지 않도록 주의한다.
- 자바 코드 컨벤션을 지키면서 프로그래밍한다.
- JDK 21에서 실행 가능해야 한다. 
- build.gradle 파일은 변경할 수 없으며, 제공된 라이브러리 이외의 외부 라이브러리는 사용하지 않는다.
- 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 등의 이름을 바꾸거나 이동하지 않는다.