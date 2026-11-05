# Contributing

Thanks for helping improve this Java DSA reference.

## Before adding a solution

- Prefer a small, focused implementation over a large collection of unrelated methods.
- Use Java 17-compatible language features.
- Put reusable code under `src/main/java/com/shashank/dsa/<topic>/`.
- Do not read from standard input or print from reusable algorithm methods.
- Document assumptions, edge cases, and time/space complexity in Javadoc.
- Cite the original problem URL when adding a platform-specific solution.
- Do not submit placeholders, generated filler, or copied code without attribution.

## Tests

Every algorithm change should include JUnit 5 tests under the matching package in `src/test/java`. Cover:
1. A normal case.
2. Empty or smallest valid input.
3. Boundary values and duplicates where relevant.
4. Invalid input behavior.

Run the full suite before submitting:

```bash
mvn test
```

## Commit guidance

Use descriptive commits that each represent one logical improvement, for example:
- `Add lower-bound binary search implementation`
- `Test linked-list cycle detection edge cases`

Do not split one change into artificial commits merely to increase activity.
