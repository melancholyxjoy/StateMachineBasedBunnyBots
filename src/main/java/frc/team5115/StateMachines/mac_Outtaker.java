package frc.team5115.StateMachines;

import frc.team5115.Base;
import frc.team5115.robot.Constants;
import frc.team5115.robot.Controls;
import frc.team5115.robot.Robot;

public class Outtake extends Base {

    public void update() {
        switch(state) {
            case Off:
                Robot.outtaker.takeout(0);
                break;
            case Input:

                if (Controls.outtake()) setState(On);
                else setState(Off);

                break;
            case On:
                Robot.outtaker.takeout(Constants.OuttakeOnSpeed);
                break;
            case FullDump:
                Robot.outtaker.takeout(Constants.FullDump);
                break;
        }
    }
}
