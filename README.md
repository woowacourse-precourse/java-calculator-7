# java-calculator-precourse


### 기능 목록 단위 

- 구분자로 숫자를 분리한다. 
  - 기본 구분자는 쉼표, 콜론이다.
  - 문자열 앞부분의 "//"와 "\n" 사이에 위치하는 문자를 커스텀 구분자로 사용할 수 있다.

- 분리된 각 숫자의 합을 반환한다.

### 예외사항
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.
- 숫자 합이 Long 타입 최대 범위를 초과할 시 예외가 발생한다.
- 아무 입력이 없을 시 0을 반환한다.
- 구분자 없이 숫자만 입력했을 경우 그대로 반환한다.

### 커밋 규칙

- [AngularJS Git Commit Message Conventions](https://gist.github.com/stephenparish/9941e89d80e2bc58a153#allowed-type)을 참고한다.
- 형식 : Type(Scope): Subject 

Type
- feat (기능 구현)
- fix (버그 수정)
- docs (문서화)
- style (포맷팅, 형식 수정)
- refactor (리팩터링)
- test (테스트 작성)
- chore (그 외 설정)

Scope
- 클래스(.class) 혹은 객체의 큰 범위로 작성한다.

Subject
- 현재형과 명령어로 내용을 작성한다.