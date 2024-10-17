# java-calculator-precourse

**📚 구현 기능 목록**

---

**📌 문자열 입력 받기 기능**

- [x]  “덧셈할 문자열을 입력해 주세요.” 출력
- [x]  문자열 입력받기

---

📌 **커스텀 구분자 지정 판별 기능**

- [x]  맨 처음 문자열에 “//”가 있고, “\n”이 포함 되어있는지 여부로 커스텀 구분자 지정인지 아닌지 판별

**🚫 예외 처리**

- [x]  “//" 또는 "\n" 둘 중 하나만 문자열에 포함 되어있을 경우 `IllegaArgumentException`

---

**📌 커스텀 구분자 추출 기능**

- [ ]  “//” 와 “\n” 사이의 커스텀 구분자 문자 추출 후 반환

**🚫 예외 처리**

- [ ]  “//” 와 “\n” 사이의 커스텀 구분자가 **`문자열`** 이라면 `IllegaArgumentException`
- [ ]  “//” 와 “\n” 사이의 커스텀 구분자가 **`숫자`**  라면 `IllegaArgumentException`

---

**📌 구분자들을 기준으로 연산 할 문자열 분리 해주는 기능**

- [ ]  기본 구분자 + 커스텀 구분자가 들어있는 모든 구분자를 기준으로 분리해준다.

---

**📌 분리 된 문자열들 더해주고 출력**

- [ ]  분리 된 문자열들 정수로 변환해서 더해주고
- [ ]  결과 값 출력
    - 결과 : [결과 값]

**🚫 예외 처리**

- [ ]  문자열이 정수가 아니라면 `IllegaArgumentException`

---