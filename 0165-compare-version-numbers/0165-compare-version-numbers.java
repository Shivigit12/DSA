class Solution {
    public int compareVersion(String version1, String version2) {
        String s1[] = version1.split("\\.");
      String s2[] = version2.split("\\.");
      int length = Math.max(s1.length, s2.length);
      int v1[] = new int[length];
      int v2[] = new int[length];
      for(int i = 0; i < s1.length; i++){
        v1[i] = Integer.parseInt(s1[i]);
      }
      for(int i = 0; i < s2.length; i++){
        v2[i] = Integer.parseInt(s2[i]);
      }
      for(int i = 0; i < length; i++){
        if(v1[i] < v2[i])
          return -1;
        else if(v1[i] > v2[i])
          return 1;
      }
      return 0;
    }
}