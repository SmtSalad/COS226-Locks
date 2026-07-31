public class Petersons {

    //indictates which thread wants to enter the critical section
    private boolean[] flag = new boolean[2];
    private int turn; // indicates which thread should wait if both threads want to enter the critical section at the same time

    public void lock(int id){//Requests accwss ro the critical section
        int other = 1 - id; // determines id of other thread

        flag[id] = true;//indictaes that this thread wants to enter thre critical section
        turn = id;//giving priority to other thread making this threrasd the victim if both threads request simultaneously then the thread stored in turn will wait

        //waits while the other thread also wants to enter and it is still this threads turn to wait
        while(flag[other] && turn == id){
            Thread.yield();
        }
        //once loop exits the thread has access to the critical section
    }

    public void unlock(int id){
        //indicates that the thread no longer wishes to enter the C.S allowing other threads to enter
        flag[id] = false;
    }


    
}
