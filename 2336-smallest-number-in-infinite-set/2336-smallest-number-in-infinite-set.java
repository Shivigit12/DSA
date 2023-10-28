class SmallestInfiniteSet {
    PriorityQueue<Integer> pq;
    HashSet<Integer> set;
    public SmallestInfiniteSet() {
        pq = new PriorityQueue<>(1000);
        set = new HashSet<>(1000);
        for(int i = 1; i <= 1000; i++) {
            pq.add(i);
            set.add(i);
        }
    }
    
    public int popSmallest() {
        int val =  pq.poll();
        set.remove(val);
        return val;
    }
    
    public void addBack(int num) {
        if(!set.contains(num)) {
            set.add(num);
            pq.add(num);
        }
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */