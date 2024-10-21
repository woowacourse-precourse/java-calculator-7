# 🎯 문자열 덧셈 계산기
***
## 기능 구현 목록

**👉입력 기능**
- [x] 구분자와 양수로 구성된 문자열을 입력받는다.

**👉출력 기능**
- [x] 덧셈 결과를 출력한다.

**✅ 계산 기능**
- [x] 기본 구분자`(쉼표, 콜론)`를 기준으로 숫자를 분리한다.
- [x] 커스텀 구분자를 기준으로 숫자를 분리한다.`문자열 앞부분의 "//"와 "\n" 사이에 위치하는 문자가 커스텀 구분자이다.`
- [x] 입력값이 `공백` 일 경우 결과값이 `0`이 되어야 한다.
- [x] 분리된 숫자들을 모두 더한다.

**🚫 예외처리 기능**
- [x] 커스텀 구분자가 숫자일 경우 예외처리를 한다.
- [x] 커스텀 구분자가 공백인 경우 예외처리를 한다.
- [x] 커스텀 구분자가 기본 구분자와 중복될 경우 예외처리를 한다.
- [x] 숫자 입력 부분에 숫자가 아닌 문자가 들어온 경우 예외처리를 한다.
- [x] 구분자`(기본 구분자, 커스텀 구분자)`가 아닌 문자가 들어온 경우 예외 처리를 한다.
- [x] 커스텀 구분자 형식`"//[delimiter]\n"`이 올바르지 않은 경우 예외처리를 한다.
- [x] 숫자가 양의 정수가 아닐 경우 예외처리를 한다.
