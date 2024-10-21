# java-calculator-precourse

## 문자열 덧셈 계산기
- 입력 값 검증
    - 입력 값이 null이거나 빈 문자열일 경우 0을 반환

- 구분자를 기준으로 문자열 분리 기능
  - 입력 값에 기본 구분자(쉼표 , 또는 콜론 :)가 포함된 경우 해당 구분자를 기준으로 숫자를 분리
  - 커스텀 구분자가 지정된 경우 해당 구분자를 추출하고, 해당 구분자를 기준으로 문자열을 분리

- 커스텀 구분자 처리 기능
  - 문자열의 앞부분에 "//[커스텀 구분자]\n" 형식으로 입력된 경우, 커스텀 구분자를 인식하고 이를 기준으로 문자열을 분리
  - 커스텀 구분자가 적용된 경우에도 각 숫자의 합을 구하여 반환

- 숫자 추출 및 덧셈 기능
  - 분리된 문자열을 숫자로 변환
  - 숫자들을 모두 더한 결과를 반환

- 계산 결과 출력 기능
  - 사용자가 입력한 문자열을 처리하고, 덧셈 결과를 출력

- 메인 실행 기능
  - Application 클래스의 main() 메서드에서 프로그램이 실행되며, 사용자가 문자열을 입력할 수 있도록 대기
  - 결과를 계산하고 이를 화면에 출력