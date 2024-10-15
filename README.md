# java-calculator-precourse

- [x] 기본 문자열 파싱 기능 및 덧셈 기능
    - 빈 문자열, null 입력 처리
    - 숫자 하나만 입력된 경우 처리
    - 쉼표(,)를 구분자로 사용하여 문자열 분리 및 덧셈
- [x] 콜론(:) 구분자 추가
  - 쉼표(,)와 콜론(:)을 동시에 구분자로 사용
- [x] 커스텀 구분자 처리
  - "//"와 "\n" 사이의 문자를 커스텀 구분자로 인식한다.
  - 커스텀 구분자를 사용했을 때 문자열 분리 및 덧셈
- [ ] 예외 처리
  - 음수나 잘못된 입력값이 들어왔을 때 `IllegalArgumentException`으로 처리
- [ ] 사용자 인터페이스 구현
  - `camp.nextstep.edu.missionutils`에서 제공하는 `Console`API를 사용하여 구현
  - 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용
- [ ] 메인 로직 구현
  - 위의 기능을 사용하여 전체 로직 구현
- [ ] 테스트 코드 작성
  - 테스트 코드를 작성하여 안정적인 어플리케이션 유지