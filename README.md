# ➕문자열 덧셈 계산기

## 기능 요구 사항
입력한 문자열에서 숫자를 추출하여 더하는 계산기를 구현한다.
* 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환한다.
* 예: "" => 0, "1,2" => 3, "1,2,3" => 6, "1,2:3" => 6
* 앞의 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 "//"와 "\n" 사이에 위치하는 문자를 커스텀 구분자로 사용한다.
* 예를 들어 "//;\n1;2;3"과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
* 사용자가 잘못된 값을 입력할 경우?IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.
## 기능목록
1. **main 클래스에서 문자열 입력 받는 기능**:  
   - camp.nextstep.edu.missiononutils.Console의 readLine() 활용. 잘못된 값 입력 시 illegalArgumentException 발생 후 종료.
   
2. **문자열에 구분자 판별하는 클래스 만들기**:  
   - ,와 ; 구분자 판별 함수  
   - //와 \n 커스텀 구분자 판별하는 함수

3. **숫자 더하는 계산 클래스 만들기**:  
   - 판별한 정보를 받아와서 덧셈을 계산하는 함수

4. **main 클래스에서 결과 출력하기**
## 입출력 요구사항
### 입력  
- 구분자와 양수로 구성된 문자열  
### 출력  
- 덧셈 결과  
결과 : 6  
### 실행 결과 예시  
  덧셈할 문자열을 입력해 주세요.  
  1,2:3  
  결과 : 6
## 프로그래밍 요구사항
* JDK 21 버전에서 실행 가능해야 한다.
* 프로그램 실행의 시작점은 Application의 main()이다.
* build.gradle파일은 변경할 수 없으며,제공된 라이브러리 이외의 외부 라이브러리는 사용하지 않는다.
* 프로그램 종료 시 System.exit()를 호출하지 않는다.
* 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 등의 이름을 바꾸거나 이동하지 않는다.
* 자바 코드 컨벤션을 지키면서 프로그래밍한다.
* 기본적으로 Java Style Guide를 원칙으로 한다.
###라이브러리
* camp.nextstep.edu.missionutils에서 제공하는 Console API를 사용하여 구현해야 한다.
* 사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.

