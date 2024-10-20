# java-calculator-precourse

## 기능 요구 사항
- [ ] 입력을 받습니다.
  - 구분자와 양수로 구성된 문자열입니다.
- [ ] 숫자를 추출합니다.
  - 쉼표(,) 또는 콜론(:)을 가졌을 경우 분리해서 각 숫자를 추출합니다.
- [ ] 쉼표와 콜론 외의 커스텀 구분자를 지정할 수 있습니다.
  - "||"와 "\n" 사이에 위치한 문자를 커스텀 구분자로 사용합니다.
  - e.g) "||;\n1;2;3"의 경우 커스텀 구분자는 세미콜론이며, 결과로 6이 반환됩니다.
- [ ] 잘못된 입력은 IllegalArgumentException을 발생시키며 애플리케이션을 종료합니다.
- [ ] 출력합니다.
  - 추출된 숫자의 덧셈의 결과입니다.

## 실행 결과 예시
```
덧셈할 문자열을 입력해 주세요.
1,2:3
결과 : 6
```


## 프로그래밍 요구 사항
- JDK 21에서 실행 가능해야한다.
- 프로그램의 실행 시작점은 Application의 main()이다.
- build.gradle 파일을 변경하면 안되며, 외부 라이브러리를 사용하지 않는다.
- 프로그램 종료 시 System.exit() 를 호출하지 않는다.
- 요구 사항에서 명시하지 않는 이상 파일, 패키지 등의 이름을 바꾸거나 이동하지 않는다.
- [자바 코드 컨벤션](https://github.com/woowacourse/woowacourse-docs/tree/main/styleguide/java)을 지키며 프로그래밍한다.
- camp.nextstep.edu.missionutils 에서 제공하는 Console API를 사용해 구현해야한다.
  - 사용자 입력 값은 camp.nextstep.edu.missionutils.Console의 readLine() 를 사용한다.