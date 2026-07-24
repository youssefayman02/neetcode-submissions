class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> map = new HashMap<>();

        int j = 0;
        for (char c : order.toCharArray()) {
            map.put(c, j++);
        }

        for (int i = 0; i < words.length - 1; i++) {
            String s1 = words[i], s2 = words[i + 1];
            int firstIdx = 0, secondIdx = 0;
            int firstLen = s1.length(), secondLen = s2.length();
            while (firstIdx < firstLen && secondIdx < secondLen) {
                int pos1 = map.get(s1.charAt(firstIdx));
                int pos2 = map.get(s2.charAt(secondIdx));

                if (pos1 < pos2) break;
                if (pos1 > pos2) return false;
                 
                firstIdx++;
                secondIdx++;
            }

            if (secondIdx >= secondLen && firstIdx < firstLen) return false;
        }

        return true;
    }
}