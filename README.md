# 문자열 덧셈 계산기

## 1. 빈 문자열 처리 기능
- **`processNull(String input)`**
- 입력값이 null이거나 빈 문자열일 경우 문자열 "0"을 반환
- 아닌 경우 입력 문자열 그대로 반환

## 2. 커스텀 구분자 추출 기능
- **`extractCustomSymbols(String input)`**
- 입력값이 "//"로 시작하면 "//"와 "\n" 사이의 문자열을 커스텀 구분자로 추출하여 반환
- 커스텀 구분자가 없으면 빈 문자열을 반환

## 3. 입력값 유효성 검사 기능
- **`validateInput(String input, String custom)`**
- 커스텀 구분자가 존재할 경우
  - 커스텀 구분자가 숫자일 경우 IllegalArgumentException 발생
  - "\n" 이후 문자열이 [숫자, 쉼표, 콜론, 커스텀 구분자]가 아니면 IllegalArgumentException 발생
- 커스텀 구분자가 없을 경우 전체 문자열이 [숫자, 쉼표, 콜론]이 아니면 IllegalArgumentException 발생

## 4. 문자열 분리 기능
- **`splitString(String input, String custom)`**
- 커스텀 구분자가 없을 경우 [쉼표, 콜론]으로 입력 문자열 분리
- 커스텀 구분자가 존재할 경우 "\n" 이후 문자열을 [쉼표, 콜론, 커스텀 구분자]로 분리

## 5. 합계 계산 기능
- **`sumArray(String[] arr)`**
- 문자열 배열의 각 요소를 정수로 변환한 후 더하여 합계를 반환

## 6. 프로그램 실행 기능
- **`run()` 메서드**
- 사용자로부터 입력을 받고, 입력값을 처리하여 결과를 출력

## 7. 프로그램 진입점
- **`main(String[] args)`**
- `Application` 클래스의 인스턴스를 생성하고 `run()` 메서드를 호출하여 프로그램 실행