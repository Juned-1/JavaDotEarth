public class Node<T>{
    private T data;
    private Node<T> nextLink; //reference by default have null, we do not have to set
    public Node(T data){
        this.data = data;
    }
    public T getData() {
        return data;
    }
    public Node<T> getNextLink() {
        return nextLink;
    }
    public void setData(T data) {
        this.data = data;
    }
    public void setNextLink(Node<T> link) {
        this.nextLink = link;
    }
    
}