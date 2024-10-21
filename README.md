# java-calculator-precourse

-----


## 🧮 문자열 덧셈 계산기
> 사용자가 입력한 문자열에서 구분자를 기준으로 숫자를 추출하고, 이들의 합을 반환합니다.

<br/>



**실행 결과 예시**
```
덧셈할 문자열을 입력해 주세요.
1,2:3
결과 : 6
```
<br/>

-----

## 🛠️ 기능 목록

### - 연산
  - [X] 추출된 숫자를 더하는 계산 기능 구현

<br/>

### - 추출
  - [ ] 문자열에서 숫자를 추출하는 기능 구현
    - 기본 구분자일 경우
      - [X] 기본 구분자를 정의 
        - 쉼표(,) 또는 콜론(:)
      - [X] 문자열을 기본 구분자로 분리하여 숫자 추출
        - e.g. "1,2:3" => 6
        
        <br/>
    - 커스텀 구분자일 경우
      - [ ] 커스텀 구분자를 추출
        - '//'와 '\n' 사이에 지정된 문자
      - [ ] 문자열을 커스텀 구분자로 분리하여 숫자 추출
        - e.g. "//;\n1;2;3" => 6

<br/>

### - 입력
  - [X] 문자열을 입력받기 위한 안내 메시지 출력 <br/>
    ```
    덧셈할 문자열을 입력해 주세요.
    ```
  - [X] 사용자에게 문자열을 입력받는 기능 구현
    - 사용자 입력 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용

<br/>

### - 예외 처리
  - 사용자가 잘못된 값을 입력할 경우, `IllegalArgumentException 발생 후 애플리케이션 종료`
  
    <br/>

    - [ ] 입력된 문자열에 숫자가 없는 경우
      - e.g. ",,,"
    - [ ] 문자가 포함된 경우
      - e.g. "ㄱㄴ:ㅏ", "ㄱ,1,2"
    - [ ] 음수가 입력된 경우
      - e.g. "1,2,-3"

<br/>

### - 출력
  - [ ] 덧셈 결과를 출력하는 기능
    ```
    결과 : 6
    ```

<br/>

-----

<br/>

<!--
### **💭 커스텀 구분자에 대한 예외 처리**
> 커스텀 구분자는 '//'와 '\n' 사이에 지정된 문자로 특수문자, 기호, 숫자, 영문자, 조합된 문자열 등이 올 수 있다.

- [ ] 커스텀 구분자가 여러 개인 경우
  - e.g. "//!;\n", "//abc;1\n"
- [ ] 커스텀 구분자가 정의되지 않은 경우
  - e.g. "//\n"
- [ ] 기본 구분자와 커스텀 구분자를 혼합하여 사용할 경우
  - e.g. "//;\n1;2:3"

<br/>

---
-->

### 📜 프로그래밍 요구 사항
  - [X] 프로그램 실행의 시작점은 Application의 `main()`이다.
  - [ ] 프로그램 종료 시 `System.exit()`를 호출하지 않는다.
  - [ ] 기능 목록 단위로 커밋한다.
  - [ ] 외부 라이브러리를 사용하지 않는다.
    - `camp.nextstep.edu.missionutils`에서 제공하는 Console API를 사용하여 구현해야 한다.
  - [ ] 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 등의 이름을 바꾸거나 이동하지 않는다.
  - [ ] 자바 코드 컨벤션을 지키면서 프로그래밍한다.

<br/>

-----
