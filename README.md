# java-calculator-precourse

### 구현할 기능 목록

</br>
</br>

> Calculator
   * 사용자로부터 입력받은 문자열에서 구분자로부터 숫자를 분리해내 합을 계산하는 기능
   
    기본 구분자 : 쉼표(,), 콜론(:)
    커스텀 구분자 : 문자열 앞 "//"와 "\n" 사이에 위치하는 문자

</br>
</br>

> InputView
   * 사용자에게 문자 입력을 안내하는 기능

    (예시)
    덧셈할 문자열을 입력해 주세요.

   
</br>
</br>

> OutputView
   * 사용자에게 계산 결과를 출력하는 기능 

    (예시)
    결과 : 6
       
</br>
</br>

> CalCulatorController
   * Calculator와 View(Input, Output)가 상호작용할 수 있도록 돕는 기능
   
    1. View 출력 지시
    2. Calculator 계산 지시
    3. 유효성 검사

</br>
</br>

> Validator
   * 사용자 입력이 올바른지 유효성을 검사하는 기능
   
    1. 입력한 숫자가 양수인지 확인
    2. 입력한 기본 구분자가 올바른지 확인
    3. 입력한 커스텀 구분자 양식이 올바른지 확인
