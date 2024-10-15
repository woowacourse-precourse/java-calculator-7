# java-calculator-precourse








## 👨‍💻 커밋 큐칙
### 주제 라인
- 형식: <type>(<scope>): <subject>
- 주제 내용: 간결하게 변경 사항 설명


#### 👉 허용된 <type>
- feat (기능)
- fix (버그 수정)
- docs (문서)
- style (형식, 세미콜론 누락 등)
- refactor
- test (테스트 추가)
- chore (유지보수)


#### 👉 허용된 <scope>
- 커밋 변경의 위치를 명시하는 범위. 예: $location, $browser, $compile, $rootScope, 등.


#### 👉 <subject> 텍스트
- 명령형 현재 시제 사용: “change”가 아닌 “changed” 또는 “changes”
- 첫 글자 대문자 사용 금지
- 마침표(.) 사용 금지


#### 메시지 본문
- 명령형 현재 시제 사용
- 변경 동기 및 이전 동작과의 대비 설명
- Close에 이슈 번호를 지정하여 몇번 이슈를 추가하거나 제거하였는지 확인할 수 있도록 작성함 



#### 예시) feat($browser): onUrlChange 이벤트 추가
```
- feat($browser): onUrlChange 이벤트 추가

$browser에 새로운 이벤트 추가:
- 가능할 경우 popstate 이벤트 전달
- popstate가 불가능할 경우 hashchange 이벤트 전달
- 두 이벤트 모두 불가능할 경우 polling 수행

BREAKING CHANGE: $browser.onHashChange가 제거되었습니다. 대신 onUrlChange를 사용해야 합니다.

Closes #1
```