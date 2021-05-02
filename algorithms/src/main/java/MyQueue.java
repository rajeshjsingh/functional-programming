import java.util.Arrays;

public class MyQueue<E> {

    Object[]   store;
    private  static  int DEFAULT_CAPACITY = 10;
    int count = 0;
    int size =0;
    public static void main(String[] args) {
        MyQueue<Integer> myQueue = new MyQueue<>();
        myQueue.add(1);
        myQueue.add(2);

        System.out.println(myQueue.get());
        System.out.println(myQueue.get());
    }

    public MyQueue(){
        store = new Object[DEFAULT_CAPACITY];
    }

    public  boolean add(E element ){
        if(size == DEFAULT_CAPACITY)  return  false;
        store[size++] = element;
       // count++;
        return true;
    }

    public E get(){
        return (E) store[count++];
    }
}

