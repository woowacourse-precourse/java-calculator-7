# java-calculator-precourse

입력한 문자열에서 숫자를 추출하여 더하는 계산기를 구현한다.

- 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환한다.
- 예: "" => 0, "1,2" => 3, "1,2,3" => 6, "1,2:3" => 6
- 앞의 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 "//"와 "\n" 사이에 위치하는 문자를 커스텀 구분자로 사용한다.
- 예를 들어 "//;\n1;2;3"과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.

입출력 요구 사항
입력
구분자와 양수로 구성된 문자열
출력
덧셈 결과
결과 : 6
실행 결과 예시
덧셈할 문자열을 입력해 주세요.
1,2:3
결과 : 6

1. 콘솔을 통해 문자열 입력받기

2. 입력받은 문자열 유효성 검사 및 파싱
   - 커스텀 구분자 확인
     - "\\"로 시작하고 특정 문자 이후 "\n"가 나오는지 확인
     - 양식에 맞지 않으면 IllegalArgumentException 발생
   - 문자열 파싱
     - 기본 구분자, 커스텀 구분자를 이용하여 파싱
     - 리스트에 각각의 요소들 저장
   - 수로 변환
     - 리스트에 있는 문자열을 수로 변환
     - 수가 아닌 다른 값이라면 IllegalArgumentException 발생
   - 변환한 수를 정수 리스트에 저장

3. 리스트의 수를 계산하기
   - 리스트의 수를 합산하고 저장

4. 콘솔을 통해 출력하기

###수정해야 할 것
- https://newwisdom.tistory.com/m/96 해당 포스트의 5번 규칙에 맞춰 패키지, 클래스, 메소드, 변수 명명 수정
- https://myeonguni.tistory.com/1596 해당 포스트의 10번 규칙에 맞춰 전체적인 코드 리팩토링 (특히 ListChecking)
- https://github.com/woowacourse/woowacourse-docs/blob/main/cleancode/pr_checklist.md 참고하여 전체적인 코드 리팩토링
- 예외처리 사항 생각하고 추가하기
