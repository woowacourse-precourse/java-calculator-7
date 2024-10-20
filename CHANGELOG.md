# Change Log

<br>
<br>

## v1.2 (2024.10.21)

---

> 주요 작업 : 리팩토링 및 TC 보강

[9500f22]refactor: 불필요한 Regex 패턴 제거
[a6eb930]refactor: Matcher를 생성하는 역할을 RegexCompileCache로 위임
[892e24f]refactor: 패키지 구조 변경으로 클래스 위치 재배치
[308ea78]style: 테스트 코드에서 사용된 라이브러리 import 방식 변경
[9147923]test: 콘솔 입력값 TC 추가
[5352e57]fix: 최종 구분자 추출시 쉼표(,)중복 되는 이슈 해결
[af993b9]refactor: Regex compile을 Enum으로 관리하도록 구조 변경

<br>
<br>

## v1.1 (2024.10.17)

---

> 주요 작업 : 기능 개선 및 리팩토링

[1e6726a] refactor: 코드의 가독성을 연관성 있는 코드의 수직거리 조정
[9d6bb34] fix: 문자열의 white_space(공백)를 ""로 변경해주는 로직 추가
[717d74f] refactor: 커스텀 구분자 추출 및 문자열 분리하는 전 과정을 비지니스 로직으로 분리

<br>
<br>

## v1.0 (2024.10.16)

---

> 주요 작업 : 기능 구현 & TC 작성

- [b78045b] feat: IO를 담당하는 클래스 생성
- [64a5b07] feat: 입력을 기본&커스텀 구분자로 split하는 기능
- [e100582] feat: 커스텀 구분자 추출 기능
- [589ea38] feat: CalculateSystem 클래스 생성 & Validation 작업 (with TC)
- [6212fa4] feat: Numbers 클래스 생성 & Validation 작업 (with TC)