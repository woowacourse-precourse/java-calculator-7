# ✔️ TODO List 

- [x] ConsoleInput 클래스 구현
  - [ ] Input test 작성
- [ ] Preprocessor 클래스 구현
  - 띄워쓰기도 구분자로 사용가능 해야함 
  - [ ] 구분자와 숫자+구분자 문자열을 담고 있는 DTO 구현
    - 기본 구분자를 들고 있어야 함
  - [ ] 커스텀 구분자를 확인하는 기능 구현
  - [ ] Preprocessor test 작성
- [ ] Parser 클래스 구현
  - [ ] 구분자와 숫자+구분자 문자열을 담고 있는 DTO를 입력받아서 숫자 리스트로 변환하는 기능 구현
  - [ ] Parser test 작성
- [ ] Calculator 클래스 구현
  - [ ] 숫자 리스트를 입력받아서 더하는 기능 구현
  - [ ] Calculator test 작성
- [ ] MultipleUseCase 구현체 (MultipleService) 클래스 구현
  - [ ] Preprocessor, Parser, Calculator를 사용해서 결과를 반환하는 기능 구현
  - [ ] MultipleService test 작성 
- [ ] ConsoleOutput 클래스 구현
- [ ] 전체적인 Output까지의 동작 과정을 확인하기 위한 통합 테스트 작성

# ➕ 문자열 덧셈 계산기

## 📚 과제 진행 요구 사항

- 미션은 [문자열 덧셈 계산기](https://github.com/woowacourse-precourse/java-calculator-7) 저장소를 포크하고 클론하는 것으로 시작한다.
- 기능을 구현하기 전 `README.md` 에 구현할 기능 목록을 정리해 추가한다.
- Git의 커밋 단위는 앞 단계에서 `README.md`에 정리한 기능 목록 단위를 기준으로 추가한다.
  - [AngularJS Git Commit Message Conventions](https://gist.github.com/stephenparish/9941e89d80e2bc58a153)을 참고해 커밋 메시지를 작성한다.
- 자세한 과제 진행 방법은 프리코스 진행 가이드를 문서화 참고한다.

## 🛠️ 기능 요구 사항

입력한 문자열에서 숫자를 추출하여 더하는 계산기를 구현한다.

- 쉼표(`,`) 또는 콜론(`:`)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환한다.
  - 예: "1,2" => 3, "1,2,3" => 6
- 앞의 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 `//`와 `\n` 사이에 위치하는 문자를 커스텀 구분자로 사용한다.
  - 예를 들어 `//;\n1;2;3`과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(`;`)이며, 결과 값은 6이 반환되어야 한다.
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.

## 💬 입출력 요구 사항

### 입력

- 구분자와 양수로 구성된 문자열

### 출력

- 덧셈 결과

```bash
결과 : 6
```

### 실행 결과 예시

```bash
덧셈할 문자열을 입력해 주세요.
1,2:3
결과 : 6
```

## 🥅 프로그래밍 요구 사항

- JDK 21 버전에서 실행 가능해야 한다.
- 프로그램 실행의 시작점은 `Application` 의 `main()` 이다.
- `build.gradle` 파일은 변경할 수 없으며, 제공된 라이브러리 이외의 외부 라이브러리는 사용하지 않는다.
- 프로그램 종료 시 `System.exit()` 를 호출하지 않는다.
- 프로그래밍 요구 사항에서 달리 명시하지 않은 한 파일, 패키지 등의 이름을 바꾸거나 이동하지 않는다.
- 자바 코드 컨벤션을 지키면서 프로그래밍한다.
  - 기본적으로 [Java Style Guide](https://github.com/woowacourse/woowacourse-docs/tree/main/styleguide/java)를 원칙으로 한다.

## 📚 라이브러리

- `camp.nextstep.edu.missionutils` 에서 제공하는 `Console` API를 사용하여 구현해야 한다.
  - 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console` 의 `readLine()` 을 활용한다.

  
# 🤔 요구사항 분석, 설계 

## 입력

1. **"1,2:3" => 6**이 가능하다면 구분자를 여러 개 받을 수 있는 것으로 추측됨
2. \\ \n 사이에 커스텀 구분자를 추가 할 수도 안할 수도 있음
3. **"" => 0**을 봤을 때 입력이 없는 경우 예외처리를 해줘야 함
   2-1. **"1" => 1**이 된다면, while loop을 돌면서 sum에 poll 되는 모든 값을 더해주는 식으로 구현 가능할 것으로 보임
4. Java SE 프로젝트에서 IllegalArgumentException이 발생했을 때 자동으로 종료되는지 확인 필요
5. 기본 구분자는 , : 임

## 아키텍처

1. 인풋, 아웃풋을 Console로 하는 것으로 추측됨
    - MVC 패턴에서 View에 해당하는 부분을 Console input output으로 구현하면 될 것으로 보임
2. UseCase는 MultipleUseCase 하나만 구현하면 될 것 같음
3. 도메인은 구분자를 확인할 수 있는 전처리기, 구분자를 통해서 더해야 할 숫자를 파싱하는 파서, 숫자를 더하는 계산기로 구성되면 될 것 같음

```bash
- view
  - ConsoleInput
  - ConsoleOutput
- service 
  - MultipleService
- controller
  - MultipleController
- domain
    - MultipleUseCase
    - Preprocessor
    - Parser
    - Calculator
```
