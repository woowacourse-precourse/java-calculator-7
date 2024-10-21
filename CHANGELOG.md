# Change Log

## v1.2 (2024.10.20)
> 주요 작업 : 코드 리팩토링 및 예외 처리 추가

- [46e553e] refactor : SeparatorHandler에 VaildExceptionMessage enum을 적용
- [cab8e06] refactor : SeparatorHandler에 대한 에러 메시지 enum 추가
- [76d9f77] fix : 구분자 형식 검증 및 예외 처리 추가
- [2bc06c4] refactor : 입력 컨트롤러에 구분자를 String으로 받게 수정
- [9bb9a76] refactor : 커스텀 구분자에 문자열 가능하게 수정
- [0b0e5a8] refactor : 실행 코드 수정

## v1.1 (2024.10.19)

---

> 주요 작업 : MVC 패턴으로 코드 리팩토링

- [57c9787] refactor : 문제 조건인 IllegalArgumentException를 발생하도록 수정
- [c79398d] refactor : 예외 메시지 enum을 적용하게 수정
- [0051ea4] refactor : 예외 메시지 enum 추가
- [1da7a44] refactor : 추가된 입, 출력 메시지 enum을 적용하게 수정
- [c9c7862] refactor: 입, 출력 메시지를 가진 enum을 추가
- [df46051] feat: 입력 검증 및 비즈니스 로직 처리 기능
- [5bdbbcf] feat : 입력 처리 및 구분자 검증 기능 클래스
- [427ffee] feat : 입력 예외처리 클래스
- [9Bceff3] feat : 커스텀 구분자 검증 클래스
- [3845256] feat : 입력 및 출력 view

## v1.0 (2024.10.17)

---

> 주요 작업 : 기능 구현 & TC 작성

- [4b3cc36] feat : 메소드 별 테스트 코드 작성
- [111bf16] feat : 전체적인 코드 작성