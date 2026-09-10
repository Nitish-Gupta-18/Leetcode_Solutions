class Solution {
    public int lengthOfLastWord(String s) {
        int length = 0;
        int i;

        
        for (i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                break; 
            }
        }

        
        for (; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                break;
            }
            length++;
        }

        return length;
    }
}