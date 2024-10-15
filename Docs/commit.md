# Git Commit Conventions

## Commit Format
```
<type>(<scope>): <subject>
<BLANK LINE>
<body>
<BLANK LINE>
<footer>
```

### Type
커밋의 종류를 나타낸다.
| Commit Type | Description |
| --- | --- |
| feat | 새로운 기능 추가 |
| fix | 버그 수정 |
| docs | 문서 수정 |
| style | 코드 포맷팅, 세미콜론 누락, 코드 변경이 없는 경우 |
| refector | 코드 리팩토링 |
| test | 테스트 코드 생성 |
| chore | 빌드 업무 수정, 패키지 매니저 수정, 패키지 관리자 구성 등 업데이트,<br>Production Code 변경 없음 |

<br>

### Scope
변경 사항이 적용되는 범위를 지정한다.<br>
예시) ```authentication```, ```UI```, ```database```

<br>

### Subject
변경 사항에 대한 간단한 설명을 작성한다.<br>

#### Subject 작성 규칙
- 과거시제는 사용하지 않는다.
- 마침표 및 특수기호는 사용하지 않는다.
- 개조식 구문으로 작성한다. 예시) ```결제 처리 버그 수정```
- 50글자 이내로 작성한다.

<br>

### Body
변경한 이유와 이전 동작과의 차이를 상세히 설명합니다.

#### Body 작성 규칙
- 한 줄당 80자 이내로 작성한다.
- 변경의 이유를 명확하게 작성한다.

<br>


### Footer
브레이킹 체인지(Breaking Changes)나 관련 이슈를 참조한다.

#### Footer 작성 규칙
- Breaking Changes가 있을 경우 ```BREAKING CHANGE:```로 시작하여 변경 내용을 설명한다.
- 관련 이슈 번호는 ```Closes #이슈번호``` 형식으로 작성한다.
- 여러 이슈를 참조할 경우 쉼표(,)로 구분한다.

<br>

## Commit 작성 예시
```
fix(payment): 결제 처리 버그 수정

결제 API 호출 시 발생하는 버그를 수정했습니다.
사용자 입력 검증 로직을 강화하여 오류를 방지합니다.

Closes #123, #124
```

```
feat(authentication): OAuth2 로그인 지원

OAuth2 프로토콜을 사용하여 소셜 로그인 기능을 지원합니다.
기존의 JWT 기반 인증과 병행하여 사용할 수 있습니다.

BREAKING CHANGE: 기존 JWT 인증 방식이 제거되었습니다.
새로운 인증 방식을 사용하려면 설정을 업데이트해야 합니다.
```
```
style(header): 헤더 컴포넌트 코드 포맷팅 정리

헤더 컴포넌트의 코드 스타일을 프로젝트 규칙에 맞게 정리했습니다.
불필요한 공백과 줄바꿈을 제거했습니다.
```
```
docs(api): 사용자 인증 API 문서 추가

사용자 인증과 관련된 API 엔드포인트에 대한 상세 문서를 작성했습니다.
각 엔드포인트의 요청 및 응답 예시를 포함했습니다.
```