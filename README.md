# 🏁 문자열 계산기

### 👩🏻‍💻 프로그램 소개
사용자가 입력한 문자열에서 **숫자를 추출해 합산하는 간단한 덧셈 계산기**입니다. 
쉼표(`,`)와 콜론(`:`) 같은 기본 구분자는 물론, **커스텀 구분자**도 지정해서 사용할 수 있습니다. 
잘못된 입력이 들어오면 예외를 발생시키고 프로그램이 종료됩니다.

---

### ✅ 기능 요구사항

- [x] 입력된 문자열이 (숫자 구분자 숫자) 형식이 맞는지 확인하기
- [x] 기본 구분자를 사용해서 계산하기
  - [x] 쉼표(`,`)와 콜론(`:`)을 구분자로 사용해 입력된 숫자들을 더하기

- [x] 커스텀 구분자를 사용해서 계산하기
  - [x] 문자열이 `"//[구분자]\n"` 형태로 시작하면 해당 구분자를 사용해 숫자들을 분리하기
  - [x] 구분자가 숫자일 경우 예외처리하기

- [x] 잘못된 커스텀 구분자 형식 처리하기
  - [x] 커스텀 구분자가 `"//"`와 `"\n"` 사이에 올바르게 정의되지 않을 경우 예외 발생하기

- [x] 빈 문자열 또는 `null` 입력을 처리하기
  - [x] 입력이 없거나 빈 문자열인 경우 합계를 **0**으로 설정하기

- [x] 음수 입력 시 예외 처리하기
  - [x] 음수가 포함된 경우 예외를 발생시키고 프로그램을 종료하기 (양수만 입력하도록)

- [x] 숫자가 아닌 값 입력 시 예외 처리하기
  - [x] 입력에 숫자가 아닌 값이 있으면 예외를 발생시키고 종료하기



