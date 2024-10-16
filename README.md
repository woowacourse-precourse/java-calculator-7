# 🧮 문자열 덧셈 계산기
- - -

## 🚀 기능 요구 사항
- - -

입력한 문자열에서 숫자를 추출하여 **더하는** 계산기 구현

- 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달
  - 구분자를 기준으로 분리한 각 숫자의 합을 반환
  - 예: `""` => 0, `"1,2"` => 3, `"1,2,3"` => 6, `"1,2:3"` => 6
- 기본 구분자 외 커스텀 구분자를 지정 가능
  - 문자열 앞부분의 "//"와 "\n" 사이 위치하는 문자를 커스텀 구분자로 사용 
  - 예: `"//;\n1;2;3"`의 경우 커스텀 구분자는 세미콜론(;), 결과 값은 6
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException` 발생시킨 후 애플리케이션 종료

## 📡 입출력 요구 사항
- - -

**입력**
- 구분자, 양수로 이루어진 문자열

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

## 📂 패키지 구조
- - -

```
src
 └── main
     └── java
         └── com
             └── calculator
                 ├── controller
                 │   └── CalculatorController.java
                 ├── model
                 │   └── Calculator.java
                 ├── service
                 │   └── CalculatorService.java
                 ├── view
                 │   └── CalculatorView.java
                 └── Application
 └── test
     └── java
         └── calculator
             ├── controller
             │   └── CalculatorControllerTest.java
             ├── model
             │   └── CalculatorTest.java
             ├── service
             │   └── CalculatorServiceTest.java
             ├── view
             │   └── CalculatorViewTest.java
             └── ApplicationTest

```


## 🔍 계획
- - -

- 프로젝트 초기 세팅
- 구현할 기능 목록 작성
- MVC 패턴에 따른 패키지 구조 설정
- Exception 클래스 생성 여부에 따른 고민
- 어떤 경우 예외 처리를 할 것인지, 빠진 부분은 없는지
- 구현 및 테스트 코드 작성
- README.md 수정
- 리팩토링

## 📝 구현할 기능 목록
- - -

- [ ] 입력 받기 
  - `camp.nextstep.edu.missionutils.Console`의 `readLine()` 활용
- [ ] 기본 구분자 처리
  - 쉼표(,)와 콜론(:)을 기본 구분자로 처리하도록 구현
- [ ] 커스텀 구분자 처리
  - 문자열이 `//`로 시작하고 `\n`이 포함되어 있다면 해당 부분 처리
- [ ] 숫자 합산 로직 구현
  - [ ] 분리한 문자열들을 숫자로 변환
  - [ ] 각 분리된 값이 **양수**인지 검증
  - [ ] 그 값을 더하는 로직 구현
  - [ ] 빈 문자열일 경우, 0만 있는 경우 `0` 반환
- [ ] 예외 처리
  - 잘못된 값이 입력된 경우 `IllegalArgumentException` 예외 발생
    - [ ] 빈 문자열이 아닌데 숫자가 아닌 경우
- [ ] 결과 출력
  - 덧셈 결과를 콘솔에 출력
- [ ] 테스트 케이스 작성
  - 다양한 입력 케이스에 대해 동작하는지 테스트