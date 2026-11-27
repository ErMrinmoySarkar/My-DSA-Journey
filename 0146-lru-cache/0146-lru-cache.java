class LRUCache {
    class Node{ //for DLL
        int key,val;
        Node prev;
        Node next;
        Node(int key, int val){
            this.key = key;
            this.val = val;
            prev = next = null;
        }
    }
    //dumy node
    Node head = new Node(-1,-1);
    Node tail = new Node(-1,-1);

    int limit;
    HashMap<Integer,Node>cache = new HashMap<>();
    public LRUCache(int capacity) {
        limit = capacity;
        head.next = tail;
        tail.prev = head;
    }

    private void addNode(Node newNode){
        Node temp = head.next;

        newNode.next = temp;
        newNode.prev = head;

        head.next = newNode;
        temp.prev = newNode; 
    }
    private void removeNode(Node oldNode){
        Node back = oldNode.prev;
        Node front = oldNode.next;
        
        back.next = front;
        front.prev = back;
    }
    public int get(int key) {
        if(cache.containsKey(key)){
            Node currNode = cache.get(key);
            cache.remove(key);
            removeNode(currNode);
            addNode(currNode);

            cache.put(key,head.next);

            return currNode.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)){
            Node currNode = cache.get(key);
            cache.remove(key);
            removeNode(currNode);
        }

        if(cache.size() == limit){
            cache.remove(tail.prev.key);
            removeNode(tail.prev);
        }

        addNode(new Node(key,value));
        cache.put(key,head.next);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */