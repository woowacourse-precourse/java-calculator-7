# 프리코스 1주차 계산기

## 기능 요구 사항

### 입력 - 덧셈할 문자열을 입력받는다.
1. 입력을 담당하는 InputView를 생성한다.
   - "덧셈할 문자열을 입력해 주세요."를 출력한 후 덧셈할 문자열을 입력받는다.
   - 입력받은 문자열을 구분자로 나눠서 반환한다.
   - 문자열에서 커스텀 구분자, 구분자를 이용해서 숫자로 분리하는 함수를 작성하여 이용한다.
    
### 비즈니스 로직 - 입력받은 문자열을 이용해서 계산기를 구현한다.
1. 비즈니스 로직을 담당하는 Calculator를 생성한다.
    - 계산할 숫자들을 인자로 받고 결과를 반환하는 sum함수를 가진다.

### 출력 - 계산기의 결과를 출력한다.
1. 출력을 담당하는 OutputView를 생성한다.
   -  덧셈의 결과를 입력받아 출력하는 함수를 만든다.
