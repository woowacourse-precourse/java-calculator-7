#!/bin/bash

# CHANGELOG.md 파일을 생성하고 초기 내용을 작성합니다.
echo "# Changelog" > CHANGELOG.md
echo "" >> CHANGELOG.md
echo "## [Unreleased]" >> CHANGELOG.md
echo "" >> CHANGELOG.md

# 새로운 기능 섹션
echo "### 새로운 기능" >> CHANGELOG.md
# 'feat'으로 시작하는 커밋 메시지를 가져오고, Merge 커밋은 제외합니다.
git log --pretty=format:"- %s (%h)" --grep="^feat" --no-merges >> CHANGELOG.md
echo "" >> CHANGELOG.md

# 버그 수정 섹션
echo "### 버그 수정" >> CHANGELOG.md
# 'fix'로 시작하는 커밋 메시지를 가져오고, Merge 커밋은 제외합니다.
git log --pretty=format:"- %s (%h)" --grep="^fix" --no-merges >> CHANGELOG.md
echo "" >> CHANGELOG.md

# 문서 섹션
echo "### 문서" >> CHANGELOG.md
# 'docs'로 시작하는 커밋 메시지를 가져오고, Merge 커밋은 제외합니다.
git log --pretty=format:"- %s (%h)" --grep="^docs" --no-merges >> CHANGELOG.md
echo "" >> CHANGELOG.md

# 기타 변경사항 섹션
echo "### 기타 변경사항" >> CHANGELOG.md
# feat, fix, docs로 시작하지 않고 Merge 커밋도 아닌 나머지 커밋 메시지를 가져옵니다.
git log --pretty=format:"- %s (%h)" --grep="^feat\|^fix\|^docs" --invert-grep --no-merges >> CHANGELOG.md

# 주요 git log 옵션 설명:
# --pretty=format:"- %s (%h)": 커밋 메시지와 커밋 해시코드를 불릿 포인트로 출력합니다.
# --grep="^pattern": 지정된 패턴으로 시작하는 커밋 메시지를 필터링합니다.
# --invert-grep: grep 패턴과 일치하지 않는 커밋을 선택합니다.
# --no-merges: Merge 커밋을 제외합니다.
# 여러 --grep 옵션을 사용하면 OR 조건으로 작동합니다.