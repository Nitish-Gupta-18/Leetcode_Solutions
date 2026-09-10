class Solution {
    public boolean isPalindrome(String s) {
        if (s.isEmpty()){
            return true;
        }
        int start = 0;
        int last = s.length() - 1;
        while(start <= last)
        {
            char charleft = s.charAt(start);
            char charright = s.charAt(last);
            if(!Character.isLetterOrDigit(charleft))
                start++;
            else if(!Character.isLetterOrDigit(charright))
                last--;
            else{
                if(Character.toLowerCase(charleft) != Character.toLowerCase(charright))
                    return false;
                start++;
                last--;
            }
        }
        return true;
    }
}