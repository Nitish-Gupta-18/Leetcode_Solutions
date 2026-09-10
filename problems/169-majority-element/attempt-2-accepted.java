class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int count = 0;

            // Count how many times nums[i] appears
            for (int j = 0; j < n; j++) {
                if (nums[j] == nums[i]) {
                    count++;
                }
            }

            // If it appears more than half → return it
            if (count > n / 2) {
                return nums[i];
            }
        }

        return -1; // Not needed if majority always exists
    }
}