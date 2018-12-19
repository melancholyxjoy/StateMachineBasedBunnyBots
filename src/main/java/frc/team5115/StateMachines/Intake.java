package frc.team5115.StateMachines;

import frc.team5115.Base;
import frc.team5115.robot.Constants;
import frc.team5115.robot.Controls;
import frc.team5115.robot.Robot;

public class Intake extends Base {

    public void update() {
        switch(state) {
            case Off:
                Robot.intaker.takein(0);
                break;
            case Idle:
                Robot.intaker.takein(Constants.IntakeIDLE);
                if (Controls.intakinggrr()) {
                    setState(On);
                }
                break;
            case On:
                Robot.intaker.takein(Constants.IntakeON);
                if (!Controls.intakinggrr()) {
                    setState(Idle);
                }
                break;
        }
    }

}
