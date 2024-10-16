# java-calculator-precourse

## 구현 시 참고 사항

- **과제 진행 요구 사항**, **기능 요구 사항**, **프로그래밍 요구 사항** 세 가지를 지키기위해 노력한다.
- 기능을 구현하기 전에 기능 목록을 만들고, 기능 단위로 커밋한다.
    - [AngularJS Git Commit Message Conventions](https://gist.github.com/stephenparish/9941e89d80e2bc58a153)을 참고해 커밋
      메시지를
      작성한다.
- [Java Style Guide](https://github.com/woowacourse/woowacourse-docs/tree/main/styleguide/java)를 지키면서 프로그래밍 한다.
- 제공하는 `Console` API를 사용하여 구현해야 한다.
- JDK 21 버전에서 실행 가능해야 한다.
- 모든 테스트가 성공적으로 실행되는지 확인한다.
- 기능 요구 사항에 기재되지 않은 내용은 스스로 판단하여 구현한다.

## 구현할 기능 목록

1. 입력 안내 문구와 문자열 입력받는 기능
2. 입력받은 문자열 중 **커스텀 구분자**를 찾는 기능
    1. **커스텀 구분자**: ``//`` 와 ``\n`` 사이의 문자
3. 입력받은 문자열을 구분자(`,`, `:`)와 **커스텀 구분자**로 나누어 숫자 배열을 만드는 기능
    1. 숫자가 아닐 경우 `IllegalArgumentException`에러 발생
    2. 구분자를 제외하고 음수가 입력된 경우 `IllegalArgumentException`에러 발생
    3. 공백("")일 경우 0으로 계산
4. 구분된 숫자를 계산하는 기능
5. 결과를 출력하는 기능