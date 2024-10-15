# java-calculator-precourse

## 구현할 기능
**1. add number with basic delimiters**
 
쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환한다. (빈 문자열일 경우 0 반환)
 - 예: "" => 0, "1,2" => 3, "1,2,3" => 6, "1,2:3" => 6
  
**2. add number with custom delimiters**
 
앞의 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 "//"와 "\n" 사이에 위치하는 문자를 커스텀 구분자로 사용한다.
 - 예를 들어 "//;\n1;2;3"과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.

**3. handle incorrect input exception**

 사용자가 잘못된 값을 입력할 경우, IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.
 - 입력값이 음수이거나 이상한 구분자가 포함된 경우, 잘못된 값으로 간주

**4. Make clean structure using function**

 위의 구현한 기능들을 함수 형태로 구조화하여 보다 쉽게 관리가 가능하도록 하고자 한다. (다음과 같은 형태로 구조화)
- public static String delimiter = ",|:'
- public static String handleCustomDelimiter(String input)
- public static void calculateResult(String input)

**Test cases**
1. 1,2:3,4:5  -> 결과 : 15 (통과) 
2. 1,33*2:4:5 -> 잘못된 구분자 (*) IllegalArgumentException (실패)
3. //&\n1&23:31,4&55 -> 결과 : 114 (통과)
4. //@\n12@43:@@11,4 -> 잘못된 구분자 (@@) IllegalArgumentException (실패)
5. //;\n1;-4:3,124:2 -> 음수값 입력 IllegalArgumentException (실패)
6. 빈 문자열 입력 -> 결과 : 0 (통과)
7. //\\\n11,33\2:42:5 -> 결과 : 93 (통과) 
8. //?\n128,321?42?1 -> 결과 : 492 (통과)