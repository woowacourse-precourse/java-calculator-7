# java-calculator-precourse

## 기능 목록

- [ ] 문자열 입력 받기
- [ ] 커스텀 구분자 처리
    - [ ] 커스텀 구분자 존재 여부 확인
    - [ ] 커스텀 구분자가 있는 경우:
        - [ ] 커스텀 구분자를 구분자로 설정
        - [ ] 커스텀 구분자 부분 제거 후 숫자 문자열만 추출
    - [ ] 커스텀 구분자가 없는 경우:
        - [ ] 쉼표(,) 또는 콜론(:)을 기본 구분자로 설정
- [ ] 구분자를 기준으로 숫자 문자열 계산
    - [ ] 구분자를 기준으로 숫자 문자열 분리
    - [ ] 문자열을 숫자로 변환
    - [ ] 숫자들의 합 계산
    - [ ] 계산 결과 출력
- [ ] 사용자 입력 오류 처리 및 오류 메시지 출력

## 폴더 구조

``` 
java-calculator/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── calculator/
│   │           ├── domain/
│   │           │   ├── StringCalculator.java
│   │           │   └── Number.java
│   │           ├── service/
│   │           │   └── CalculatorService.java
│   │           ├── util/
│   │           │   ├── InputParser.java
│   │           │   └── NumberValidator.java
│   │           └── Application.java
```

## 클래스 설명

### Domain (핵심 로직, 엔티티)

- `StringCalculator`: 실제 계산 로직 구현
- `Number`: 값 객체(Value Object)

### Service (전체 프로세스)

- `CalculatorService`: 전체 계산 프로세스 관리

### Util (유틸리티 클래스)

- `InputParser`: 입력 문자열 파싱
- `NumberValidator`: 숫자의 유효성 검사

### Application

- 프로그램의 진입점 및 실행 로직