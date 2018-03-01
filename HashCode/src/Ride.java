public class Ride {
    Intersection start;
    Intersection end;
    int distance;
    int EST;
    int LFT;

    boolean started = false;
    boolean reached = false;

    Intersection[] finalSteps;

    Intersection[] stepsReal;
    int stepCounter = 0;


    int rideNum;

    Ride (Intersection start, Intersection end, int EST, int LFT, int rideNum) {
        this.start = start;
        this.end = end;
        this.EST = EST;
        this.LFT = LFT;
        this.rideNum = rideNum;
        setDistance();
        this.stepsReal = new Intersection[distance];
        this.stepsReal = createStepsArray(this.start, this.end);
    }

    public Intersection nextStep() {
        int temp = stepCounter;
        stepCounter++;
        return finalSteps[temp];
    }

    public void setCompleted(boolean started) {
        this.started = started;
    }

    public int getEST() {
        return this.EST;
    }

    public boolean isStarted() {
        return this.started;
    }

    public void setDistance() {
        int disX = Math.abs(end.xPosition - start.xPosition);
        int disY = Math.abs(end.yPosition - start.yPosition);
        this.distance = disY + disX + 1;
        System.out.println("\ndistance: " + this.distance);
    }

    public static Intersection[] createStepsArray(Intersection start, Intersection end) {
        int distance = Intersection.getDist(start, end);
        int arraySize = distance + 1;
        Intersection[] steps = new Intersection[arraySize];
        int x = start.xPosition;
        int y = start.yPosition;
        steps[0] = start;
        System.out.print(" [" + steps[0].xPosition + " " + steps[0].yPosition + "]");


        for (int i = 1; i < arraySize - 1; i++) {
            steps[i] = new Intersection();
            if (x != end.xPosition) {
                if (x < end.xPosition) {
                    x = x + 1;
                    steps[i].xPosition = x;
                } else {
                    x = x - 1;
                    steps[i].xPosition = x;
                }
                steps[i].yPosition = y;
            } else {
                if (y < end.yPosition) {
                    y = y + 1;
                    steps[i].yPosition = y;
                } else {
                    y = y - 1;
                    steps[i].yPosition = y;
                }
                steps[i].xPosition = x;
            }
            System.out.print(" [" + steps[i].xPosition + " " + steps[i].yPosition + "]");

        }
        steps[arraySize - 1] = end;
        System.out.print(" [" + steps[arraySize - 1].xPosition + " " + steps[arraySize - 1].yPosition + "]");
        return steps;
    }

}
