# java-calculator-precourse

## 패키지 구조
<table>
    <tr>
        <th>패키지</th>
        <th>클래스</th>
        <th>설명</th>
    </tr>
    <tr>
        <td rowspan="2">Common</td>
        <td>Contants</td>
        <td>상수 정의</td>
    </tr>
    <tr>
        <td>InputValidator</td>
        <td>입력값을 검증하여 유효성 체크</td>
    </tr>
    <tr>
        <td>Controller</td>
        <td>Calculator</td>
        <td>계산 로직 처리 및 사용자 요청에 대한 응답 생성</td>
    </tr>
    <tr>
        <td rowspan="2">Model</td>
        <td>Number</td>
        <td>게산에 필요한 숫자 데이터를 표현</td>
    </tr>
    <tr>
        <td>Numbers</td>
        <td>여러 개의 숫자를 관리</td>
    </tr>
    <tr>
        <td rowspan="2">View</td>
        <td>InputView</td>
        <td>사용자로부터 입력 받는 UI 제공</td>
    </tr>
    <tr>
        <td>OutputView</td>
        <td>계산 결과를 사용자에게 출력하는 UI 제공</td>
    </tr>
</table>


# 기능 목록
## 입력
- [x] 입력 프롬프트를 출력한다.
- [x] 한 줄의 문자열을 입력 받는다.
- [x] 입력이 숫자 혹은 '/'로 시작하지 않는 경우에는  
IllegealArgumentException을 발생시킨 후 애플리케이션을 종료한다.

## 빈 입력 처리
- [x] 입력이 비어 있을 경우 0을 반환한다.

## 숫자 추출
1. 입력이 숫자(0~9)로 시작하는 경우 </br>
   - [x] 입력 문자열을 쉼표(,) 또는 콜론(:)으로 분리하여 숫자만 추출한다.
2. 입력이 커스텀 구분자인 경우 ("//" + separator + "\n") </br>
   - [x] "//"와 "\n" 사이의 문자를 추출한다.
   - [x] 입력 문자열을 추출한 문자로 분리하여 숫자만 추출한다.

## 덧셈
- [x] 추출한 숫자들을 모두 더한다.

## 결과
- [x] 출력 프롬프트와 함께 더한 값을 출력한다.