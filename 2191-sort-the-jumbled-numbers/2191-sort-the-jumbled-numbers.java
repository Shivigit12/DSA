class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            if(!map.containsKey(num)) {
                map.put(num, translateNums(num, mapping));
            }
        }
        Integer[] numbers = Arrays.stream(nums).boxed().toArray(Integer[] :: new);
        Arrays.sort(numbers, (a, b) -> Integer.compare(map.get(a), map.get(b)));
        for(int i = 0; i < nums.length; i++) {
            nums[i] = numbers[i];
        }
        return nums;
    }
    public int translateNums(int num, int[] mapping) {
        if(num == 0)
            return mapping[0];
        int res = 0;
        int mul = 1;
        while(num > 0) {
            int digit = num % 10;
            num = num / 10;
            res = res + mapping[digit] * mul;
            mul = mul * 10;
        }
        return res;
    }
}