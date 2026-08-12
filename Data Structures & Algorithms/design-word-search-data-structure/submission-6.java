class WordDictionary {

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

    public WordDictionary() {
        this.head = new Node('#', false);
    }

    public void addWord(String word) {
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
        return recursion(0, lowerCaseWord, head);
    }

    private boolean recursion(int index, String word, Node root) {
        Node cur = root;
        for (int i = index; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == '.') {
                for (Node node : cur.children.values()) {
                    if (recursion(i + 1, word, node)) return true;
                }
                return false;
            } else {
                if (cur.children.containsKey(c)) {
                    cur = cur.children.get(c);
                } else {
                    return false;
                }

            }
        }
        return cur.isWord;
    }}

