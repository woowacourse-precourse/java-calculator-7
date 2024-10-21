# java-calculator-precourse
### 프리코스 1주차 [오예현]
# 🔆 문자열 덧셈 계산기
입력한 문자열에서 숫자를 추출하여 더하는 계산기를 구현한다.

## ✅ 기능 요구사항
- `,`와 `:`을 구분자로 하여 문자열 전달한다.  
    > `"1,2:3" => 6`

- `//`과 `\n` 사이 `커스텀 구분자` 사용할 수 있다.   
    > `"//;\n1;2;3" => 6` : `;`가 커스텀 구분자로 사용됨  

- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생 후 종료된다.  

## ✅ 입출력 요구사항

- 입력 : `구분자`와 `양수`로 구성된 문자열  


- 출력 : `덧셈 결과`


- 실행 결과

    ```
    덧셈할 문자열을 입력해 주세요.
    1,2:3
    결과 : 6
    ```

## ☑️ 구현할 기능 목록

- [x] 커스텀 구분자가 있는지 확인하는 함수  


- [x] 커스텀 구분자를 문자열에서 분리하는 함수


- [x] 빈 문자열인지 확인하는 함수


- [x] 구분자로 분리하여 숫자 추출하는 함수  


- [x] 추출한 숫자가 음수인지 확인하는 함수


- [x] 추출한 숫자를 더하는 함수

 
- [x] 출력 형식대로 출력하는 함수  

# ⭐TDD 개발 방식을 적용하기!

## **질문**

1. 사용자 입력에서 숫자를 올바르게 추출할 수 있나?  


2. 추출한 숫자들을 더하여 올바른 결과가 나오나? 


3. 커스텀 구분자가 올바르게 인식되나?


4. 사용자 입력이 잘못됐을 경우, `IllegalArgumentException`이 발생되나?


5. 빈 문자열을 입력했을 때, 결과가 0으로 나오나?


6. 음수가 포함되었을 경우, `IllegalArgumentException`이 발생되나?


7. 출력 형식이 올바르게 나오나?



## **응답**

### **1. 사용자 입력에서 숫자를 올바르게 추출할 수 있나?**

```
class ApplicationTest extends NsTest {
  @Test
  @DisplayName("쉼표와 콜론으로 구분된 문자열에서 숫자 추출")
  void 숫자_추출_테스트() {
    String input = "1,2,3";
    int[] result = Application.extractNumbers(input, Application.separators);
    assertThat(result).contains(1, 2, 3);
  }
}
```

`Application.extractNumbers`와 `Application.separators` 를 찾을 수 없어 테스트에 실패하게 된다.  
=> `Application` 클래스에 숫자를 추출하는 `extractNumbers`와 기본 구분자(`,`, `:`)를 담는 `separators`를 만들어주어 해당 테스트가 `green`을 띄도록 해준다.

```
public class Application {
  public static List<String> separators = new ArrayList<>(Arrays.asList(",", ":"));

  public static int[] extractNumbers(String input, List<String> separators) {
      String separatorsRegex = String.join("|", separators);
      return Arrays.stream(input.split(separatorsRegex))
              .map(String::trim)
              .mapToInt(Integer::parseInt)
              .toArray();
}
```

기본 정규식을 담는 리스트인 `separators`를 생성한다.

그리고 구분자를 담는 정규식을 `separatorsRegex`로 저장하여, `split` 하여 추출한 숫자를 `int 배열`로 바꿔서 원하는 숫자를 추출할 수 있도록 하는 `extractNumbers` 메서드를 생성한다.

> **_[🔥짚고 넘어갈 부분!!]_**  
>
> _-` throw new Error( )`는 좋지 않다!_  
 _에러를 발생시킬 때 사용하는 `throw new Error( )`보다 명시적인 예외를 사용하는 것이 좋다. `Error`는 주로 `JVM의 심각한 오류`에 사용되므로, 논리적인 오류 처리에는 `IllegalArgumentException` 같은 적절한 예외 타입을 사용하는 것이 좋다._
