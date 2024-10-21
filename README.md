# java-calculator-precourse :문자열 덧셈 계산기

### 입력한 문자열에서 숫자를 추출하여 더하는 계산기를 구현한다.

</br>

## 기능 목록

### 문자열을 입력받는다.

- 문자열은 구분자와 양수로 구성된다.

- 사용자로부터 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 입력받을 수 있다.

> 입력받은 문자열 앞부분의 "//"와 "\n" 사이에 위치하는 문자를 커스텀 구분자로 사용한다.

- 커스텀 구분자와 덧셈할 문자열을 한 줄로 입력받는다.
- 커스텀 구분자를 입력받고 다음 줄에서 덧셈할 문자열을 입력받는다.
- 커스텀 구분자를 입력받지 않은 경우 덧셈할 문자열만 입력받는다.


- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션이 종료된다.<br/>

  잘못된 값의 예시

    - 커스텀 구분자를 한 문자 넘게 입력한 경우
    - 지정된 구분자와 양수 외에 다른 문자를 입력한 경우

- 빈 문자열("")이 입력될 경우 0을 반환한다.

### 입력 문자열에서 커스텀 구분자를 추출한다.

- 커스텀 구분자를 입력받지 않은 경우에는 기본 구분자(쉼표, 콜론)을 기준으로 문자열을 분리한다.
- 커스텀 구분자를 입력받은 경우에는 기본 구분자와 커스텀 구분자를 기준으로 문자열을 분리한다.

### 입력 문자열에서 숫자를 추출한다.

> 기본 구분자 (쉼표(,)또는 콜론(:)) 와 커스텀 구분자를 기준으로 숫자를 추출한다.

### 추출된 숫자들에 대해 합을 계산한다.

### 계산 결과를 출력한다.

</br>

  
