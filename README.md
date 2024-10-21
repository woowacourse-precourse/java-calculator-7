# 프리코스 1주차 - 문자열 덧셈 계산기

## 구현 기능 목록
- [x] 사용자 입력 기능
- [x] 쉼표, 콜론, 커스텀 구분자 분리 기능
- [x] 결과 출력 기능
- [x] 예외 처리 기능

## 설계
![image](https://github.com/user-attachments/assets/6de619fd-def6-4819-951b-03f4223bff25)

## 구현 과정
### Calculate
**splitString(input)**
- Pattern, Matcher 클래스를 이용, `find()` 함수를 통해 일치하는 문자열을 찾아 커스텀 구분자를 분리한다.
- `replaceAll()`을 이용해 커스텀 구분자를 표시하는 `\\`과 `\n`을 삭제하고 기본 구분자와 커스텀 구분자로 문자열을 분리한다. 이후 `filter()`를 이용해 공백 요소를 제거한다.
- split에 커스텀 구분자를 단순히 `+`로 추가했는데 다른 특수기호를 커스텀 구분자로 추가했을 때 에러가 발생했다. -> 커스텀 구분자 앞에 `\\`를 추가하여 문제를 해결했다.

**addition(numbers)**
- for문을 돌며 `numbers`의 숫자들을 더한다. 이때 `isPositiveNumber()`를 통해 양수인지 확인한다.

**isPositiveNumber(number)**
- `number`를 int로 변환하고 양수가 아니거나 기본 구분자와 커스텀 구분자가 아닌 경우 `IllegalArgumentException`을 발생하도록 구현하였다.
- 숫자가 아닌 경우 int로 변환하는 과정에서 `NumberFormatException`이 발생하기 때문에 try-catch를 이용해 예외를 발생시켰다.

### InputView & OutputView
- 입력 화면과 출력 화면을 각각 구현하였다.
- 입력은 `readLine()`을 이용하였다.

## 실행 결과
![image](https://github.com/user-attachments/assets/917c63c2-bde8-4764-9898-da122bc5a93e)
