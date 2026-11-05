# Implemented algorithms

Every entry below has a corresponding source implementation and unit tests. Complexity uses expected time where hash-based structures are involved.

| Topic | Algorithm | Time | Auxiliary space |
|---|---|---:|---:|
| Arrays | Two Sum | O(n) expected | O(n) |
| Arrays | Kadane maximum subarray | O(n) | O(1) |
| Arrays | Prefix sums | O(n) | O(n) |
| Binary search | Lower bound | O(log n) | O(1) |
| Binary search | First occurrence | O(log n) | O(1) |
| Sliding window | Maximum fixed-window sum | O(n) | O(1) |
| Sliding window | Longest subarray with at most k distinct values | O(n) expected | O(k) |
| Strings | Longest substring without repeating code points | O(n) expected | O(n) |
| Strings | Alphanumeric palindrome | O(n) | O(1) |
| Linked lists | Iterative list reversal | O(n) | O(1) |
| Linked lists | Floyd cycle detection | O(n) | O(1) |
| Linked lists | Middle node | O(n) | O(1) |
| Graphs | Unweighted BFS distances | O(V + E) | O(V) |
| Graphs | Deterministic Kahn topological sort | O((V + E) log V) | O(V) |
| Graphs | Disjoint set union | Amortized O(alpha(n)) per operation | O(n) |
| Dynamic programming | Minimum coin change | O(amount × coin count) | O(amount) |
| Dynamic programming | LIS length | O(n log n) | O(n) |
| Stack | Circular next-greater element | O(n) | O(n) |

Run `mvn test` to execute the test suite.
