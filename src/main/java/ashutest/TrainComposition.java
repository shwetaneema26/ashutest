package ashutest;


public class TrainComposition {

    private static class Wagon
    {
        public int no;
        public Wagon left;
        public Wagon right;
        public Wagon()
        {
            no =0;
            left = null;
            right = null;
        }
        public Wagon(int id )
        {
            no =id;
            left = null;
            right = null;
        }
    }
    public Wagon left;
    public Wagon right;

    public TrainComposition()
    {
        left =  null;
        right = null;
    }
    public void displayWagonsFromLeft()
    {
        while(left!= null) {
            System.out.println(left.no);
            left = left.right;
        }
    }
    public void attachWagonFromLeft(int wagonId) {
        Wagon wagon = new Wagon(wagonId);
        if(left == null && right == null)
        {
            left = wagon;
            right = wagon;
        }
        else {
            left.left = wagon;
            wagon.right = left;
            left = wagon;
        }

    }

    public void attachWagonFromRight(int wagonId) {
        Wagon wagon = new Wagon(wagonId);
        if(left == null && right == null)
        {
            left = wagon;
            right =  wagon;
        }
        else {
            wagon.left = right;
            right.right = wagon;
            right = wagon;
        }
    }

    public int detachWagonFromLeft() {
        int wagonId = 0;
        if(left!=null)
        {
            wagonId = left.no;
            left.right.left = null;
            left = left.right;
        }
        return wagonId;
    }

    public int detachWagonFromRight() {
        int wagonId = 0;
        if(right!=null)
        {
            wagonId = right.no;
            right.left.right = null;
            right = right.left;
        }
        return wagonId;
    }

    public static void main(String[] args) {
        TrainComposition train = new TrainComposition();
        train.attachWagonFromLeft(7);
        train.attachWagonFromLeft(13);
        System.out.println(train.detachWagonFromRight()); // 7
        System.out.println(train.detachWagonFromLeft()); // 13
        //train.displayWagonsFromLeft();
    }
}
