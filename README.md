# java-calculator-precourse

# 문자열 덧셈 계산기

## 기능 목록

1. 입력 기능
    - [ ] 사용자로부터 문자열 입력 받기

2. 문자열 파싱 기능
    - [ ] 쉼표(,)를 구분자로 문자열 분리
    - [ ] 콜론(:)을 구분자로 문자열 분리
    - [ ] 커스텀 구분자 처리 ("//"와 "\n" 사이의 문자를 구분자로 사용)

3. 숫자 추출 및 변환 기능
    - [ ] 분리된 문자열에서 숫자 추출
    - [ ] 추출된 문자열을 숫자로 변환

4. 덧셈 계산 기능
    - [ ] 추출된 숫자들의 합 계산

5. 예외 처리
    - [ ] 잘못된 입력에 대한 IllegalArgumentException 발생
    - [ ] 음수 입력에 대한 예외 처리

6. 결과 출력 기능
    - [ ] 계산된 덧셈 결과 출력

7. 프로그램 종료 기능
    - [ ] 예외 발생 시 프로그램 종료 처리

## 프로그래밍 요구사항

- JDK 21 사용
- main() 메소드를 시작점으로 사용
- build.gradle 파일 변경 금지
- 외부 라이브러리 사용 금지 (제공된 라이브러리 제외)
- System.exit() 사용 금지
- 파일 및 패키지 이름 변경 금지
- Java 코드 컨벤션 준수
- camp.nextstep.edu.missionutils.Console의 readLine() 메소드 사용하여 입력 처리

## 입출력 요구사항

### 입력
- 구분자와 양수로 구성된 문자열

### 출력
- 덧셈 결과

예시:
```
덧셈할 문자열을 입력해 주세요.
1,2:3
결과 : 6
```

# 커밋 메시지 작성 가이드

## 기본 형식

```
<타입>(<범위>): <제목>

<본문>

<꼬리말>
```

## 타입

- feat: 새로운 기능 추가
- fix: 버그 수정
- docs: 문서 수정
- style: 코드 포맷팅, 세미콜론 누락, 코드 변경이 없는 경우
- refactor: 코드 리팩토링
- test: 테스트 코드, 리팩토링 테스트 코드 추가
- chore: 빌드 업무 수정, 패키지 매니저 수정

## 제목 규칙

- 제목은 50자를 넘기지 않습니다.
- 첫 글자는 대문자로 시작합니다.
- 마지막에 마침표(.)를 붙이지 않습니다.
- 명령문으로 작성합니다. ("추가하다", "변경하다" 등)

## 본문 규칙

- 각 줄은 72자를 넘기지 않습니다.
- 어떻게 변경했는지보다 무엇을, 왜 변경했는지 설명합니다.

## 꼬리말 규칙

- Resolve : 기능목록
- BREAKING CHANGE가 있을 경우 명시합니다.

## 예시

```
feat(로그인): 소셜 로그인 기능 추가

카카오와 네이버 소셜 로그인 기능을 추가했습니다.
사용자 편의성을 높이고 회원가입 절차를 간소화하기 위한 목적입니다.

BREAKING CHANGE: 기존 로그인 API의 응답 형식이 변경되었습니다.
```

# MVC 아키텍처

## 🧩 구성 요소 및 예제 코드

### Application
- 프로그램의 시작점

```java
public class Application {
    public static void main(String[] args) {
        InputView inputView = new ConsoleInputView();
        OutputView outputView = new ConsoleOutputView();
        InputValidator inputValidator = new InputValidator();
        ModelFactory modelFactory = new ModelFactory();
        
        Controller controller = new Controller(inputView, outputView, inputValidator, modelFactory);
        controller.run();
    }
}
```

### 컨트롤러 (Controller)
- 주요 게임 루프 관리
- 사용자 입력 처리 및 모델 프로세싱
- 뷰와 모델 컴포넌트 간 조정

