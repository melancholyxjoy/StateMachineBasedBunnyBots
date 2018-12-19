package frc.team5115.StateMachines;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Timer;
import frc.team5115.Base;
import frc.team5115.robot.Constants;
import frc.team5115.robot.Robot;

public class Sort extends Base {

    String color = Robot.response;

    private boolean OurColor;
    private boolean TheirColor;

    public void update() {
        switch (state) {
            case Stop:
                Robot.sorter.TurnSorter(0);
                break;
            case Sorting:
                if (DriverStation.getInstance().getAlliance() == DriverStation.Alliance.Red) {
                    if (color.equals("Red")) {
                        OurColor = true;
                    } else if (color.equals("Blue")) {
                        TheirColor = true;
                    }
                }
                else if (DriverStation.getInstance().getAlliance() == DriverStation.Alliance.Blue) {
                    if (color.equals("Red")) {
                        TheirColor = true;
                    } else if (color.equals("Blue")) {
                        OurColor = true;
                    }
                }

                if (!Robot.sorter.homePosition.get()) {
                    if (OurColor) {
                        Robot.sorter.TurnSorter(Constants.SorterTurnSpeed);
                        if (Robot.sorter.ourPosition.get()) {
                            Robot.sorter.TurnSorter(0);
                            Timer.delay(Constants.OurColorSorterDelay);
                            Robot.sorter.TurnSorter(-Constants.SorterTurnSpeed);
                            if (!Robot.sorter.homePosition.get()) {
                                Robot.sorter.TurnSorter(0);
                            }
                        }
                    } else if (TheirColor) {
                        Robot.sorter.TurnSorter(-Constants.SorterTurnSpeed);
                        if (Robot.sorter.theirPosition.get()) {
                            Robot.sorter.TurnSorter(0);
                            Timer.delay(Constants.TheirSideSorterDelay);
                            Robot.sorter.TurnSorter(-Constants.SorterTurnSpeed);
                            if (!Robot.sorter.homePosition.get()) {
                                Robot.sorter.TurnSorter(0);
                            }
                        }
                    }
                } else if (!Robot.sorter.homePosition.get()) {
                    Robot.sorter.TurnSorter(Constants.SorterTurnSpeed);
                    if (!Robot.sorter.homePosition.get()) {
                        Robot.sorter.TurnSorter(0);
                    }
                    break;
                }
        }
    }
}
