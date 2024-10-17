# java-calculator-precourse

## 📌 프로그래밍 요구사항
***
1. **JDK 21 버전에서 실행 가능해야 한다.**
2. **프로그램 실행의 시작점은 Application의 main() 이다.**
3. **build.gradle 파일은 변경할 수 없으며, 제공된 라이브러리 이외의 외부 라이브러리는 사용하지 않는다.**
4. **프로그램 종료 시 System.exit()를 호출하지 않는다.**
5. **프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 등의 이름을 바꾸거나 이동하지 않는다.**
6. **자바 코드 컨벤션을 지키면서 프로그래밍한다.**
7. **기본적으로 Java Style Guide를 원칙으로 한다.**

### 라이브러리
1. **camp.nextstep.edu.missionutils에서 제공하는 Console API를 사용하여 구현해야 한다.**
2. **사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.**
***


## 🙋🏻‍♂️ 기능 요구 사항
***
###  입력한 문자열에서 숫자를 추출하여 더하는 계산기를 구현한다.

1. _**쉼표(,) 또는 콜론(:)**_ 을 구분자로 가지는 문자열을 전달하는 경우 _**구분자**_ 를 기준으로 분리한 각 숫자의 합을 반환한다.
```
예: "" => 0, "1,2" => 3, "1,2,3" => 6, "1,2:3" => 6
```
2. 앞의 기본 구분자(쉼표, 콜론) 외에 _**커스텀 구분자**_ 를 지정할 수 있다. <br>
3. 커스텀 구분자는 문자열 앞부분의 **"//"** 와 **"\n"** 사이에 위치하는 문자를 커스텀 구분자로 사용한다. <br>
4. 예를 들어 "//;\n1;2;3"과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다. <br>
5. 사용자가 잘못된 값을 입력할 경우 _**IllegalArgumentException**_ 을 발생시킨 후 애플리케이션은 _**종료**_ 되어야 한다.
***

### 입출력 요구 사항
#### 입력
구분자와 양수로 구성된 문자열 : **ex) 기능 요구 사항 1번 예시 참조**
#### 출력
* 덧셈 결과
```
결과 : 6
```
#### 실행 결과 예시
```
덧셈할 문자열을 입력해 주세요.
1,2:3
결과 : 6
```


# 프로그램 흐름 및 구현할 기능 목록
***
## 프로그램 흐름
1. **Console.readLine()호출 ** (사용자가 문자를 입력)
    - 입력된 문자를 **Calculator** 생성자 매개변수로 전달
3. **Calculator.run()** 호출 (계산기 시작)
4. **checkCustomToken(String input)** 호출 (커스텀 구분자가 있는지 확인) <br>
   **커스텀 구분자 유무에 따라 아래 상황 진행**

```
> No : 구분자로 쉼표(,), 콜론(:)만을 사용. 이후 5번 진행
> Yes : 구분자로 쉼표(,), 콜론(:)과 함께 커스텀 구분자를 넣어줌. 이후 5번 진행
```
5. **executeParsingInput(String input, String token)** 호출
    - **splitAsToken(String input, String token)** (구분자에 따라 입력된 문자열을 분리하여 문자열 배열에 담음)
    - **parseIntArray(String[] inputArray)** (분리된 배열을 순회하며 입력된 문자가 유효한지 검증,<br>
      만약 유효하다면 String 배열을 int 배열로 파싱하여 반환) <br>
      **입력된 문자의 유효성에 따라 아래 상황 진행** <br>

```
> No : IllegalArgumentException 을 발생시킨 후 애플리케이션 종료
> Yes : 순회. 단, 순회가 끝나면 6번 진행
```

6. **sumArray(int[] intArray)** (반환된 정수 배열 합산하여 반환)
7. **printSum(int result)** (합산된 정수 출력)
***


## 구현 ✅&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 미구현 ❎

### _**Calculator Class**_
#### ❎ void run()
계산기 실행 기능
#### ❎ String checkCustomToken(String input)
커스텀 구분자 확인 및 구분자 반환 기능
#### ❎ int sumArray(int[] intArray)
정수 배열 합산 기능
#### ❎ void printSum(int result)
합산된 정수 출력 기능
***

### _**ParsingInput Class**_
#### ❎ int[] executeParsingInput(String input, String token)
ParsingInput 실행 기능
#### ❎ String[] splitAsToken(String input, String token)
구분자에 따라서 입력된 문자열 분리 기능
#### ❎ int[] parseIntArray(String[] inputArray)
분리된 문자열을 정수형 배열로 변환 및 입력 값 검증 기능
***
