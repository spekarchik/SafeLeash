# GitHub rulesets JSON (import-ready)

You can create rulesets directly from these JSON files:

- `.github/rulesets/main-protected.ruleset.json`
- `.github/rulesets/production-protected.ruleset.json`
- `.github/rulesets/agent-pr-branches.ruleset.json`

## Import with GitHub CLI

> [!IMPORTANT]
> Before import, replace these placeholders in JSON files:
> - `REPLACE_WITH_MAIN_REQUIRED_CHECK`
> - `REPLACE_WITH_PRODUCTION_REQUIRED_CHECK`
>
> If you import without replacing them, merges will be blocked by non-existent check names.

Run from repository root:

```bash
GITHUB_REPO="<owner>/<repo>" # e.g. myorg/myrepo

gh api \
  --method POST \
  -H "Accept: application/vnd.github+json" \
  /repos/$GITHUB_REPO/rulesets \
  --input .github/rulesets/main-protected.ruleset.json

gh api \
  --method POST \
  -H "Accept: application/vnd.github+json" \
  /repos/$GITHUB_REPO/rulesets \
  --input .github/rulesets/production-protected.ruleset.json

gh api \
  --method POST \
  -H "Accept: application/vnd.github+json" \
  /repos/$GITHUB_REPO/rulesets \
  --input .github/rulesets/agent-pr-branches.ruleset.json
```

## Notes

- `agent-pr-branches.ruleset.json` intentionally ships with an empty `bypass_actors` list to keep import portable.
- If you need bypass actors, add them after import (or before import) using valid IDs for your own repository/organization integrations.
