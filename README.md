# java-calculator-precourse

# 문자열 덧셈 계산기

## 개요

이 프로젝트는 문자열 덧셈 계산기를 구현합니다. 사용자가 입력한 문자열에서 숫자를 추출하여 더하는 기능을 제공합니다.

## 기능 목록

1. 문자열 입력 받기
2. 기본 구분자(쉼표, 콜론)를 기준으로 숫자 분리 및 합 계산
3. 커스텀 구분자 지정 및 숫자 분리 및 합 계산
4. 잘못된 입력값 처리 및 예외 발생

## 실행 방법

1. JDK 21이 설치된 환경에서 실행 가능합니다.
2. 프로그램의 시작점은 `Application` 클래스의 `main()` 메서드입니다.
3. `Console.readLine()`을 사용하여 사용자 입력을 받습니다.

## 사용 예시
문자열을 입력해 주세요 //;\n1;2;3 result: 6

## 구현 상세

### 입력

- 문자열로 입력 받습니다.
- 기본 구분자: 쉼표(,), 콜론(:)
- 커스텀 구분자: `//`와 `\n` 사이의 문자를 사용

### 출력

- 덧셈 결과를 출력합니다.

### 예외 처리

- 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킵니다.

## 코드 설명

- `plus` 메서드: 문자열을 입력 받아 숫자를 더한 결과를 반환합니다.
  - 입력 문자열이 `null` 또는 빈 문자열인 경우 0을 반환합니다.
  - 기본 구분자(쉼표, 콜론)를 기준으로 숫자를 분리합니다.
  - 커스텀 구분자가 있는 경우 이를 기준으로 숫자를 분리합니다.
  - 잘못된 값이 있는 경우 `IllegalArgumentException`을 발생시킵니다.

## 자바 코드 컨벤션

- Java Style Guide를 따릅니다.
- 프로그램 종료 시 `System.exit()`를 호출하지 않습니다.
- 외부 라이브러리를 사용하지 않습니다.
