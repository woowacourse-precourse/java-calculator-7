# java-calculator-precourse


### **CalculatorApplication**
  - [x] 객체를 생성한다.
  - [x] 의존성이 필요한 객체를 생성한다.
  - [x] 계산기를 작동시킨다.


### **View**

- **InputView**
    - [x]  사용자로부터 문자열을 입력받는다.
- **OutputView**
    - [x]  결과를 출력한다.


### **Model**

- **Delimiters**
    - [x]  커스텀 구분자가 숫자가 아닌 문자인지 검사한다.
    - [x]  커스텀 구분자를 추가로 구분자에 저장한다.
- **Numbers**
    - [x]  숫자를 저장한다.
- **Calculator**
    - [x]  숫자들을 더한다(계산한다).


### **Service**

 - **CustomDelimitersService**
    - [x]  커스텀 구분자 지정이 끝날 때 까지 반복하며 커스텀 구분자를 추가한다.
        - [x]  커스텀 구분자를 지정하는지 확인한다.
        - [x]  커스텀 구분자를 지정하는 포맷을 검사한다.
            - [x]  문자열의 길이가 5보다 크거나 같은지 검사한다
            - [x]  커스텀 구분자를 지정하는 앞 부분의 포맷이 올바른지 검사한다
            - [x]  커스텀 구분자를 지정하는 마지막 부분의 포맷이 올바른지 검사한다
            - [x]  Delimiters에 커스텀 구분자를 전달한다.
 - **NumberExtractionService**
    - [x]  문자열에서 구분자들을 기준으로 숫자들을 추출한다.
        - [x]  계산하려는 문자열이 digit으로 시작하는지 검사한다.
        - [x]  구분자들을 기준으로 문자열들을 추출한다.
        - [x]  문자열에 “+”, “-”를 포함하여 숫자 이외의 문자가 있는지 검사한다.
        - [x]  Numbers에 숫자를 전달한다.
 - **CalculatorService**
     - [x]  Numbers에 저장된 숫자를 calculator에 전달한다.


### **Controller**

- **Controller**
    - [x]  InputView로부터 입력을 받는다.
    - [x]  입력 문자열을 CustomDelimitersService로 전달한다.
    - [x]  반환된 문자열을 NumberExtractionService로 전달한다.
    - [x]  CalculatorService을 통해 결과를 계산한다.
    - [x]  OutputView로 계산 결과를 전달한다.



### **+추가적인 기능 요구 사항**

- 구분자는 하나의 문자이다.
- 구분자는 숫자가 될 수 없다.
- 커스텀 구분자 지정을 마친 후, 첫 문자는 반드시 숫자이다.
- 구분자가 연속으로 쓰일 때는 구분자와 구분자 사이에 숫자 0이 있는 것으로 취급되므로 잘못된 입력이 아니다.
- 여러 개의 커스텀 구분자를 지정할 수 있다. (e.g. //^\n//%\n6%5^2)