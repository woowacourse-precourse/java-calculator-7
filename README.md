# java-calculator-precourse

-[ ] 문자열 입력 받기
-[ ] 커스텀 구분자 있는지 체크하기
    1. [ ] 커스텀 구분자가 있다면?
        2. [ ] 커스텀 구분자를 구분자로 설정
        3. [ ] 커스텀 구분자 부분 제거후 숫자 문자열만 남기기
    2. [ ] 커스텀 구분자가 없다면?
        3. [ ] 쉼표(,) 또는 클론(:) 을 구분자로 설정

4. [ ] 구분자를 기준으로 숫자 문자열을 계산한다
    5. [ ] 구분자 기준으로 숫자 문자열을 쪼갠다
    6. [ ] 문자열을 숫자로 바꾼다.
    7. [ ] 숫자를 더한다
    8. [ ] 더한 값을 출력한다.
9. [ ] 사용자 입력에 문제가 있다면 오류를 출력한다.

폴더 구조

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

domian(핵심 로직, 엔티티)

- StringCalculator : 실제 계산 로직
- Number : 값 객체(Value Object)

service(전체 프로세스)

- CalculatorService : 전체 계산 로직

util(유틸리티 클래스)

- InputParser : 입력 문자열을 파싱
- NumberValidator : 숫자의 유효성을 검사

