class Solution {
    public int sumOfPower(int[] nums) {
        Arrays.sort(nums);

        long mod = 1_000_000_007L;
        long ans = 0;
        long prefix = 0;

        for (int x : nums) {
            long square = (1L * x * x) % mod;

            ans = (ans + square * ((prefix + x) % mod)) % mod;

            prefix = (2 * prefix + x) % mod;
        }

        return (int) ans;
    }
}