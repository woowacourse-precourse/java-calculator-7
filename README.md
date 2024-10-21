# java-calculator-precourse

## 과제 진행 요구사항
- 미션 구현 후 Github 통해 제출
  - 과제 제출 문서 참고
- Github에 미션을 제출한 후, 우테코 지원 플랫폼에서 PR 링크를 포함하여 최종 제출
    - 과제 수행하면서 느낀 점, 배운 점 정리
- 문자열 덧셈 계산기 저장소 포크하고 클론
- README.md에 구현할 기능 목록 정리
- [AngularJs Git Commit Conventions](https://gist.github.com/stephenparish/9941e89d80e2bc58a153) 참고하여 커밋 메세지 작성

## 기능 요구 사항 (문자열 덧셈 계산기)
입력한 문자열에서 숫자를 추출하여 더하는 계산기 구현

- 쉽표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환한다.
  - 예 : "" -> 0 , "1,2" -> 3 , "1,2,3" -> 6, "1,2:3" -> 6
>think) StringTokenizer 이용하면 되겠다.
  
- 앞의 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 **문자열 앞 부분**의 "//"와 "\n" 사이에 위치하는 문자를 커스텀 구분자로 사용한다.
  - 예를 들어, "//;\n1;2;3"과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 리턴되어야 한다.
>think) Delimiter Parser 를 직접 구현해보자.

- 사용자가 잘못된 값을 입력한 경우 IllegalArgumentException 을 발생시킨 후 애플리케이션은 종료되어야 한다.
>think) "사용자가 잘못된 값을 입력한 경우", 그 외는 RuntimeException 을 발생시키거나, 커스텀 예외를 발생시키자.

### 입출력 요구사항
- 입력
  - 구분자와 양수로 구성된 문자열
- 출력
  - 덧셈 결과
  - `결과 : 6`

- 실행 결과 예시
```
덧셈할 문자열을 입력해 주세요.
1,2:3
결과 : 6
```

## 프로그래밍 요구사항
- JDK 21 버전 사용
- 프로그램 시작점은 Application의 main()
- build.gradle 파일은 변경할 수 없으며, 제공된 라이브러리 이외의 외부 라이브러리는 사용하지 않는다.
- 프로그램 종료 시 System.exit() 를 호출하지 않는다.
- 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 등의 이름을 바꾸거나 이동하지 않는다.
>think) 하위 패키지 구조를 새로 만드는 건 가능할까?
- 자바 코드 컨벤션을 지키면서 프로그래밍 한다.
  - [Java Style Guide](https://github.com/woowacourse/woowacourse-docs/tree/main/styleguide/java) 를 원칙으로 한다.

### 라이브러리
- camp.nextstep.edu.missionutils 에서 제공하는 Console API를 사용하여 구현해야 한다.
  - 사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console 의 readLine()을 활용한다.