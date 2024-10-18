# java-calculator-precourse

## 구현 목록 정리
- [ ] 문자열 입력받기
- [ ] 구분자 확인 및 저장
- [ ] 숫자 부분 파싱
- [ ] 예외처리
- [ ] 결과 출력하기

# Github
## 커밋 메시지 포맷

```
<type>(<scope>): <subject> 

한 줄 띄운 후에 <body>

또 한 줄 띄운 후에 <footer>.
```

길이 제한: 각 줄은 100자를 넘지 않도록 해야 하며, 이는 GitHub 및 기타 Git 도구에서 읽기 쉽게 하기 위함입니다.

## Subject Line
간결하게 변경 사항을 설명합니다.
명령형, 현재 시제를 사용합니다. (“change” not “changed” nor “changes”)
첫 글자를 대문자로 쓰지 않습니다.
마지막에 마침표를 넣지 않습니다.

## Allowed <type>
```
feat: 새로운 기능
fix: 버그 수정
docs: 문서 관련
style: 코드 형식 수정 (세미콜론 추가, 들여쓰기 등)
refactor: 리팩토링
test: 테스트 추가
chore: 기타 유지보수 작업
```


## Allowed <scope>
변경 사항이 발생한 위치를 명시합니다. (예: $location, $browser, $compile)
## \<subject> Text
명령형, 현재 시제를 사용합니다. (“change” not “changed” nor “changes”)
첫 글자를 소문자로 시작하고, 마침표를 사용하지 않습니다.
## Message Body
제목과 마찬가지로 명령형, 현재 시제를 사용합니다.
변경의 동기와 이전 동작과의 차이점을 설명합니다.
## Message Footer
### Breaking Changes
모든 호환되지 않는 변경 사항은 꼬리말에 명시해야 하며, 변경 사항 설명과 함께 마이그레이션 가이드를 포함해야 합니다.
```
BREAKING CHANGE: 설명 내용...

이전 코드 예시:

scope: {
myAttr: 'attribute',
myBind: 'bind',
myExpression: 'expression'
}

변경 후 코드 예시:

scope: {
myAttr: '@',
myBind: '@',
myExpression: '&'
}
```



### Referencing Issues
해결된 버그는 꼬리말에서 Closes 키워드로 참조합니다.

`Closes #123`
여러 이슈를 참조할 때는 쉼표로 구분합니다.

`Closes #123, #245, #992`

## Examples
```
feat($browser): onUrlChange event (popstate/hashchange/polling)

Added new event to $browser:
- forward popstate event if available
- forward hashchange event if popstate not available
- do polling when neither popstate nor hashchange available

BREAKING CHANGE: $browser.onHashChange was removed. Use onUrlChange instead.
```


```
fix($compile): couple of unit tests for IE9

Older IEs serialize HTML uppercased, but IE9 does not. Expect case insensitive,
but unfortunately, Jasmine does not support regex for throw expectations.

Closes #392
```

```
style($location): add couple of missing semi colons
```

```
docs(guide): updated fixed docs from Google Docs

Fixed typos:
- batchLogbatchLog -> batchLog
- missing brace
```
