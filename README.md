# java-calculator-precourse

## 기능 요구 사항

#### 1. 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환한다.
```
String delimiter = ",|:";
String[] inputNumbers = input.split(delimiter);
```
',' 와 ':' 를 delimiter로 구분하고, input으로 입력 받은 string을 delimiter기준으로 분할한다.
```
if(input.isEmpty()){
            System.out.println("result : 0" );
            return;
        }
```
문자열이 입력되지 않았을 때 결과를 0으로 처리한다.
```
int sum = 0;
for (String numberString : inputNumbers) {
            if (numberString.trim().isEmpty()) continue;
            int number = Integer.parseInt(numberString.trim());
            sum += number;
}
System.out.println("result : " + sum);
```
합산을 저장할 변수를 지정하고, 한글자씩 추출해 합산후 결과를 출력한다.

#### 2. 앞의 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 "//"와 "\n" 사이에 위치하는 문자를 커스텀 구분자로 사용한다.
```
if (input.startsWith("//")) {
            int endIndex = input.indexOf("\\n");
            String customDelimiter = input.substring(2, endIndex);
            delimiter += "|" + Pattern.quote(customDelimiter);
            input = input.substring(endIndex + 2);
        }
```
문자열 시작이 "//"라면, "\n" 앞에 있는 커스텀 구분자를 구분하기 위해 substring으로 customdelimiter를 추출한다.

* indexOf에서 단순히 "\n"를 사용하면 개행문자로 인식하기 때문에 "\\n"으로 개행문자가 아닌 문자열임을 인식하게끔 한다.

기존 delimiter의 정규표현식에 "|"와 customdelimiter를 추가해 기존 구분자를 삭제하지 않고 구분자 개수를 늘리는 방식으로 진행한다.

이후 input을 "\\n"값 이후로 설정해 커스텀 구분자를 지정하기 위해 사용했던 문자들을 제거한다.

#### 3. 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.
```
try {
  int number = Integer.parseInt(numberString.trim());
  if (number < 0) {
    throw new IllegalArgumentException("invalid value(negative integer)" + number);
  }
  sum += number;
} catch (IllegalArgumentException e) {
    System.out.println("invalid value(not integer)");
    return;
}
```
입력값이 음수일때와 숫자가 아닌 값이 들어오면 IllegalArgumentException이 발생한다.


