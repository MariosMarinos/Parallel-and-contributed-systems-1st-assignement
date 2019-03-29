public class Bridge  {

	private int RedOnBridge  = 0; // currently Red cars on bridge
    private int BlueOnBridge = 0; // currently Blue cars on bridge
    private int waitblue = 0; // wait line for blue cars
    private int waitred = 0; //wait line for red cars
    private boolean blueturn = true; // turn for blue/red cars

    synchronized void redEnter(RedCars car) throws InterruptedException { 
    	++waitred; //auksisi ton kokkinwn nimatwn pou perimenoun.
        while (BlueOnBridge>0 || (waitblue>0 && blueturn)|| RedOnBridge==2) wait(); //elegxos gia an uparxoun alla nimata stin gefira diaforetikou xrwmatos.
      //episis elegxos gia an uparxoun mple nimata pou perimenun kai einai i seira tous i an uparxoun duo kokkina nimata stin gefira tote perimenoun.
        --waitred; //meiwsi kokkinwn nimatwn pou perimenoun afou mpei sto krisimo tmima"
        ++RedOnBridge;//auksisi twn nimatwn pou vriskontai panw stin gefira.
        System.out.println(car.getID() + " on the bridge at "+ Main.Time()); //print 
    }

    synchronized void redExit(RedCars car){
        --RedOnBridge; //meiwsi kokkinwn nimatwn  
        if (waitred>waitblue) // an ta kokkina pou perimenun einai perissotera apo ta mple nimata tote pairnoun tin seira ksana.
        	blueturn = false;
        else				//alivws tin dinoun sta mple nimata.
        	blueturn = true;
        if (RedOnBridge==0)// an den uparxoun kokkina nimata panw stin gefira ksipnaei ola ta nimata gia na diekdikisoun thn seira tous.
            notifyAll();
        System.out.println(car.getID() + " exiting the bridge at " + Main.Time());//print
    }

    synchronized void blueEnter(BlueCars car)  throws InterruptedException {
    	++waitblue;//auksisi ton mple nimatwn pou perimenoun.
        while (RedOnBridge>0 || (waitred>0 && !blueturn) || BlueOnBridge==2) wait();//elegxos gia an uparxoun alla nimata stin gefira diaforetikou xrwmatos.
      //episis elegxos gia an uparxoun kokkina nimata pou perimenun kai einai i seira tous i an uparxoun duo mple nimata stin gefira tote perimenoun.
        --waitblue;//meiwsi kokkinwn nimatwn pou perimenoun afou mpei sto krisimo tmima"
        ++BlueOnBridge;//auksisi twn nimatwn pou vriskontai panw stin gefira.
        System.out.println(car.getID()+" on the bridge at "+ Main.Time());//print
    }

    synchronized void blueExit(BlueCars car){
        --BlueOnBridge;//meiwsi kokkinwn nimatwn  
        if (waitblue>waitred)// an ta mple pou perimenun einai perissotera apo ta kokkina nimata tote pairnoun tin seira ksana.
        	blueturn = true;
        else				//alivws tin dinoun sta kokkina nimata.
        	blueturn = false;
        if (BlueOnBridge==0)// an den uparxoun mple nimata panw stin gefira ksipnaei ola ta nimata gia na diekdikisoun thn seira tous.
        	notifyAll();
        System.out.println(car.getID()+ " exiting the bridge at " + Main.Time());//print
        }
}