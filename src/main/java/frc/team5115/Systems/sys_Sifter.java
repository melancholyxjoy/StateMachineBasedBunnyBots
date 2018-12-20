package frc.team5115.Systems;

import edu.wpi.first.wpilibj.Spark;
import frc.team5115.robot.Constants;

public class Sifter {

    public Spark ballSifter;

    public Sifter() {
        ballSifter = new Spark(Constants.BallSifterID);
    }
    public void TurnSifter(double speed) {
        ballSifter.set(speed);
    }
}
