# java-calculator-precourse

## 기능 목록 - v3

> ### 1️⃣문자열 파싱 기능
> &emsp; **문자열 입력 및 구분자 처리**
> - [x] 문자열 입력 (`camp.nextstep.edu.missionutils.Console`의 `readLine()` 활용)
> - [x] 기본 구분자를 기준으로 문자열을 분할
> - [x] 커스텀 구분자 추출 및 구분 (`//`와 `\n` 사이의 문자)

> ### 2️⃣예외 처리
> &emsp; **입력 검증 및 예외 처리**
> - [x] 빈 문자열 처리
> - [x] 숫자가 아닌 문자 처리
> - [x] 음수 처리
> - [x] 잘못된 커스텀 구분자 형식 처리
> - [x] int 범위를 넘는 큰 수 처리
> - [x] ~~0으로 시작하는 숫자 처리~~
> - [x] 문자열에 공백이 포함된 경우
> - [x] ~~커스텀 구분자 길이가 1이 넘는 경우~~
> - [x] 맨 끝에 구분자가 오는 경우
> - [x] 연속적인 구분자 처리
> - [x] 커스텀 구분자가 숫자인 경우

> ### 3️⃣숫자 처리 기능
> &emsp; **계산 처리**
> - [x] 문자를 숫자로 변환
> - [x] 숫자들의 합계 계산
> 
> ### 4️⃣코드 리팩토링
> - [ ] 구조 변경
> - [ ] 음수 예외 처리