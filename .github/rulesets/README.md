# GitHub rulesets JSON (import-ready)

You can create rulesets directly from these JSON files:

- `.github/rulesets/main-protected.ruleset.json`
- `.github/rulesets/production-protected.ruleset.json`
- `.github/rulesets/agent-pr-branches.ruleset.json`

## Import with GitHub CLI

Run from repository root:

```bash
OWNER_REPO="spekarchik/SafeLeash" # change if applying to another repository

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
- Replace `REPLACE_WITH_MAIN_REQUIRED_CHECK` and `REPLACE_WITH_PRODUCTION_REQUIRED_CHECK` with your real check context names before import.
