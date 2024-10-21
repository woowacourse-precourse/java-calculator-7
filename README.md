# java-calculator-precourse

## 문자열 덧셈 계산기

### 1. 입출력 처리

- **기능**: 구분자와 양수로 구성된 문자열 받기
    - **입력 형식**:
      ```
      덧셈할 문자열을 입력해 주세요.
      2/3:1
      결과: X
      ```

### 2. 로직 구현

- **기능**
    1. 입력 문자열 개별 문자로 분리하기
    2. 커스텀 구분자 찾기
    3. 구분자 & 피연산자 찾기
    4. 최종 덧셈 하기

### 3. 예외 처리

- **구분자가 없는 경우**
    - **오류 메시지**: "문자열에 구분자가 존재하지 않습니다."
        - **오류 클래스**: `IllegalArgumentException`
        - 에러 처리 후 애플리케이션 종료
        - `System.exit()` 불가


- **피연산자가 없는 경우**
    - **오류 메시지**: "문자열에 피연산자가 존재하지 않습니다."
    - **오류 클래스**: `IllegalArgumentException`
    - 에러 처리 후 애플리케이션 종료
        - `System.exit()` 불가

### 4. 테스트

- **기능**: 테스트 케이스 작성
    - 기본 구분자 사용: "1,2:3" => 6
    - 커스텀 구분자 사용: "//;\n1;2;3" => 6
    - 입력 값이 문자열이 아닌 경우
    - 구분자가 없는 경우
    - 피연산자가 없는 경우
    - 구분자 문자 2개가 연속해서 존재하는 경우

<hr>

### Commit Convention

- `feat` feature 새로운 기능 추가
- `fix` bug fix 버그 수정
- `docs` documentation 문서 수정
- `style` 코드 포맷팅, 세미콜론 누락 등
- `refactor` 코드 리팩토링
- `test` test 코드 추가
- `chore` maintain (잡일), 빌드 업무 수정, 패키지 매니저 수정