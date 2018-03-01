public class Intersection {

    int xPosition;
    int yPosition;


    public Intersection(int x ,int y) {
        this.xPosition = x;
        this.yPosition = y;
    }

    public Intersection() {

    }

    public boolean equals(Intersection that){
        if (this.xPosition != that.xPosition)
            return false;
        if (this.yPosition != that.yPosition)
            return false;
        else return true;
    }

    public String toString()
    {
        return ("[" + this.xPosition + " , " + this.yPosition + "]");
    }

    public static int getDist(Intersection a, Intersection b) {
        int disX = Math.abs(a.xPosition - b.xPosition);
        int disY = Math.abs(a.yPosition - b.yPosition);
        return disY + disX;

    }

}
