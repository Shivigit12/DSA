class Solution {
    public String reverseWords(String s) {
        String str[] = s.split(" ");
        StringBuilder result = new StringBuilder();
        
        for(int i = 0; i < str.length; i++) {
            StringBuilder sb = new StringBuilder();
             System.out.print(str[i]+" ");
            sb.append(str[i]);
            sb.reverse();
            
           result.append(sb + " ");
        } 
        //result.setLength(result.length() - 1);
        return result.toString().trim();
    }
}