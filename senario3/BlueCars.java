public class BlueCars implements Runnable  {
	private String id;          //name      
	private Bridge bridge;      //bridge being used
	//constructor
	public BlueCars(String id, Bridge bridge,int id_number) {
	    this.id = id;
	    this.bridge= bridge;
	    System.out.println(id+" Arrived at Time " +  Main.Time());   //print arrived time 
	}
	//getters
	public String getID() {
	    return id;
	}
	@Override
	public void run() {
        try {
			bridge.blueEnter(this);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
        try {
            Thread.sleep(1000); //1 second for crossing the bridge.
        } catch (InterruptedException e) {} 
        bridge.blueExit(this);
	}
}
