class LFUCache {
    class Node {
        int val;
        int freq;

        public Node(int val, int freq) {
            this.val = val;
            this.freq = freq;
        }

    }

    int capacity;
    // cache key and value with freq
    Map<Integer, Node> cache;
    // freq to set of cache keys
    Map<Integer, LinkedHashSet<Integer>> freqMap;
    int minFreq;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        freqMap = new HashMap<>();
        this.minFreq = 0;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            // remove the item from freqMap
            // add the item to new frqMap key
            LinkedHashSet<Integer> integers = this.freqMap.get(node.freq);
            int curFreq = node.freq;
            integers.remove(key);

            node.freq += 1;
            cache.put(key, node);

            if(this.minFreq == curFreq && this.freqMap.get(minFreq).isEmpty()){
                this.minFreq = node.freq;
            }

//            this.minFreq = Math.min(this.minFreq, node.freq);

            LinkedHashSet<Integer> orDefault = freqMap.getOrDefault(node.freq, new LinkedHashSet<>());
            orDefault.add(key);
            freqMap.put(node.freq, orDefault);


            return node.val;
        }

        return -1;

    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            get(key);
            Node node = cache.get(key);
            node.val = value;
            cache.put(key, node);
//            this.minFreq = Math.min(this.minFreq, node.freq);

        } else {
            Node node = new Node(value, 1);
            // create a new node
            // check capacity
            // if has capacity then add directly to the cache and freqMap
            // else first remove from cache and freqMap then add to the cache
            if (this.capacity == cache.size()) {
                Integer firstNode = this.freqMap.get(this.minFreq).getFirst();
                this.cache.remove(firstNode);
                this.freqMap.get(minFreq).removeFirst();
            }
            cache.put(key, node);
            LinkedHashSet<Integer> orDefault = freqMap.getOrDefault(1, new LinkedHashSet<>());
            orDefault.add(key);
            freqMap.put(1, orDefault);
            this.minFreq = 1;
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */