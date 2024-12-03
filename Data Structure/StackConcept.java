class Stack<T>{
    private Node<T> top;
    private int siz;
    public Stack(){
        siz = 0;
    }
    public int size(){
        return siz;
    }
    @SuppressWarnings("unused")
    public void push(T data){
        try{
            Node<T> node = new Node<T>(data);
            if(node == null) throw new Exception("Memory allocation failed!");
            if(top == null) top = node;
            else{
                node.setNextLink(top);
                top = node;
            }
            siz++;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public T pop(){
        T data = null;
        try{
            if(top == null) throw new Exception("Underflow! Stack is empty.");
            data = top.getData();
            top = top.getNextLink();
            siz--;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return data;
    }
    public void show(){
        try{
            if(top == null) throw new Exception("Underflow! Stack is empty.");
            Node<T> node = top;
            System.out.print("[");
            while(node != null){
                if(node.getNextLink() == null) System.out.print(node.getData() + "]");
                else System.out.print(node.getData() + " ");
                node = node.getNextLink();
            }
            System.out.println();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public T peek(){
        T data = null;
        try{
            if(top == null) throw new Exception("Underflow! Stack is empty.");
            data = top.getData();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return data;
    }
}
class StackConcept{
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<Integer>();
        st.push(5);
        st.push(7);
        st.push(10);
        st.show();
        System.out.println(st.peek());
        st.show();
        System.out.println(st.pop());
        st.show();
        System.out.println(st.size());
        st.pop();
        st.pop();
        System.out.println(st.pop());
        st.show();
        System.out.println(st.peek());
    }
}