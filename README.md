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

