## 🎯 구현 기능 목록

### 📌 덧셈할 문자열 입력

✅ 구분자를 사용해 덧셈할 양수를 입력

✅ 기본적으로 쉼표(,), 또는 콜론(;)이 구분자가 된다.

```markdown
ex: "", "1,2:3", "1;2;3", "4.2;3.5,2"
```

**🚫 입력 예외 처리**

✅ 0이 들어오거나 음수가 들어온 경우 `IllegalArgumentException`

✅ 숫자, 구분자, 소수점(.)을 제외한 문자가 들어올 경우`IllegalArgumentException`

✅ 구분자의 앞 뒤에 값이 없는 경우 `IllegalArgumentException`

✅ 너무 큰 숫자를 입력한 경우 `IllegalArgumentException`

---

### 📌 커스텀 구분자 입력

✅ “//”와 ”\n” 사이에 위치하는 문자는 커스텀 구분자로 지정해준다.

```markdown
ex: "//*\n", "//l\n"
```

✅ 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용

**🚫 커스텀 구분자 예외 처리**

✅ 커스텀 구분자는 맨 앞에 나오기 때문에 INDEX 형식으로 “/”, “/”, “숫자를 제외한 문자”, “/”, “n” 순서대로 오는지 확인

---

### 📌 덧셈 실행

✅ 커스텀 구분자를 포함한 구분자들 사이에 숫자를 더하기 해준다.

✅ 덧셈 결과를 화면에 출력한다.

```markdown
1,2:3
결과 : 6
```

**🚫 예외 처리**

✅ 결과 값이 너무 큰 숫자인 경우 `IllegalArgumentException`

✅ “”처럼 null 값이 들어온다면 0을 출력