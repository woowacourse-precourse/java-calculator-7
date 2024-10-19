# **java-calculator-precourse**

## **💪 사전 작업**

- [X]  : 미션을 fork하고 local에 clone을 합니다.
- [X]  : clone한 Repository에 이름으로 된 branch를 생성하여 미션을 수행합니다.
- [X]  : 우테코 코드 스타일을 Intellij에 자동 적용합니다.
    - https://github.com/woowacourse/woowacourse-docs/blob/main/styleguide/java/intellij-java-wooteco-style.xml 에서 해당
      파일을
      다운합니다.
    - IntelliJ에서 Settings -> Editer -> Code Style -> Java 순으로 들어갑니다
    - 우측 설정을 누르고 Import Scheme -> IntelliJ IDEA code style XML를 import합니다.
    - Code Style 의 Enable EditorConfig support를 체크하면 적용됩니다.
    - Tools -> Action on Save의 Reformat code와 Optimize imports 체크박스를 체크하고 적용합니다.
    - 끝!!!
- [X]  : Angular JS Git Commit Message Conventions을 숙지하고 이를 미션에 적용해봅니다.

---

## **👊 미션 개요 및 마인드 Set**

### 미션 개요

- 이 미션은 문자열을 입력받아 계산하여 숫자를 추출하고, 그 합을 계산하는 덧셈 계산기를 구현하는 것입니다.
- Java의 기본 기능과 camp.nextstep.edu.missionutils 라이브러리를 활용하여, 사용자 입력을 받고 계산 결과를 출력합니다.
- 1주차 미션의 주요 목표는 실제 개발 환경에서의 Java와 Git 사용을 익히고, 기능 목록 작성과 단위 테스트 등의 기초 개발 절차를 경험하는 것이라고 생각합니다.
- 주어진 요구사항을 기능별로 잘 분리하고, 예외사항을 고려해야 합니다.
- 특히, 커스텀 구분자와 관련된 예외 처리가 중요할 것이라고 생각합니다.

### 마인드 Set

- 1주차 미션인만큼 패키지 구조를 **MVC 패턴**을 기반으로 하여 설계를 구성하게 한 뒤, **점차 디벨롭** 시켜나갈 예정입니다.
- 요구사항에 명시되어 있지는 않지만 그 밖에 여러 세밀한 예외 케이스들을 생각하는 것도 중요하다고 생각합니다.
- 간단한 프로그램(미션)일지라도 **Test 코드의 필요성**을 인지하고자 합니다.
- 여러가지 사항들을 고려하고 설계를 하는데 많은 고민이 필요하겠지만, **사전작업에 너무 많은 시간을 투자 하지 않습니다.**
    - 최소한의 고민과 설계를 통해 **1차 구현을 우선**시 합니다.
    - 프로그램을 한번에 완벽하게 짜는 것을 불가능하기 때문에, 1차 구현 후 지속적으로 리팩토링 해나가고자 합니다.

---

## 📞 기능 요구사항

> **입력한 문자열에서 숫자를 추출하여 더하는 계산기를 구현합니다.**
>

- 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환합니다.
    - 예: "" => 0, "1,2" => 3, "1,2,3" => 6, "1,2:3" => 6
- 앞의 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있습니다. 커스텀 구분자는 문자열 앞부분의 "//"와 "\n" 사이에 위치하는 문자를 커스텀 구분자로 사용하기로 약속합니다.
    - 예를 들어 "//;\n1;2;3" 과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 합니다.
- 사용자가 잘못된 값을 입력할 경우[Error] 로 시작하는 Messaege와 함께 Error를 터트린 후, 애플리케이션을 종료하게 합니다.

### 입출력 요구 사항

| **입력**           | **출력** |
|------------------|--------|
| 구분자와 양수로 구성된 문자열 | 덧셈한 결과 |

### **실행 결과 예시**

```
덧셈할 문자열을 입력해 주세요.
1,2:3
결과 : 6
```

---

## **💻 프로그래밍 요구사항**

- JDK 21 버전에서 실행 가능해야 합니다.
- 프로그램 실행의 시작점은 Application의 main()입니다.
- build.gradle 파일은 변경할 수 없으며, 제공된 라이브러리 이외의 외부 라이브러리는 사용하지 않습니다.
- 프로그램 종료 시 System.exit()를 호출하지 않습니다.
- 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 등의 이름을 바꾸거나 이동하지 않습니다.
- 자바 코드 컨벤션을 지키면서 프로그래밍합니다.
    - 기본적으로 Java Style Guide를 원칙으로 합니다.
- camp.nextstep.edu.missionutils에서 제공하는 Console API를 사용하여 구현해야 합니다.
    - 사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용합니다.

