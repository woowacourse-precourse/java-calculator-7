# java-calculator-precourse

## 덧셈 계산기의 핵심 기능

- 입력된 문자열에서 추출된 숫자의 합계를 계산한다.

## 덧셈 계산기의 비즈니스 로직

- 입력된 문자열에서 숫자를 구분자를 기준으로 추출한다.
  - 쉼표(,)와 콜론(:)을 기본 구분자로 사용한다.
  - 문자열의 시작이 "//"로 시작하고 "\n"이 나올 때까지의 문자를 커스텀 구분자로 사용한다.

## 예외 처리할 사항

- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료한다.
  - 구분자 사이에 0, 음수, 문자 등 양수가 아닌 입력이 들어온 경우 예외 처리

## 기능 구현 목록

### 1. 덧셈할 문자열 입력 및 요청 메시지 출력 기능

- [ ] 덧셈할 문자열 요청 메시지를 출력한다.
  - `"덧셈할 문자열을 입력해 주세요."`를 출력한다.
- [ ] 덧셈할 문자열을 입력받는다.
- [ ] 입력받은 문자열이 빈 문자열(`""`)인 경우 합계는 `0`을 반환한다.

### 2. 입력된 문자열의 유효성 검사 및 파싱 기능

- [x] 커스텀 구분자가 있는지 확인한다.
    - [x] 문자열이 `"//"`로 시작하고 `"\n"`을 포함하는지 검사한다.
    - [x] 커스텀 구분자가 있다면 구분자를 추출한다.
- [x] 구분자를 기준으로 문자열을 분리한다.
    - [x] 기본 구분자(쉼표, 콜론)를 사용하여 분리한다.
    - [x] 커스텀 구분자가 있다면 해당 구분자도 추가로 사용하여 분리한다.
- [x] 분리된 각 문자열을 숫자로 변환한다.
    - [ ] 문자열 배열을 순회하며 숫자로 파싱한다.
    - [x] 숫자가 아닌 문자가 포함되어 있다면 `IllegalArgumentException`을 발생시킨다.
- [x] 양수가 아닌 숫자(0 또는 음수)가 포함되어 있다면 `IllegalArgumentException`을 발생시킨다.
- [ ] 숫자들의 리스트를 생성한다.

### 3. 숫자 리스트의 합을 계산하는 기능

- [x] 숫자 리스트를 입력받는다.
- [x] 숫자 리스트의 합계를 계산하여 반환한다.
    - 리스트를 순회하며 합계를 계산한다.

### 4. 결과를 출력하는 기능

- [ ] 계산된 합계를 출력한다.
  - `"결과 : [합계]"` 형식으로 출력한다.