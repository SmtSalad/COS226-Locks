public class Counter {
    private int value; //the resource that the thread modifies
    private Petersons lock;  //Petersons lock used to ensure mutual exclusion

    public Counter(int initialValue){ //constructer
        value = initialValue;
        lock = new Petersons();
    }

    public void increment(int id){ // increments the counter and the thread must aquire the lock before entering the C.S
        lock.lock(id); // Requests access to C.S
        //the Crtical Section
        value++;
        System.out.println("Thread "+ id +" incremented: "+value);

        lock.unlock(id);//Releases the lock so the other Thread can enter
    }

    public void decrement(int id){//decrements the counter and the thread must aquire the lock before entering the C.S
        lock.lock(id); // Requests access to C.S
        //the Crtical Section
        value--;
        System.out.println("Thread "+ id +" decrement: "+value);

        lock.unlock(id);//Releases the lock so the other Thread can enter
    }

    public int getValue(){ // getter for current value
        return value;
    }
    
    
}