```java
public class Controller {
    private final InputView inputView;
    private final OutputView outputView;
    private final InputValidator inputValidator;
    private final ModelFactory modelFactory;

    public Controller(InputView inputView, OutputView outputView,
                      InputValidator inputValidator, ModelFactory modelFactory) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.inputValidator = inputValidator;
        this.modelFactory = modelFactory;
    }

    public void run() {
        try {
            String input = getValidInput();
            Model model = modelFactory.createModel(input);
            String result = model.process();
            outputView.printResult(result);
        } catch (Exception e) {
            outputView.printError(e.getMessage());
        }
    }

    private String getValidInput() {
        while (true) {
            try {
                String input = inputView.readInput();
                inputValidator.validate(input);
                return input;
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }
}
```

### 뷰 (View)
- **입력뷰 (InputView)**: 사용자 입력 읽기 인터페이스
- **출력뷰 (OutputView)**: 출력 표시 인터페이스

```java
public interface InputView {
    String readInput();
}

public class ConsoleInputView implements InputView {
    @Override
    public String readInput() {
        return camp.nextstep.edu.missionutils.Console.readLine();
    }
}

public interface OutputView {
    void printResult(String result);
    void printError(String error);
}

public class ConsoleOutputView implements OutputView {
    @Override
    public void printResult(String result) {
        System.out.println(result);
    }

    @Override
    public void printError(String error) {
        System.out.println("[ERROR] " + error);
    }
}
```

### 모델 (Model)
- **모델 (Model)**: 게임 로직 인터페이스
- **모델팩토리 (ModelFactory)**: 적절한 모델 인스턴스 생성

```java
public interface Model {
    String process();
}

public class DefaultModel implements Model {
    private final String input;

    public DefaultModel(String input) {
        this.input = input;
    }

    @Override
    public String process() {
        return "처리된 결과: " + input;
    }
}

public class ModelFactory {
    public Model createModel(String input) {
        return new DefaultModel(input);
    }
}
```

### 유틸리티
- **입력검증기 (InputValidator)**: 사용자 입력 유효성 검사

```java
public class InputValidator {
    public void validate(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("입력이 비어있습니다.");
        }
        // 추가적인 검증 규칙을 여기에 구현
    }
}
```

## ✨ 주요 특징

1. **모듈성**: 관심사의 명확한 분리로 유지보수 용이
2. **확장성**: 새로운 기능이나 모델 추가가 쉬움
3. **테스트 용이성**: 의존성 주입을 통한 단위 테스트 용이
4. **유연성**: 인터페이스를 통한 다양한 입출력 구현 가능
5. **오류 처리**: 중앙집중식 오류 관리
6. **재사용성**: 모델팩토리를 통한 다양한 게임 모델 관리

## 📅 개발 계획

| 일 | 초점 |
|---|------|
| 1 | 기본 구조 구현 및 입출력 테스트 |
| 2 | 입력검증기 구현 및 유효성 검사 규칙 |
| 3 | 모델팩토리 및 기본 모델 구현 |
| 4 | 다양한 모델 구현 및 게임 로직 |
| 5 | 예외 처리 및 엣지 케이스 관리 |
| 6 | 시스템 통합 및 최적화 |

## 🚀 시작하기

1. 저장소 클론
2. 프로젝트 디렉토리로 이동
3. `Application.java` 실행하여 애플리케이션 시작

## 📘 요구사항 준수사항

- JDK 21 버전에서 실행 가능
- 프로그램 실행의 시작점은 `Application`의 `main()`
- `build.gradle` 파일 변경 없음
- 외부 라이브러리 사용하지 않음
- `System.exit()` 호출하지 않음
- 파일, 패키지 이름 변경 및 이동 없음
- Java Style Guide 준수
- `camp.nextstep.edu.missionutils.Console`의 `readLine()` 사용

## 🛠️ 확장 및 커스터마이징

- 새로운 모델 추가: `Model` 인터페이스를 구현하고 `ModelFactory`에 추가
- 다른 입출력 방식: `InputView`와 `OutputView` 인터페이스의 새로운 구현 제공
- 추가 유효성 검사: `InputValidator`에 새로운 검증 규칙 추가

## 🤝 기여하기

깃 팔로우를 걸어주세요!
