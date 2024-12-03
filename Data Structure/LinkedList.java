public class LinkedList<T>{
    private Node<T> head;
    public void append(T data){
        Node<T> node = new Node<T>(data);
        if(head == null){
            head = node;
        }else{
            Node<T> temp = head;
            while(temp.getNextLink() != null){
                temp = temp.getNextLink();
            }
            temp.setNextLink(node);
            temp = null; //making temp null, temp reference become ready for garbage collection
        }
    }

    public void insertAt(int index, T data){
        Node<T> node = new Node<T>(data);
        try{
            if(index < 0){
                throw new Exception("Invalid negative index " + index + "!");
            }
            else if(index == 0){
                node.setNextLink(head);
                head = node;
            }else{
                Node<T> temp = head;
                for(int i = 0; i < index-1; i++){
                    temp = temp.getNextLink();
                }
                if(temp == null){
                    throw new Exception("index " + index + " is invalid! does not exist.");
                }
                node.setNextLink(temp.getNextLink());
                temp.setNextLink(node);
                temp = null;
            }
        }catch(Exception e){
            node = null; //making node unavilable to use and ready for garbage collection
            System.out.println(e.getMessage());
        }
    }

    public void deleteFrom(int index){
        try{
            if(head == null) throw new Exception("List is empty!");
            if(index == 0){
                head = head.getNextLink();
            }else{
                Node<T> temp = head;
                for(int i = 0; i < index-1; i++){
                    temp = temp.getNextLink();
                }
                if(temp.getNextLink() == null) throw new Exception("Failed deletion! Invalid " + index + " index!");
                temp.setNextLink(temp.getNextLink().getNextLink());
                temp = null;
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

    }

    public int search(T element){
        //return index of element
        int index = 0;
        Node<T> temp = head;
        while(temp != null){
            if(temp.getData() == element){
                temp = null; //destroying pointer
                return index;
            }
            index++;
            temp = temp.getNextLink();
        }
        return -1;
    }

    public void show(){
        Node<T> temp = head;
        System.out.print("[");
        while(temp != null){
            if(temp.getNextLink() == null){
                System.out.println(temp.getData() + "]");
            }else{
                System.out.print(temp.getData() + " ");
            }
            temp = temp.getNextLink();
        }
    }

}
