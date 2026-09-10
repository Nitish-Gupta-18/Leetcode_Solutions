class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            int target = nums1[i];
            int j = 0;

            while (nums2[j] != target) {
                j++;
            }

            int nextGreater = -1;
            for (int k = j + 1; k < nums2.length; k++) {
                if (nums2[k] > target) {
                    nextGreater = nums2[k];
                    break;
                }
            }

            result[i] = nextGreater;
        }

        return result;
    }
}