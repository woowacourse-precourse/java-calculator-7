# java-calculator-precourse

## 기능 목록

1. **기본 문자열 덧셈**
    - [x] 빈 문자열 입력 시 0 반환
    - [x] 숫자 하나만 입력 시 해당 숫자 반환
    - [x] 구분자로 구분된 숫자들의 합 계산
      - [x] 쉼표(,)와 콜론(:)을 동시에 구분자로 사용 가능

2. **커스텀 구분자**
    - [ ] 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정
    - [ ] 커스텀 구분자는 문자열 앞부분의 "//"와 "\n" 사이에 위치하는 문자를 커스텀 구분자로 사용
    - [ ] 커스텀 구분자까지 포함하여 구분하여 덧셈 구현

4. **예외 처리**
    - [x] 숫자가 아닌 값 입력 시 IllegalArgumentException 발생
    - [x] 음수 입력 시 IllegalArgumentException 발생
    - [x] 예외 발생 시 에러 메시지 출력 후 프로그램 종료

5. **사용자 인터페이스**
    - [x] 사용자로부터 문자열 입력 받기
      - [x] camp.nextstep.edu.missionutils.Console를 사용하여 입력처리하기
      - [x] 에러 처리를 위해 IOException throw 처리하기
    - [x] 계산 결과 출력

6. **프로그램 종료**
    - [x] 정상적인 결과 출력 후 프로그램 종료
    - [x] 예외 발생 시 에러 메시지 출력 후 프로그램 종료
