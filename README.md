# java-calculator-precourse


# **구현 기능 목록**

## [] 기능 1: 입력받은 문자열에서 숫자 추출 및 합산
- 사용자가 입력한 문자열에서 쉼표(,) 또는 콜론(:)을 기준으로 숫자를 분리하여 합산한다.
  (`getSumOfNumbers` 함수로 입력받은 문자열을 처리한다.)
  - 입력이 빈 문자열일 경우 0을 반환한다.
  - 구분자를 기준으로 분리된 각 숫자를 추출하고 합산한다.
  - 사용자가 잘못된 값을 입력한 경우 `IllegalArgumentException`을 발생시키고 애플리케이션은 종료된다.
  (`validateInput` 함수로 입력받은 문자열을 검증한다.)

## [] 기능 2: 커스텀 구분자 지원
- 기본 구분자(쉼표, 콜론) 외에 사용자가 커스텀 구분자를 설정할 수 있다.
  - 커스텀 구분자는 "//"와 "\n" 사이에 위치하는 문자를 의미한다.
  - 커스텀 구분자가 있는 경우, 해당 구분자로 문자열을 분리하여 숫자를 추출하고 합산한다.
    - 예: `//;\n1;2;3`의 경우, 세미콜론(;)을 구분자로 사용하며 결과 값은 6이 된다.
  (`extractCustomDelimiter` 함수로 커스텀 구분자를 추출한다.)
  (`splitInputByDelimiter` 함수로 입력을 분리한다.)

## [] 기능 3: 잘못된 입력 처리
- 사용자가 잘못된 값을 입력한 경우, 예외를 발생시키고 애플리케이션은 종료된다.
  - 예: 음수 입력, 숫자가 아닌 문자 포함 등
  (`validateInput` 함수에서 입력 검증 후 `IllegalArgumentException`을 발생시킨다.)
  (`ErrorMessage` 클래스로 custom error 메시지를 관리한다.)


## [] Test: 테스트 케이스 작성 및 실행


# **개선할 사항**
- 고정된 값(구분자 등)은 상수로 관리하여 유지보수를 용이하게 한다.
- 예외 처리 시 명확한 예외 메시지를 설정하여 가독성을 높인다.
- 함수명 및 변수명은 기능을 명확히 드러내도록 작성한다.

# **과제 진행 요구 사항**


### [] Commit Convention
- Git의 커밋 단위는 앞 단계에서 README.md에 정리한 기능 목록 단위로 추가한다.
- [AngularJS Git Commit Message Conventions](https://gist.github.com/stephenparish/9941e89d80e2bc58a153)을 참고해 커밋 메시지를 작성한다.


# **프로그래밍 요구 사항**

### [✅] JDK 21 버전에서 실행 가능해야 한다.
### [✅]  build.gradle 파일은 변경할 수 없으며, 제공된 라이브러리 이외의 외부 라이브러리는 사용하지 않는다.
### [] 자바 코드 컨벤션을 지키면서 프로그래밍한다.
### [] 기본적으로 Java Style Guide를 원칙으로 한다.

## []  라이브러리
- camp.nextstep.edu.missionutils에서 제공하는 Console API를 사용하여 구현해야 한다.
- 사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.

