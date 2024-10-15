# java-calculator-precourse

## 🚀 구현할 기능 목록 

### ⌨️ 입력

- [ ] 덧셈할 문자열을 입력받는 기능을 구현한다.
  - [ ] 덧셈 문자열 입력 안내 메시지를 출력한다.
  - [ ] 사용자로부터 덧셈할 문자열을 입력받는다.
    - [ ] 정규식 조건에 부합하는 문자열이 입력됐는지 검증한다.
      - [ ] 양수, 쉼표, 콜론, 또는 커스텀 구분자 외의 특수 문자가 포함된 경우, 예외를 반환한다.
    - [ ] 입력된 문자열을 파싱한다.
      - [ ] 문자열 앞 부분에 커스텀 구분자가 있는 경우, 이를 따로 저장한다.
      - [ ] 숫자들을 추출하기 위해 아래 과정을 반복한다.
        - [ ] 주어진 문자열에 구분자가 포함되어 있는지 확인한다.
        - [ ] 만약 구분자가 포함되어 있는 경우, 구분자를 기준으로 문자열을 분리한다.
      - [ ] 최종적으로 분리된 숫자들을 리스트에 저장한다.

### 🖥 출력

- [ ] 덧셈 결과를 출력한다.
  - [ ] "결과"라는 문자열와 덧셈 결과를 ":" 구분자를 통해 구분한다.

### ⚙️ 로직

- [ ] 리스트에 저장된 숫자들을 더하는 기능을 구현한다.
  - [ ] 리스트에 저장된 숫자들을 모두 더한 결과를 반환한다.