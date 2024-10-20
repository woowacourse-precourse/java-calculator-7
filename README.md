# java-calculator-precourse
## 기능 목록
- 구분자를 통한 합 계산
  - 빈 문자열 입력 시 결과는 `0`
- 커스텀 구분자 추가
  - 커스텀 구분자의 허용 개수는 제한 없음
  - 커스텀 구분자 등록 생략해도 오류 X
    - ex) //\n -> 커스텀 등록 문자열은 사용했지만 커스텀 구분자 등록하지 않음
  - 커스텀 등록 문자열이 `3//;\n` 와 같이 맨 앞부터 시작하지 않은 경우 예외 처리 후 종료
    - `//`앞에 문자가 있다면 예외 처리
    - `Error Message : 숫자만 입력 가능합니다.`
- 형식에 맞지 않는 입력 값 예외 처리 후 종료
  - 정수형 이외의 타입 입력 시 `IllegalArgumentException` 발생
    - `Error Message : 숫자만 입력 가능합니다.`
  - 음수, 0 입력시 `IllegalArgumentException` 발생
    - `Error Message : 숫자만 입력 가능합니다음수, 0 사용 불가`
  - Integer 범위를 넘는 정수 입력 시 `IllegalArgumentException` 발생
    - `Error Message : 너무 큰 수를 입력했습니다.`
  - 구분자만 입력된 경우 `IllegalArgumentException` 발생
    - `Error Message : 구분자만 입력되었습니다.`