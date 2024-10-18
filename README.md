# java-calculator-precourse

---
`문자열 덧셈 계산기` 작업을 기록하기 위한 문서입니다. 

## Package Structure

---
```java
calculator
│
├── adapters                   # 외부 시스템과 연결 (어댑터)
│   ├── input                  # 입력 어댑터 (예: REST, CLI)
│   │   ├── cli                # 콘솔 입력 관련
│   │       └── CliInputAdapter.java   # CLI 입력을 처리하는 컨트롤러
│   └── output                 # 출력 어댑터 (예: 데이터베이스, 메시징 시스템)
│       ├── cli                # 콘솔 출력 관련
│            └── CliOutputAdapter.java        
│
├── application                # 애플리케이션 서비스 계층 (비즈니스 로직을 처리)
│   ├── dto                    # DTO (Data Transfer Objects)
│   │   ├── request            # 요청 관련 DTO
│   │   │   └── CalculationRequest.java
│   │   │   └── Request.java
│   │   └── response           # 응답 관련 DTO
│   │       └── CalculationResponse.java
│   │       └── Response.java
│   ├── service                # 서비스 클래스
│   │   └── CalculateStringCommand.java
│   ├── usecase                # 유즈케이스 실행
│   │   └── CalculateStringUseCase.java
│   └── validation             # 입력 및 비즈니스 흐름 유효성 검사
│       └── InputValidator.java  # Command에 대한 입력 검증
│
├── config                     # 설정 (의존성 주입 등)
│   ├── constants              # 상수 관리
│   │   └── ResponseMessage.java
│   └── AppConfig.java         # 애플리케이션 설정
│
├── domain                     # 핵심 도메인 로직
│   ├── service                # 도메인 서비스
│   │   └── AdditionService.java
│   ├── vo                     # 값 객체 (Value Objects)
│   │   ├── delimiter          # 구분자 관련 VO
│   │   │   ├── constants      # 구분자 상수 관리
│   │   │   │   └── DelimiterPattern.java
│   │   │   └── Delimiter.java
│   │   │   └── Delimiters.java
│   │   ├── number             # 숫자 관련 VO
│   │   │   ├── constants      # 숫자 상수 관리
│   │   │   │   └── NumberRange.java
│   │   │   └── Number.java
│   │   │   └── Numbers.java
│
├── infrastructure             # 인프라 계층 (외부 기술)
│   ├── exception              # 예외 처리 관련
│   │   └── ErrorCode.java
│
└── port                       # 포트 인터페이스 (입출력)
    ├── input                  # 입력 포트
    │   └── InputPort.java
    └── output                 # 출력 포트
        └── OutputPort.java
```

## Hexagonal Architecture

---

### 가장 중요하게 고려했던 것
헥사고날 아키텍처로 구성하면서 가장 중요하게 고려 했던 부분은 외부 환경(CLI, Web 등)에 구애받지 않고, 동일한 비즈니스 로직을 유지하면서 동작할 수 있는 구조를 설계하는 것이었습니다. 

예를 들어, 프리코스의 CLI 환경에서 구현한 클래스는 다음과 같습니다:

```java
public class CliInputAdapter implements InputPort {

    private final OutputPort outputPort;
    private final CalculateStringUseCase calculateStringUseCase;

    public CliInputAdapter(OutputPort outputPort, CalculateStringUseCase calculateStringUseCase) {
        this.outputPort = outputPort;
        this.calculateStringUseCase = calculateStringUseCase;
    }

    public void run() {
        outputPort.writeMessage("계산할 식을 입력하세요:");
        String input = Console.readLine();
        CalculationRequest request = new CalculationRequest(input);

        CalculationResponse response = process(request);  // 유스케이스 실행
        outputPort.writeResponse(response);  // 결과 출력
    }

    @Override
    public CalculationResponse process(CalculationRequest request) {
        return calculateStringUseCase.calculate(request);
    }
}
```

만약 같은 로직을 Spring 기반의 Web 환경에서 처리하는 경우 다음과 같이 구현될 수 있습니다.

```java
@RestController
@RequestMapping("/calculate")
public class WebInputAdapter {

    private final OutputPort outputPort;
    private final CalculateStringUseCase calculateStringUseCase;

    public WebInputAdapter(OutputPort outputPort, CalculateStringUseCase calculateStringUseCase) {
        this.outputPort = outputPort;
        this.calculateStringUseCase = calculateStringUseCase;
    }

    @PostMapping
    public ResponseEntity<CalculationResponse> calculate(@RequestBody CalculationRequest request) {
        CalculationResponse response = process(request);  // 유스케이스 실행
        return ResponseEntity.ok(response);  // 결과를 HTTP 응답으로 반환
    }

    @Override
    public CalculationResponse process(CalculationRequest request) {
        return calculateStringUseCase.calculate(request);
    }
}
```

