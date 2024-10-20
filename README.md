# 문자열 덧셈 계산기
문자열을 입력하면 숫자를 추출하여 더하는 계산기입니다.

## 기능 요구 사항
- 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열이 입력된 경우, 구분자를 기준으로 분리한 숫자의 합을 반환합니다.
- 기본 구분자 외에 커스텀 구분자를 지정할 수 있습니다. 커스텀 구분자는 문자열 앞부분의 "//"와 "\n"의 사이에 위치하는 문자를 커스텀 구분자로 사용합니다.
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션이 종료됩니다.

### 입출력 요구 사항
- 입력: 구분자와 양수로 구성된 문자열 `1,2:3`
- 출력: 덧셈 결과 `결과 : 6`
- 예시
    ```
    덧셈할 문자열을 입력해 주세요.
    1,2:3
    결과 : 6
    ```

##  프로그래밍 요구 사항
- JDK 21 버전에서 실행 가능해야 한다.
- 프로그램 실행의 시작점은 `Application`의 `main()`이다.
- `build.gradle` 파일은 변경할 수 없으며, 제공된 라이브러리 이외의 외부 라이브러리는 사용하지 않는다.
- 프로그램 종료 시 `System.exit()`를 호출하지 않는다.
- 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 등의 이름을 바꾸거나 이동하지 않는다.
- 자바 코드 컨벤션을 지키면서 프로그래밍한다.
- 기본적으로 [Java Style Guide](https://github.com/woowacourse/woowacourse-docs/blob/main/styleguide/java)를 원칙으로 한다.

### 라이브러리
- `camp.nextstep.edu.missionutils`에서 제공하는 `Console API`를 사용하여 구현해야 한다.
    - 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.

## 기능 목록
- 사용자에게 문자열 입력을 요청하는 메시지를 출력하는 기능: `printUserInputMessage()`
- 사용자의 입력을 받는 기능: `getUserInput()`
- 문자열에서 숫자를 제거하는 기능: `removeNumber()`
- 문자열에서 구분자를 제거하는 기능: `removeSeparator()`
- 백슬래시를 이중 처리하는 기능: `formatBackslash()`
- 숫자와 기본 구분자로 구성된 문자열인지 판별하는 기능: `isStringWithDefaultSeparator()`
- 숫자와 커스텀 구분자로 구성된 문자열인지 판별하는 기능: `isStringWithCustomSeparator()`
- 커스텀 구분자를 추출하는 기능: `getCustomSeparator()`
- 커스텀 구분자 생성자를 제거하는 기능: `removeSeparatorInitializer()`
- 문자열에서 구분자를 기준으로 숫자를 나누어 덧셈하는 기능: `calculateSum`
- 구분자를 포멧하는 기능: `formatSeparator()`
- 덧셈 결과를 출력하는 기능: `printResult()`
- 계산기 전체 로직을 처리하는 기능: `calculate()`