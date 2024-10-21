# java-calculator-precourse

### 1주차 미션

# 🔎 **문자열 덧셈 계산기 구현**
 입력한 문자열에서 숫자를 추출하여 더하는 계산기를 구현한다.
 <br>
 <br>

📌구현할 기능 목록

- 안내 멘트 출력 <br>
"덧셈할 문자열을 입력해 주세요."라는 메시지를 사용자에게 출력한다.

- 입력값 처리 <br>
사용자로부터 문자열을 입력받는다.
입력값의 앞뒤 공백을 제거한다.
입력된 문자열이 null인지 확인하고, null일 경우 IllegalArgumentException을 발생시켜 프로그램을 종료한다.
음수를 입력한 경우 예외처리
빈 문자열("")이 입력된 경우 0을 반환한다.

- 커스텀 구분자 처리 <br>
입력값에 커스텀 구분자가 포함되어 있는지 확인한다.
커스텀 구분자는 문자열이 //로 시작하고 그 다음에 \n이 오는 형태로 정의되며, 이 두 문자 사이에 위치한 구분자를 추출한다.
커스텀 구분자가 있다면 이를 기본 구분자(쉼표 ,, 콜론 :)와 함께 사용하여 입력 문자열을 분리한다.
커스텀 구분자가 없다면 기본 구분자(쉼표 ,, 콜론 :)만을 사용하여 숫자를 분리한다.

- 문자열 분리 및 숫자 변환 <br>
구분자를 기준으로 입력 문자열을 분리한 후, 각 요소를 숫자로 변환한다.
변환 과정에서 숫자가 아닌 값이 포함된 경우에도 IllegalArgumentException을 발생시켜 프로그램을 종료한다.

- 합계 계산 <br>
변환된 숫자들의 합을 계산한다.

- 결과 출력 <br>
"결과 : " + (합계) <- 형식으로 출력한다.