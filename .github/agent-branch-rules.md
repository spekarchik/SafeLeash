# GitHub Agent Branch & Push Rules

This repository should use three separate branch rulesets:

## 1) Protected branches ruleset

Apply to:
- `main` (docs/workflows only)

Recommended settings:
- Require pull request before merging
- Require status checks before merging
- Block force pushes
- Block branch deletion

## 2) Protected production branches ruleset

Apply to:
- `Neo/**`
- `Fabric/**`
- `Forge/**`

Recommended settings:
- Require pull request before merging
- Require status checks before merging
- Block force pushes
- Block branch deletion

## 3) Agent PR branches ruleset

Use a dedicated PR branch namespace that is separate from production prefixes, for example:
- `agent/pr/**`
- `copilot/pr/**`
- `pr/**`

Recommended settings:
- Allow direct pushes (do not require PR on these branches)
- Allow branch creation by the automation identity
- Keep force push blocked
- Keep branch deletion blocked unless your workflow requires cleanup

Bypass/allow actors:
- Add the GitHub App identity used by your agent
- Optionally add `github-actions[bot]` if your automation flow needs it

## 4) Repository Actions settings

In **Settings → Actions → General**:
- Set **Workflow permissions** to **Read and write**
- Enable **Allow GitHub Actions to create and approve pull requests**

## 5) Token permissions for agent workflows

For workflows that must create branches, push commits, or open PRs, set explicit permissions:

```yaml
permissions:
  contents: write
  pull-requests: write
```

Use `pull-requests: write` only when the workflow must open or update PRs.

## 6) Branch naming for existing publish flows

Current publish workflows trigger from branches that start with:
- `Neo/`
- `Fabric/`
- `Forge/`

Keep agent PR branches outside these prefixes so PR automation branches do not look like production branches.
