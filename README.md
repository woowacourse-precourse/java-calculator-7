# 문자열 덧셈 계산기

## 기능 구현 목록

### 👥 User

- [ ] 사용자는 문자열을 입력할 수 있다.
- [ ] 입력된 문자열의 결과 값을 확인할 수 있다.
- [ ] 잘못된 값을 입력하면 애플리케이션은 종료되어야 한다.

### ⌘ Delimiter

- [x] 쉼표(,) 또는 콜론(:)을 기본 구분자로 가진다.
- [x] 사용자로부터 입력받은 문자열에서 커스텀 구분자를 파싱한다.
    - [x] 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨다.
        - [x] 커스텀 구분자가 "//"와 "\n" 사이에 위치하지 않을 경우
- [x] 파싱된 커스텀 구분자 또는 기본 구분자들의 목록들을 집합으로 저장한다.

### 🔢 Number

- [ ] 사용자로부터 입력받은 문자열에서 구분자를 기준으로 분리된 숫자 정보를 추출하여 리스트로 저장한다.
    - [ ] 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨다.
        - [ ] 양수가 아닌 숫자를 입력하였을 경우
        - [ ] 구분자를 제외하고, 숫자로 변환되지 않는 값을 입력했을 경우
        - [ ] 구분자가 숫자 사이에 위치하지 않을 경우
- [ ] 추출되어 저장된 숫자들의 합을 구한다.
