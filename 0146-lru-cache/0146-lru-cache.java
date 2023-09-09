class ListNode {
    ListNode next;
    ListNode prev;
    int key;
    int val;
    
    public ListNode(int key, int val) {
        this.next = null;
        this.prev = null;
        this.key = key;
        this.val = val;
    }
}
class LRUCache {
    //HashMap to store key value pairs
    HashMap<Integer, ListNode> map = new HashMap<>();
    //Sentinel nodes for doubly linked list
    ListNode head = new ListNode(0, 0);
    ListNode tail = new ListNode(0, 0);
    int size;//Max capacity of the cache
    
    public LRUCache(int capacity) {
        this.size = capacity;
        //connect the head and tail sentinels to create an empty doubly linked list
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(map.containsKey(key)) {
            ListNode temp = map.get(key);
            //Move the accessed node to the front of the list
            deleteNode(temp);
            addNode(temp);
            return temp.val;
        }else{
            return -1; //Cache miss
        }
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key))
            deleteNode(map.get(key));
        if(map.size() == size)
            deleteNode(tail.prev);
        addNode(new ListNode(key, value));
    }
    
    public void addNode(ListNode node) {
        map.put(node.key, node);
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }
    public void deleteNode(ListNode node) {
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */