class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int firstNum = Integer.MAX_VALUE;
        int secondNum = Integer.MIN_VALUE;
        int firstSum = 0;
        int secondSum = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == firstNum)
                firstSum++;
            else if(nums[i] == secondNum)
                secondSum++;
            else if(firstSum == 0) {
                firstNum = nums[i];
                firstSum = 1;
            }else if(secondSum == 0) {
                secondNum = nums[i];
                secondSum = 1;
            }
            else{
                firstSum--;
                secondSum--;
            }
        }
        
        firstSum = 0;
        secondSum = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == firstNum)
                firstSum++;
            else if(nums[i] == secondNum)
                secondSum++;
        }
            
            if(firstSum > nums.length / 3)
                result.add(firstNum);
            if(secondSum > nums.length / 3)
                result.add(secondNum);
        
        return result;
    }
}