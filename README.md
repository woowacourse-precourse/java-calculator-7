# java-calculator-precourse

### 기능 구현 목록

#### 초기 설계

- [x] 초기 설계대로 공용 인터페이스 설정
- [x] 초기 설계대로 구현체 생성

#### 콘솔

- [x] 입력 받는 기능
- [x] 결과 출력하는 기능
- [x] 에러 메시지 출력하는 기능

#### 문자와 숫자를 분리(Separator)

- [x] 입력 문자열을 구분자를 기준으로 분리하여 숫자를 추출하는 기능
- [x] 숫자를 분리하는 기능

#### 구분자 관리(DelimiterManager)

- [x] 구분자를 추출하는 기능
- [x] 커스텀 구분자가 존재한다면 커스텀 구분자 추출하는 기능

#### 덧셈(Adder)

- [x] 숫자를 더하는 기능

#### 예외처리

- [ ] 분리하는 중 구분자와 숫자 이외의 문자 확인 및 예외 처리 (IllegalArgumentException 발생)
- [ ] 음수 값이 입력된 경우 예외 처리 (IllegalArgumentException 발생)
- [ ] 커스텀 구분자의 자리에 문자가 존재하지 않는 경우 예외 처리 (IllegalArgumentException 예외 발생)
- [ ] 구분자로 허용되지 않은 문자가 구분자로 사용되는 경우 예외 처리 (IllegalArgumentException 예외 발생)
- [ ] 숫자가 없이 구분자만 존재하는 경우 예외처리 (IllegalArgumentException 예외 발생)
- [ ] 입력값이 null일 경우 예외 처리 (IllegalArgumentException 발생)
- [ ] 커스텀 구분자가 제대로 지정되지 않았을 경우 예외 처리 (IllegalArgumentException 발생)

#### 기타

- [x] 애플리케이션 실행 시 사용자가 입력한 문자열을 받아 결과를 출력하는 기능