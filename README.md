# 🔢 Precourse-Week1 mission **[&nbsp;java-calculator&nbsp;]**

<!--

## 패지키 구조 (예정)

<div align="center">
<table>
      <tr>
        <th align="center">Package</th>
        <th align="center">Class</th>
        <th align="center">Description</th>
    </tr>
</table>
</div>

-->

---

## 기능 구현 목록

---

✅ 사용자에개 문자열을 입력받는다.

    - 사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용

&nbsp;

✅ 커스텀 구분자를 추가하였는 지 확인한다.

    - 문자열 앞 부분에 //구분자\n 형태가 존재하는 확인.
      - 없다면 그대로 진행.
      - 있다면 커스텀 구분자로 등록.
      - 이때 //와 \n 사이에 두 개 이상의 문자가 온 경우 Illegal Arguemnt, 애플리케이션 종료

&nbsp;

✅ 문자열에서 숫자를 뽑아내서 리스트를 만든다.

    - 기존 구분자, 숫자, 커스텀 구분자 이외의 입력이 있는 지 확인
    - 이때 커스텀 구분자 추가 부분은 제외하고 탐색.
      - 이외의 것이 존재한다면 이는 Illegal Argument Exception, 애플리케이션 종료.
    - 뽑아낸 숫자가 음수이거나 0인 경우 경우 Illegal Argument Exception, 애플리케이션 종료

&nbsp;

✅ 숫자들의 합을 구하여 결과값으로 출력한다.


<!--

----

## 설계 중  고려한 점(예정)

-->