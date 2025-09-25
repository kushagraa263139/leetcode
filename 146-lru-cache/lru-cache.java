class Node {
    int val;
    int key;
    Node pre;
    Node next;

    Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class LRUCache {
    int maxCapacity;
    int currCapacity;
    HashMap<Integer, Node> mp;
    Node head; // Dummy head
    Node tail; // Dummy tail

    public LRUCache(int capacity) {
        this.maxCapacity = capacity;
        this.currCapacity = 0;
        mp = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);

        // Connect dummy head and tail
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        if (!mp.containsKey(key)) return -1;

        Node node = mp.get(key);
        // Move this node to tail (most recently used)
        removeNode(node);
        addToTail(node);

        return node.val;
    }

    public void put(int key, int value) {
        if (mp.containsKey(key)) {
            // Update value and move node to tail
            Node node = mp.get(key);
            node.val = value;
            removeNode(node);
            addToTail(node);
        } else {
            // Insert new node
            if (currCapacity == maxCapacity) {
                // Remove LRU node (right after head)
                Node lru = head.next;
                removeNode(lru);
                mp.remove(lru.key);
                currCapacity--;
            }
            Node newNode = new Node(key, value);
            addToTail(newNode);
            mp.put(key, newNode);
            currCapacity++;
        }
    }

    // Helper to remove node from the list
    private void removeNode(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    // Helper to add node before tail (most recently used position)
    private void addToTail(Node node) {
        node.pre = tail.pre;
        tail.pre.next = node;
        node.next = tail;
        tail.pre = node;
    }
}
