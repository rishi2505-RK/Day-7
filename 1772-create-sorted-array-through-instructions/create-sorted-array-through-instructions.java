class Solution {
    private static final int MOD = 1_000_000_007;

    class Fenwick {
        int[] bit;

        Fenwick(int n) {
            bit = new int[n + 2];
        }

        void update(int idx, int val) {
            while (idx < bit.length) {
                bit[idx] += val;
                idx += idx & -idx;
            }
        }

        int query(int idx) {
            int sum = 0;
            while (idx > 0) {
                sum += bit[idx];
                idx -= idx & -idx;
            }
            return sum;
        }
    }

    public int createSortedArray(int[] instructions) {
        int max = 0;
        for (int x : instructions) {
            max = Math.max(max, x);
        }

        Fenwick ft = new Fenwick(max);
        long ans = 0;

        for (int i = 0; i < instructions.length; i++) {
            int x = instructions[i];

            int less = ft.query(x - 1);
            int greater = i - ft.query(x);

            ans = (ans + Math.min(less, greater)) % MOD;
            ft.update(x, 1);
        }

        return (int) ans;
    }
}