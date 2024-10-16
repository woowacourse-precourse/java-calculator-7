# 🧮java-calculator🧮 기능목록


#### <span style="background-color:#ff82ee">1. 유저 입력

- [ ] 유저에게 **쉼표(,)또는 콜론(:) 구분자와 양수로 구성된 문자열** 기능 구현
    - [ ] ~이용해 입력받기
    - [ ] 세미콜론(;)등의 커스텀 구분자 지정 가능
        - [ ] "//"와 "\n" 사이에 위치하는 문자를 커스텀 구분자로 사용
      ```
       "//;\n1;2;3"
      ```
    - **에러**
        - [ ] 잘못된 구분자를 입력했을 경우, IllegalArgumentException, 종료
        - [ ] 음수 혹은 숫자를 입력하지 않았을 경우, IllegalArgumentException, 종료
    - **진행**
        - [ ] 에러 상황이 아닌 경우, 구분자를 기준으로 분리한 각 숫자의 합을 반환한다.
    - **종료**
        - [ ] 숫자의 합이 반환되면 자동으로 프로그램 종료.


#### <span style="background-color:#E8D595">2. 출력
- [ ] 입력받은 숫자를 구분자로 분리해서 합 결과를 출력한다.
  ````
결과 : 6
  ````

#### <span style="background-color:#E8D595">3. 실행결과
- [ ] 실행결과 예시
 ````
덧셈할 문자열을 입력해 주세요.
1,2:3
결과 : 6
  ````
- 진행
    - 처음
        - [ ] 첫 시작일 경우 `덧셈할 문자열을 입력해 주세요.` 를 출력한다.
    - 유저 입력
        - [ ] 구분자 포함한 숫자 여러 개를 입력한다.
    - 마지막
        - [ ] 에러가 발생하지 않았을 경우 `결과 :` 를 출력한다.