# java-calculator-precourse
## 기능 목록
- [X] **입력 문자열 확인**
  - [X] 입력받은 문자열이 비어있는지 확인한다.
  - [X] 비어있으면 0 반환
- [X] **커스텀 구분자 파싱**
  - [X] 입력 문자열이 커스텀 구분자를 포함하는 형식인지 확인한다.
    - [X] 문자열의 시작이 "//"로 시작하고 "\n"이 있는 경우, //와 \n 사이의 문자를 커스텀 구분자로 파싱한다.
    - [X] 커스텀 구분자가 없는 경우에는 기본 구분자인 쉼표(,)와 콜론(:)을 사용하여 숫자를 분리한다.
  - [X] 문자열을 분리하여 각각의 숫자 요소로 만든다.
- [X] **숫자 합산**
  - [X] 분리된 숫자들은 합산하고 결과 값을 반환한다.
- [X] **숫자 유효성 검사**
  - [X] 분리된 각 요소가 숫자인지 확인한다.
  - [X] 숫자가 아닌 값이 있거나, 잘못된 형식의 값이 있을 경우 IllegalArgumentException을 발생시킨다.
## 잘못된 형식의 입력 예외 처리
- [X] 잘못된 형식의 입력 예외 처리
  - [X] **음수 입력 처리**:
    * 목적: 음수 값이 입력될 경우 예외가 발생하는지 확인.
    * 입력: `"1,-2,3"`
    * 예상 동작: `IllegalArgumentException` 발생
  - [X] **숫자가 아닌 값 입력 처리**:
    * 목적: 입력에 숫자가 아닌 값이 포함될 때 예외가 발생하는지 확인.
    * 입력: `"1,A,2"`
    * 예상 동작: `IllegalArgumentException` 발생
  - [X] **잘못된 구분자 형식 처리**:
    * 목적: 잘못된 구분자 형식이 있을 때 예외가 발생하는지 확인.
    * 입력: `"1,,2"`, `"1;\n2"`
    * 예상 동작: `IllegalArgumentException` 발생
## 테스트 계획
- [ ] **빈 문자열 입력 테스트**
    * 목적: 입력이 빈 문자열일 때, 0을 반환하는지 확인
    * 테스트 입력: ""
    * 기대 출력: 0
- [ ] **쉼표와 콜론 혼용 테스트**
    * 목적: 쉼표(,)와 콜론(;)을 혼용했을 때, 숫자를 올바르게 분리하여 합산하는지 확인한다.
    * 테스트 입력: "1,2:3"
    * 기대 출력: 6
- [ ] **커스텀 구분자 테스트**
    * 목적: 커스텀 구분자가 있을 때, 올바르게 처리하는지 확인
    * 테스트 입력: "//[###]\n1###2###3"
    * 기대 출력: 6
- [ ] **음수 입력 테스트**
    * 목적: 음수 값이 입력될 경우 예외가 발생하는지 확인한다.
    * 테스트 입력: "1,-2,3"
    * 기대 동작: IllegalArgumentException 발생
- [ ] **숫자가 아닌 값 입력 테스트**
    * 목적: 입력에 숫자가 아닌 값이 포함될 때 예외가 발생하는지 확인한다.
    * 테스트 입력: "1,A,2"
    * 기대 동작: IllegalArgumentException 발생
