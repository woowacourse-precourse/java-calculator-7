# java-calculator-precourse

## 기능 요구 사항
- 입력한 문자열에서 숫자를 추출하여 더하는 계산기를 구현한다.

- 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환한다.
  - 예: "" => 0, "1,2" => 3, "1,2,3" => 6, "1,2:3" => 6
- 앞의 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 "//"와 "\n" 사이에 위치하는 문자를 커스텀 구분자로 사용한다.
  - 예를 들어 "//;\n1;2;3"과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.

## 입출력 요구 사항
**입력**
- 구분자와 양수로 구성된 문자열
  
**출력**
- 덧셈 결과
  
```

결과 : 6

```

**실행 결과 예시**
```
덧셈할 문자열을 입력해 주세요.
1,2:3
결과 : 6
```

## 구현할 기능 목록
- [x] 문자열 입력 받기 위한 View 만들기
  - "덧셈할 문자열을 입력해 주세요."
- [x] 문자열 입력 받기
- [x] 입력받은 문자열 처리
  - [x] 빈 문자열 처리 ("" => 0)
  - [x] 기본 구분자 처리 (쉼표 및 콜론)
  - [x] 기본 두분자 이외에 커스텀 구분자 처리
    - [x] 기본 구분자에 커스텀 구분자를 추가
- [x] IllegalArgumentException 처리
  - [x] 숫자가 아닌 문자가 포함 된 경우
  - [x] 구분자가 비어있거나 잘못된 형식인 경우
  - [x] 음수가 입력된 경우
- [x] 숫자 합산 기능
- [x] 결과 출력하기
  - "결과 : ANS"

## 코드를 작성하며 생긴 의문점
- [x] 사용자가 문제를 알 수 있도록 error message를 출력해도 되는가?
  - 요구사항에 관련 내용을 기술하지 않았기 때문에, 에러만 발생시키는 것으로 구현하였다.
- [x] error 발생 시, 다시 처음부터 문자열을 입력하도록 하는게 나을까, 프로그램을 종료시키는 것이 나을까?
  - [x] "사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료한다"로 되어있으니 종료가 맞다.
- [x] 기본 구분자에 커스텀 구분자가 추가되는 것인가? 아니면 커스텀 구분자만 사용하는 것인가?
  - "앞의 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있다. " 라는 말로 미루어보아 기본 구분자에 추가되는 것으로 이해했다.
- [x] 커스텀 구분자가 여러 글자인 경우는 어떻게 할까? ex) "//;\\n1"
  - " "//"와 "\n" 사이에 위치하는 문자를 커스텀 구분자로 사용한다. "라는 말로 미루어보아 "문자"가 온다는 것으로 이해했다. 문자열이 온다고 했다면 해당 사항을 고려해야하지만, 
  "문자"로 적혀있어서 해당 경우는 무시했다.

## 코드 실행시키며 발생한 문제점
- [ ] "" 과 같이 숫자로 시작하지않거나 //로 시작하지 않는 예외에 대응이 안되어 있다.