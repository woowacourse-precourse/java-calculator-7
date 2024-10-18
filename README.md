# java-calculator-precourse

## ✅ 과제 요구 사항 점검

- [x] 미션은 문자열 덧셈 계산기 저장소를 포크하고 클론했는가
- [x] 기능을 구현하기 전 README.md에 구현할 기능 목록을 정리했는가
- [x] Git의 커밋 단위는 앞 단계에서 README.md에 정리한 기능 목록 단위로 추가했는가
- [x] AngularJS Git Commit Message Conventions을 참고해 커밋 메시지를 작성했는가

## ✅ 기능 요구 사항 점검

- [x] 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환하는가
- [x] 앞의 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 "//"와 "\n" 사이에 위치하는 문자를 커스텀 구분자로 사용하는가
- [x] 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션이 종료되는가

## ✅ 구현할 기능 목록

**1. 시작**
- [x] 사용자 입력 메서드 - getUserInput()

**2. 입력 값 가공**
- [x] Default 구분자 기준 분리 메서드 - splitWithDefaultSeparator()
  - [x] 쉼표(,)와 콜론(:)을 기준으로 분리되는가
- [x] Custom 구분자 기준 분리 메서드 - splitWithCustomSeparator()
  - [x] “//“와 “\n” 사이에 입력된 문자를 기준으로 분리되는가

**3. 입력 값 검증**
- [x] 빈 입력 값 검증 메서드 - checkIsInputEmpty()
- [x] 양수 검증 메서드 - checkIsPositiveNumber()
- [x] 숫자 형식 검증 메서드 - checkHasNumberFormat()

**4. 결과 반환**
- [x] 숫자의 총 합을 구하는 메서드 - getTotal()
- [x] 결과를 출력하는 메서드 - printResult()

**5. 예외 처리**
- [x] IllegalArgumentException 예외 처리

## ✅ 입출력 요구 사항 점검

- [x] 입럭: 구분자와 양수로 구성된 문자열인가
- [x] 출력: 문자열에서 구분자 기준 숫자만을 추출한 총 합 결과가 도출되는가
```text
결과 : 6
```
- [x] 전체적인 실행 결과가 아래와 일치하는가
```text
덧셈할 문자열을 입력해 주세요.
1,2:3
결과 : 6
```

## ✅ 프로그래밍 요구 사항 점검

- [x] JDK 21 버전에서 실행 가능한가
- [x] 프로그램 실행의 시작점은 Application의 main()인가
- [x] build.gradle 파일은 변경하지 않고, 제공된 라이브러리 이외의 외부 라이브러리는 사용하지 않았는가
- [x] 프로그램 종료 시 System.exit()를 호출하지 않는가
- [x] 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 등의 이름을 바꾸거나 이동하지 않았는가
- [ ] 자바 코드 컨벤션을 지키면서 프로그래밍 했는가
- [ ] 기본적으로 Java Style Guide를 원칙으로 했는가
- [x] camp.nextstep.edu.missionutils에서 제공하는 Console API를 사용하여 구현했는가
- [x] 사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용했는가