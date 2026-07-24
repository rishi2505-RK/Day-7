class Solution {
    private List<Integer>[] graph;
    private int[] nums;
    private int target;

    public int componentValue(int[] nums, int[][] edges) {
        int n = nums.length;
        this.nums = nums;

        graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }

        int total = 0;
        for (int x : nums) total += x;

        for (int k = n; k >= 1; k--) {
            if (total % k != 0) continue;

            target = total / k;
            if (dfs(0, -1) == 0) {
                return k - 1;
            }
        }

        return 0;
    }

    private int dfs(int node, int parent) {
        int sum = nums[node];

        for (int next : graph[node]) {
            if (next != parent) {
                sum += dfs(next, node);
            }
        }

        if (sum == target) return 0;
        return sum;
    }
}