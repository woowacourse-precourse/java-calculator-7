# java-calculator-precourse

<!-- ROADMAP -->
## 기능 요구 사항
<hr>
입력한 문자열에서 숫자를 추출하여 더하는 계산기를 구현한다.

- [ ] 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 구분자를 기준으로 분리한다.
- [ ] 구분자를 기준으로 분리한 각 숫자의 합을 계산한다.
- [ ] 쉼표, 콜론 외 커스텀 구분자를 지정한다(문자열 앞부분의 "//"와 "\n"사이에 위치하는 문자)
- [ ] 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시키고 애플리케이션을 종료한다.

### 입출력 요구 사항
<h4>입력</h4>
- 구분자와 양수로 구성된 문자열
<h4>출력</h4>
- 덧셈 결과
<pre>결과 : 6</pre>
<h4>실행 결과 예시</h4>
<pre>
덧셈할 문자열을 입력해 주세요.
1,2:3
결과 : 6
</pre>

## 프로그래밍 요구 사항
<hr>

- [ ] JDK 21 버전에서 실행 가능해야 한다.
- [ ] 프로그램 실행의 시작점은 `Application`의 `main()`이다.
- [ ] `build.gradle` 파일은 변경할 수 없다.
- [ ] 제공된 라이브러리 이외의 외부 라이브러리를 사용하지 않는다.
- [ ] 프로그램 종료 시 `System.exit()`를 호출하지 않는다.
- [ ] 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 등의 이름을 바꾸거나 이동하지 않는다.
- [ ] 자바 코드 컨벤션을 지키면서 프로그래밍한다.
  - 기본적으로 [Java Style Guide](https://github.com/woowacourse/woowacourse-docs/blob/main/styleguide/java)를 원칙으로 한다.

### 라이브러리
- [ ] `camp.nextstep.edu.missionutils`에서 제공하는 `Console` API를 사용하여 구현해야 한다.
- [ ] 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.