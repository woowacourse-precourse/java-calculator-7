# java-calculator-precourse

# 1주차 프리코스: 문자열 덧셈 계산기
- 2024-10-15 15:00 ~ 2024-10-22 00:00

## 기능 요구 사항
입력한 문자열에서 숫자를 추출하여 더하는 계산기를 구현한다.
- 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환한다.
- 앞의 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 "//"와 "\n" 사이에 위치하는 문자를 커스텀 구분자로 사용한다.
  - 예를 들어 "//;\n1;2;3"과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.

## 입출력 요구 사항
### 입력
- 구분자와 양수로 구성된 문자열
### 출력
- 덧셈 결과
```
결과 : 6
```
### 실행 결과 예시
```
덧셈할 문자열을 입력해 주세요.
1,2:3
결과 : 6
```

## 프로그래밍 요구 사항
- JDK 21 버전에서 실행 가능해야 한다.
- 프로그램 실행의 시작점은 `Application`의 `main()`이다.
- `build.gradle` 파일은 변경할 수 없으며, 제공된 라이브러리 이외의 외부 라이브러리는 사용하지 않는다.
- 프로그램 종료 시 `System.exit()`를 호출하지 않는다.
- 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 등의 이름을 바꾸거나 이동하지 않는다.
- 자바 코드 컨벤션을 지키면서 프로그래밍한다.
  - 기본적으로 [Java Style Guide](https://github.com/woowacourse/woowacourse-docs/tree/main/styleguide/java)를 원칙으로 한다.

## 라이브러리
- `camp.nextstep.edu.missionutils`에서 제공하는 `Console` API를 사용하여 구현해야 한다.
  - 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.

## 기능 목록
- 입력 기능
  - 사용자로부터 문자열을 입력 받는 기능
  
- 문자열 검증 기능
  - 커스텀 구분자가 존재하는지 확인하는 기능
    - "//"와 "\n" 사이에 커스텀 구분자가 존재하는지 확인한다.
    - 커스텀 구분자가 존재한다면 해당 구문자는 기본 구분자와 동일한 기능을 한다.
  - 해당 문자열이 구분자와 양수로만 구성되었는지 확인하는 기능
  - 잘못된 값을 입력하는 경우 `IllegalArgumentException`을 발생시키고 종료하는 기능
    - 입력 문자열이 null인 경우
    - 문자열 앞부분의 "//"와 "\n" 사이에 커스텀 구분자를 지정하지 않은 경우
    - "//"와 "\n" 사이에 2개 이상의 문자가 포함되어 있는 경우
    - 기본 및 지정된 커스텀 구분자와 숫자 이외의 문자가 포함된 경우
    - 음수가 입력된 경우

- 문자열 계산 기능
  - 입력 문자열을 구분자로 분리하여 숫자를 추출하는 기능
    - 쉼표(,)와 콜론(:)을 기본 구분자로 사용한다.
    - 문자열을 구분자로 분리한다.
  - 커스텀 구분자를 사용하는 기능
    - 커스텀 구분자가 존재한다면 기본 구분자와 통합하여 새로운 구분자 셋을 정의한다.
    - 마찬가지로 문자열을 새로운 구분자 셋을 통해 분리한다.
  - 문자열을 정수로 변환하는 기능
    - 구분자로 숫자를 분리한다.
    - 분리된 숫자를 합산한다.

- 출력 기능
  - 덧셈 결과를 출력하는 기능
