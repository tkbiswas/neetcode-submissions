class Solution {
    public boolean isValid(String s) {
        if(s.length()==1)
            return false;
        var stack = new Stack<Character>();
        for(Character c : s.toCharArray()){
            switch(c){
                case '(':
                    stack.push(c);
                    break;
                case '{':
                    stack.push(c);
                    break;
                case '[':
                    stack.push(c);
                    break;
                case ')':
                    if(!stack.isEmpty() && stack.peek() == '(')
                        stack.pop();
                    else
                        return false;
                    break;    
                case '}':
                     if(!stack.isEmpty() && stack.peek() == '{')
                        stack.pop();
                    else
                        return false;
                    break;
                case ']':
                     if(!stack.isEmpty() && stack.peek() == '[')
                        stack.pop();
                    else
                        return false;
                    break;
            }
        }
        return stack.isEmpty();
    }
}
