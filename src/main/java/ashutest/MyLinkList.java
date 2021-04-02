public class MyLinkList<E> implements Cloneable{

    Node<E> head;
    Node<E> tail;

    private class Node<E> {
        Node<E> prev =null;
        Node<E> next =null;
        E e;


    }

    void addFirst(E e) {

        Node<E> node = new Node();
        node.prev = null;
        node.next = head;
        node.e = e;

        head = node;

    }

    void addLast(E e) {

        Node<E> node = new Node();


        node.prev = tail;
        node.next = null;
        node.e = e;

        tail = node;

    }

    E removeFirst() {

        if (head != null) {
            Node node = head;

            head = head.next;
            head.prev = null;


            E e = (E)node.e;
            node = null;

            return e;
        }
            return null;

    }

    public static void main(String[] args) throws CloneNotSupportedException{

        MyLinkList<String> str = new MyLinkList<>();
        str.addFirst("Shweta");
        str.addLast("Neema");
        str.addFirst("Mrs");

        System.out.println(str.removeFirst());
        System.out.println(str.toString());

        str.clone();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
