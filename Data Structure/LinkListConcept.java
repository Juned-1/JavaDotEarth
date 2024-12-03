public class LinkListConcept {
    public static void main(String[] args) {
        LinkedList<Integer> l = new LinkedList<Integer>();
        l.deleteFrom(0); //trying to delete when list is empty
        l.append(2);
        l.append(4);
        l.append(6);
        l.insertAt(0, 8); //inserting at beginning
        l.insertAt(2, 7); //inserting any random pos
        l.insertAt(5, 10); //inserting at end
        l.insertAt(7, 11); //trying to inserty at invalid indices
        l.show();
        l.deleteFrom(6); //trying to delete from element does not exist
        l.deleteFrom(5); //deleting from end
        l.deleteFrom(0); //deleting from beginning
        l.deleteFrom(2); //deleting from in between 
        l.show();
        System.out.println(l.search(8));
        System.out.println(l.search(2));
        System.out.println(l.search(6));
        System.out.println(l.search(7));
    }
}
