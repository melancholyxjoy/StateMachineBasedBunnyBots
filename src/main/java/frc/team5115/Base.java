package frc.team5115;

public class Base {

    public static final int Stop = 0;
    public static final int Driving = 1;
    public static final int Sorting = 2;
    public static final int Off = 3;
    public static final int On = 4;
    public static final int FullDump = 5;
    public static final int BBRoutine = 6;
    public static final int Idle = 7;
    public static final int Extending = 8;
    public static final int Retracting = 9;

    public int state = 0;
    public Base() {}
    protected void updateChildren() {}
    public void update() {}
    public void setState(int s) {
        state = s;
    }
}
