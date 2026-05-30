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
OWNER_REPO="<owner>/<repo>" # e.g. myorg/myrepo

gh api \
  --method POST \
  -H "Accept: application/vnd.github+json" \
  /repos/$OWNER_REPO/rulesets \
  --input .github/rulesets/main-protected.ruleset.json

gh api \
  --method POST \
  -H "Accept: application/vnd.github+json" \
  /repos/$OWNER_REPO/rulesets \
  --input .github/rulesets/production-protected.ruleset.json

gh api \
  --method POST \
  -H "Accept: application/vnd.github+json" \
  /repos/$OWNER_REPO/rulesets \
  --input .github/rulesets/agent-pr-branches.ruleset.json
```

## Notes

- `agent-pr-branches.ruleset.json` includes `actor_id: 15368` for `github-actions[bot]` integration bypass.
- Add your GitHub Agent app integration as an extra `bypass_actors` entry if needed.