## **📝 구현해야할 기능 목록 & 고려해야할 예외 사항**

### 1. 문자열 입력 처리

- [X]  **1-1 입력받기:** 유저로부터 문자열을 입력받습니다.
    - [X]  **예외 처리:** 입력이 빈 문자열이 아닌 실제 null일 경우 `IllegalArgumentException`을 발생시킵니다.
- [X]  **1-2 입력 검증:** 입력된 문자열이 빈 문자열(`""`)인지 확인하고, 빈 문자열인 경우 0을 반환합니다.
    - [X]  **예외 처리:** 빈 문자열 외에 공백 문자열(`" "`)이 들어오는 경우에도 0을 반환합니다.

### 2. 기본 구분자 구분 및 숫자 추출

- [X]  **2-1 구분자 설정:** 기본 구분자인 쉼표(`,`)와 콜론(`:`)을 기준으로 문자열을 분리할 수 있도록 설정합니다.
- [X]  **2-2 기본 구분자 분리:** 쉼표와 콜론을 기준으로 입력 문자열을 숫자로 분리합니다.
    - [X]  **예외 처리:** 구분자 사이에 숫자가 없는 경우(예: `"1,,2"`, `"1::2"`)는 `IllegalArgumentException`을 발생시킵니다.
    - [X]  **예외 처리:** 구분자 뒤에 숫자 없이 끝나는 경우(예: `"1,2,"`) 예외로 처리합니다.
    - [X]  **추가 고려 사항:** 기본 구분자(쉼표, 콜론)와 커스텀 구분자가 함께 포함된 경우(예: `"//;\n//s\n1;2s3,4:5"`), 두 구분자가 모두 정상 동작하도록 처리합니다.

### 3. 커스텀 구분자 처리

- [X]  **3-1 커스텀 구분자 확인:** 문자열에 커스텀 구분자가 포함되어 있는지 확인한다. 커스텀 구분자는 `"//"`로 시작하여 `"\n"`이 나오기 전까지의 부분에 위치합니다.
    - [X]  **예외 처리:** 커스텀 구분자가 형식에 맞지 않을 경우(예: `"//1;"`) `IllegalArgumentException`을 발생시킵니다.
    - [X]  **예외 처리:** 커스텀 구분자가 숫자나 특수문자가 아닌 경우 예외로 처리합니다.
    - [X]  **추가 고려 사항:** 커스텀 구분자를 선언했지만 사용하지 않는 경우(예: `"//;;\n1,2"`) 정상 동작하도록 합니다.
- [X]  **3-2 커스텀 구분자 분리:** 커스텀 구분자가 존재할 경우 해당 구분자를 사용해 문자열을 분리합니다.
    - [X]  **예외 처리:** 커스텀 구분자가 숫자 형식인 경우(예: `"//1\n112"`) 숫자와 커스텀 구분자가 혼동되지 않도록 예외로 처리합니다.
    - [X]  **추가 고려 사항:** 커스텀 구분자 형식이 맞으나 사이에 구분자가 없는 경우(예: `"//\n12"`) 즉, 커스텀 구분자가 빈 문자열인 경우는 예외로 처리합니다.

### 4. 숫자 변환 및 합산

- [ ]  **4-1 숫자 변환:** 분리된 문자열 조각들을 숫자로 변환합니다.
    - [ ]  **예외 처리:** 숫자 형식이 아닌 문자가 포함된 경우(예: `"1,a,3"`) `IllegalArgumentException`을 발생시킵니다.
- [ ]  **4-2 양수 검증:** 숫자가 양수가 아닌 음수인 경우 `IllegalArgumentException`을 발생시킵니다.
- [ ]  **4-3 합산 계산:** 모든 숫자의 합을 계산합니다.

### 5. 예외 처리

- [ ]  **5-1 애플리케이션 종료:** 예외가 발생하면 애플리케이션이 종료되게 합니다.
    - [ ]  **예외 처리:** 예외 발생 시 오류 메시지를 출력하고 애플리케이션을 종료합니다.

### 6. 결과 출력

- [X]  **6-1 결과 출력:** 최종 계산 결과를 출력합니다.
    - [X]  **예외 처리:** 출력 형식이 요구사항과 일치하는지 검토합니다 → `결과 : 숫자`

---

## **📌 Commit Message Format**

```
<type>(scope): <subject> - Subject line
<BLANK LINE>               - 줄 바꿈으로 구분한다.
<body>                     - Message body
```

- **Subject line**
    - 변경 사항에 대한 간단한 설명을 한다.
    - 70자를 넘기지 않도록 한다.
- **Message body**
    - 수정 이유와 전후 비교 설명을 한다.
    - 명령형 현재 시제로 작성한다.
    - 70자를 넘기면 줄바꿈한다.
