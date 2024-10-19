# java-calculator-precourse

# 문자열 덧셈 계산기

# 기능 목록
기능 요구 사항  
입력한 문자열에서 숫자를 추출하여 더하는 계산기를 구현한다.

쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환한다.
예: "" => 0, "1,2" => 3, "1,2,3" => 6, "1,2:3" => 6
앞의 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 "//"와 "\n" 사이에 위치하는 문자를 커스텀 구분자로 사용한다.
예를 들어 "//;\n1;2;3"과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.

- Main -> InputHandler : 문자열 입력 받아줘
- InputHandler -> Main : 입력 문자열 받아줘
- Main -> Parser : 문자열 파싱해줘
- Parser -> Main : 숫자 문자열 받아줘 (문자열배열)
- Main -> Validator : 숫자들을 검증해줘(자연수로 변환)
- Validator -> Main : 숫자 받아줘 (정수배열)
- Main -> Calculator : 정수를 합해줘
- Calculator -> Main : 계산 결과 받아줘
- Main -> Printer : 계산 결과 출력해줘
- 예외처리발생 -> ErrorHandler : 예외처리 받아줘
- ErrorHandler -> Printer : 에러 메세지 출력해줘


# 예외 처리
- 사용자가 잘못된 값을 입력한 경우 `IllegaArgumentException`을 발생시킨 후 애플리케이션 종료
- 빈 문자열일 경우 0 userInput.length, 양수 추출이 없을 때
- 음수의 경우 숫자검증에서 처리
- "///" 의 경우 delimiterEndIndex를 이용한 예외처리 "\n\n" 의 경우 숫자검증에서 처리

# 실행 결과 예시

```angular2html
덧셈할 문자열을 입력해 주세요.
1,2:3
결과 : 6
```