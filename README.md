# java-calculator-precourse

## 구현할 기능 목록

</br>
</br>

### InputView
   * 사용자에게 문자 입력 안내 메시지 출력
   * 사용자 입력을 받아 Controller로 전달

    (예시)
    덧셈할 문자열을 입력해 주세요.

   
</br>
</br>

### OutputView
   * 계산 결과를 출력

    (예시)
    결과 : 6
       
</br>
</br>

### CalCulatorController
   * InputView로부터 전달 받은 사용자 입력을 StringCalculatorValidator에게 전달
   * InputView로부터 전달 받은 사용자 입력을 StringCalculator에게 전달
   * Calculator로부터 전달받은 결과 값을 OutputView에게 전달

</br>
</br>

### StringCalculatorValidator
   * 사용자 입력이 올바른지 유효성을 검사

   > 커스텀 구분자

      1. 커스텀 구분자 양식이 올바른지 검사
      2. 커스텀 구분자를 사용하여 입력했는지 검사
      3. 양수만을 입력했는지 검사
   
   > 일반 구분자

      1. 올바른 일반 구분자를 입력했는지 검사
      2. 양수만을 입력했는지 검사

### StringCalculator
   * 사용자로부터 입력받은 문자열에서 구분자로부터 숫자를 분리
   * 분리한 숫자의 합 계산
   
    기본 구분자 : 쉼표(,), 콜론(:)
    커스텀 구분자 : 문자열 앞 "//"와 "\n" 사이에 위치하는 문자

</br>
</br>
