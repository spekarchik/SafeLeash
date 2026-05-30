# GitHub rulesets JSON (import-ready)

You can create rulesets directly from these JSON files:

- `.github/rulesets/main-protected.ruleset.json`
- `.github/rulesets/production-protected.ruleset.json`
- `.github/rulesets/agent-pr-branches.ruleset.json`

## Import with GitHub CLI

Run from repository root:

```bash
gh api \
  --method POST \
  -H "Accept: application/vnd.github+json" \
  /repos/spekarchik/SafeLeash/rulesets \
  --input .github/rulesets/main-protected.ruleset.json

gh api \
  --method POST \
  -H "Accept: application/vnd.github+json" \
  /repos/spekarchik/SafeLeash/rulesets \
  --input .github/rulesets/production-protected.ruleset.json

gh api \
  --method POST \
  -H "Accept: application/vnd.github+json" \
  /repos/spekarchik/SafeLeash/rulesets \
  --input .github/rulesets/agent-pr-branches.ruleset.json
```

## Notes

- `agent-pr-branches.ruleset.json` includes `actor_id: 15368` for `github-actions[bot]` integration bypass.
- Add your GitHub Agent app integration as an extra `bypass_actors` entry if needed.
- If your required check context differs from `Build NeoForge Mod`, update the `required_status_checks` context before import.
