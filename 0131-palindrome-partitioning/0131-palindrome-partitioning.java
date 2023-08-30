class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> path = new ArrayList<>();
        checkPartition(0, s, path, res);
        return res;
    }
    
    public void checkPartition(int ind, String s, List<String> path, List<List<String>> res) {
        if(ind == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = ind; i < s.length(); i++) {
            if(checkPalindrome(s, ind, i)) {
                path.add(s.substring(ind, i + 1));
                checkPartition(i + 1, s, path, res);
                path.remove(path.size() - 1);
            }
        }
    }
    
    boolean checkPalindrome(String s, int i, int j) {
        while(i <= j) {
            if(s.charAt(i) != s.charAt(j))
                return false;
            else{
                i++;
                j--;
            }
        }
        return true;
    }
}