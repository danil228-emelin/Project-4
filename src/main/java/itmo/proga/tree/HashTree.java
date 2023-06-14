package itmo.proga.tree;

import java.util.*;
import java.util.stream.Collectors;

public class HashTree<K, V> implements Functionality<K, V>, Iterable<V> {
    private Node<K, V>[] hashTable;
    private int size = 0;
    private double threshold;

    @SuppressWarnings("unchecked")
    public HashTree() {

        hashTable = (Node<K, V>[]) new Node[16];
        threshold = hashTable.length * 0.75;
    }


    @Override
    public boolean insert(K key, V value) {
        if (size + 1 >= threshold) {
            threshold *= 2;
            arrayDoubling();
        }
        Node<K, V> newNode = new Node<>(key, value);

        int index = newNode.getHash();

        if (hashTable[index] == null) {
            return simpleAdd(index, newNode);
        }
        List<Node<K, V>> nodeList = hashTable[index].getNodes();
        for (Node<K, V> node : nodeList) {
            if (keyExistButValueNew(node, newNode, value) || collisionProcessing(node, newNode, nodeList)) {
                return true;
            }
        }
        return false;
    }

    private boolean simpleAdd(int index, Node<K, V> newNode) {
        hashTable[index] = newNode;
        hashTable[index].getNodes().add(newNode);

        size++;
        return true;
    }

    private boolean keyExistButValueNew(Node<K, V> nodeFromList, Node<K, V> newNode, V value) {
        if (newNode.getKey().equals(nodeFromList.getKey()) && !newNode.getValue().equals(nodeFromList.getValue())) {
            nodeFromList.setValue(value);
            return true;
        }
        return false;
    }

    private boolean collisionProcessing(Node<K, V> nodeFromList, Node<K, V> newNode, List<Node<K, V>> nodes) {
        if (newNode.getHash() == nodeFromList.getHash() && !Objects.equals(newNode.key, nodeFromList.key)
                && !Objects.equals(newNode.value, nodeFromList.value)) {
            nodes.add(newNode);
            size++;
            return true;
        }

        return false;
    }

    @SuppressWarnings("unchecked")
    private void arrayDoubling() {
        Node<K, V>[] oldOne = hashTable;
        hashTable = (Node<K, V>[]) new Node[oldOne.length * 2];
        size = 0;
        for (Node<K, V> node : oldOne) {
            if (node != null) {
                for (Node<K, V> n : node.getNodes()) {
                    insert(n.key, n.value);
                }
            }
        }
    }

    @Override
    public boolean delete(K key) {
        int index = hash(key);
        if (hashTable[index] == null) {
            return false;
        }
        if (hashTable[index].getNodes().size() == 1) {
            hashTable[index].getNodes().remove(0);
            return true;
        }
        List<Node<K, V>> nodeList = hashTable[index].getNodes();
        for (Node<K, V> node : nodeList) {
            if (key.equals(node.getKey())) {
                nodeList.remove(node);
                return true;
            }

        }
        return false;
    }

    @Override
    public V get(K key) {
        int index = hash(key);
        if (hashTable[index] != null) {

            List<Node<K, V>> list = hashTable[index].getNodes();

            for (Node<K, V> node : list) {
                if (key.equals(node.getKey())) {
                    return node.getValue();
                }
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private int hash(K key) {

        int hash = 31 * 17 + key.hashCode();

        return Math.abs(hash % hashTable.length);
    }

    @Override
    public Iterator<V> iterator() {
        return new Iterator<>() {
            int counterArray = -1;
            int valuesCounter = 0;
            Iterator<Node<K, V>> subIterator = null;

            @Override
            public boolean hasNext() {
                if (valuesCounter == size)
                    return false;
                if (subIterator == null || !subIterator.hasNext()) {
                    if (moveToNextCell()) {
                        subIterator = hashTable[counterArray].getNodes().iterator();
                    } else {
                        return false;
                    }
                }

                return subIterator.hasNext();

            }

            private boolean moveToNextCell() {
                do {
                    counterArray++;
                } while (counterArray < hashTable.length && hashTable[counterArray] == null);

                return counterArray < hashTable.length && hashTable[counterArray] != null;
            }

            @Override
            public V next() {
                valuesCounter++;
                return subIterator.next().getValue();
            }
        };


    }

    public List<K> getKeys() {
        return Arrays.stream(hashTable).
                filter(Objects::nonNull).
                map(Node::getKey).
                collect(Collectors.toList());

    }

    public class Node<K, V> {
        private final List<Node<K, V>> nodes;
        private final K key;
        private V value;

        private final int hash;
        private Node(K key, V value) {
            this.key = key;
            this.value = value;
            nodes = new LinkedList<>();
            hash = hash();
        }

        public int getHash() {
            return hash;
        }

        private List<Node<K, V>> getNodes() {
            return nodes;
        }

        private int hash() {
            return Math.abs(hashCode() % hashTable.length);
        }

        protected K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        private void setValue(V value) {
            this.value = value;
        }

        @Override
        public int hashCode() {

            int hash = 31 * 17 + key.hashCode();
            return Math.abs(hash);
        }

        @Override
        @SuppressWarnings("unchecked")
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Node) {
                Node<K, V> node = (Node<K, V>) obj;
                return (Objects.equals(key, node.getKey())
                        && Objects.equals(value, node.getValue()));
            }

            return false;
        }
    }

    public static void main(String[] args) {
        HashTree<String, String> collection = new HashTree<>();
        collection.insert("368149", "danil");
        collection.insert("368134", "Roma");
        collection.insert("368134", "Vi");
        collection.insert("125124", "Oleg");

        for (String name : collection) {
            System.out.println(name);
        }

    }
}
