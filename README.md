# java-calculator-precourse
요구사항 명세에 명시 되어있지 않던 부분은 🔺 표시

## Input

---

### [ Input 받기 ]
✅`Console` API의 `readLine()` 사용해 `String input` 를 받는다.
  - 🔺구분자 앞 뒤로 숫자 없는 공백이면 이는 예외가 아닌 0으로 간주한다. ( “” 결과가 0이기 때문 ) 
      - ex1 ) “1,2:3: “ ⇒ 6, “1,3: “ ⇒ 4
      - ex2 ) “ ,1,3” ⇒ 4, “ :3,4” ⇒ 7
      - ex3 ) “:,:” ⇒ 0
  - 🔺input으로 들어오는 양수는 부호가 붙지 않는 숫자로 가정한다.
      - ex ) “+3,+2:1” ⇒ exception, “3,2:1” ⇒ 6
  - 🔺커스텀 구분자 길이는 제한이 없다.
  - 🔺커스텀 구분자를 설정할 경우, 기본 구분자와 혼합해 사용하는 것은 불가능하다.
  - 🔺커스텀 구분자로 빈 문자는 불가능하다.
  - 🔺커스텀 구분자로 공백 문자는 사용 가능하다.
    - ex ) "// \n 3 2" ⇒ 5
  - 🔺기본 구분자 사용 시, 공백 문자가 포함된 input은 공백을 제거하고 계산한다.
      - ex) "3  ,2:1" ⇒ ("3,2:1") ⇒ 6

### [ Input ErrorException ]
✅ `validateInput()` : input이 유효한지 확인하는 메서드
  - Input은 아래의 경우들에 대해 `IllegalArgumentException`을 발생시킨다.
      1. 커스텀 구분자가 사용 되는 문자열일 때, 커스텀 구분자 외의 다른 문자가 포함될 경우 예외가 발생한다.
          - ex ) “//a\n3&1a9a1” ⇒ 구분자는 a인데 &가 포함되었으므로 exception
          - 🔺기본 구분자가 혼합되어 사용하는 경우도 이에 포함된다.
      2. 🔺커스텀 구분자가 사용 되는 문자열일 때, 커스텀 구분자가 빈 문자일 경우 예외가 발생한다.
         - ex ) "//\n123" ⇒ exception
      3. 커스텀 구분자를 사용하지 않는 문자열일 때, 즉, 기본 구분자를 사용하는 문자열일 때 `:`, `,` 외의 다른 문자가 포함될 경우 예외가 발생한다.
          - ex ) “1=3~2” ⇒ exception, “A:3,C” ⇒ exception

## Key Functions

---

### [ 구분자 및 숫자 Parsing ]
✅ `hasCustomDelimiter()` : input에 커스텀 구분자가 있는지 판단하는 메서드
  - input에서 index 0,1의 문자가 모두 `/`
  - 이후 특정 index i에 대해, index i에는 `\`, index (i+1)는 `n` 인지 판단
  - 커스텀 구분자가 알맞은 형태로 존재할 시 true 리턴


✅ `extractCustomDelimiter()` : input에서 커스텀 구분자를 추출하는 메서드
  - input String에서 `//`와 `\n` 사이 있는 문자를 추출
  - 추출된 커스텀 구분자인 `String` 리턴


✅ `parseNumbersFromInput()` : input에서 구분자를 기준으로 숫자를 추출하는 메서드
  - parameter로 구분자 넣어주기
  - 구분자가 나타나면, 해당 구분자 다음 index부터 숫자로 간주
      - 다음 구분자가 나타날 때까지 등장한 모든 숫자들을 String으로 합치기
      - `Integer.parseInt()` 사용해 int 형으로 변환
  - 구분자 뒤에 다시 구분자가 나타날 경우, 해당 숫자는 0
  - 구분자로 구분 된 숫자 목록인 `List<Integer>` 리턴
      - 숫자 개수를 모르므로 `List<Integer>` 사용


## Output

---

### [ 계산 결과 출력하기 ]

✅ `parseNumbersFromInput()` 으로 추출한 모든 숫자들의 합 구해 출력하기
  - 추출한 숫자들을 담은 List size가 0일 경우, 숫자가 없었다는 의미이므로 `answer = 0;`



