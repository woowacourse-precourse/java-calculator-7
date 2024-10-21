# java-calculator-precourse
우테코 프리코스 1주차 과제, 입력한 문자열에서 숫자를 추출하여 더하는 계산기

# 프로젝트 구조

```
src
├── main
│   └── java
│       └── calculator
│           ├── Application.java
│           ├── InputService.java
│           └── OperationService.java
└── test
    └── java
        └── calculator
            └── ApplicationTest.java


```

-----

# 기능 구현 리스트

### 1. String 숫자 int 숫자로 인식

- [x] ```Console.readLine()``` 사용하여 문자열 입력
- [x] String 숫자 int로 변환 후 연산

### 2. 구분자 포함된 문자열 sum 기능 구현

- [x] 문자열 구분자로 splite => String 숫자 추출
- [x] 추출된 String 숫자 sum 하기

### 3. 커프텀 기능 구현

- [x] `String test1 = "//;\\n1"` 문자열의 `';'` 문자 인식하기
- [x] `//(특정 문자)\\n` (특정 문자) 구분자로 설정 후 계산 기능

### 4. 테스트 케이스 추가

- [x] 기본 테스트 예제 `"//;\\n1"`와 `"-1,2,3"` 성공하기
- [x] 추가로 테스트 코드 만들고 성공하기