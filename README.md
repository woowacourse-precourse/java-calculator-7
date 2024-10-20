# java-calculator-precourse

### 확실한 요구사항 목록

- 구분자를 통해 토큰 추출
- 숫자 덧셈

이 2가지는 해당 서비스의 핵심 비즈니스라 판단하여 변할 수 있는 가능성이 적다고 판단했습니다.

### 입력값 받기
- [x] 입력 값을 받는다.
  - 입력 값은 `CalculatorRequest`로 받는다. 
  - [x] 구분자 등록 마크가 있다면 커스텀 구분자를 파싱한다.
  - [x] 구분자 등록 마크가 없다면 커스텀 구분자는 null 처리한다.
### 숫자 구분하기
- [x] 구분자를 등록한다.
  - [x] 구분자는 숫자, null, empty 값이 될 수 없다. 
  - [x] 커스텀 구분자 등록 마크가 있어야 등록할 수 있다.(`//`, `\n`)
- [x] 구분자를 통해 숫자를 추출한다.
  - [ ] 문자열에 구분자가 있어야 한다.
### 숫자 더하기
- [x] 요청 값을 숫자로 변환한다.
  - [x] 요청 값이 양수인지 검증한다.
  - [x] 요청 값이 Blank(`""`, `" "`)이면 0으로 변환한다.
- [x] 각 숫자를 더한 값을 반환한다.

# 참고 문서

- `StringTokenizer`와 `String.split()`의 성능 비교

  [[Java] StringTokenizer와 Split() 메서드 언제 써야할까? - effiRin](https://velog.io/@effirin/Java-StringTokenizer%EC%99%80-Split-%EB%A9%94%EC%84%9C%EB%93%9C-%EC%96%B8%EC%A0%9C-%EC%8D%A8%EC%95%BC%ED%95%A0%EA%B9%8C)

  [자바 split / StringTokenizer - 문자열 자르기 비교 - Inpa Dev](https://inpa.tistory.com/entry/JAVA-%E2%98%95-Split-StringTokenizer-%EB%AC%B8%EC%9E%90%EC%97%B4-%EC%9E%90%EB%A5%B4%EA%B8%B0-%EB%B9%84%EA%B5%90%ED%95%98%EA%B8%B0)

- 일급 컬렉션

  [일급 컬렉션(First-Class Collection)이란? - dkswnkk](https://dkswnkk.tistory.com/696)

- 숫자 체크

  [Check If a String Is Numeric in Java - baeldung](https://www.baeldung.com/java-check-string-number)

- 자바 개행 문자 split 방법

  [Split Java String by Newline - baeldung](https://www.baeldung.com/java-string-split-by-newline)

  [Strange String.split("\n") behavior - stackoverflow](https://stackoverflow.com/questions/4539878/strange-string-split-n-behavior/46288888)