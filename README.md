# java-calculator-precourse

# 구현할 기능
### 1. layered architecture 객체지향 설계 
   - [x] 전체기능을 3가지 역할(1.유저 입력 검증 | 2.입력으로부터 수 데이터 분리 및 처리 | 3.UI ) 로 분리
   - [x] calculator.domain.data.DataManager 로 유저입력 검증 메서드 구상 (로직 구현 x)
   - [x] calculator.service.CalculatorService 로 입력으로 부터 수 데이터 분리 및 처리 메서드 구상( 로직 구현 x)
   - [x] calculator.presentation.CalculatorRunner 로 UI 메서드 구현

### 2. 로직 구현()
- [x] 유저 인풋이 유효한지 검증
- [x] 유효한 인풋으로 부터 구분자를 제외한 숫자 추출
- [x] Service layer에서 최종 합 출력

# Fix
- [x] 커스텀 패턴 매칭 알맞게 변경 "^//(.+)\n(\\d+\\1)*\\d+$" -> "^//(.+)\\\\n(\\d+\\1)*\\d+$";