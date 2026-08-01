public class LockOne{
    private boolean[] flag = new boolean[2]; //flags for either thread as indicator for C.S entry

    public void lock(int i){ //parameter to manually set ID to other 0 or 1

        int j = 1 - i; //obtains other ID
        flag[i] = true; //thread raises it flag when ready to enter C.S
        while(flag[j]){}  //waits for the other thread
    }

    public void unlock(int i){
        flag[i] = false; //relases the lock to indicate to other thread its exit from C.S and its chance to enter
    }
}
