# java-calculator-precourse
## 기능 요구 사항 정리

1. 쉼표 or 콜론을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 각 숫자를 분리하고 각 숫자의 합을 반환한다.
2. 그 외 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 “//”와 “\n”사이에 위치하는 문자이다.
3. 그 외 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.

### Feat1: InputView 및 OutputView 구현

- InputView
    - 콘솔에 출력할 문자열을 상수로 선언한다.
    - 입력받은 문자열을 Controller 레이어로 반환한다.
- OutputView
    - 콘솔에 출력할 문자열 포맷을 상수로 선언한다.
    - Calculator로부터 전달받은 연산 결과를 통해 문자열을 완성시켜 콘솔에 출력한다.

### Feat2: CalculatorController 구현

1. InputView를 통해 문자열을 받는다.
2. Validator를 통해 해당 문자열이 잘못된 문자열인지 판단한다. 잘못된 문자열이라면 `IllegalArgumentException` 을 발생시킨 후 애플리케이션을 종료시킨다.
3. 정상적인 문자열이라면 Extractor를 통해 숫자를 모두 뽑아 Calculator로 전달한다.
4. Calculator는 더하기 연산을 수행한 결과를 Controller로 반환한다.
5. OutputView로 연산 결과를 전달해, 출력 포맷을 완성시킨 후 콘솔에 출력한다.

### Feat3: Validator 구현

사용자가 잘못된 값을 입력하는 경우는 어떤 경우가 있을까?

1. 문자열이 숫자로 시작하지 않는데, 커스텀 구분자 선언부로 시작하지 않는 경우(공백 제외)
    1. “+2…”
    2. “//”로 시작했지만 뒤에 “\n”으로 끝나지 않는 경우
    3. “//\n”처럼 사이에 구분자가 존재하지 않는 경우
2. 끝까지 탐색해봐야 알 수 있는 경우
    1. 쉼표, 콜론, 정의된 커스텀 구분자 이외의 구분자가 등장한 경우
    2. 음수가 등장한 경우 → 커스텀 구분자로서 `-` 이외에 `-` 가 등장한 경우

유효성 검증에 실패하면  `IllegalArgumentException` 응답, 통과 시 Extractor 호출

### Feat4: Extractor 구현

1. 커스텀 구분자를 포함해 구분자를 정규 표현식으로 나타낸다.
2. 해당 구분자를 기준으로 문자열을 split 한다.
3. 반환한다.

### Feat5: Calculator 구현

1. Calculator는 Extractor로부터 숫자 모음을 받아온다.
2. 더하기 연산을 수행한다.
3. OutputView로 결과를 전송한다.

### 더 생각해볼 점

- Validator 구현에서, 사용자가 잘못된 값을 입력했다고 판단하는 조건이 더 있을지 생각해봐야 한다.