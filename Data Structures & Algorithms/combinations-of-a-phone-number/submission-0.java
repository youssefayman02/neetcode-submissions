class Solution {

    private Map<Integer, String> map;

    public List<String> letterCombinations(String digits) {
        this.map = new HashMap<>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");

        List<String> res = new ArrayList<>();
        if (digits.length() == 0) return res;

        dfs(digits, 0, new StringBuilder(), res);
        return res;
    }

    public void dfs(String digits, int i, StringBuilder sb, List<String> res) {
        if (i == digits.length()) {
            res.add(sb.toString());
            return;
        }

        String possibleChars = map.get(Integer.parseInt("" + digits.charAt(i)));
        for (char c : possibleChars.toCharArray()) {
            dfs(digits, i + 1, sb.append(c), res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
