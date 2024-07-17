package generics;


import java.util.ArrayList;
import java.util.List;

//this can hold a candy, or pen, or may be pencil
public class Box<T> {

    List<T> items;// if we have this then we can have candy, pencil, pen or anything in the same box

    public Box() {
        items = new ArrayList<>();
    }
    public void add(T item) {
        items.add(item);
    }

}
