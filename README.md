# java-calculator-precourse
## 목적
- 입력한 문자열에서 숫자를 추출하여 더하는 계산기를 구현한다.

## 기능 목록
- 입출력
- 문자열을 구분자로 구분하여 숫자 추출
- 추출한 숫자 덧셈
- 예외 처리

## 상세 기능 명세

### 입출력
- [x] 제공된 Console API를 사용하여 입력 구현
- [x] 결과 숫자 반환

### 문자열 구분
- [x] 문자열 입력 구현
- [x] 쉼표(,) 또는 콜론(:) 구분자를 기준으로 숫자 분리
- [x] "//"와 "\n" 사이에 위치하는 문자를 커스텀 구분자로 설정

### 숫자 덧셈
- [x] 숫자 덧셈

### 예외 처리
- [x] 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException 반환