# java-calculator-precourse

## 구현할 기능 목록 정리
- Model: DelimiterParser와 Calculator 클래스가 데이터 처리를 담당합니다.
  - 구분자를 선별하여, 계산할 값만 추출하는 기능 (+값이 비어("\n") 있으면 곧바로, 0 출력.)
  - 숫자 형태로 전환 후 합을 계산
- View: CalculatorView 클래스가 사용자로부터 값을 입력받는다.
- Controller: CalculatorController 클래스가 Model과 View를 연결하고 전체 로직을 제어한다.

+) 커스텀 구분자를 입력 안 했으면(//\n), 에러 ; Delimiter cannot be empty
+) 음수 입력 시, 에러 ; Negative numbers are not allowed: -2
+) 공백 입력 시 ; 0 or 공백 제거
+) 잘못 입력 시, 에러 ; 잘못된 값을 입력하셨습니다. 애플리케이션은 종료됩니다. 입력값:1?2
