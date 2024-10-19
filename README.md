# java-calculator-precourse

### 기능 구현 목록

1. calculatorController를 통하여 계산기를 시작한다.
   1. calculatorController에서 run() 구현한다.

2. inputView를 구현한다.
   1. readLine() 을 통하여 입력값을 받아온다.

3. outputView를 구현한다.
   1. 처음 안내문구을 출력한다.
   2. 결과값을 출력한다.

4. inputText domain을 구현한다.
   1. 문자열과 구분자 리스트를 변수로 가지며, 생성자와 동시에 생성한다.
   2. 문자열과 구분자 리스트를 만드는 로직을 구현한다.

5. calculator domain을 구현한다.
   1. inputText를 숫자, 구분자 순서로 반복되는지 확인한다. 동시에 합산을 구한다
   2. text가 ""면 0을 바로 전달한다.
   3. 잘못 입력시 예외처리를 담당한다.
      1. 양수가 들어오지 않았을시 ex) "-1,2,3"
      2. 허가되지 않는 구분자 사용시 예외 발생 ex) "1,2?3", "//!\n1!2?3"