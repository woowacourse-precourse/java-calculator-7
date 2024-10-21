🖩문자열 덧셈 계산기
============

ℹ️ 과제 진행 요구사항
--------
***

* 미션은 [문자열 덧셈 계산기 저장소](https://github.com/woowacourse-precourse/java-calculator-7)를 포크하고 클론하는 것으로 시작한다.
* 기능을 구현하기 전 `README.md`에 구현할 기능 목록을 정리해 추가한다.
* Git의 커밋 단위는 앞 단계에서 `README.md`에 정리한 기능 목록 단위로 추가한다.
    * [AngularJS Git Commit Message Conventions](https://gist.github.com/stephenparish/9941e89d80e2bc58a153)을 참고해 커밋
      메시지를 작성한다.
* 자세한 과제 진행 방법은 [프리코스 진행 가이드 문서](https://github.com/woowacourse/woowacourse-docs/tree/main/precourse)를 참고한다.

📍 기능 요구 사항
-----------
***
입력한 문자열에서 숫자를 추출하여 더하는 계산기를 구현한다.

* 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환한다.
    * 예: "" => 0, "1,2" => 3, "1,2,3" => 6, "1,2:3" => 6
* 앞의 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 "//"와 "\n" 사이에 위치하는 문자를 커스텀 구분자로 사용한다.
    * 예를 들어 "//;\n1;2;3"과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
* 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.

## 입출력 요구 사항

### 입력

* 구분자와 양수로 구성된 문자열

### 출력

* 덧셈 결과

```
    결과 : 6
```

### 실행 결과 예시

```
    덧셈할 문자열을 입력해 주세요.
    1,2:3
    결과 : 6
```

💻 프로그래밍 요구 사항
-------
***

* JDK 21 버전에서 실행 가능해야 한다.
* 프로그램 실행의 시작점은 `Application`의 `main()`이다.
* `build.gradle` 파일은 변경할 수 없으며, **제공된 라이브러리 이외의 외부 라이브러리는 사용하지 않는다.**
* 프로그램 종료 시 `System.exit()`를 호출하지 않는다.
* 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 등의 이름을 바꾸거나 이동하지 않는다.
* 자바 코드 컨벤션을 지키면서 프로그래밍한다.
    * 기본적으로 [Java Style Guide](https://github.com/woowacourse/woowacourse-docs/tree/main/styleguide/java)를 원칙으로 한다.

### 라이브러리

* `camp.nextstep.edu.missionutils`에서 제공하는 `Console` API를 사용하여 구현해야 한다.
    * 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.

기능 목록 체크리스트
====================
***

> 📍 **기능 목록**

### ☀️ 입력 기능

* `camp.nextstep.edu.missionutils`에서 제공하는 `Console` API를 사용
* 덧셈할 문자열을 입력해 주세요. 아래에 문자열 입력

### ✨ 커스텀 구분자 판별 기능 getCustomSeparator()

* 커스텀 구분자는 "\\"와 "\n" 사이에 위치하는 문자이다.

### ✨ 입력값 검증 기능 currectString()

* 기본 구분자 쉼표(,) 또는 콜론(:)이 아닌 문자가 있다면 예외 발생
    * IllegalArgumentException
* 커스텀 구분자가 있다면 기본 혹은 커스텀 구분자가 아닌 문자가 있다면 예외 발생
    * IllegalArgumentException

### ✨ 숫자 추출 기능 extractNumbers()

* 기본 구분자 쉼표(,) 또는 콜론(:)과 커스텀 구분자를 제외한 숫자 추출

### ✨ 숫자 더하기 기능 addNumbers()

* 추출된 모든 숫자를 더하는 기능

### 💭 출력 기능

* 결과 : 6 의 예시처럼 결과 출력
* 결과 출력 후 종료

###

> 📍 **예외처리 목록**

### ❗️ 잘못된 입력

* 입력시 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException` 발생 후 종료

###

> 📍 **제약사항**

* 열 제한: 120