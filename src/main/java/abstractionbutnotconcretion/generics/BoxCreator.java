package abstractionbutnotconcretion.generics;

public class BoxCreator {


    //create generic key value store

    public static void main(String[] args) {
        Box<Candy> candyBox = new Box<>();

        candyBox.add(new Candy("choco"));

    }

}
