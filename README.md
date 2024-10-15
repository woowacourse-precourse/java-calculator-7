# 문자열 덧셈 계산기

## 기능 명세서

### 1. 입력 처리
- 사용자의 입력을 확인
  - 첫 번째 입력에 커스텀 구분자 입력이 있는지 확인
    - 없다면 기본 구분자 `,`, `:`를 이용해서 문자를 구분
    - 있다면 커스텀 구분자를 프로그램 내 저장 후 다음 입력 대기
  - 구분자로 나눈 문자가 양수인지 확인
    - 모든 문자가 양수라면 각 숫자를 더한 결과를 출력
    - 그 외에는 에러를 발생 후 프로그램 종료 (ex. 알파벳, 음수, 기호)

### 2. 에러 처리
- 구분된 문자에 음수 입력 시 에러 발생
- 빈 문자열 입력 시 0을 반환
- 잘못된 형식을 입력 시 에러 발생 후 프로그램 종료

### 3. 추가 기능 고려사항
- 커스텀 구분자는 숫자와 공백을 허용 X (ex. `// \n1 2 3`)
- 빈 문자가 들어왔다면 `0`을 출력
- 공백은 입력 처리 시 모두 제거