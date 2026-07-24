class Solution {
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            char c1 = Character.toLowerCase(s.charAt(left)), c2 = Character.toLowerCase(s.charAt(right));
            if (!(c1 >= 'a' && c1 <= 'z' || c1 >= '0' && c1 <= '9')) {
                left++;
                continue;
            } else if (!(c2 >= 'a' && c2 <= 'z' || c2 >= '0' && c2 <= '9')) {
                right--;
                continue;
            }
            if (c1 != c2) return false;
            left++;
            right--;
        }
        return true;
    }
}
