import java.util.ArrayList;

class Map<K, V> {

    class MapNode<K, V> {
        K key;
        V value;
        MapNode<K, V> next;

        public MapNode(K key, V value) {
            this.key = key;
            this.value = value;
            next = null;
        }
    }

    ArrayList<MapNode<K, V>> buckets;
    int size;
    int numBuckets;
    final double DEFAULT_LOAD_FACTOR = 0.75;

    public Map() {
        numBuckets = 5;
        buckets = new ArrayList<>(numBuckets);
        for (int i = 0; i < numBuckets; i++) {
            buckets.add(null);
        }
        System.out.println("HashMap created");
        System.out.println("Number of pairs in the Map: " + size);
        System.out.println("Size of Map: " + numBuckets);
        System.out.println("Default Load Factor : " + DEFAULT_LOAD_FACTOR + "\n");
    }

    private int getBucketInd(K key) {
        int hashCode = key.hashCode();
        return (hashCode % numBuckets);
    }

    public void insert(K key, V value) {
        int bucketInd = getBucketInd(key);
        MapNode<K, V> head = buckets.get(bucketInd);
        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }
        MapNode<K, V> newElementNode = new MapNode<K, V>(key, value);
        head = buckets.get(bucketInd);
        newElementNode.next = head;
        buckets.set(bucketInd, newElementNode);

        System.out.println("Pair(" + key + ", " + value + ") inserted successfully.\n");

        size++;
        double loadFactor = (1.0 * size) / numBuckets;
        System.out.println("Current Load factor = " + loadFactor);
        if (loadFactor > DEFAULT_LOAD_FACTOR) {
            System.out.println(loadFactor + " is greater than " + DEFAULT_LOAD_FACTOR);
            System.out.println("Therefore Rehashing will be done.\n");
            rehash();
            System.out.println("New Size of Map: " + numBuckets + "\n");
        }
        System.out.println("Number of pairs in the Map: " + size);
        System.out.println("Size of Map: " + numBuckets + "\n");
    }

    private void rehash() {
        System.out.println("\n***Rehashing Started***\n");
        ArrayList<MapNode<K, V>> temp = buckets;
        buckets = new ArrayList<MapNode<K, V>>(2 * numBuckets);
        for (int i = 0; i < 2 * numBuckets; i++) {
            buckets.add(null);
        }
        size = 0;
        numBuckets *= 2;

        for (int i = 0; i < temp.size(); i++) {
            MapNode<K, V> head = temp.get(i);
            while (head != null) {
                K key = head.key;
                V val = head.value;
                insert(key, val);
                head = head.next;
            }
        }

        System.out.println("\n***Rehashing Ended***\n");
    }

    public void printMap() {
        ArrayList<MapNode<K, V>> temp = buckets;
        System.out.println("Current HashMap:");
        for (int i = 0; i < temp.size(); i++) {
            MapNode<K, V> head = temp.get(i);
            while (head != null) {
                System.out.println("key = " + head.key + ", val = " + head.value);
                head = head.next;
            }
        }
        System.out.println();
    }

    public V getValue(K key) {
        int actualIndex = getBucketInd(key);
        MapNode<K, V> temp = buckets.get(actualIndex);
        while (temp != null) {
            if (temp.key == key) {
                return temp.value;
            }
            temp = temp.next;
        }
        return null;
    }
}

class Solution {

    public static void main(String[] args) {
        Map<Integer, String> map = new Map<Integer, String>();
        map.insert(1, "Geeks");
        map.printMap();
        map.insert(2, "forGeeks");
        map.printMap();
        map.insert(3, "A");
        map.printMap();
        map.insert(4, "Computer");
        map.printMap();
        map.insert(5, "Portal");
        map.printMap();
        int key = 4;
        String value = map.getValue(key);
        System.out.println("Value at key " + key + " is: " + value);
    }
}
