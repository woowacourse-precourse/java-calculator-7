## 목차
- [java-calculator-precourse](#java-calculator-precourse)
    - [📚 학습 목표](#-학습-목표)
    - [🔍 프리코스 진행 방식](#-프리코스-진행-방식)
    - [📮 미션 제출 방법](#-미션-제출-방법)
    - [🚨 과제 제출 전 체크 리스트](#-과제-제출-전-체크-리스트)
        - [테스트 실행 가이드](#테스트-실행-가이드)
    - [🚀 기능 요구 사항](#-기능-요구-사항)
    - [📥 입출력 요구 사항](#-입출력-요구-사항)
        - [실행 결과 예시](#실행-결과-예시)
    - [✨ 프로그래밍 요구 사항](#-프로그래밍-요구-사항)
    - [📚 라이브러리 사용 가이드](#-라이브러리-사용-가이드)
- [문자열 덧셈 계산기 기능 목록](#문자열-덧셈-계산기-기능-목록)
    - [1. 사용자 입력 처리](#1-사용자-입력-처리)
    - [2. 입력값 검증](#2-입력값-검증)
    - [3. 문자열에서 숫자 추출](#3-문자열에서-숫자-추출)
    - [4. 숫자 변환 및 합산](#4-숫자-변환-및-합산)
    - [5. 결과 출력](#5-결과-출력)
    - [6. 테스트 케이스 작성](#6-테스트-케이스-작성)
    - [7. 커밋 및 코드 관리](#7-커밋-및-코드-관리)

# java-calculator-precourse

## 📚 학습 목표
- Git, GitHub, IDE 등의 개발 환경에 익숙해진다.
- 교육 분야에 맞는 프로그래밍 언어를 사용하여 간단한 문제를 해결한다.

## 🔍 프리코스 진행 방식
1. 미션은 **과제 진행 요구 사항, 기능 요구 사항, 프로그래밍 요구 사항** 세 가지로 구성된다.
2. 기능을 구현하기 전 **기능 목록을 작성**하고, 기능 단위로 커밋하여 진행한다.
3. 기능 요구 사항에 명시되지 않은 부분은 스스로 판단하여 구현한다.
4. 미션은 매주 화요일 오후 3시에 제공되며, 다음 주 월요일까지 구현을 완료하고 제출해야 한다.
5. 제출은 일요일 오후 3시부터 가능하며, 정해진 시간을 지키지 않으면 제출하지 않은 것으로 간주한다.
6. 종료 일시 이후에는 추가 푸시가 허용되지 않는다.

## 📮 미션 제출 방법
- **GitHub**을 통해 미션을 제출하며, [프리코스 과제 제출](https://github.com/woowacourse/woowacourse-docs/tree/master/precourse) 문서를 참고하여 제출한다.
- 제출 후, [우아한테크코스 지원 플랫폼](https://apply.techcourse.co.kr)에 PR 링크를 포함하여 최종 제출한다.
- [제출 가이드](https://github.com/woowacourse/woowacourse-docs/tree/main/precourse#%EC%A0%9C%EC%B6%9C-%EA%B0%80%EC%9D%B4%EB%93%9C)를 참고하여 과제 수행 중 느낀 점과 배운 점 등을 자유롭게 작성한다.

## 🚨 과제 제출 전 체크 리스트
1. **출력 형식을 준수**하지 않으면 0점 처리된다.
2. 기능 구현 완료 후, 아래 테스트 실행 가이드를 따라 **모든 테스트가 성공**하는지 확인한다.
3. **테스트 실패 시 0점 처리**되므로 반드시 확인 후 제출한다.

### 테스트 실행 가이드
- 터미널에서 `java -version`을 실행하여 Java 버전이 21인지 확인한다.
- Mac 또는 Linux 사용자는 `./gradlew clean test`, Windows 사용자는 `gradlew.bat clean test` 명령을 실행하여 모든 테스트가 성공하는지 확인한다.


```
BUILD SUCCESSFUL in 0s
```


## 🚀 기능 요구 사항
1. **기본 구분자로 문자열을 분리하여 합산**
    - 쉼표(,) 또는 콜론(:)을 구분자로 가진 문자열에서 숫자를 추출하고 합산한다.
    - 예시: `"" => 0`, `"1,2" => 3`, `"1,2,3" => 6`, `"1,2:3" => 6`

2. **커스텀 구분자로 문자열을 분리하여 합산**
    - 문자열의 앞부분에 `"//"`와 `"\n"` 사이에 위치한 문자를 커스텀 구분자로 사용한다.
    - 예시: `"//;\n1;2;3"`에서 커스텀 구분자는 `";"`이며, 결과 값은 `6`이 반환된다.

3. **유효하지 않은 입력에 대한 예외 처리**
    - 잘못된 값이 입력되면 `IllegalArgumentException`을 발생시키고 프로그램을 종료한다.

## 📥 입출력 요구 사항
- **입력**: 구분자와 양수로 구성된 문자열을 입력받는다.
- **출력**: 입력된 숫자의 합을 반환한다.

### 실행 결과 예시
```
덧셈할 문자열을 입력해 주세요. 1,2:3 결과 : 6
```

## ✨ 프로그래밍 요구 사항
1. **JDK 21** 버전에서 실행 가능해야 한다.
2. 프로그램 실행의 시작점은 `Application`의 `main()` 메서드이다.
3. `build.gradle` 파일을 변경할 수 없으며, 외부 라이브러리는 사용하지 않는다.
4. **System.exit()**를 호출하지 않고 프로그램을 종료한다.
5. 자바 코드 컨벤션을 준수하여 프로그래밍하며, [Java Style Guide](https://google.github.io/styleguide/javaguide.html)를 따른다.

## 📚 라이브러리 사용 가이드
- [mission-utils 라이브러리](https://github.com/woowacourse-projects/mission-utils)
- `camp.nextstep.edu.missionutils`의 **Console API**를 사용하여 사용자의 입력을 처리한다.
- 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()` 메서드를 통해 받아온다.

```java
String input = Console.readLine();
```

# 문자열 덧셈 계산기 기능 목록

## 1. 사용자 입력 처리
- **콘솔 입력 받기**:
    - `camp.nextstep.edu.missionutils.Console`의 `readLine()` 메서드를 사용해 사용자로부터 문자열을 입력받는다.
- **입력 검증**:
    - 잘못된 입력이 감지되면 예외를 발생시키고, 프로그램을 종료한다.

## 2. 입력값 검증
- **빈 문자열 검증**:
    - 입력값이 빈 문자열 ""일 경우 결과로 0을 반환한다.

- **구분자 유효성 검증**:
    - 커스텀 구분자가 숫자(`0-9`), 소수점(`.`), `e` 또는 `E`인 경우 주어지는 숫자와 구분할 수 없기 때문에 허용하지 않는다.
    - 해당 문자가 구분자로 지정되면 `"커스텀 구분자 형식 오류: 숫자('0-9'), '.', 'e', 'E'는 사용할 수 없습니다."`라는 메시지와 함께 예외를 발생시킨다.

- **유효한 숫자 및 문자 검증**:
    - 입력값이 지정된 구분자를 기준으로 나누어진 후, 각 요소가 양수, 소수, 또는 과학적 표기법을 사용한 숫자인지 확인한다.
    - 숫자, 소수, 과학적 표기법을 제외한 문자가 포함된 경우 `"양수, 소수 또는 과학적 표기법 형식의 숫자로 입력해야 합니다."`라는 메시지와 함께 `IllegalArgumentException`을 발생시킨다.

## 3. 문자열에서 숫자 추출
- **기본 구분자로 숫자 분리**:
    - 입력 문자열에 쉼표(,) 또는 콜론(:)이 포함된 경우 이를 기준으로 숫자를 분리한다.

- **커스텀 구분자로 숫자 분리**:
    - 입력 문자열이 `"//"`와 `"\n"`을 포함할 경우, `"//"`와 `"\n"` 사이의 문자를 커스텀 구분자로 사용하여 숫자를 분리한다.
    - 커스텀 구분자가 위의 제한된 문자(`0-9`, `.`, `e`, `E`)일 경우 예외를 발생시킨다.

- **혼합 구분자 처리**:
    - 기본 구분자와 커스텀 구분자가 혼합된 입력에 대해 적절히 분리하여 숫자를 추출하고, 유효성 검증을 수행한다.

## 4. 숫자 변환 및 합산
- **데이터 타입 선택**:
    - 각 숫자의 크기에 따라 적절한 데이터 타입을 선택한다:
        - **정수 범위**: `int` 또는 `long` 사용
        - **소수 범위**: `double` 사용
        - **큰 숫자 처리**: 정수 및 소수를 초과하는 매우 큰 값에 대해서는 `BigInteger` 또는 `BigDecimal` 사용
- **숫자 변환 및 합산**:
    - 분리된 숫자들을 적절한 데이터 타입으로 변환하여 합산한다.
    - 변환 중 음수가 포함된 경우 `"음수는 허용되지 않습니다: [음수 목록]"`이라는 메시지와 함께 `IllegalArgumentException`을 발생시킨다.
    - 과학적 표기법(`e`, `E`)을 사용한 숫자도 변환 후 합산한다.

## 5. 결과 출력
- 합산된 결과를 화면에 출력한다.
- 출력 형식이 요구 사항에 맞는지 확인하고, 요구 사항과 일치하지 않는 경우 형식을 맞추어 반환한다.

## 6. 테스트 케이스 작성
- **빈 문자열 테스트**:
    - 빈 문자열 입력 시 예외가 발생하는지 테스트한다.

- **기본 구분자 테스트**:
    - 쉼표 또는 콜론이 포함된 문자열에 대해 올바른 합산 결과를 반환하는지 테스트한다.

- **커스텀 구분자 테스트**:
    - 커스텀 구분자가 포함된 문자열에 대해 올바른 합산 결과를 반환하는지 테스트한다.

- **과학적 표기법 테스트**:
    - 과학적 표기법이 포함된 숫자에 대해 올바른 합산 결과를 반환하는지 테스트한다.

- **큰 숫자 처리 테스트**:
    - `BigInteger` 또는 `BigDecimal`을 사용해야 하는 매우 큰 숫자에 대해 올바른 합산 결과를 반환하는지 테스트한다.

- **예외 처리 테스트**:
    - 빈 문자열, 잘못된 구분자, 음수 등이 포함된 경우 `IllegalArgumentException`과 적절한 에러 메시지가 발생하는지 테스트한다.

- **혼합 구분자 테스트**:
    - 기본 구분자와 커스텀 구분자가 혼합된 입력에 대해 올바르게 처리되는지 테스트한다.

- **잘못된 문자 및 구분자 형식 테스트**:
    - 잘못된 구분자 및 문자가 포함된 입력에 대해 올바르게 예외를 발생시키는지 테스트한다.

## 7. 커밋 및 코드 관리
- **기능 단위로 커밋하기**:
    - 각 기능이 구현될 때마다 작은 단위로 커밋을 진행하여 변경 이력을 명확히 관리한다.
- **커밋 메시지 작성**:
    - [AngularJS Git Commit Message Conventions](https://gist.github.com/stephenparish/9941e89d80e2bc58a153)에 따라 일관된 커밋 메시지를 작성한다.
    - 커밋 메시지는 주요 변경 사항을 반영하도록 한다. 예시:
        - `feat: 기본 구분자로 문자열을 분리하여 합산 기능 구현`
        - `fix: 커스텀 구분자로 잘못된 문자가 포함될 경우 예외 처리 추가`
- **테스트 후 커밋**:
    - 코드 변경 시마다 테스트를 실행하고, 모든 테스트가 통과할 때만 커밋한다.