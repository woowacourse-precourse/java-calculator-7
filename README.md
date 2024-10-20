# java-calculator-precourse


## 미션하면서 주의할 점 
- README.md에 기능 미리 적어두고 그걸 기준으로 커밋 남기기
- PR을 만들고, 과제를 수행하면서 느낀 점, 배운 점, 많은 시간을 투자한 부분 등 자유롭게 작성한다.
- 기능을 올바르게 구현했더라도 요구 사항에 명시된 출력 형식을 따르지 않으면 0점을 받게 된다.
- 터미널에서 java -version을 실행하여 Java 버전이 21인지 확인한다.
- Windows 사용자의 경우 gradlew.bat clean test 또는 .\gradlew.bat clean test 명령을 실행할 때 모든 테스트가 아래와 같이 통과하는지 확인한다.
BUILD SUCCESSFUL in 0s

- AngularJS Git Commit Message Conventions (https://gist.github.com/stephenparish/9941e89d80e2bc58a153) 을 참고해 커밋 메시지를 작성한다.
- 자바 코드 컨벤션을 지키면서 프로그래밍한다 : 기본적으로 Java Style Guide를 원칙으로 한다.
- 라이브러리 camp.nextstep.edu.missionutils에서 제공하는 Console API를 사용하여 구현해야 한다.
  - 사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.
  - 프로그램 종료 시 System.exit()를 호출하지 않는다.


## 기능 목록 
1) 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환하는 기능 구현<br>
2) 커스텀 구분자(문자열 앞부분의 "//"와 "\n" 사이에 위치하는 문자)로 숫자의 합 반환하는 기능 구현 <br>
3) 사용자가 잘못된 값을 입력할 경우 예외처리
  - 음수를 입력한 경우 : IllegalArgumentException
  - 아무것도 입력하지 않은 경우 : StringIndexOutOfBoundsException 처리 후 결과값 0으로 반환 

