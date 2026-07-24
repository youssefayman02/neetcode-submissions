class Solution {

    public String encode(List<String> strs) {
        String res = "";
        for (String s : strs) {
            res += s.length() + "#" + s; 
        }
        return res;
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            StringBuilder s = new StringBuilder();
            while (str.charAt(i) != '#') {
                s.append(str.charAt(i));
                i++;
            }
            int size = Integer.parseInt(s.toString());
            res.add(str.substring(i + 1, i + 1 + size));
            i += size + 1;
        }
        
        return res;
    }
}