>
> _-`separatorsRegex`로 기본 구분자를 정규식으로 저장한 것이 아니라 `separators` 로 따로 저장해서 `join` 해준 이유?_  
_기본 구분자를 그 상태로 그대로 저장하고 싶었기 때문이다. 이후에 기본 구분자를 추가할 때도, 정규식을 통째로 다시 저장하는 것이 아니라 이 리스트에 추가해주기만 하면 된다._

### **2. 추출한 숫자들을 더하여 올바른 결과가 나오나?**

```
class ApplicationTest extends NsTest {
...
  @Test
  @DisplayName("배열의 모든 숫자를 더함")
  void 더하는_기능_테스트() {
    int[] input = {1, 2, 3};
    int result = Application.sum(input);
    assertThat(result).isEqualTo(6);
  }
}
```

`Application.sum`을 찾을 수 없어 테스트에 실패하게 된다.  
=> `Application` 클래스에 추출한 숫자들을 더하는 `sum` 함수를 만들어주어 해당 테스트가 `green`을 띄도록 해준다.

```
public class Application {
...
  public static int sum(int[] numbers) {
    return Arrays.stream(numbers).sum();
  }
}
```

`sum` 함수를 생성한다.

### **3. 커스텀 구분자가 올바르게 인식되나?**

```
class ApplicationTest extends NsTest {
...
  @Test
  @DisplayName("커스텀 구분자를 사용한 문자열 덧셈")
  void 커스텀_구분자_사용_테스트1() {
    assertSimpleTest(() -> {
      run("//;\\n1");
      assertThat(output()).contains("1");
    });
  }
    
  @Test
  void 커스텀_구분자_사용_테스트2() {
    assertSimpleTest(() -> {
      run("//.\\n1");
      assertThat(output()).contains("1");
    });
  }
    
  @Test
  void 커스텀_구분자_사용_테스트3() {
    assertSimpleTest(() -> {
      run("//\\t\\n1\\t2\\t3,4");
      assertThat(output()).contains("10");
    });
  }
}
```

우선 커스텀 구분자를 지정하는 형식인 `//(커스텀\_구분자)\\n` 을 구별할 수 없어 테스트에 실패하게 된다.  
=> 커스텀 구분자를 인식하여 `separators` 리스트에 추가해 주며 해당 테스트가 `green`을 띄도록 해준다.

```
public class Application {
...
  public static final String CUSTOM_SEPARATOR_START = "//";
  public static final String CUSTOM_SEPARATOR_END = "\\\\n";
  public static final String CUSTOM_FORMAT = CUSTOM_SEPARATOR_START + "(.*?)" 
                                              + CUSTOM_SEPARATOR_END + "(.*)";

  public static boolean hasCustomSeparator(String input) {
    return input.startsWith(CUSTOM_SEPARATOR_START);
  }

  public static String parseCustomSeparator(String input, List<String> separators) {
    Matcher matcher = Pattern.compile(CUSTOM_FORMAT).matcher(input);

    if (matcher.find()) {
      String customSeparator = matcher.group(1);  // 커스텀 구분자
      String remainingInput = matcher.group(2);  // 나머지 문자열

      separators.addFirst(Pattern.quote(customSeparator));
      return remainingInput;
    }
    throw new IllegalArgumentException("커스텀 구분자 형식이 틀렸습니다.");
  }
}
```

`//(.*?)\\\\n(.*)` 이 정규식은 `//`과 `\\\\n`사이의 문자와 `\\\\n` 뒤의 문자를 저장하여 각각 `customSeparator`와 `remainingInput`으로 설정할 수 있게 한다.

그리고 `customSepatator`를 `separators` 리스트에 추가해 준다.

만약 `matcher`를 찾을 수 없으면, 커스텀 구분자 형식이 잘못되었으므로 `IllegalArgumentException`을 발생시킨다.

