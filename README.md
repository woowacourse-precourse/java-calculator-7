# 📚 구현 기능 목록

---

### 📌 사용자 입력 처리

- [x] 계산 할 문자열은 구분자와 양수로 구성된 문자열을 입력한다.
- [x] 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.

---

### 📌 구분자 처리

- [x] 기본 구분자는 쉼표(,)와 콜론(:)이다.
- [ ] "//"와 "\n" 사이에 위치하는 문자를 커스텀 구분자로 지정할 수 있다.

---

### 📌 문자열 계산 수행

- [ ] 문자열에서 구분자를 이용해 숫자를 추출하고 합산한다.
- [ ] 단, ""과 같이 빈 문자열일 경우는 0을 반환한다.

```text
덧셈할 문자열을 입력해 주세요.
1,2:3
```

---

### 📌 계산 결과 출력

-[ ] 구분자를 기준으로 분리한 각 숫자의 합을 계산한 후, 결과를 출력한다.

```text
결과 : 6
```

### 🚫 예외 처리

- [ ] 예상치 못한 입력 형식이 들어올 경우 ``IllegalArgumentException``을 발생시킨다
    - [ ] 숫자가 너무 큰 경우
    - [ ] 허용되지 않은 구분자가 포함된 경우
    - [ ] 구분자가 연속해서 나타나는 경우
    - [ ] 커스텀 구분자 생성시 "//"에 대응하는 "\n"를 찾을 수 없는 경우
    - [ ] 커스텀 구분자 생성시 "//"와 "\n" 사이에 위치하는 문자가 없는 경우
    - [ ] 커스텀 구분자 생성시 "//"와 "\n" 사이에 숫자가 있는 경우
    - [ ] 입력한 문자열에 공백이 포함된 경우
        - [ ] 커스텀 구분자의 공백은 허용한다. ```ex) // \n1 2 3```
        - [x] 문자열의 첫 글자는 공백을 허용하지 않는다.
        - [x] 문자열의 마지막 글자는 공백을 허용하지 않는다.
        - [x] 문자열이 모두 공백인 경우는 허용하지 않는다.
        - [ ] 커스텀 구분자가 아닌 경우, 문자열 중간에 공백을 허용하지 않는다.
