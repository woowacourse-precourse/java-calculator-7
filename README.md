# java-calculator-precourse

## 🎯 프로그래밍 요구 사항

- [ ] JDK 21 버전에서 실행 가능해야 한다.
- [ ] 프로그램 실행의 시작점은 Application의 main()이다.
- [ ] build.gradle 파일은 변경할 수 없으며, 제공된 라이브러리 이외의 외부 라이브러리는 사용하지 않는다.
- [ ] 프로그램 종료 시 System.exit()를 호출하지 않는다.
- [ ] 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 등의 이름을 바꾸거나 이동하지 않는다.
- [ ] 자바 코드 컨벤션을 지키면서 프로그래밍한다.
	- [ ] 
	  기본적으로 [Java Style Guide](https://github.com/woowacourse/woowacourse-docs/blob/main/styleguide/java)
	  를 원칙으로 한다.

## 🚀 기능 요구 사항

> [!IMPORTANT]
> - 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환한다.
>     - 예: "" => 0, "1,2" => 3, "1,2,3" => 6, "1,2:3" => 6
>
> - 앞의 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 "//"와 "\n" 사이에 위치하는 문자를 커스텀 구분자로 사용한다.
>     - 예를 들어 "//;\n1;2;3"과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
>
> - 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.

### 입출력 요구 사항

**입력**

- 구분자와 양수로 구성된 문자열

**출력**

- 덧셈 결과

  ```bash
  결과 : 6
  ```

**실행 결과 예시**

```bash
덧셈할 문자열을 입력해 주세요.
1,2:3
결과 : 6
```

## ✏️ 구현할 기능

> [!NOTE]
> 애플리케이션의 결합도를 낮추고 확장성을 높이기 위해, DI(Dependency Injection)과 IoC(Inverse of Control)를 추가 기능으로 구현하였다.

- [x] 인터페이스와 테스크 케이스를 작성한다. 
- [x] `amp.nextstep.edu.missionutils`에서 제공하는 `Console` API를 사용하여 사용자의 입력을 받는다.
- [x] 사용자의 입력에서 커스텀 구분자가 있는지 확인한다.
	- [x] 만약 커스텀 구분자가 없다면, 기본 구분자 ',', ':'을 사용한다.
	- [x] 만약 커스텀 구분자가 있다면, 기본 구분자 ',', ':'에 사용자의 커스텀 구분자를 추가한다.
- [x] 사용자의 입력을 사용하기 전에 전처리 과정을 진행한다.
	- [x] 만약 커스텀 구분자가 있다면, 커스텀 구분자를 정의하는 부분 `//${커스텀 구분자}\n`을 삭제한다.
- [ ] 사용자의 입력과 구분자를 활용하여, 숫자를 추출한다.
	- [ ] 만약 커스텀 구분자나 숫자가 아닌 경우, `IllegalArgumentException` 오류를 발생시킨다.
	- [ ] 만약 숫자가 음수일 경우, '-'를 잘못된 구분자로 사용한 가능성이 있으므로 `IllegalArgumentException` 오류를 발생시킨다.
- [ ] 추출된 숫자를 합산한다.
- [ ] 합산된 숫자를 형식에 맞게 출력한다.
- [ ] (추가 기능)
	- [ ] `@Component` annotation을 가지고 있는 클래스를 찾는다.
	- [ ] 스캔된 클래스를 인스턴스로 생성해 `Bean`에 등록한다.
		- [ ] 인스턴스 생성 과정에서 클래스의 생성자가 필요로 하는 Class, Interface 인자를 찾아서 넣어준다.
		- [ ] Interface를 주입해주는 경우, Interface의 구현체를 찾아 주입한다.

