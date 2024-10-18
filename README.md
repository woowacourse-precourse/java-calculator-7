# java-calculator-precourse

---

## 문자열 덧셈 계산기 - 개요
- 구분자와 양수로 구성된 문자열을 입력하면 숫자를 추출하여 더한 결과를 출력하는 계산기입니다.
- 입력되는 개별 숫자의 최대 값은 `1000` 입니다.
- 입력되는 숫자의 총 개수는 최대 `30`개 입니다.
- 기본 구분자 : 쉼표 `,` 또는 콜론`:`을 사용합니다.
  - 구분자를 기준으로 분리한 각 숫자의 합을 출력합니다.
    - 예시 :
        ```
        "" => 0
        "1,2" => 3
        "1,2,3" => 6
        "1,2:3" => 6
        ```
- 커스텀 구분자 : 문자열 맨 앞에 "`//`"와 "`\n`" 사이에 위치하는 문자를 커스텀 구분자로 사용합니다.
  - 커스텀 구분자는 최대 3개까지 추가 가능합니다.
  - 커스텀 구분자를 지정해도 기본 구분자를 사용할 수 있습니다.
  - 커스텀 구분자로 복합문자를 지정할 수는 없습니다.
  - 대시 `-`, 역슬래시 `\ ` , 슬래시 `/` 문자와 숫자는 구분자로 사용할 수 없습니다.
    - 적용 예시
      - `//;\n1;2;3` 입력 시 커스텀 구분자는 `;`, 결과 값은 `6`
      - `//;\n1,2;3:5` 입력 시 커스텀 구분자는 `;`, 결과 값은 `10`
      - `//a;+\n1;2a3+5` 입력 시 커스텀 구분자는 `a`,`;`,`+` 결과 값은 `11`
      - `//-\n1-2-3` 입력 시 어플리케이션 종료
- 잘못된 값을 입력할 경우 어플리케이션이 종료됩니다.

### 실행 결과 예시
```
  덧셈할 문자열을 입력해 주세요.
  문자열은 구분자와 양수로만 입력가능합니다.
  1,2:3
  결과 : 6
```

### 에러 코드
`[Fnnnn]` : 입력값의 형식 오류   
`[Rnnnn]` : 입력값의 제한 범위 초과 오류

### 실행 환경
- `JDK 21`
- `Application`의 `main()`에서 시작

### 라이브러리
  - `camp.nextstep.edu.missionutils`

---

## 기능 목록
- [v] 사용자에게 문자열을 입력받는다
- 입력된 문자열의 유효성을 검증한다
  - ~~[v] 문자열의 마지막 문자는 무조건 숫자~~
  - ~~[v] 문자열의 시작 문자는 숫자이거나 `/`~~
  - [v] 입력받은 문자로 객체를 생성한다
  - [v] 생성된 입력 데이터 객체에서 구분자 유무를 확인하고 구분자 객체를 생성한다
  - 커스텀 구분자 입력 형식 검증
    - `//`와 `\n` 의 형식을 갖추지 않으면 예외
    - `-`,`\ `, `/`, 숫자가 구분자로 입력되면 예외
    - 구분자가 3개를 초과하면 예외
- 유효한 입력에서 숫자를 추출한다
  - 구분자를 기준으로 입력되는 숫자 하나의 최대 값 : 1000
  - 숫자의 최대 개수 : 30
- 추출한 숫자를 더한다
- 결과 값을 출력한다

## 테스트 목록
- 문자열 입력
  - 유효성 검증 - 구분자, 연산자 공통
    - [v] 문자열의 마지막 문자가 숫자가 아니면 예외를 던진다
    - [v] 문자열의 마지막 문자가 숫자라면 예외를 던지지 않는다
    - **임시**
      - [v] 문자열의 시작 문자가 `/`나 숫자가 아니면 예외를 던진다
      - [v] 문자열의 시작 문자가 `/`나 숫자라면 예외를 던지지 않는다
    - **TO DO**
    - [v] 사용자의 입력을 받으면 `InputData` 객체를 생성하는지 확인한다
    - [v] `InputData` 객체에서 구분자가 있으면 `CustomDelimiter` 객체를 생성하는지 확인한다
    - [v] `InputData` 객체에서 구분자가 있으면 `DefaultDelimiter` 객체를 생성하는지 확인한다
    - [v] 구분자와 연산부위가 제대로 나누어지는지 확인한다
      - 문자열의 시작 문자
        - ~~[v] 커스텀 구분자가 없는 경우 숫자로 시작하지 않으면 예외를 던진다~~
        - ~~커스텀 구분자가 있는 경우 `/`로 시작하는지 않으면 예외를 던진다~~
          - [v] 커스텀 구분자의 패턴을 `/`로 시작하는 것으로 구현하여 테스트 삭제
    - 커스텀 구분자가 `//`와 `\n` 사이에 지정되지 않으면 예외를 던진다
    - 커스텀 구분자가 3개를 초과하면 예외를 던진다
    - 커스텀 구분자에 `-`,`\ `, `/`, 숫자가 포함되면 예외를 던진다
  - 정상 검증
    - 문자열의 마지막 문자가 숫자인지 확인
    - 문자열의 시작 문자
      - 커스텀 구분자가 없는 경우 숫자로 시작하는지 확인
      - 커스텀 구분자가 있는 경우 `/`로 시작하는지 확인
    - 커스텀 구분자가 `//`와 `\n` 사이에 올바르게 입력되었는지 확인
    - 커스텀 구분자가 3개 이하인지 확인
    - 커스텀 구분자에 `-`,`\ `, `/`, 숫자가 포함되지 않는지 확인
- 데이터 파싱
  - 유효성 검증
    - 개별 숫자의 값이 음수이거나 1000을 초과하면 예외를 던진다
    - 숫자의 최대 개수가 30을 초과하면 예외를 던진다
  - 정상 검증
    - 개별 숫자의 값이 0 이상 1000이하인지 확인
    - 숫자의 개수가 0개 이상 30개 이하인지 확인
- 계산
  - 정상 검증
    - 0개가 입력되면 계산 값은 0
    - 1개가 입력되면 계산 값은 입력값과 같다
    - 2개이상이 입력되면 계산 값은 입력된 전체 숫자의 합과 같다
