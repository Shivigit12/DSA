class Solution {
    public int minOperations(String[] logs) {
        int count = 0;
        for(int i = 0; i < logs.length; i++) {
            if(logs[i].startsWith("..")) {
                if(count > 0)
                    count--;
            }
            else if(logs[i].matches("^[a-zA-Z0-9].*"))
                count++;
            
        }
        if(count < 1)
            return 0;
        return count;
    }
}