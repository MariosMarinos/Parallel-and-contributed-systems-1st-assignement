public class SafeBridge {
 
	 private int nred  = 0;//red cars on bridge
	 private int nblue = 0;//blue cars on bridge

	//Methods
	public synchronized void redEnter(RedCars2 car) throws InterruptedException {
		while (nblue>0 || nred==1) wait();// an einai kapoio mple nimata stin gefira i einai 1 kokkino perimenei.
	    nred++;//auksisi kokkinwn nimatwn( krisimo tmima)
	    System.out.println(car.getID()+ " Passing at " +  Main.Time());//print
    }

    public synchronized void redExit(RedCars2 car){
    	nred--;//meiwsi twn kokkinwn nimatwn 
    	if (nred==0)//an den uparxei allo kokkino nima stin gefira ksipnima olwn twn nimatwn.
    		notifyAll();
    	System.out.println(car.getID() +" Passed at " +  Main.Time());//print
    	
    }

    public synchronized void blueEnter(BlueCars2 car) throws InterruptedException {
    	while(nred>0 || nblue==1) wait();// an einai kapoio kokkino nima panw stn gefira i an einai 1 mple tote perimenei.
        nblue++;//auksisi twn mple nimatwn (krisimo tmima)
        System.out.println(car.getID() + " Passing at " +  Main.Time());//print
  
    }

     public synchronized void blueExit(BlueCars2 car){
    	nblue--;//meiwsi mple nimatwn
    	if (nblue==0)//an den uparxei allo mple nima stin gefira sipnima olwn twn nimatwn.
    		notifyAll();
    	System.out.println(car.getID() +" Passed at " +  Main.Time());//print
    	}
}
