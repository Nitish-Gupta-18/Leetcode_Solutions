class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        // First loop: merge from the back while both arrays have elements
        for (; i >= 0 && j >= 0; k--) {
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
        }

        // Second loop: if any elements left in nums2
        for (; j >= 0; k--, j--) {
            nums1[k] = nums2[j];
        }
    }
}