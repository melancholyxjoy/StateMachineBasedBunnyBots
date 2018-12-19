package frc.team5115.robot;

public class Constants {
    //Joystick
    public static final int AXIS_X = 2;
    public static final int AXIS_Y = 1;
    public static final double XSensitivity = 1;

    //Sort Delay
    public static double OurColorSorterDelay = 1;
    public static double TheirSideSorterDelay = 1;

    //PID Values
    public static final double Delay = 0.005;
    public static final double AutoForwardKP = 0.4;
    public static final double AutoForwardKI = 0;
    public static final double AutoForwardKD = 0.1;
    public static final double AutoTurnKP = 0.06;
    public static final double AutoTurnKI = 0;
    public static final double AutoTurnKD = 0.05;
    public static final double TurnKD = 0.05;
    public static final double TurnKP = 0.3;
    public static final double TurnKI = 0.15;

    //Tolerances
    public static final double ForwardTolerance = 0.25;
    public static final double ForwardDTolerance = 0.05;
    public static final double TurnTolerance = 5;
    public static final double TurnDTolerance = 15;

    //Talon ID's
    public static int FrontLeftTalonID = 1;
    public static int FrontRightTalonID = 2;
    public static int BackLeftTalonID = 3;
    public static int BackRightTalonID = 4;
    public static int IntakeTalon = 5;

    //Spark ID's
    public static int OuttakeSparkID = 2;
    public static int BallSorterID = 1;
    public static int BallSifterID = 0;

    //DIO ID's
    public static int HomePositionLimitSwitchID = 1;
    public static int OurPositionLimitSwitchID = 0;
    public static int TheirPositionLimitSwitchID = 2;

    //Solenoid
    public static int PCMIDBunny = 7;
    public static int BunnyForward = 0;
    public static int BunnyReverse = 1;

    //Speeds
    public static double IntakeON = .5;
    public static double IntakeIDLE = .3;
    public static double OuttakeOnSpeed = .5;
    public static double FullDump = 1;
    public static double SorterTurnSpeed = .5;
    public static double SifterTurnSpeed = .5;

    public static double AutoTurnSpeed = .5;
    public static double AutoForwardSpeed = .5;

    //Button ID's
    public static final int Intake = 8;
    public static final int Outtake = 7;
    public static final int DecreaseThrottle = 5;
    public static final int IncreaseThrottle = 6;
    public static final int Launch = 1;
    public static final int Retract = 2;
    public static final int Sift = 3;

    public static final int ToOuttake = 9;
    public static final int ThrowOut = 10;
}
