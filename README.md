# java-calculator-precourse

# 기능 요구사항

### 입력한 문자열에서 숫자를 추출하여 더하는 계산기를 구현한다.

- 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환한다.
    - 예: `"" => 0`, `"1,2" => 3`, `"1,2,3" => 6`, `"1,2:3" => 6`
- 앞의 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 `"//"`와 `"\n"` 사이에 위치하는 문자를 커스텀 구분자로 사용한다.
    - 예를 들어 `"//;\n1;2;3"`과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 `6`이 반환되어야 한다.
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.

### 입출력 요구 사항

#### 입력

구분자와 양수로 구성된 문자열

#### 출력

- 덧셈 결과

```
결과 : 6
```

#### 실행 결과 예시

```
덧셈할 문자열을 입력해 주세요.
1,2:3
결과 : 6
```

# 구현할 기능 목록

- [X] 계산기(애플리케이션)를 시작하는 기능

- [X] 문자열을 입력받기 전 사용자에게 입력을 요청하는 기능
    - [X] 사용자에게 입력을 요청하는 메시지를 출력하는 기능

- [X] 문자열을 입력받는 기능

- [X] 문자열을 구분자(`,` 혹은 `:`)로 나누는 기능

    - [X] 커스텀 구분자가 있는지 체크하는 기능
    - [X] 커스텀 구분자가 있는 경우 커스텀 구분자를 추출하는 기능
    - [X] 커스텀 구분자가 있는 경우 커스텀 구분자를 기준으로 문자열을 나누는 기능

- [X] 구분자로 나뉘어진 문자열에서 더할 숫자 문자를 추출하는 기능

    - [X] 추출한 문자열을 숫자로 변환하는 기능

- [X] 추출한 숫자를 더하는 기능

- [X] 더한 결과를 출력하는 기능

- [X] 사용자가 잘못된 값을 입력한 경우, 예외를 발생시키는 기능

    - [X] `IllegalArgumentException`을 발생시킴

# 예외 케이스

- [X] 사용자가 잘못된 값을 입력한 경우
-
    - [X] 커스텀 구분자가 있는데, 커스텀 구분자 앞에 다른 문자가 있는 경우
        - 잘못된 형식임
        ```
        예시 : 1//;\n4,5;6
        ```
    - [X] 커스텀 구분자(`//`와 `\n` 사이)에 숫자가 포함된 경우
        - 커스텀 구분자에 숫자가 포함되면 사용할 수 없는 숫자가 생기므로
        ```
        예시 : //1\n4,5;6
        ```
    - [X] 커스텀 구분자로 명시하지 않은 문자를 입력한 경우
        - 커스텀 구분자로 명시하지 않은 문자가 구분자로 사용될 수 없음
        ```
        예시 : 1//;\n4,5*6
        ```
    - [X] 커스텀 구분자에 이스케이프 문자가 포함된 경우
        - 다른 문자와 함께 사용되면, 예상치 않은 동작을 유발할 수 있음
        ```
        \0 과 1이 같이 사용될 경우
        \01 로 인식
        ```
    - [X] 음수를 입력한 경우(요구사항 - 입력이 양수로 구성)