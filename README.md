# java-calculator-precourse
### 기능 목록

- [x]  문자열 입력받기
    - [x]  구분자와 양수로 구성된 문자열
- [x]  문자열을 구분자를 기준으로 분리
    - [x]  구분자 지정 기본 - 구분자(쉼표, 콜론)
        - [x]  "//"와 "\n" 사이에 위치하는 문자를 커스텀 구분자로 등록
- [x]  숫자의 합 계산
- [ ]  덧셈 결과 출력

### 예외 발생 사항

- [x]  문자열 구분자 분리
    - [x]  커스텀 구분자 지정 형식 다르면 에러 → "//"와 "\n" 사이 위치
        - [x]  구분자 여러개 지정이면 에러
    - [x] 구분자 or 숫자 반복이면 에러
    - [x] 구분자 아닌 문자 끼어있으면 에러

---
#### 〰️ 전체 플로우 〰️
- controller
  - CalculatorContorller
  - DelimiterSeparator
  - NumberChecker
- model
  - Delimiter (구분자 등록, 구분자 판별)
- view
  - InputView
  - OutputView