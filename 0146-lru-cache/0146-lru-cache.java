class ListNode {
    ListNode next;
    ListNode prev;
    int key;
    int val;
    
    // Constructor for ListNode
    public ListNode(int key, int val) {
        this.next = null;
        this.prev = null;
        this.val = val;
        this.key = key;
    }
}

class LRUCache {
    // HashMap to store key-value pairs
    HashMap<Integer, ListNode> map = new HashMap<>();
    // Sentinel nodes for Doubly Linked List
    ListNode head = new ListNode(0, 0);
    ListNode tail = new ListNode(0, 0);
    int size; // Maximum capacity of the cache
    
    // Constructor to initialize the LRUCache
    public LRUCache(int capacity) {
        this.size = capacity;
        // Connect the head and tail sentinels to create an empty Doubly Linked List
        head.next = tail;
        tail.prev = head;
    }
    
    // Get the value associated with a key
    public int get(int key) {
        if (map.containsKey(key)) {
            ListNode temp = map.get(key);
            // Move the accessed node to the front of the list (indicating it's the most recently used)
            deleteNode(temp);
            addNode(temp);
            return temp.val;
        } else {
            return -1; // Cache miss
        }
    }
    
    // Put a key-value pair in the cache
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            // Key already exists, so delete the existing node
            deleteNode(map.get(key));
        }
        if (map.size() == size) {
            // If the cache is full, remove the least recently used item (tail.prev)
            deleteNode(tail.prev);
        }
        // Create a new node and add it to the front of the list and the HashMap
        addNode(new ListNode(key, value));
    }

    // Helper function to add a node to the front of the Doubly Linked List
    public void addNode(ListNode node) {
        map.put(node.key, node);
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    // Helper function to delete a node from the Doubly Linked List
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