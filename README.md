
<p>
    <img src="https://github.com/user-attachments/assets/c811c2be-923e-4134-a7d4-56bd12198910" alt="우아한테크코스" width="300px">
</p>

# 프리코스 1주차 미션 - 문자열 덧셈 계산기

---

##  💪 미션 개요
구분자를 통해 입력된 문자열에서 숫자를 구분하여 더해주는 덧셈 계산기를 만든다. <br>
(구분자는 임의로 설정할 수 있다.)

# 📝기능 목록

1. 문자열을 입력받는 기능
   - 출력문구: "덧셈할 문자열을 입력해 주세요."<br><br>

2. 기본 구분자를 통해 숫자를 구분하는 기능
   - 구분자는 쉼표(,) 또는 콜론(:) 2가지이다.<br><br>

3. 커스텀 구분자를 통해 숫자를 구분하는 기능
   - 커스텀 구분자는 문자열 앞부분의 "//"와 "\n" 사이에 위치하는 문자를 커스텀 구분자로 사용한다.<br><br>

4. 구분된 숫자를 더하는 기능<br><br>

5. 덧셈 결과를 출력하는 기능
   - 출력문구: "결과 : ${결과값}"

   
## 예외 발생 사안
`사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.`

2. 구분자를 통해 숫자를 구분하는 기능
- [ ] 예외처리: 기본 구분자가 생략된 문자열인 경우
- [ ] 예외처리: 문자열에 숫자가 없는경우
- [ ] 예외처리: 잘못된 커스텀 지정자를 사용한 경우
- [ ] 예외처리: 커스텀 지정자를 설정시 입력한 문자열이 5글자 미만인 경우
- [ ] 예외처리: 분리된 요소들 중 음수가 포함된 경우

