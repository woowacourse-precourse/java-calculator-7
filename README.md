# java-calculator-precourse

# 문자열 계산기

## 기능 요구 사항

- 입력된 문자열에서 숫자를 추출하여 더하는 계산기.
- 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달할 경우, 각 숫자의 합을 반환.
    - 예: `"" => 0`, `"1,2" => 3`, `"1,2,3" => 6`, `"1,2:3" => 6`
- 커스텀 구분자 사용 가능.
    - 커스텀 구분자는 문자열의 맨 앞부분에 `//`와 `\n` 사이에 위치한 문자를 사용.
    - 예: `"//;\n1;2;3"`에서 커스텀 구분자는 `;`, 결과는 6.
- 잘못된 입력을 처리할 때는 `IllegalArgumentException`을 발생시키고 프로그램을 종료.

## 입출력 요구 사항

- 입력: 구분자와 양수로 구성된 문자열.
- 출력: 덧셈 결과.

## 예외 처리

- 잘못된 입력값이 주어졌을 경우 `IllegalArgumentException`을 발생시키고 프로그램 종료.