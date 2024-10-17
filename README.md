# java-calculator-precourse
***


## 구현
***

### Controller
- 프로그램 동작 과정을 제어하는 클래스

### DataStore
- 과정에 필요한 값들을 저장하고 처리할 클래스

### InputHandler
- 입력을 책임지는 클래스

### OutputHandler
- 출력을 책임지는 클래스

### CheckDelimiter
- 구분자를 등록하는 클래스

### SumCalculator
- 합을 구하는 클래스

### ExceptionHandler
- 예외처리를 다루는 클래스



## 기능 요구 사항
***

### 프로그램 개요
- 문자열에서 숫자를 추출해 더하는 계산기를 구현한다.

### 기본 기능
1. 쉼표(,) 또는 콜론(:) 을 기본 구분자로 한다.

### 커스텀 구분자 기능
1. "//", "\n" 사이에 위치한 문자를 커스텀 구분자로 한다.

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
