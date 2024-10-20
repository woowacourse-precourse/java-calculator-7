# java-calculator-precourse

### 구현할 기능

- 기본 구분자를 이용한 계산기 기능 구현
- 커스텀 구분자를 이용한 계산기 기능 구현
- 사용자가 잘못된 입력을 할 경우 IllegalArgumentException 발생

### 구현 방법
- 정규 표현식과 StringTokenizer를 활용한 구분자 분석 및 계산 수행
- 입력에 대한 예외 처리와 덧셈과정에서 음수에 대한 예외 처리
- primitive type overflow 방지를 위한 BigInteger 클래스 사용
- 커스텀 구분자를 한 개 이상 입력할 수 있도록 로직 구현