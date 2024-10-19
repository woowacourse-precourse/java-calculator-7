## 1. ✖️➕java-calculator-precourse 기능 목록➗➖
---

### ▪️ 입력

- [x] `덧셈할 문자열을 입력해 주세요.` 출력 후 문자열 입력받기

### ▪ 계산기

- [x] 입력받은 문자열이 비어있는 경우 0 반환
- [x] 각 숫자의 합 구하기
- 예외처리🚨: `IllegalArgumentException` 반환 후 종료시키기
    - [x] `음수` 또는 `0`으로 구성된 숫자일 경우

### ▪ 숫자 추출기

- [x] 문자열 형식의 숫자를 숫자로 파싱
- 예외처리🚨: `IllegalArgumentException` 반환 후 종료시키기
    - [x] 숫자가 아닌 문자열이 들어있는 경우

### ▪ 문자열 분리기

- [x] 문자열에서 커스텀구분자 형식 제거하기
- [x] 구분자로 문자열 분리하기

### ▪ 커스텀구분자 추출기

- [x] 커스텀구분자 있는지 없는지 확인하기
- [x] `"//"`와 `"\n"` 사이에 위치하는 문자를 커스텀구분자로 지정하기
- 예외처리🚨: `IllegalArgumentException` 반환 후 종료시키기
    - [x] 문자열 앞부분이 `"//"`로 시작하지 않을 경우
    - [x] 커스텀구분자 형식이 `"\n"`로 끝나지 않을 경우
    - [x] 커스텀구분자가 빈 문자열 인 경우

### ▪ 출력

- [x] 각 숫자의 합을 `결과 : ${합}` 형식에 맞게 출력하기

## 2. ✅ 과제 제출 전 확인 사항 ✅
---

- [x] `java -version` 명령어로 자바 버전이 21인지 확인
- [x] `./gradlew clean test` 명령어로 테스트 모두 통과되는지 확인
- [x] 요구 사항에 명시된 출력 형식을 지켰는지 확인
- [x] 자바 코드 컨벤션 지켰는지 확인
