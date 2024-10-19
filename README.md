# java-calculator-precourse

---
## 1. 기능 요구 사항 분석
 - 입력되는 문자열에 대해 특정 형식에 부합하는지 판별할 수 있어야 한다.


 - 각 형식에 따라 정수만을 추출하여 덧셈을 할 수 있어야 한다.

## 2. 아이디어

- 문자열의 주어진 형식에 매칭되는지 판별하기 위해 정규식(Regular Expression) 을 사용한다.
- 각 형식마다 separator를 지정해 문자열을 파싱, 덧셈 연산을 수행 후 반환한다.

## 3. 구현할 기능 목록

1. 구현할 클래스는 application과 StringCalculator로 정한다.
2. application에서는 camp.nextstep.edu.missionutils.Console 라이브러리를 사용해 문자열을 입력받는다.
3. application에서는 StringCalculator가 수행한 덧셈 결과를 콘솔에 출력한다.
4. StringCalculator에서는 static method인 calculator를 구현한다.
5. StringCalculator.claculator()는 정규식을 이용해 두가지 패턴을 조사한다.
6. 각 패턴에 맞는 경우 구분자를 통해 문자열을 파싱한 후 덧셈을 수행, 반환한다.
7. 각 패턴에 맞지 않는 경우 IllegalArgumentException을 발생시킨다.