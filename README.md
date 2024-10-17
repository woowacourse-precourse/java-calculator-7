# 프리코스 1주차 - 문자열 덧셈 계산기

- - -

### 입력한 문자열에서 숫자를 추출하여 더하는 계산기를 구현한다.

## 💻 실행결과 예시

- - -

```
덧셈할 문자열을 입력해 주세요.
1,2:3  
결과 : 6
```

## ✅ 구현할 기능 목록

- - -

### 1. 입력

- 문자열 입력 받기
    - "덧셈할 문자열을 입력해 주세요."

### 2. 입력 문자열 처리

- 구분자 정의하기
    - 문자열의 시작이 "//"인 경우, 커스텀 구분자 추출
    - 아닌 경우, 기본 구분자(",", ":") 사용
- 커스텀 구분자 추출하기
    - 문자열의 커스텀 구분자 "//"와 "\n" 사이에 정의돼 있다면 그 사이의 구분자 추출
    - 문자열의 커스텀 구분자가 "//"와 "\n" 사이에 정의되어 있지 않다면, IllegalArgumentException 에러 발생
- 계산할 숫자 리스트 생성하기
    - 구분자를 기준으로 입력받은 문자열 분리해서 리스트 생성하기
    - String 리스트를 Int 형으로 변경
        - 빈 문자의 경우, 0으로 처리
        - 음수 값이 있을 경우, IllegalArgumentException
        - 숫자가 아닌 값이 있을 경우, IllegalArgumentException

### 3. 계산기

- 입력받은 숫자 모두 더하기

### 4. 결과 출력

- 계산기의 결과 값 출력
    - "결과 : " + 계산 결과