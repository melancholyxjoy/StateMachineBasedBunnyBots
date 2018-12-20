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
            case Input:

                if (Controls.intakinggrr()) setState(On);
                else setState(Idle);

                break;
            case Idle:
                Robot.intaker.takein(Constants.IntakeIDLE);
                break;
            case On:
                Robot.intaker.takein(Constants.IntakeON);
                break;
        }
    }

}
