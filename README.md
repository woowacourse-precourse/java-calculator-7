# 기능 구현 목록

## 1. 프로그램 진행 기능

- [ ] 덧셈할 문자열 과 구분자를 입력받는다
  ```
  > 덧셈할 문자열을 입력해 주세요.
  > 1,2:3
  ```
   - [ ] "//"와 "\n" 사이에 위치하는 문자가 존재할경우 커스텀 구분자로 사용한다.
   - [ ] 구분자와 양수로 구성된 문자열 제외하고 입력하면 예외를 발생시킨다.
   - [ ] 올바른값을 입력했다면 결과를 출력한다.
 

## 2. 입력 기능

- 입력받는 기능
  - [ ] 입력값 공백제거
  - [ ] 예외 검증에 해당 된다면 IllegalArgumentException 던진후 애플리케이션 종료
  
- ⚠️예외 검증: 덧셈할 문자열 입력
   - [ ] 구분자와 양수로 구성된 문자열 인지
   - [ ] 입력값이 공백인지
   - [ ] 입력값이 구분자로 끝나는지
   - [ ] 입력값이 구분자로 시작하는지
   - [ ] 입력값이 구분자로 시작하는지
   - [ ] 유효한 구분자인지


## 3. 출력 기능

- [ ] 덧셈 결과 출력하는 기능
  ```
  > 덧셈할 문자열을 입력해 주세요.
  > 1,2:3
  > 결과 : 6
  ```

- ⚠️예외 발생시: 덧셈할 문자열 입력
   - [ERROR] 올바른 구분자와 양수로 된 문자열을 입력해주세요.
   - [ERROR] 공백을 입력할 수 없습니다.
   - [ERROR] 구분자로 끝날 수 없습니다.
   - [ERROR] 구분자로 시작할 수 없습니다.
   - [ERROR] 유효하지 않은 구분자입니다."

---


## 4. ✅ 체크할 점
- [ ] 커스텀 구분자를 생성할때 
  - //:\n과 같은 입력에 대해서 //와 \n 사이의 를 추출하고 싶을 때 1번처럼 정규식을 사용하면 \n을 인식하지 못한다. 그래서 \\n으로 역슬래쉬를 붙여줘야한다.
  - 하지만 정규표현식에서는 역슬래쉬를 2개더 붙여줘야 정상적으로 인식한다.
  ```
  // 1
  Pattern pattern = Pattern.compile("//(.)\\n(.*)");

  // 2
  Pattern pattern = Pattern.compile("//(.)\\\\n(.*)"); // 역슬래시 3개 + 이스케이프문자

  ```
  

### 프로그래밍 요구사항
- [x] 사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.

---
