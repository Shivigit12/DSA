class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ans = new ArrayList<>();
        int n = intervals.length;
        for(int i = 0; i < n; i++) {
            if(intervals[i][1] < newInterval[0]) {
                ans.add(intervals[i]);
            } else if(intervals[i][0] > newInterval[1]) {
                ans.add(newInterval);
                newInterval = intervals[i];
            } else if(intervals[i][0] <= newInterval[1] || intervals[i][1] >= newInterval[0]) {
                newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
                newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            }
        }
        ans.add(newInterval);
        return ans.toArray(new int[ans.size()][]);
    }
}