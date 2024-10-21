# java-calculator-precourse
## 🏁 미션 개요

사용자가 입력한 문자열에서 해당하는 구분자로 숫자를 추출한 후, 숫자들의 합을 구하는 계산기를 구현합니다.

 단, 구분자는 쉼표(,) 또는 콜론(:)을 가지는 **기본 구본자**와 앞의 기본 구분자(쉼표, 콜론) 외에 **커스텀 구분자**를 지정할 수 있습니다.

## ☑️ 구현 기능 목록

### 문자열 입력받는 기능

- **입력 방법:** camp.nextstep.edu.missionutils.Console의 **readLine()**으로 받습니다.
- **예시: “**덧셈할 문자열을 입력해 주세요.”

### 결과 출력 기능

- **출력 형식**: 계산된 덧셈 결과를 출력합니다.
- **예시**: “결과 : 6”

### 입력 문자열 유효성 검사

- 정규식을 활용하여 입력 문자열의 유효성을 확인합니다.
    
    > 예를 들어, 입력값이 공백 문자열, null, 음수, 잘못된 구분자가 포함된 경우에는 **IllegalArgumentException**을 발생시킨 후 애플리케이션을 종료해야 합니다.
    > 

### 문자열을 구분자로 분리하는 기능

정규식을 활용하여 입력된 문자열을 분석하여, **적절한 구분자**를 사용해 숫자를 분리하고, 문자열 배열로 반환합니다.

- **기본 구분자**: **쉼표(,)**와 **콜론(:)**을 기준으로 숫자를 분리합니다.
- **커스텀 구분자:** "**//커스텀구분자\n**" 형식의 문자열에서 커스텀 구분자를 추출하고, 이를 기준으로 숫자를 분리합니다.

### 숫자 합산 기능

- 추출된 숫자들을 모두 더하는 기능을 구현합니다.

### **프로그래밍 요구 사항**

- JDK 21 버전에서 실행 가능해야 한다.
- 프로그램 실행의 시작점은 **Application의 main()**이다.
- **build.gradle** 파일은 변경할 수 없으며, **제공된 라이브러리 이외의 외부 라이브러리는 사용하지 않는다.**
- 프로그램 종료 시 **System.exit()**를 호출하지 않는다.
- 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 등의 이름을 바꾸거나 이동하지 않는다.
- 자바 코드 컨벤션을 지키면서 프로그래밍한다.
    - 기본적으로 [Java Style Guide](https://github.com/woowacourse/woowacourse-docs/blob/main/styleguide/java)를 원칙으로 한다.

### **라이브러리**

- **camp.nextstep.edu.missionutils**에서 제공하는 **Console** API를 사용하여 구현해야 한다.
    - 사용자가 입력하는 값은 **camp.nextstep.edu.missionutils.Console**의 **readLine()**을 활용한다.

## 패키지 목록

## Calculator

### controller

- CalculatorController : 사용자 입력을 처리 및 계산 로직과 뷰를 연결

### model

- Calculator: 계산 메서드 인터페이스
- CalculatorImpl: 파싱된 숫자 배열 합산
- DelimiterParser : 입력 문자열 해당 하는 구분자로 파싱하여 숫자 추출
- Validator : 입력값 유효성 검사

### view

- InputView : 입력 요청 및 저장
- ResultView: 결과 출력

**Application :** 메인 코드로서 모든 로직 빌드