import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
public class Main {
	// i & j katholikes metavlites gia na mporw na tis kalesw mesa stin run tou timer.
	public static int i,j,Left_Red_cars=0,Right_Blue_cars=0,MaxCar,arrival_frequency=0;
	
	public static void main(String[] args) {
		
	    Bridge bridge = new Bridge();   //create our bridge
	   if (args.length != 3) {
		    System.out.println("Usage: java Bridge program waiting for Red cars,Blue cars and arrival frequency in miliseconds.");
		    System.exit(1);
		}

		try {
			Left_Red_cars = Integer.parseInt(args[0]);
			Right_Blue_cars = Integer.parseInt(args[1]);
			arrival_frequency = Integer.parseInt(args[2]);
		}
		catch (NumberFormatException nfe) {
		    System.out.println("Integer arguments expected");
		    System.exit(1);
		}
		// eisodo dedomenwn apo cmd.
	    //create cars
	    
	    ArrayList<Thread> Redcars = new ArrayList<Thread>();//list red cars.
	    ArrayList<Thread> Bluecars = new ArrayList<Thread>();//list blue cars.
	    
	    //dhmiourgia arxikwn nhmatwn kai prosthiki se antistoixes listes.
		for (i = 0; i < Left_Red_cars; i++) 
			Redcars.add( new Thread(new RedCars2("Red Car " +(i+1),bridge,i)));
		for (i=0; i < Right_Blue_cars;i++) 
			Bluecars.add( new Thread(new BlueCars2("Blue Car " +(i+1),bridge,i)));
		
		//evresi perissoterwn nhmatwn (blue h red)
		if (Right_Blue_cars>Left_Red_cars)
			MaxCar = Right_Blue_cars;
		else
			MaxCar = Left_Red_cars;
		
		//ksekinima olwn ton nimatwn kai i antistoixi if se periptwsi pou kapoia lista exei parapanw nimata kai i allh ligotera. 
		for (i=0;i<MaxCar;i++) {
			if (Redcars.size() > i && Redcars.get(i) != null) 
				Redcars.get(i).start();
			if (Bluecars.size() > i && Bluecars.get(i) != null) 
				Bluecars.get(i).start();
		}
		Redcars.clear();//clear afou ksekinisoun ola ta nhmata
		Bluecars.clear();//clear afou ksekinisoun ola ta nhmata
		j = Right_Blue_cars;//se periptwsi allaghs tou j apo for 
		i=Left_Red_cars;//antistoixa gia to i apo for.
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			  @Override
			  public void run() {
				  System.out.println("New Cars arrived at " + Main.Time());
				   int temp1 = Left_Red_cars +i ,temp2 = Right_Blue_cars + j;
				   //dhmiourgia twn nimatwn antistoixa gia red kai blue.
				   while (i<temp1) {
						Redcars.add(new Thread(new RedCars2("Red Car " +(i+1),bridge,i)));
						i++;
				   }
				   while(j<temp2) {
						Bluecars.add(new Thread(new BlueCars2("Blue Car " +(j+1),bridge,j)));
						j++;
				   }
				   //ksekinima olwn ton nimatwn kai i antistoixi if se periptwsi pou kapoia lista exei parapanw nimata kai i allh ligotera.
				   for (int x=0;x<MaxCar;x++) {
						if (Redcars.size() > x && Redcars.get(x) != null) {
							Redcars.get(x).start();
						}
						if (Bluecars.size() > x && Bluecars.get(x) != null) {
							Bluecars.get(x).start();
						}
				   }
				   Redcars.clear();//clear afou ksekinisoun ola ta nhmata
				   Bluecars.clear();//clear afou ksekinisoun ola ta nhmata
			  }
			}, arrival_frequency, arrival_frequency); //kathe arrival_frequency miliseconds tha dhimourgei Left_Red_cars kai Right_Blue_cars	
	}												//afou exei perimenei arrival frequency gia na ksekinisei na dhmiourgei.
	
	public static String Time () { // static method gia na pairnw to currentTime se milis kai metatropi se wres lepta klp. 
		Date instant = new Date(System.currentTimeMillis());
	    SimpleDateFormat sdf = new SimpleDateFormat( "HH:mm:ss:ms" );
	    return sdf.format( instant );
	}
}	   
