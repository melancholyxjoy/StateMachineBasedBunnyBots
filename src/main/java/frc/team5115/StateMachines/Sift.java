package frc.team5115.StateMachines;

import frc.team5115.Base;
import frc.team5115.robot.Constants;
import frc.team5115.robot.Robot;

public class Sift extends Base {

    public void update() {
        switch(state) {
            case Off:
                Robot.sifter.TurnSifter(0);
                break;
            case On:
                if (Robot.outtake.state == 1) {
                    Robot.sifter.TurnSifter(-Constants.SifterTurnSpeed);
                }
                break;
        }
    }

}
