class PrefixTree {
    private final Node head;

    static class Node {
        char c;
        boolean isWord;
        Map<Character, Node> children;

        Node(char c, boolean isWord) {
            this.c = c;
            this.isWord = isWord;
            this.children = new HashMap<>();
        }
    }

    public PrefixTree() {
        this.head = new Node('#', false);
    }

    public void insert(String word) {
        String lowerCaseWord = word.toLowerCase();
        Node temp = head;
        for (char c : lowerCaseWord.toCharArray()) {
            if (!temp.children.containsKey(c)) {
                Node node = new Node(c, false);
                temp.children.put(c, node);
            }
            temp = temp.children.get(c);
        }
        temp.isWord = true;


    }

    public boolean search(String word) {
        String lowerCaseWord = word.toLowerCase();
        Node temp = head;
        for (char c : lowerCaseWord.toCharArray()) {
            if (temp.children.containsKey(c)) {
                temp = temp.children.get(c);
            } else return false;
        }
        return temp.isWord;
    }

    public boolean startsWith(String prefix) {
        String lowerCaseWord = prefix.toLowerCase();
        Node temp = head;
        for (char c : lowerCaseWord.toCharArray()) {
            if (temp.children.containsKey(c)) {
                temp = temp.children.get(c);
            } else return false;
        }
        return true;
    }
}
