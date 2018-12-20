package frc.team5115.Systems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Spark;
import frc.team5115.robot.Constants;

public class Sorter {

    public Spark ballSorter;
    public DigitalInput homePosition;
    public DigitalInput ourPosition;
    public DigitalInput theirPosition;

    public Sorter() {
        ballSorter = new Spark(Constants.BallSorterID);

        homePosition = new DigitalInput(Constants.HomePositionLimitSwitchID);
        ourPosition = new DigitalInput(Constants.OurPositionLimitSwitchID);
        theirPosition = new DigitalInput(Constants.TheirPositionLimitSwitchID);
    }
    public void TurnSorter(double speed) {
        ballSorter.set(speed);
    }
}
