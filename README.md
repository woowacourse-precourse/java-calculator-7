# java-calculator-precourse
📆 2024.10.15 ~ 2024.10.21

# 기능 목록
## 입력 요구 사항
1. (기능 id 1-1) 구분자와 양수로 구성된 문자열을 입력받는다.
2. (id 1-2) 구분자는 ',' 또는 ':'이다.
3. (id 1-3) 위 구분자 외에 커스텀 구분자를 지정할 수 있다. 문자열 앞부분의 "//"와 "\n" 사이에 위치하는 문자이다.

## 출력 요구 사항
1. (id 2-1) 문자열을 입력받기 전, "덧셈할 문자열을 입력해 주세요." 라는 안내문구를 출력하며 프로그램을 시작한다.
2. (id 2-2) "결과 : 6"과 같은 형식을 따른다.

## 기능 요구 사항
1. (id 3-1) 구분자를 기준으로 분리한 각 숫자의 합을 반환한다.

## 예외 처리
1. (id 4-1) 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료된다.
  - 잘못된 값: 0, 음수, long 타입의 범위를 넘는 2^63-1 이상의 수, 문자열에 커스텀 구분자가 아닌 문자를 포함할 경우
2. (id 4-2) 빈 문자열을 입력할 경우 0을 반환한다.
3. 구분자 입력 관련 실수가 있는 경우 아래와 같이 처리한다.
  - (id 4-3) 구분자가 연속으로 나올 경우: 구분자 하나만 입력된 것으로 간주한다.
  - (id 4-4) 문자열의 시작이나 끝에 구분자가 올 경우: 문자열의 시작에 위치할 경우 앞에 0이 입력된 것으로, 문자열의 끝에 위치할 경우 후에 0이 입력된 것으로 간주한다.
