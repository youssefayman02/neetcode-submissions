class Solution {
    public int characterReplacement(String s, int k) {
        int res = 0;
        Map<Character, Integer> map = new HashMap<>();

        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            map.put(c, map.getOrDefault(c, 0) + 1);
            int max = 0;
            for (char c1 : map.keySet()) {
                max = Math.max(max, map.get(c1));
            }
            while ((r - l + 1 - max) > k) {
                System.out.println(map.get(s.charAt(l)));
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                l++;
            }
            res = Math.max(res, r - l + 1);
        }

        return res;
    }
}
