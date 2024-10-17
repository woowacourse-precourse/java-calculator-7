# 구현할 기능 목록

## 🧮 미션 - 문자열 덧셈 계산기

## 💡 핵심 기능

### What

- 입력된 문자열에서 지정된 구분자를 사용하여 숫자를 추출하고 합산하는 계산기 기능을 제공하는 것

### How

- 기본 구분자(쉼표 ,와 콜론 :)뿐만 아니라 커스텀 구분자를 지원하여 다양한 구분자를 처리하도록 구현
- 사용자의 입력 패턴과 행동을 예측하여, 잘못된 입력에 대해 명확하게 대응하고, 정확한 예외 처리를 하도록 구현

### Why

- 사용자가 원하는 형식으로 손쉽게 숫자를 입력하고 결과를 얻을 수 있도록 하여 사용자의 편의성을 높이기 위해서
- 기본 구분자 외에 커스텀 구분자를 지원하여, 사용자에게 자신만의 방식으로 숫자를 입력하고 계산할 수 있는 자유도를 제공하기 위해서
- 사용자 입력 패턴 분석 및 예외 처리를 통해 입력 오류를 최소화하고 계산의 정확성을 보장하기 위해서

## ⛳️ 1주차 목표

- [ ] JDK 21 기능 활용
- [ ] 객체에 대한 명확한 책임 분배
- [ ] 편리하고 유연한 문자열 덧셈 계산기 만들기

## ✏️ 구현할 기능 목록

### 안내 멘트

- [x] "`덧셈할 문자열을 입력해 주세요.`" 를 출력한다.

### 입력값 확인

- [ ] **사용자로부터 문자열을 입력받는다.**
    - [ ] 입력된 문자열의 앞뒤 공백을 제거한다.
    - [ ] 입력된 문자열이 `null`인지 확인한다.
        - [ ] `null`인 경우`IllegalArgumentException`을 발생시키고 **"`null은 입력할 수 없습니다.`"** 라는 오류 메시지를 출력한 후 프로그램을 종료한다.
    - [ ] 입력된 문자열이 빈 문자열(`""`)인지 확인한다.
        - [ ] **빈 문자열인 경우 결과로 `0`을 출력하고 다시 입력받는다.**
    - [ ] **`null`도 아니고 빈 문자열도 아닌 경우 다음 단계를 진행한다.**

### 커스텀 구분자 처리

- [ ] **커스텀 구분자가 있는지 확인한다.**
    - [ ] 입력 문자열에서 `"//"`와 `"\n"`의 위치를 찾는다.
        - [ ] **case 1: `"//"`와 `"\n"`이 모두 존재하고, `"//"`가 `"\n"`보다 앞에 위치하는 경우**
            - [ ] `"//"`와 `"\n"` 사이의 문자열을 **커스텀 구분자**로 추출한다.
                - [ ] **커스텀 구분자가 비어 있는 경우**
                    - [ ] `IllegalArgumentException`을 발생시키고 **"`커스텀 구분자가 비어 있습니다.`"** 라는 오류 메시지를 출력한 후 프로그램을 종료한다.
            - [ ] **커스텀 구분자와 기본 구분자(`,`, `:`)를 구분자 목록에 추가한다.**
            - [ ] `"//"`와 `"\n"` 및 그 사이의 **구분자를 제외한 나머지 부분을 연산할 문자열**로 설정한다.
        - [ ] **case 2: `"//"`와 `"\n"`이 모두 존재하지만, `"//"`가 `"\n"`보다 뒤에 위치하는 경우**
            - [ ] `IllegalArgumentException`을 발생시키고 **"`'//'는 '\\n'보다 앞에 위치해야 합니다.`"** 라는 오류 메시지를 출력한 후 프로그램을 종료한다.
        - [ ] **case 3: `"//"`와 `"\n"` 중 하나만 존재하는 경우**
            - [ ] `IllegalArgumentException`을 발생시키고 **"`'//'와 '\\n'이 모두 존재해야 합니다.`"** 라는 오류 메시지를 출력한 후 프로그램을 종료한다.
        - [ ] **case 4: `"//"`와 `"\n"`이 모두 존재하지 않는 경우**
            - [ ] **기본 구분자(`,`, `:`)만을 구분자 목록에 추가한다.**
            - [ ] **전체 입력 문자열**을 **연산할 문자열**로 설정한다.

### 문자열을 구분자로 나눈 후, 각 부분을 숫자로 변환하면서 검증

- [ ] 구분자 목록을 사용하여 연산할 문자열을 분리하여 **숫자 문자열 배열을 생성한다.**


- [ ] 숫자 문자열 배열을 순회하며 **각 요소를 정수로 변환하고 검증한다.**
    - [ ] 변환 과정에서 **숫자가 아닌 값**이 있는 경우
        - [ ] `IllegalArgumentException`을 발생시키고 **"`숫자가 아닌 값이 포함되어 있습니다`"** 라는 오류 메시지를 출력한 후 프로그램을 종료한다.
    - [ ] 변환된 정수가 **음수 값**인 경우
        - [ ] `IllegalArgumentException`을 발생시키고 **"`음수는 허용되지 않습니다`"** 라는 오류 메시지를 출력한 후 프로그램을 종료한다.

### 합계 계산

- [ ] 변환된 정수들의 합계를 계산한다.

### 합산 결과

- [ ] 합계를 "`결과 : (합계)`" 방식으로 출력한다.

## 📦 역할 별 패키지 분리

### [domain]

#### StringParser

- 입력된 문자열을 파싱하여 커스텀 구분자와 숫자 부분을 추출

#### DelimiterManager

- 기본 구분자와 커스텀 구분자를 관리하고, 문자열 분리에 사용할 정규식 패턴을 생성

#### NumberSplitter

- 구분자를 사용하여 숫자 문자열을 개별 숫자 문자열로 분리

#### PositiveIntegerConverter

- 숫자 문자열을 받아 양의 정수로 변환

#### SumCalculator

- 변환된 양의 정수들의 합계를 계산

### [view]

#### InputView

- 사용자로부터 입력 받기

#### OutputView

- 결과나 메시지를 사용자에게 출력

### [controller]

#### CalculatorController

- 전체 계산 흐름을 조율하고, 계산 과정에 참여하는 클래스 간의 상호작용을 관리

### [validator]

### [exception]

## ✅ 과제 진행 요구 사항

- [x]  **[java-calculator-7](https://github.com/woowacourse-precourse/java-calculator-7)** 저장소를 Fork & Clone
- [x]  README.md에 구현할 기능 목록을 정리해 추가
- [ ]  완료 후 Pull Request
- [ ]  우아한테크코스 지원 플랫폼에 소감 작성 후 제출
- [ ]  제출한 후 결과 확인, 통과하지 못했다면 수정해 다시 제출

## ✅ 프로그래밍 요구 사항

### 제출 전 확인 리스트

- [ ]  JDK-21 사용
- [ ]  프로그램 실행의 시작점은 `Application`의 `main()`
- [ ]  `build.gradle` 변경 불가, 제공된 라이브러리만 사용
- [ ]  [Java Style Guide](https://github.com/woowacourse/woowacourse-docs/tree/main/styleguide/java)를 준수하며 프로그래밍
- [ ]  프로그램 종료 시`System.exit()`를 호출 X
- [ ]  프로그램 구현 완료 시 `ApplicationTest`의 모든 테스트가 성공
- [ ]  프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 이름을 수정하거나 이동 X

### 라이브러리 요구 사항

- [ ]  camp.nextstep.edu.missionutils에서 제공하는 Console API를 사용하여 구현
- [ ] 사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용 
