# 📈기능 구현 목록 - 문자열 덧셈 계산기

---

## 🗂 Model

### `Calculator` (계산기)

- [ ] 전달받은 `숫자들`을 이용해 `덧셈 연산`을 한다.
- [ ] 계산한 결과 값을 `Controller`에게 반환한다.

### `CalculationString` (계산 문자열)

- [ ] 입력받은 `문자열`의 문법과 형태를 `검증`한다.
- [ ] `유효하지 않은 입력 값`에 대해 `IllegalArgumentException`을 발생시킨다.

### `StringParser` (파싱 및 변환기)

- [ ] `CalculationString`을 받아서 `문자열을 파싱`하여 `구분자`를 추출한다.
- [ ] 파싱한 결과를 `숫자(int)`로 변환한다.
- [ ] 변환된 `숫자 리스트`를 `Calculator`에게 전달한다.

---

## 💻 View

### `InputView`

- [ ] 구분자와 양수로 구성된 `문자열을 입력`받는다 (`String`).
- [ ] 입력 받은 문자열을 `CalculationString`에게 전달한다.

### `OutputView`

- [ ] `계산기 시작 문구`를 출력한다.
- [ ] `계산 결과`를 출력한다.

---

## 🗼 Controller

### `CalculatorController`

- [ ] `InputView`에서 입력된 문자열을 `CalculationString` 객체로 전달한다.
- [ ] 검증된 문자열을 `StringParser`로 넘긴다.
- [ ] 파싱된 `숫자 리스트`를 `Calculator`로 전달하여 덧셈을 수행한다.
- [ ] `Calculator`에서 계산된 결과 값을 받아 `OutputView`로 출력한다.
- [ ] 예외 발생 시 `오류 메시지`를 출력하고 프로그램을 종료한다.
