package frc.team5115.StateMachines;

import frc.team5115.Base;
import frc.team5115.robot.Constants;
import frc.team5115.robot.Controls;
import frc.team5115.robot.Robot;

public class Launch extends Base {

    public void update() {
        switch(state) {
            case Off:
                Robot.bunnyLauncher.nolaunch();
                break;
            case Input:

                if (Controls.launchbunny()) setState(Extending);
                else if (Controls.retractbunny()) setState(Retracting);
                else setState(Off);

                break;
            case Extending:
                Robot.bunnyLauncher.launch();
                break;
            case Retracting:
                Robot.bunnyLauncher.retract();
                break;
        }
    }

}
