/*
 * @lc app=leetcode id=146 lang=java
 *
 * [146] LRU Cache
 */

// @lc code=start
class LRUCache {
    // public static void main(String[] args) {
    //     LRUCache cache = new LRUCache(2);
    //     cache.put(1, 1);
    //     cache.put(2, 2);
    //     cache.get(1);
    //     cache.put(3, 3);
    //     cache.get(2);
    //     cache.put(4, 4);
    //     cache.get(1);
    //     cache.get(3);
    //     cache.get(4);
    // }

    class Node {
        Node(int key, int value) {this.key = key; val = value; }
        int key;
        int val;
        Node prev;
        Node next;
    }

    private Node[] map = new Node[10001];
    private int capacity = 0;
    private int size = 0;
    private Node dummyHead = new Node(-1, 0);
    private Node tail = null;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        Node node = map[key];
        if (node == null) {
            return -1;
        }
        updateHead(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        Node node = map[key];
        if (node == null) {
            node = new Node(key, value);
            map[key] = node;
            if (dummyHead.next != null) {
                dummyHead.next.prev = node;
            }
            node.next = dummyHead.next;
            node.prev = dummyHead;
            dummyHead.next = node;
            if (size == capacity) {
                removeTail();
            } else {
                ++size;
                if (size == 1) {
                    tail = node;
                }
            }
        } else {
            node.val = value;
            updateHead(node);
        }
    }

    private void updateHead(Node node) {
        if (node == dummyHead.next) {
            return;
        }

        // break chain
        if (node.prev != null) {
            node.prev.next = node.next;
        }

        if (node.next != null) {
            node.next.prev = node.prev;
        }

        // set head
        if (dummyHead.next != null) {
            dummyHead.next.prev = node;
        }

        // set tail
        if (node == tail) {
            tail = tail.prev;
            if (tail == dummyHead) {
                tail = null;
            } else {
                tail.next = null;
            }
        }
        node.next = dummyHead.next;
        node.prev = dummyHead;
        dummyHead.next = node;
    }

    private void removeTail() {
        if (tail == null) {
            return;
        }
        map[tail.key] = null;
        tail.prev.next = null;
        tail = tail.prev;
        if (tail == dummyHead) {
            tail = null;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end

