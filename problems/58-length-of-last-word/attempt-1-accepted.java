class Solution {
    public int lengthOfLastWord(String s) {
        int length = 0;
        int i;

        // Start from the end of the string and skip trailing spaces
        for (i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                break; // stop at the last letter
            }
        }

        // Now count characters of the last word
        for (; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                break;
            }
            length++;
        }

        return length;
    }
}