> **_[🔥짚고 넘어갈 부분!!]_**
>
> _-`\\n`이 아니라 `\\\\n`인 이유?_  
_이스케이프 문자이기 때문에 `\`은 `\\`로 입력을 해야 한다. 따라서 터미널에 `\n`를 입력하면 내부적으로 `\\n`으로 저장이 되고, 이를 찾으려면 `\\n`은 `\\\\n`으로 입력해야 하므로 `\\\\n`으로 찾아야 내부적으로 `\\n`으로 인식되어 찾을 수 있다._  
>
> _- `Pattern.quote`를 사용한 이유?_  
_커스텀 구분자가 `.`이면 `separators` 리스트에 저장되어 `|`로 조인되어 정규식으로 사용될 때, 모든 문자를 뜻하는 정규식 문자 `.`이랑 구분할 수가 없어 모든 문자열을 빈 문자열로 치환해 버리는 문제가 발생하였다. 이뿐 아니라 `.`, `\t`, `(` 등 정규식에서 사용되는 문자들을 각각 어떻게 처리해야 하지 고민하다가 찾아낸 문법이 `Pattern.quote`이다. 이 문법은 정규식에서의 특수 문자로 처리하지 않고 그냥 문자열 그대로 저장한다! 따라서 이를 통해 문제를 해결할 수 있었다._
>
> _- `CUSTOM_FORMAT`을 한 번에 정규식으로 저장하지 않고, `CUSTOM_SEPARATOR_START`와 `CUSTOM_SEPARATOR_END`로 나눠서 저장하여 합친 이유?_
_`CUSTOM_SEPARATOR_START`와 `CUSTOM_SEPARATOR_END`를 상수로 따로 저장하여, 커스텀 구분자를 설정하는 형식이 바뀌더라도 각각 재설정할 수 있게 하였고, 이를 조합하여 `CUSTOM_FORMAT`으로 만들어 정규식의 가독성을 높이려고 했다._

### **4. 사용자 입력이 잘못됐을 경우, `IllegalArgumentException`이 발생되나?**

```
class ApplicationTest extends NsTest {
...
  @Test
  @DisplayName("잘못된 형식의 문자열에 대한 예외 발생")
  void 형식에_맞지_않는_문자열_테스트1() {
    assertSimpleTest(() ->
      assertThatThrownBy(() -> runException("aks3lii1ndm"))
      .isInstanceOf(IllegalArgumentException.class)
    );
  }
    
  @Test
  void 형식에_맞지_않는_문자열_테스트2() {
    assertSimpleTest(() ->
      assertThatThrownBy(() -> runException("1,,2,3"))
      .isInstanceOf(IllegalArgumentException.class)
    );
  }
    
  @Test
  void 형식에_맞지_않는_문자열_테스트3() {
    assertSimpleTest(() ->
      assertThatThrownBy(() -> runException("//\\n1234"))
      .isInstanceOf(IllegalArgumentException.class)
    );
  }
    
  @Test
  void 형식에_맞지_않는_문자열_테스트4() {
    assertSimpleTest(() ->
      assertThatThrownBy(() -> runException("//3\\n13233"))
      .isInstanceOf(IllegalArgumentException.class)
    );
  }
}
```

입력된 문자열 형식이 잘못되었을 경우, 커스텀 구분자가 공백(아무것도 없음)인 경우, 커스텀 구분자가 숫자인 경우에 원하는 `IllegalArgumentException`이 발생하지 않아 테스트에 실패하게 된다.  
=> 각각 `IllegalArgumentException`이 발생하도록 오류를 직접 발생시켜 해당 테스트가 `green`을 띄도록 해준다.

> **_[🔥짚고 넘어갈 부분!!]_**
>
> _- 커스텀 구분자가 `숫자`이면 안 되는 이유?_  
 _만약에 커스텀 구분자가 `3`이고 문자열이 `132333`이면 같은 `3`을 구분자 `3`인지, 더하고 싶은 숫자 `3`인지 어떻게 구별할 수 있을까 하고 정말 많이 고민했다. 아무리 고민해도 `[1, 2, 33]` 인지 `[1, 23, 3]`인지 구별할 수 없을 거 같아 커스텀 구분자로 숫자를 입력해도 `IllegalArgumentException`을 발생시키기로 했다._

```
public class Application {
...
  public static int[] extractNumbers(String input, List<String> separators) {
    try {
      String separatorsRegex = String.join("|", separators);
      return Arrays.stream(input.split(separatorsRegex))
              .map(String::trim)
              .mapToInt(Integer::parseInt)
              .toArray();
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException("숫자가 아닌 문자가 포함되어 있습니다.");
    }
  }

  public static String parseCustomSeparator(String input, List<String> separators) {
    Matcher matcher = Pattern.compile(CUSTOM_FORMAT).matcher(input);

    if (matcher.find() && !matcher.group(1).isEmpty()) {
      String customSeparator = matcher.group(1);  // 커스텀 구분자
      String remainingInput = matcher.group(2);  // 나머지 문자열

      if (!Character.isDigit(customSeparator.charAt(0))) {
        separators.addFirst(Pattern.quote(customSeparator));
        return remainingInput;
      }
    }
    throw new IllegalArgumentException("커스텀 구분자 형식이 틀렸습니다.");
  }
}
```

사용자 입력이 올바르지 않아 `input.split(separatorsRegex)` 과정에서 추출한 배열에 숫자가 아닌 문자가 담겨 있을 수 있다. 그렇다면, `mapToInt(Integer::parseInt)` 과정에서 `NumberFormatException` 이 발생하기 때문에 이 오류를 `catch` 하여 요구사항에 말하는 `IllegalArgumentException`을 발생시킨다.

그리고 `parseCustomSeparator` 함수에 `!matcher.group(1).isEmpty( )` 조건문을 추가하여, 커스텀 구분자가 없는 경우와 `Character.isDigit(customSeparator.charAt(0)` 조건문을 추가하여 커스텀 구분자가 숫자인 경우 모두 `IllegalArgumentException`을 발생시킨다.

### **5. 빈 문자열을 입력했을 때, 결과가 0으로 나오나?**

```
class ApplicationTest extends NsTest {
...
  @Test
  @DisplayName("빈 문자열 입력 시 결과는 0")
  void 빈문자열_테스트() {
    assertSimpleTest(() -> {
      run("\n");
      assertThat(output()).contains("0");
    });
  }
}
```

단순히 아무 입력 하지 않고 엔터(`\n`)만 쳤을 때 0으로 계산되지 않아 테스트가 실패하게 된다.  
=> 아무것도 입력하지 않더라도 `0`으로 출력되도록 하여 해당 테스트가 `green`을 띄도록 해준다.

```
public class Application {
...
  public static boolean inputIsEmpty(String input) {
    return input == null || input.trim().isEmpty();
  }

  public static int calculateSum(String input, List<String> separators) {
    if (inputIsEmpty(input)) {
      return 0;
    }

    if (hasCustomSeparator(input)) {
      input = parseCustomSeparator(input, separators);
    }

    int[] numbers = extractNumbers(input, separators);
    return sum(numbers);
  }
}
```

처음에 `input`을 받고, 해당 `input`이 비었는지 확인하는 `inputIsEmpty`함수를 추가하여 비었으면 합계로 `0`을 리턴하도록 하였다.

### **6. 음수가 포함되었을 경우, `IllegalArgumentException`이 발생되나?**

```
class ApplicationTest extends NsTest {
...
  @Test
  @DisplayName("음수 포함 시 예외 발생")
  void 음수_포함_예외_테스트() {
    assertSimpleTest(() ->
      assertThatThrownBy(() -> runException("-1,2,3"))
      .isInstanceOf(IllegalArgumentException.class)
   );
 }
}
```

음수가 입력됐을 때 `IllegalArgumentException`이 발생하지 않아 테스트가 실패하게 된다.  
=> 숫자가 음수이면 `IllegalArgumentException`을 발생시켜 해당 테스트가 `green`을 띄도록 해준다.

```
public class Application {
...
  public static int[] extractNumbers(String input, List<String> separators) {
    try {
      String separatorsRegex = String.join("|", separators);
      return Arrays.stream(input.split(separatorsRegex))
              .map(String::trim)
              .mapToInt(Integer::parseInt)
              .peek(Application::validateNonNegative)
              .toArray();
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException("숫자가 아닌 문자가 포함되어 있습니다.");
    }
  }

  public static void validateNonNegative(int number) {
    if (number < 0) {
      throw new IllegalArgumentException("음수는 허용되지 않습니다: " + number);
    }
  }
}
```

`extractNumbers` 함수에 `peek(Application::validateNonNegative)`를 추가해서, 음수이면 `IllegalArgumentException`을 발생시키는 `validateNonNegative` 함수를 실행하여 각각 숫자들이 음수인지 확인하도록 한다.

### **7. 출력 형식이 올바르게 나오나?**

```
class ApplicationTest extends NsTest {
...
  @Test
  @DisplayName("출력 형식이 올바르게 표시됨")
  void 출력_형식_테스트() {
    assertSimpleTest(() -> {
      run("///\\n1/2,3:4");
      assertThat(output()).contains("덧셈할 문자열을 입력해 주세요.");
      assertThat(output()).contains("결과 : 10");
    });
  }
}
```

출력 결과가 요구사항과 같은 형식으로 출력되지 않아 테스트가 실패하게 된다.  
=> 요구사항에 따른 출력 결과대로 출력하도록 하여 해당 테스트가 `green`을 띄도록 해준다.

```
public class Application {
...
  public static void printInstructions() {
    System.out.println("덧셈할 문자열을 입력해 주세요.");
  }

  public static void printResult(int sumValue) {
    System.out.println("결과 : " + sumValue);
  }
    
  public static void main(String[] args) {
    printInstructions();
    String input = readLine();
    int sumValue = calculateSum(input, separators);
    printResult(sumValue);
  }
}
```

`덧셈할 문자열을 입력해 주세요.`를 출력하는 `printInstructions` 함수와 `결과 : (결과값)`을 출력하는 `printResult` 함수를 만들어주어, `main`함수에서 요구사항의 출력 결과대로 출력하도록 하였다.

## **정제**

```
class ApplicationTest extends NsTest {
...
  @ParameterizedTest(name = "커스텀 구분자: \"{0}\" -> 결과: {1}")
  @CsvSource({
          "'//;\\n1', 1",
          "'//.\\n1', 1",
          "'//\\t\\n1\\t2\\t3,4', 10"
  })
  @DisplayName("커스텀 구분자를 사용한 문자열 덧셈")
  void 커스텀_구분자_사용_테스트(String input, int expectedSum) {
    assertSimpleTest(() -> {
      run(input);
      assertThat(output()).contains("결과 : " + expectedSum);
    });
  }

  @ParameterizedTest(name = "잘못된 입력: \"{0}\"")
  @CsvSource({
          "'aks3lii1ndm'",
          "'1,,2,3'",
          "'//\\n1234'",
          "'//3\\n13233'"
  })
  @DisplayName("잘못된 형식의 문자열에 대한 예외 발생")
  void 형식에_맞지_않는_문자열_테스트(String input) {
    assertSimpleTest(() ->
      assertThatThrownBy(() -> runException(input))
      .isInstanceOf(IllegalArgumentException.class)
    );
  }
}
```

`JUnit5`의 `ParameterizedTest`를 사용하여 중복된 패턴을 제거하고 유사한 테스트를 그룹화하였다.

![스크린샷 2024-10-18 231131](https://gist.github.com/user-attachments/assets/f73a0ea5-b1fb-43e0-89c5-ece92b117de2)

모든 테스트 케이스를 통과하였다 ~~~~~~~~~ !!