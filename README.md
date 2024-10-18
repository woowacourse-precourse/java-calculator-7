# java-calculator-precourse

---

## 목차

[1. 프로젝트 소개](#프로젝트-소개)

[2. 구현 기능 목록](#구현-기능-목록)

[3. 버전 로그](#버전-로그)

---

## 프로젝트 소개

---

## 구현 기능 목록

### 입력

- [x] "덧셈할 문자열을 입력해 주세요." 를 출력
- [x] 사용자 데이터 입력 받기

### 연산

- [x] 커스텀 구분자가 포함된 문자열인지 확인하기
- [x] 커스텀 구분자 포함일 경우 포멧이 맞는지 확인
    - [x] 포멧이 정확하지 않을 경우 에러 처리
- [x] 구분자로 이루어진 배열 생성
- [x] 양수 추출 대상 배열 생성
- [x] 양수 추출 대상 배열 검증
    - [x] 양수와 구분자로만 이루어졌지 않을 경우 에러 처리
- [x] 구분자로 구분된 숫자 더하기

### 출력

- [x] "결과 : {합}" 형식으로 결과 출력

### 종료

- [x] 리소스 반환

### 에러 처리

- [x] 사용자가 잘못된 값을 입력할 경우 예외처리 후 애플리케이션 종료

---

## 버전 로그

### v 0.0.3

- 이전 버전의 문제점

 ```text
1.DataParser class 가 기본 포멧과 커스텀 포멧을 모두 처리해 로직의 흐름을 한눈에 파악하기 어려움
```

- 변경사항

```text
- DataParser 를 CustomDataParser 와 DefaultDataParser 로 분리
- 기존 DataParser 를 interface 로 변경
- 입력받은 문자열에 대해 적절한 DataParser 를 실행시키는 ParseManager 생
```

- 역할

```text
- Application class

    - Calculator 를 호출하는 역할
    
- Calculator class

    - Data dto 기반으로 더하기 연산을 하는 역할
    
- InputDataReader class

    - 사용자에게 입력을 받는 역할
    
- ParseManager class

    - 입력 받은 문자열을 파싱할 수 있는 파서를 찾고 실행하는 역할
    
- DataParser Interface

    - DefaultDataParser : 커스텀 구분자가 없는 문자열을 Data dto 로 변환하는 역할
    - CustomDataParser : 커스텀 구분자가 존재하는 문자열을 Data dto 로 변환하는 역할
    
- Validator class

    - 문자열을 검증하는 역할
    
- Logger class

    - 결과를 정해진 포멧으로 출력하는 역할
    
- Data class

    - 구분자 배열과 피 연산 데이터 배열을 가진 DTO
```

### v 0.0.2

- 이전 버전의 문제점

```text
1. 하나의 클래스가 여러 기능을 가지는 문제점이 존재
2. 테스트 코드를 작성하지 않아 로직의 정확성이 떨어짐
```

- 변경사항

```text
- 하나의 클래스는 하나의 책임만 가지도록 변경

    - 기존 클래스 내부 클래스 명에 맞지 않은 역할들을 다른 클래스로 이동
    
- Test Code 작성

    - 각 클래스의 기능을 검증하기 위한 클래스 별 테스트 코드 작성
```

- 역할

```text
- Application class

    - Calculator 를 호출하는 역할
    
- Calculator class

    - Data dto 기반으로 더하기 연산을 하는 역할
    
- InputDataReader class

    - 사용자에게 입력을 받는 역할
    
- DataParser class

    - 문자열을 Data dto 로 파싱하는 역할
    
- Validator class

    - 문자열을 검증하는 역할
    
- Logger class

    - 결과를 정해진 포멧으로 출력하는 역할
    
- Data class

    - 구분자 배열과 피 연산 데이터 배열을 가진 DTO
```

- todo

```text
 [x] DataParser 를 기본 포맷과 커스텀 포멧 처리를 따로 하도록 분리
```

### v 0.0.1

- 역할

```text
- Application class

    - 문자열 입력받는 역할
    - 기본 포맷인지 커스텀 포멧인지 구분하는 역할
    - 결과 출력하는 역할
    - 사용한 자원 반납하는 역할

- DataParser class

    - 입력받은 문자열을 검증하는 역할
    - 입력 받은 문자열을 구분자와 데이터로 파싱하는 역할

- Calculator class

    - 문자열을 정수형으로 바꾸는 역할
    - 바뀐 정수를 더하는 역할
    - 문자 배열을 문자열로 바꾸는 역할

- Data class

    - 구분자 배열과 피 연산 데이터 배열을 가진 DTO
```

- todo

```text
 [x] Application, DataParser, Calculator class 가 단일 책임을 가지도록 리펙터링
 [x] 또한 각 클래스별 테스트 코드를 작성
```