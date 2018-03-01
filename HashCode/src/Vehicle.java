public class Vehicle
{
    public Intersection currentIntersection;
    public Intersection nextDes;
    public boolean isVacant;
    public Ride currentRide;

    public Vehicle()
    {
        this.currentIntersection = new Intersection(0,0);
        isVacant = true;
    }

    public void move(Intersection next)
    {
        System.out.println("old pos: " + currentIntersection.toString());
        if (this.currentIntersection.equals(next)) {
            System.out.println("DESTINATION REACHED for Ride " + currentRide.rideNum);
            this.isVacant = true;
            return;
        }

        else if (next.xPosition == this.currentIntersection.xPosition)
            this.moveY();
        else this.moveX();
        System.out.println("Ride " + currentRide.rideNum + " is moved.");
        System.out.println("new pos: " + currentIntersection.toString());


    }

    private void moveX()
    {
        int moveDirection = this.currentRide.end.xPosition - this.currentIntersection.xPosition;
        if (moveDirection > 0) //move +ve - add
            this.currentIntersection.xPosition ++;
        else this.currentIntersection.xPosition --;
    }

    private void moveY()
    {
        int moveDirection = this.currentRide.end.yPosition - this.currentIntersection.yPosition;
        if (moveDirection > 0) //move +ve - add
            this.currentIntersection.yPosition ++;
        else this.currentIntersection.yPosition --;
    }



    public void newRide(Ride r) {
        currentRide = r;
//        this.currentRide.started = true;
        this.isVacant = false;
        this.currentRide = r;
    }
}
