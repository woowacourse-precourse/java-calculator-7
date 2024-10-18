# 문자열 덧셈 계산기

## 목표
입력한 문자열에서 숫자를 추출하여 더하는 계산기를 구현한다.

## 기능 요구 사항
* 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환한다. 
* (예: "" => 0, "1,2" => 3, "1,2,3" => 6, "1,2:3" => 6)
* 앞의 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 "//"와 "\n" 사이에 위치하는 문자를 커스텀 구분자로 사용한다.
* 예를 들어 "//;\n1;2;3"과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
* 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.

## 구현 기능 목록

### 입력
- [x] 사용자에게 `덧셈할 문자열을 입력해 주세요.` 라고 `콘솔`을 통해 질의한다.
- [x] `Scanner` 를 연다.
- [x] `쉼표(,)`와 `콜론(:)` 같은 구분자와 `양수`로 구성된 `문자열`을 입력 받는다. (예시: "1,2:3")

### 비즈니스 로직
- [x] 만약 사용자의 입력이 `빈 문자열` 일 경우, 아무런 비즈니스 로직을 취하지 않고, `결과: 0` 을 출력하고 프로그램을 종료한다.
- [x] `빈 문자열` 이 `null`, `empty`, `blank` 형식일 가능성에 대해서도 고려한다.
- [x] `쉼표(,)`와 `콜론(:)` 를 구분자로 등록한다.
- [x] 사용자의 입력값에서 `커스텀 구분자` 를 찾는다.
- [x] `커스텀 구분자` 가 있다면 구분자로 등록한다.
- [x] 이때, `커스텀 구분자`는 문자열 앞부분의 `//`와 `\n` 사이에 위치하는 `특정 문자` 를 추출해서 등록한다.
- [x] 등록된 구분자로 문자열을 분리한다.
- [x] 분리된 문자열이 모두 `양의 숫자값` 인지 확인한다.
- [x] 분리된 문자열을 모두 `정수` 로 `파싱` 하고 숫자들을 등록한다.
- [ ] 파싱된 숫자들을 모두 더한다.
- [ ] 결과를 출력하고 프로그램을 종료한다. 이때 `System.exit()` 을 호출하지 않는다.

### 예외 처리
모든 예외 상황에서 `IllegalArgumentException` 를 `throw` 하고 프로그램을 종료한다.
- [x] 구분자와 숫자가 아닌 문자가 입력되었을 때
- [x] 양수 범위의 숫자가 아닌 숫자가 입력되었을 때

### 출력
- [ ] 덧셈 결과를 출력한다. (예시: `결과: 6`)
- [ ] `Scanner` 를 닫는다.
