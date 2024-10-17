# java-calculator-precourse
***


## 구현
***

### Controller
- 프로그램 동작 과정을 제어하는 클래스
- [ ] `void startProcess()`
    - 프로그램 시작점
    - 프로그램 전반의 흐름 제어
      1. DataStore 생성
      2. 입력 받기
      3. 구분자 체크
      4. 합연산
      5. 결과 출력

### DataStore
- 과정에 필요한 값들을 저장하고 처리할 클래스
- [ ] `String target`
- [ ] `List<Character> delimiter`
- [ ] `Integer sum`

### InputHandler
- 입력을 책임지는 클래스
- [ ] `String makeInput()`

### OutputHandler
- 출력을 책임지는 클래스
- [ ] `void printAnswer()`

### CheckDelimiter
- 구분자를 등록하는 클래스
- [ ] `List addBasicDelimiter()`
- [ ] `List addSpecialDelimiter()`
    - [ ] `Character extractDelimiter()`
      - `StringBuilder`의 `substring`

### SumCalculator
- 합을 구하는 클래스
- [ ] `Integer makeSum()`

### ExceptionHandler
- 예외처리를 다루는 클래스



## 기능 요구 사항
***

### 프로그램 개요
- 문자열에서 숫자를 추출해 더하는 계산기를 구현한다.

### 기본 기능
1. 쉼표(,) 또는 콜론(:) 을 기본 구분자로 한다.
2. 숫자의 합을 더한다. 숫자는 양수만 입력 받는다고 가정한다.
### 커스텀 구분자 기능
1. "//", "\n" 사이에 위치한 문자를 커스텀 구분자로 한다.
- 구분자를 문자로 볼 것인가 문자열로 볼 것인가? //:;,\n 는 구분자가 :;, 인지?
- 커스텀 구분자를 구분하는 섹션은 반드시 앞에 위치하는가? 무작위인가?
### 예외 처리
1. 잘못된 값을 입력할 경우 IllegalArumentException을 발생시킨다.



## 프로그래밍 요구 사항
***

1. JDK 21
2. `Application`의 `main()`에서 시작
3. `build.gradle`은 기본 값 유지
4. 제공된 것 외에 외부 라이브러리 금지
5. 프로그램 종료 시 `System.exit()` 호출 금지
6. 사용자 입력 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 사용
