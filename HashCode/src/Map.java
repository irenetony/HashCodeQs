import java.util.ArrayList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Map {
    public static int R;
    public static int C;
    public static int vehCount;
    public static int rides;
    public static int bonus;
    public static int maxSteps;

    int currentStep;

    public static void main(String[] args) {

        In input = new In("a_example.in");
        String[] output = input.readAllLines();


        System.out.println( "mainline = " + output[0]);
        String[] info = output[0].split(" ");

        R = Integer.parseInt(info[0]);
        System.out.println("row = " + R);

        C = Integer.parseInt(info[1]);
        System.out.println("column = " + C);

        vehCount = Integer.parseInt(info[2]);
        System.out.println("vehicles = " + vehCount);

        rides = Integer.parseInt(info[3]);
        System.out.println("rides = " + rides);

        bonus = Integer.parseInt(info[4]);
        System.out.println("bonus = " + bonus);

        maxSteps = Integer.parseInt(info[5]);
        System.out.println("steps = " + maxSteps);



        Vehicle[] allVehicles = new Vehicle[vehCount];
        ArrayList<Ride> allRides = new ArrayList<>();

        String[] rideParams;

        for (int i=1; i<=rides;i++) {
            rideParams = output[i].split(" ");
            Intersection start = new Intersection();
            start.xPosition = Integer.parseInt(rideParams[0]);
            start.yPosition = Integer.parseInt(rideParams[1]);
            Intersection end = new Intersection();
            end.xPosition = Integer.parseInt(rideParams[2]);
            end.yPosition = Integer.parseInt(rideParams[3]);
            int EST = Integer.parseInt(rideParams[4]);
            int LFT = Integer.parseInt(rideParams[5]);
            allRides.add(new Ride(start, end, EST, LFT, i - 1));
        }


        for(int i = 0; i < vehCount; i++){
            allVehicles[i] = new Vehicle();
        }


//        Collections.sort(allRides, new Comparator<Ride>() {
//            @Override
//            public int compare(Ride o1, Ride o2) {
//                final double ride1 = o1.getEST();
//                final double ride2 = o2.getEST();
//                return ride1 > ride2? 1
//                        : ride1 < ride2? -1 : 0;
//            }
//        });


        for (int i = 0; i < maxSteps; i++) {
            System.out.println("\n enter maxsteps.");

            // find a non-completed ride
            for (int j = 0; j < vehCount; j++) {
                System.out.println("counting veh.");

                if (allVehicles[j].isVacant) {
                    System.out.println("Vehicle is vacant.");

                    int k = 0;
                    Ride current;
                    while (k < rides - 1) {
                        current = allRides.get(k);
                        if (!current.isStarted()) {
                            allVehicles[j].newRide(current);

                            System.out.println("Vehicle assigned.");
                            if (!current.reached) {
                                Intersection preStart = allVehicles[j].currentIntersection;
                                Intersection realStart = current.start;
                                Intersection[] preToReal = current.createStepsArray(preStart, realStart);
                                current.reached = true;
                                current.finalSteps = new Intersection[preToReal.length + current.stepsReal.length];
                                System.arraycopy(preToReal, 0, current.finalSteps ,0 , preToReal.length - 1);
                                System.arraycopy(current.stepsReal, 0 , current.finalSteps , preToReal.length , current.stepsReal.length - 1 );
                            }
                        }
                        k++;
                    }
                } else {
                    allVehicles[j].move(allVehicles[j].currentRide.nextStep());
                }
            }




        }
    }
}
