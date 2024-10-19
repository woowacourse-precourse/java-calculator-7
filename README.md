# java-calculator-precourse

## 기능 요구 사항

입력한 문자열에서 숫자를 추출하여 더하는 계산기를 구현한다.

- 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환한다.
  - 예: "" => 0, "1,2" => 3, "1,2,3" => 6, "1,2:3" => 6
- 앞의 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 "//"와 "\n" 사이에 위치하는 문자를 커스텀 구분자로 사용한다.
  - 예를 들어 "//;\n1;2;3"과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.

- 입력 : 구분자와 양수로 구성된 문자열
- 출력 : 덧셈 결과 
  - 예: 결과 : 6

-----------

## 기능 목록 

1. 문자열 입력 받기
2. 기본 구분자(, :)를 기준으로 숫자 추출
3. 커스텀 구분자 지정 기능
    - "//" 와 "\n" 사이에 커스텀 구분자로 사용
      - 커스텀 구분자와 기본 구분자를 구별하기
        - 문자열 시작이 "//"인지 아닌지로 구별?
        - 커스텀 구분자가 있다면 `//` 와 `\n` 사이에 위치한 문자열을 구분자로 추출
        - 없다면 기본 구분자로만 추출
4. 추출한 숫자 덧셈 기능
5. 입력값 검증
    - 빈 문자열은 0으로 반환
    - 음수값 예외 처리
    - 유효하지 않은 값 예외 처리
6. 예외 처리
    - 잘못된 값을 입력할 경우 `IllegalArgumentException` 발생시키고 종료
7. 결과 출력

------------

## 코드 작성 중 헷갈렸던 문제들

```java
// 커스텀 구분자인지 확인
if (input.startsWith("//")) {
    int delimiterEndIndex = input.indexOf("\n"); //
    customDelimiter = input.substring(2, delimiterEndIndex); //
    numbersPart = input.substring(delimiterEndIndex + 2); //

    // 로그 출력
    System.out.println("Custom delimiter: " + customDelimiter);
    System.out.println("Numbers part: " + numbersPart);
}
```

이렇게 코드 작성시 테스트 코드`커스텀_구분자_사용()`가 계속 에러발생 ..

```java
@Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }
```

에러 원인은 `delimiter`의 `index`가 `-1`이 나오고 있어서 범위 밖이라는 에러.

```java
java.lang.StringIndexOutOfBoundsException: Range [2, -1) out of bounds for length 6
	at java.base/jdk.internal.util.Preconditions$1.apply(Preconditions.java:55)
```

> `\n`과 `\\n` 의 차이

* `\n` : 줄바꿈 문자
* `\\n` : 문자열로써 두 개의 문자 `\`와 `n`을 의미

> `run("//;\\n1")`와 `run("//;\n1;2;3")`의 

1. `run("//;\\n1")`의 경우 :
    
    * `\\n`은 문자 그대로 `\` 와 `n`
    * `input.indexOf("\\n")` 을 했을 때, 이 코드는 문자열에서 문자열 `\\n`을 찾음

2. `run("//;\n1;2;3")`의 경우 :
    
    * `\n`은 줄바꿈 문자
    * `input.indexOf("\n")`라고 했을 때, 이 코드는 문자열에서 실제 줄바꿈을 찾