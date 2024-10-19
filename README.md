# java-calculator-precourse

### 주요 기능

- **케이스 판단 기능**:

  입력된 문자열의 수가 `1. , 과 : 로 구분되는 경우` 인지, `2. 커스텀 문자로 구분되는 경우` 인지 판단하는 기능

- **구분자 추출 기능**:

  숫자 구분에 사용 할 구분자를 추출하는 기능. 1번의 경우 `,|:` 를 반환하고, 2번의 경우 해당되는 커스텀 문자를 String값으로 반환한다.

- **구분자를 사용한 정수 추출 기능**:

  구분자를 사용하여 정수를 추출한다.

- **덧셈 기능**:

  추출된 정수를 모두 더하여 값을 도출한다.


### 예외 처리 기능

- 입력에서 빈 문자열이나 null이 입력 될 경우 IllegalArgumentException을 일으키도록 한다.
- 케이스 판단 기능에서, 첫 글자가 `정수`가 아니거나, `/`로 시작하지 않으면 IllegalArgumentException을 일으키도록 한다.
- 커스텀 구분자를 추출할 때 `\n`으로 정상적인 끝맺음이 이루어지지 않으면 IllegalArgumentException을 일으키도록 한다.
- 구분자를 사용하여 정수를 추출할 때, 추출된 정수가 정수가 아닌 값(음수, 문자열) 인 경우 IllegalArgumentException을 일으키도록 한다.