둘 다 입력 방식을 다르게 처리하지만, **핵심 로직은 동일**합니다. 입력을 받아서 유스케이스에 전달하고 결과를 출력하는 흐름은 변하지 않습니다.
이처럼, 헥사고날 아키텍쳐를 사용하여 입력 방식에 관계없이 시스템의 비즈니스 로직을 일관되게 유지하면서, 외부 인터페이스(CLI, Web 등)에 유연하게 대응할 수 있도록 설계하였습니다.

--- 

### 입력은 InputValidator로 검증했는데, 그 외 검증은 객체 내에서 진행한 이유
검증 로직이 매우 복잡하거나 외부 서비스와의 상호작용이 필요한 경우 별도의 Validator로 분리했으며, 그 외의 경우 객체 생성 시점에 검증의 책임을 갖고 있도록 구현하였습니다.

또한, 객체 내부에서 검증을 처리하면 해당 객체의 상태가 도메인 논리에 맞는지를 보장할 수 있어 더 응집력이 높아집니다.

그 예 : 검증해야 하는 로직이 복잡하고 다양하였으며 추가적인 확장 가능성이 존재
```java
 public void validate(final CalculationRequest calculationRequest) {
        String target = calculationRequest.input();

        isEmpty(target);
        isNotTrimmed(target);
        isNotEndedWithNumber(target);
        isProperCustomDelimiterFormat(target);
    }
```

반면, 객체는 생성 시점에 검증을 수행하도록 구현하였습니다. 밑의 예제 처럼 구분자가 한 단어로 이뤄지는지, 혹은 `Number` 객체에서 `Number`의 범위를 검증하는 로직 등은 객체 내부에 위치하는 것이 더 적절합니다.
```java
    private Delimiter(final String value) {
        validate(value);
        this.value = value;
    }

    protected void validate(final String value) {
        if (value == null || value.length() != 1) {
            throw new IllegalArgumentException(INVALID_DELIMITER.getMessage());
        }
    }
```

---

### 각 계층이 갖고 있어야 할 책임 with Hexagonal Architecture Perspective
`CliInputAdapter.java` : 외부에서 들어오는 입력 (CLI)를 내부 도메인 로직으로 전달하고, 내부 로직에서 처리된 응답 데이터를 출력하는 책임을 가집니다. 

- 헥사고날 아키텍처에서 `Input Port`는 애플리케이션이 입력을 받을 수 있도록 설계된 인터페이스이며, 입력 어댑터는 이를 구현하여 외부 시스템과의 연결을 담당합니다.
- (번외) `Output Port`는 위와 반대로 애플리케이션이 출력을 전달할 수 있도록 설계된 인터페이스이며, 출력 어댑터는 이를 구현하여 외부 시스템과의 연결을 담당합니다. 

`CalculateStringUseCase.java` : 비즈니스 로직을 **실행** 하는 유스케이스입니다.입력된 요청을 검증하고, 도메인 서비스를 통해 계산을 수행 후 결과를 반환합니다. 

- 헥사고날 아키텍처에서 유스케이스는 입력 포트를 통해 전달된 데이터를 받아 애플리케이션의 핵심 비즈니스 로직을 실행하는 역할을 합니다. 즉, 비즈니스 로직을 도메인 서비스에 **위임** 하는 역할을 합니다.

`AdditionService.java` : 비즈니스 로직 (계산) 을 **처리** 하는 도메인 서비스 입니다.

- 헥사고날 아키텍쳐 관점에서 도메인 서비스는 여러 도메인 객체가 상호작용해야 할 때, 그 상호작용을 처리하고 조율하는 역할을 합니다. 문자열 계산기에서는 `Delimiters`와 `Numbers`가 서로 상호작용합니다.

---

### 🤔도메인 서비스가 처리해야 하는가 유스케이스가 처리해야 하는가
도메인 서비스가 처리해야 되는가 유스케이스가 처리해야되는가 이는 흐름을 볼 필요가 있습니다. 만약 여러 객체를 사용하여 전체 작업을 처리하는 흐름이라면 UseCase가 처리합니다. 그렇지 않고 주로 도메인 간의 협력 (흐름) 이라면 도메인 서비스가 관리합니다.

예를 들어, 문자열 덧셈 계산기가 아닌 문자열 계산기라고 가정해보겠습니다. 
이 때 들어온 입력을 '덧셈', '뺄셈', '곱셈', '나눗셈'에 따라 분리하는 역할 (전체적인 흐름) 은 UseCase가 처리하고, 각각의 계산을 하는 부분은 도메인 서비스가 처리합니다. 

(번외) 이 때는 `Operator` 라는 새로운 도메인 서비스가 추가되어 `AdditionOperator`, `SubtractionOperator` 와 같은 방식으로 처리될 수 있습니다. 

---

### 구현하면서 느낀 헥사고날 아키텍쳐의 장점
헥사고날 아키텍쳐의 장점은 어댑터를 교체하는 방식으로 비즈니스 로직의 수정 없이 외부 시스템의 변경에 대응할 수 있다는 것입니다. 