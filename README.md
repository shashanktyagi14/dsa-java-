# DSA in Java

A structured, testable collection of data structures and algorithms implemented in Java. The goal is to build a reliable reference for problem solving: clear implementations, documented complexity, edge-case tests, and small runnable examples.

## Project status

This repository is being built incrementally. Only solutions that have been implemented and checked belong in the completed sections. Problem-specific solutions should include the source/problem link and any assumptions in their file header or README.

## Topics

| Area | What belongs here |
|---|---|
| Arrays and strings | Two pointers, sliding window, prefix sums, sorting, searching |
| Hashing | Hash maps, hash sets, frequency counting |
| Linked lists | Reversal, cycle detection, merging, pointer techniques |
| Stacks and queues | Monotonic stack, deque, expression evaluation |
| Trees | Traversals, BST operations, LCA, diameter |
| Heaps | Priority queues, top-K, streaming problems |
| Graphs | BFS, DFS, shortest paths, topological sort, DSU |
| Recursion and backtracking | Subsets, permutations, constraint search |
| Dynamic programming | Knapsack, subsequences, grid DP, interval DP |
| Greedy | Scheduling, intervals, exchange arguments |
| Bit manipulation | Masks, XOR, bit tricks |
| Tries | Prefix lookup and word search |

## Requirements

- JDK 17 or newer
- Maven 3.8+

## Build and test

```bash
mvn test
```

Compile the project:

```bash
mvn -q -DskipTests package
```

## Repository layout

```text
src/
  main/java/com/shashank/dsa/
    arrays/
    strings/
    hashing/
    linkedlist/
    stack/
    queue/
    trees/
    heaps/
    graphs/
    backtracking/
    dp/
    greedy/
    bitmanipulation/
    trie/
  test/java/com/shashank/dsa/
docs/
  problem-index.md
```

Each implementation should:
1. Use a descriptive class and method name.
2. State important preconditions and edge-case behavior.
3. Avoid reading from standard input inside reusable algorithm classes.
4. Have time and space complexity documented.
5. Include unit tests for normal, boundary, and invalid-input cases where applicable.

## Contributing

See [CONTRIBUTING.md](CONTRIBUTING.md). Prefer one focused commit per logical improvement. Do not add placeholder solutions, copied submissions without attribution, or files that have not been checked.

## License

MIT. See [LICENSE](LICENSE).
