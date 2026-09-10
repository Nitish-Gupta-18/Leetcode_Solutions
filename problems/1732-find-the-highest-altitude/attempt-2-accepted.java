class Solution {
    public int largestAltitude(int[] gain) {
        int maxHeight = 0;
        int currHeight = 0;

        for (int i = 0; i < gain.length; i++) {
            currHeight = currHeight + gain[i];

            if (currHeight > maxHeight) {
                maxHeight = currHeight;
            }
        }

        return maxHeight;
    }
}