class Solution {
    public String losingPlayer(int x, int y) {
        int i = 0;
        int j = 0;
        int counter = 0;
        while(x >= 0 && y >= 0) {
            x = x - 1;
            y = y - 4;
            if(counter % 2 == 0)
                i++;
            else
                j++;
            counter++;
        }
        if(i > j)
            return "Bob";
        return "Alice";
    }
}