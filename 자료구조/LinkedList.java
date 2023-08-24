package 자료구조;


class Node<E>{

    private E data;
    public Node<E> link;

    public Node(E data) {
        this.data = data;
        this.link = null;
    }
}

public class LinkedList<E> {

    private Node<E> head;
    private Node<E> tail;
    public int size;

    public LinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void add(){

    }

    private Node<E> search(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        Node<E> result = head;
        for(int i = 0 ; i < index ; i++){
            result = result.link;
        }
        return result;
    }



}
