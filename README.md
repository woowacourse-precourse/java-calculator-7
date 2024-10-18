# java-calculator-precourse

## 문자열 덧셈 계산기
### 기능 요구사항
입력한 문자열에서 숫자를 추출하여 더하는 계산기를 구현한다.

- 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환한다.
  - 예: "" => 0, "1,2" => 3, "1,2,3" => 6, "1,2:3" => 6
- 앞의 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 "//"와 "\n" 사이에 위치하는 문자를 커스텀 구분자로 사용한다.
  - 예를 들어 "//;\n1;2;3"과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.

**입출력 요구 사항**   
`입력` : 구분자와 양수로 구성된 문자열  
`출력` : 덧셈 결과
```
결과 : 6
```
**실행 결과 예시**
```
  덧셈할 문자열을 입력해 주세요.
  1,2:3
  결과 : 6
```

### 구현할 기능 목록
- 기본 구분자(쉼포, 콜론)를 가지는 문자열로 부터 숫자 분리
- 커스텀 구분자를 가지는 문자열로 부터 숫자 분리
- 문자열로 부터 분리된 숫자의 합 계산 및 반환
- 사용자의 잘못 된 입력에 대해 `IllegalArgumentException` 발생, 애플리케이션 종료

### 프로그래밍 요구사항 - 제공 라이브러리 파악
| camp.nextstep.edu.missionutils

**Console**
- `getInstance()`
  - java.util.Scanner 객체가 존재하지 않는 경우(scanner==null) **새로운 Scanner 객체 생성**
  - null이 아닌 경우는 **이미 존재하는 scanner 반환**
  - 생성된 **Scanner 객체 반환**
- `readLine()`
  - getInstance() 로부터 **Scanner 객체를 받음**
  - Scanner 객체의 nextLine()을 통해 한 줄의 문자열을 읽어 옴  
    (사용자가 Enter 키를 누를 때 까지, Enter 키는 버림)
- `close()`
  - 현재의 scanner가 null이 아니라면, **열려있는 Scanner 객체 닫기**
  - 그 후 scanner를 null로 설정 

**DateTimes**
- `now()`
  - 시스템의 현재의 날짜와 시간을 LocalDateTime 객체로 반환

**Randoms**
- `ThreadLocalRandom.current()`를 통해 난수 생성기(defaultRandom) 초기화
- `pickNumberInList()`
  - numbers(Integer List)를 입력 받음
  - `validateNumbers()`를 통해 numbers가 비어있는지 검사
  - `pickNumberInRange()`에서 defaultRandom을 통해 범위에서 랜덤한 숫자를 생성, 지정한 시작값과 더해 무작위 숫자를 반환 받음
  - `validateRange()`를 통해 범위의 양 끝 유효성을 확인하고, Integer의 최대값을 초과하는지 검사
- `pickUniqueNumbersInRange()`
  - `validateRange()`를 통해 범위의 양 끝 유효성을 확인하고, Integer의 최대값을 초과하는지 검사
  - `validateCount()`를 통해 count 값이 0보다 작거나 범위 내의 값인지 검사
  - 주어진 범위의 숫자들을 numbers 배열에 추가
  - `suffle()`에서 java.util.Collections의 suffle()을 통해 numbers의 수를 무작위로 섞고,  
     count 수 만큼의 숫자 배열을 반환
