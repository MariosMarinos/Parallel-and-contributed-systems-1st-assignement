
public class Bridge {
	//Methods
	public void redEnter(RedCars2 car) {
	    System.out.println(car.getID()+ " Passing at " +  Main.Time());
    }
	public void redExit(RedCars2 car){
    	System.out.println(car.getID() +" Passed at " +  Main.Time());
    }
    public void blueEnter(BlueCars2 car) {
        System.out.println(car.getID() + " Passing at " +  Main.Time());
    }
     public void blueExit(BlueCars2 car){
    	System.out.println(car.getID() +" Passed at " +  Main.Time());
    }
}
