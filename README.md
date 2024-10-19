# java-calculator-precourse

## - 학습 목표
- Git, Github, IDE 등 실제 개발 환경에 익숙해지기  
- 교육분야에 맞는 프로그래밍 언어를 사용하여 문제해결하기  
- TDD로 개발하기

## - 기능 요구사항  
**기능 핵심 : 입력한 문자열에서 구분자로 구분된 숫자를 추출하여 더하는 계산기**  
- [] 문자열을 입력받는다.
- [x] 두 구분자 ",", ":"는 기본 구분자로 사용한다.
- [] "//"와 "\n" 사이에 위치하는 문자는 커스텀 구분자로 사용한다.
- [] 기본 구분자와 커스텀 구분자로 구분된 각 숫자를 더한다.
- [] 잘못된 입력을 할 경우 IllegalArgumentException 을 발생시킨 후 애플리케이션 종료한다.
    - [] 기본 구분자와 커스텀 구분자가 아닌 문자를 입력한 경우
    - [] 0 이하의 숫자를 입력한 경우
    - [] 범위 밖의 숫자를 입력한 경우

## - 입출력 요구사항
- [] 입력 : 구분자와 양수로 구성된 문자열 (예: "//!\n1,2:3!4")
- [] 출력 : 덧셈 결과 (예 : "결과 : 10")

## - 프로그래밍 요구사항
- [] JDK 21 버전에서 실행 가능해야한다.
- [] 프로그램 실행의 시작점은 Application의 main() 이다.
- [] 제공된 라이브러리 이외의 외부 라이브러리는 사용하지 않는다.
- [] 프로그램 종료시 System.exit()를 호출하지 않는다.
- [] 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 등의 이름을 바꾸거나 이동하지 않는다.
- [] 자바 코드 컨벤션을 준수한다. (Java Style Guide를 원칙으로 한다.)
- [] 사용자 입력은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.