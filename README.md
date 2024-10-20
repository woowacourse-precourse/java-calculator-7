# java-calculator-precourse

<h2 style="border-bottom: 1px solid #21262d; color: #c9d1d9;"> 📜 과제 진행 요구 사항 </h2>

- 미션은 문자열 덧셈 계산기 저장소를 포크하고 클론하는 것으로 시작한다.

- 기능을 구현하기 전 README.md에 구현할 기능 목록을 정리해 추가한다.

- Git의 커밋 단위는 앞 단계에서 README.md에 정리한 기능 목록 단위로 추가한다.

  : `AngularJS Git Commit Message Conventions`을 참고해 커밋 메시지를 작성한다.

- 자세한 과제 진행 방법은 프리코스 진행 가이드 문서를 참고한다.

<h2 style="border-bottom: 1px solid #21262d; color: #c9d1d9;"> 🛠️ 기능 요구 사항 </h2>

1. **문자열 입력**:
   - 사용자가 콘솔에서 문자열 입력
   - 입력된 문자열이 `null` 혹은 빈 문자열이면 0 반환
   
2. **구분자 처리**:
   - 기본 구분자는 쉼표( `,` )와 콜론( `:` )임
   - 커스텀 구분자 지정가능
     - 문자열의 앞에서 `//`와`\n`사이의 문자가 커스텀 구분자
   
3. **숫자 덧셈**:
   - 구분자를 기준으로 문자열을 분리해 숫자를 추출
   - 추출된 숫자들 모두 더해서 출력함
   
4. **예외 처리**:
   - 음수가 포함된 경우 `IllegalArgumentException`을 발생시킴
   - 잘못된 입력 형식 또는 유효하지 않은 구분자가 입력된 경우에도 예외 발생시킴

<h2 style="border-bottom: 1px solid #21262d; color: #c9d1d9;"> 👩🏻‍💻 프로그래밍 요구 사항 </h2>

- JDK 21 버전에서 실행 가능해야 한다.

- 프로그램 실행의 시작점은 Application의 main()이다.

- build.gradle 파일은 변경할 수 없으며, 제공된 라이브러리 이외의 외부 라이브러리는 사용하지 않는다.

- 프로그램 종료 시 System.exit()를 호출하지 않는다.

- 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 등의 이름을 바꾸거나 이동하지 않는다.

- 자바 코드 컨벤션을 지키면서 프로그래밍한다.

  : 기본적으로 `Java Style Guide`를 원칙으로 한다.

- camp.nextstep.edu.missionutils에서 제공하는 Console API를 사용하여 구현해야 한다.

  : 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다
