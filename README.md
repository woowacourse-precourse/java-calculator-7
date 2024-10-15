# ➕ 계산기

## 📝 기능 목록

----

- [x] 사용자로부터 계산할 문자열을 입력받는다. ex) 덧셈할 문자열을 입력해 주세요.
- [ ] 입력받은 문자열에서 커스텀 구분자가 있으면 구분자 목록에 추가한다.
- [ ] 구분자를 기준으로 분리한 각 숫자의 합을 계산한다.
- [ ] 계산된 결과를 출력한다. ex) 결과 : 6
- [ ] 사용자가 잘못된 값을 입력할 경우 ```IllegalArgumentException```을 발생 시킨 후 애플리케이션을 종료한다.
  - [ ] 예외 1: 너무 큰 숫자를 입력할 경우 ex) 21억이 넘는 수
  - [ ] 예외 2: 양수가 아닐 경우 ex) -1, 0
  - [ ] 예외 3: 구분자가 연속으로 있는 경우 ex) ",,,,:::1:2"
  - [ ] 예외 4: 구분자만 있는 경우 ex) ",:"
  - [ ] 예외 5: 커스텀 구분자 추가가 문자열의 앞부분에 없는 경우
  - [ ] 예외 6: “//”와 “\n” 사이에 문자 하나가 아닌 여러개가 있는 경우
  - [ ] 예외 7: “//”와 “\n” 사이에 숫자가 오는 경우
  - [ ] 예외 8: “//”와 “\n” 가 아닌 이상한 문자가 오는 경우 ex) [][]\n

## ✅ 실행 결과 예시
```shell
덧셈할 문자열을 입력해 주세요.
1,2:3
결과 : 6
```



