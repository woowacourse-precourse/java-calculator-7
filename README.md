# 📈기능 구현 목록 - 문자열 덧셈 계산기

---

## 🗂 Model

### `Calculator`

- [x] 전달받은 `숫자 리스트`를 이용해 `덧셈 연산`을 한다.
    - [x] 계산한 결과 값을 `CalculatorController`에게 반환한다.

### `CalculationString` (계산 문자열)

- [x] 입력받은 `문자열`을 `검증`한다.
    - [x] `빈 문자열`일 경우 `0`을 반환한다.

### `StringHandler`

- [ ] `문자열`을 받아서 `파싱`한다.
    - [ ] `커스텀 구분자 문법`이 잘못된 경우, `IllegalArgumentException`을 발생시킨다.
- [ ] 파싱한 결과를 `숫자 리스트`로 변환한다.
    - [ ] `숫자 리스트`에 `음수`가 존재할 경우, `IllegalArgumentException`을 발생시킨다.
- [ ] 변환된 `숫자 리스트`를 `CalculatorController`에게 반환한다.
-

---

## 💻 View

### `InputView`

- [x] `구분자와 양수`로 구성된 `문자열을 입력`받는다.
    - [x] `입력 요청 문구`를 출력한다.
    - [x] 입력 받은 `문자열`을 `CalculatorController`에게 반환한다.

### `OutputView`

- [x] `계산 결과`를 출력한다.

---

## 🗼 Controller

### `CalculatorController`

- [ ] `InputView`에 `문자열 입력`을 요청한다.
- [ ] 반환된 `문자열`을 `CalculationString`에 담아 `StringHandler`로 전달한다.
- [ ] 반환된 `숫자 리스트`를 `Calculator`로 전달하여 덧셈을 수행한다.
- [ ] 반환된 `결과 숫자값`을 받아 `OutputView`에 `문자열 출력`을 요청한다.