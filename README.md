# 문자열 덧셈 계산기

## <span style='color: #2D3748;background-color: #f7ddbe'>📌프로젝트 구조</span>

```
\---calculator
    |   Application.java
    |   Calculator.java
    |
    +---constant
    |   |   ErrorStatus.java
    |   |
    |   \---message
    |           OutputMessage.java
    |
    +---controller
    |       CalculatorController.java
    |
    +---service
    |       CalculatorService.java
    |
    +---util
    |       Separator.java
    |
    \---view
            InputView.java
            OutputView.java
```

---

## <span style='color: #2D3748;background-color: #f1f8ff'>📌프로젝트 컨벤션</span>

- [x]  자바 코드 컨벤션을 지켰는가?
    - 인텔리제이 Code Style 적용
- [x]  JDK 21 버전을 사용하였는가?
- [x]  프로그램 실행 시작점이 `Application.main()` 인가?
- [x]  build.gradle을 변경하지 않고, 외부 라이브러리를 사용하지 않았는가?
- [x]  프로그램 종료 시 `System.exit()` 을 호출하지 않았는가?
- [x]  프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 등의 이름을 바꾸거나 이동하지 않았는가?
- [x]  `camp.nextstep.edu.missionutils`에서 제공하는`Console`API를 사용하여 구현하였는가?

## 기능

- [x]  `덧셈할 문자열을 입력해 주세요.` 메세지를 출력한다.


- [x]  문자열을 입력받는다.


- [x]  구분자를 통해 구분한다.
    - [x]  기본 구분자를 통해 구분할 수 있다. (`,` , `:` )
    - [x]  커스텀 구분자를 통해 구분할 수 있다.
    - [x]  기본/커스텀 구분자 외의 구분자가 들어올 경우 "지정되지 않은 구분자입니다."메세지를 출력하고 `IllegalArgumentException` 을 발생시켜 종료한다.


- [x]  구분된 문자에서 숫자를 추출한다.
    - [x]  숫자가 아니라면 `"계산기에서 처리 가능한 숫자 형식의 입력이 아닙니다."` 메세지를 출력하고 `IllegalArgumentException` 을 발생시킨다.
    - [x]  양수가 아닐 경우 "숫자가 양수가 아닙니다." 메세지를 출력하고 `IllegalArgumentException` 을 발생시킨다.
    - [x]  숫자의 범위에 대한 언급 X ⇒ `Long` 범위를 벗어날 경우, `"계산기에서 처리 가능한 숫자 형식의 입력이 아닙니다."` 메세지 제공하고 종료시킨다.


- [x]  구분 기능에 대한 테스트 코드를 작성한다.


- [x]  추출한 숫자들을 더한다.
    - [x]  숫자들의 합이 `Long` 범위를 벗어날 경우, `"계산기의 성능을 초과했습니다."` 메세지를 출력하고 `IllegalArgumentException`을 발생시킨다.


- [x] 계산값이 정확한지 테스트 코드를 작성한다.


- [x]  계산 결과에 따른 적절한 결과값을 출력한다.


- [x] 전체적인 계산기 프로그램을 완성한다.


- [x] `IllegalArgumentException`이 발생할 경우 애플리케이션을 종료시킨다.

## ## <span style='color: #2D3748;background-color: #ffdce0'>📌시스템 흐름</span>

![img.png](img.png)

## <span style='color: #2D3748;background-color: #ffdce0'>📌고민한 부분</span>

대부분 제가 고민한 부분들은 `이 부분을 과제에 적용하는 것이 맞을까?` 를 중점으로 생각했습니다!

### 싱글톤

컨테이너 객체를 생성해서 `Map<Class<?>, Object>` 와 같은 형식의 컨테이너를 사용하여 다음과 같이 사용하려 했습니다.

```java
Sample sample = container.get(Sample.class);
```

그런데 과제 규모에 굳이 불필요한 작업이라 생각해, `Bill Pugh` 방식으로 사용했습니다. 하지만 전체적으로 과제에 있어서 **‘`싱글톤`  자체가 필요한 작업일까?’**라는 의문이 생겼습니다! 다른 분들의
의견이 어떤지 궁금합니다.

### MVC

1주차 과제를 수행하는 데에 MVC 패턴을 적용하였습니다. 이 계획을 세우고 과제를 진행하다가 **‘과제에 MVC 패턴을 적용하는 작업이 필요할까?’**라는 고민이 들었습니다.

단순한 프로그램인데 억지로 MVC에 끼워맞추는 것처럼 느껴져 불필요하게 복잡하게 구현한 것은 아닌지 고민하게 되었습니다.

### 검증 로직의 위치

이번 과제에서 저희는 구분자를 통해 구분하고 연산을 수행해야 합니다. 간략하게 `정확한 구분자가 존재하는지`, `구분된 문자열이 숫자인지` 를 검증해야 합니다.

이 때 관련된 **검증 로직을 `Controller`에서 구현하는게 맞을지, `Service`에서 구현하는게 맞을지** 의문이 생겼습니다.

저는 `MVC 패턴` 을 기준으로 `Service` 는 숫자 리스트를 받는 이후에 로직을 담당하도록 하였습니다. `Service` 에서 최대한 비즈니스 로직을 수행하도록 고려하다보니,
`문자열에서 구분자를 통해 구분하는 로직`, `구분된 문자열을 숫자로 바꾸는 로직` 은 `Controller` 단에서 실행하도록 하였습니다.

다른 분들의 의견은 어떤지 궁금합니다!
