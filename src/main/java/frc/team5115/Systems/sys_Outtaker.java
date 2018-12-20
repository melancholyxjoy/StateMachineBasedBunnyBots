package frc.team5115.Systems;

import edu.wpi.first.wpilibj.Spark;
import frc.team5115.robot.Constants;

public class Outtaker {

    private Spark outtake;

    public Outtaker() {
        outtake = new Spark(Constants.OuttakeSparkID);
    }
    public void takeout(double OuttakeSpeed) {
        outtake.set(-OuttakeSpeed);
    }

}
