# java-calculator-precourse

## 구현할 기능 목록

1. **기본 구분자로 덧셈 연산 (',', ':')**
    - 사용자가 입력한 문자열을 쉼표(,)와 콜론(:)을 기준으로 분리한다.
    - 분리된 문자열을 숫자로 변환하고, 이를 모두 더한 결과를 반환한다.
    - 빈 문자열이 입력되면 0을 반환한다.
    - 숫자가 아닌 문자가 입력되거나 기본 구분자가 아닐 경우 에러 메시지 출력하고 종료한다.
    - 양수가 아닌 수가 포함되어있을 때, 에러 메시지 출력하고 종료한다.

2. **커스텀 구분자로 덧셈 연산**
    - 입력문 중에 "//"와 "\n" 사이에 정의한 구분자를 추출한다.
    - 커스텀 구분자가 여러 문자인 경우를 고려해, 구분자를 정확하게 분리한다.
    - 커스텀 구분자가 존재하는 경우, 기본 구분자인 쉼표(,)와 콜론(:)과 함께 해당 구분자를 사용해 숫자를 분리한다.
    - 커스텀 구분자가 없는 경우, 기본 구분자만을 사용한다.


3. **잘못된 입력에 대한 예외 처리**
    - 입력된 문자열에 잘못된 형식이나 구분자가 포함된 경우, IllegalArgumentException을 발생시켜 프로그램을 종료한다.
    - 양수가 아닌 수가 포함되어있을 때, 에러 메시지 대신 IllegalArgumentException을 발생시켜 프로그램을 종료한다.

4. **커스텀 구분자, 기본 구분자 동시 적용**
   - 커스텀 구분자가 없을 경우에 기본 구분자로도 덧셈을 할 수 있도록 수정한다.
   - Test Case 실행해, 프로그램 구현을 다시 확인한다. 
