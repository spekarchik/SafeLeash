# GitHub Agent Branch & Push Rules

This repository should use two separate branch rulesets:

## 1) Protected branches ruleset

Apply to:
- `main`
- `release/**` (if/when release branches are used)

Recommended settings:
- Require pull request before merging
- Require status checks before merging
- Block force pushes
- Block branch deletion

## 2) Agent branches ruleset

Apply to branches dedicated to automation, for example:
- `agent/**`
- `copilot/**`
- `Neo/agent/**`
- `Fabric/agent/**`
- `Forge/agent/**`

Recommended settings:
- Allow direct pushes (do not require PR on these branches)
- Allow branch creation by the automation identity
- Keep force push blocked
- Keep branch deletion blocked unless your workflow requires cleanup

Bypass/allow actors:
- Add the GitHub App identity used by your agent
- Optionally add `github-actions[bot]` if your automation flow needs it

## 3) Repository Actions settings

In **Settings → Actions → General**:
- Set **Workflow permissions** to **Read and write**
- Enable **Allow GitHub Actions to create and approve pull requests**

## 4) Token permissions for agent workflows

For workflows that must create branches, push commits, or open PRs, set explicit permissions:

```yaml
permissions:
  contents: write
  pull-requests: write
```

Use `pull-requests: write` only when the workflow must open or update PRs.

## 5) Branch naming for existing publish flows

Current publish workflows trigger from branches that start with:
- `Neo/`
- `Fabric/`
- `Forge/`

If an agent-created branch should participate in publish flows, keep one of those prefixes in the branch name.
