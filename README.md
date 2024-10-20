# 🔢  **[&nbsp;java-calculator&nbsp;]**

----

## 패지키 구조

<img width="686" alt="스크린샷 2024-10-21 오전 3 50 17" src="https://github.com/user-attachments/assets/10e4d606-4daa-4742-b12f-7816db818f96">


<div>
<table>
<tr>
<th>Package</th>
<th>Class</th>
<th>Description</th>
</tr>

<tr>
<td><b>🕹&nbsp;&nbsp;controller</b></td>
<td><b>Calculator</b></td>
<td>계산기 로직을 메인으로 동작하는 컨트롤러 클래스</td>
</tr>

<tr><td colspan="3"></td></tr>

<tr>
<td rowspan="4"><b>💻  domain</b></td>
<td><b>InputProcessor</b></td>
<td>입력을 받아 InputParser를 통해 데이터를 추출하고, 결과를 계산하는 클래스</td>
</tr>

<tr>
<td><b>InputParser</b></td>
<td> 입력을 변환하고 필요한 데이터를 추출하는 클래스 </td>
</tr>

<tr>
<td><b>InputValidator</b></td>
<td>InputParser 메서드에 전달된 인자의 유효성을 검사하는 클래스</td>
</tr>

<tr>
<td><b>MathOperator</b></td>
<td>연산 기능을 수행하는 클래스</td>
</tr>

<tr>
<td><b>    ↘️  / constants</b></td>
<td><b>DefaultDelimiter</b></td>
<td> Default delimiter에 대해 정의된 Enum</td>
</tr>

<tr><td colspan="3"></td></tr>

<tr>
<td rowspan="1"><b>💬  view</b></td>
<td><b>View</b></td>
<td>사용자에게 응답을 출력하는 클래스</td>
</tr>

</table>
</div>


---

## 기능 구현 목록

#### 1. 유저 입력

- 유저에게 안내문구 출력 후 문자열을 입력하는 기능 구현

    - 사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.

#### 2. 커스텀 구분자 추가여부 확인

- 문자열 앞 부분에 //구분자\n 형태가 존재하는 지 확인 후 존재한다면 커스텀 구분자로 등록
    - 없다면 그대로 진행한다.
    - 있다면 커스텀 구분자로 등록한다.

    - **예외 처리 사항**:
        - 문자열이 비어있는 경우 분석할 필요가 없기에 3번 과정을 생략하고 4번으로 넘어간다.

    - **에러**:
        - 커스텀 구분자 등록 시 //와 \n 사이에 두 개 이상의 문자가 온 경우 Illegal Argument, 종료

#### 3. 숫자 추출 후 리스트 업

- 구분자를 이용하여 문자열에서 숫자 추출 후 변환하여 등록
    - 커스텀 구분자 있다면 문자열에서 커스텀 구분자를 추가하는 부분을 제거한다
    - 구분자들을 통해 문자열을 나눠서 리스트에 담는다.
    - 리스트에 있는 원소 하나씩 검사한다.
    - **예외 처리 사항**:
        - 커스텀 구분자 추가 부분을 문자열에서 제거 후 문자열이 비어있게 된다면 이후의 3번 과정을 생략하고 4번으로 넘어간다.
    - **에러**:
        - 숫자 이외의 것이 존재한다면 이는 Illegal Argument Exception, 애플리케이션 종료.
            - 이때 공백이 포함되어도 입출력 요구 사항에 위반되므로 Illegal Argument Exception, 애플리케이션 종료.
        - 뽑아낸 숫자가 음수이거나 0인 경우 Illegal Argument Exception, 애플리케이션 종료

#### 4. 출력

- 얻어낸 숫자들을 모두 합하여 출력한다.

