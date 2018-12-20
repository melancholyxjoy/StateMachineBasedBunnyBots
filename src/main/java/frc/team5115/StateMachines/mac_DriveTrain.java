package frc.team5115.StateMachines;

import edu.wpi.first.wpilibj.DriverStation;
import frc.team5115.Base;
import frc.team5115.robot.Controls;
import frc.team5115.robot.Robot;

public class Drive extends Base {

    private double Throt = .5;

    public void update() {
        switch(state) {
            case Stop:
                Robot.driveTrain.Drive(0, 0, 0);
                if (!DriverStation.getInstance().isAutonomous()) {
                    setState(Driving);
                }
                break;
            case Driving:
                if (Controls.increaseThrottle()){ // Right button increases throttle
                    Throt += 0.02;
                }
                else if (Controls.decreaseThrottle()){ // Left button decreased throttle
                    Throt -= 0.02;
                }
                if(Throt > 1) {
                    Throt = Math.signum(Throt);
                }
                if (Throt <= 0) {
                    Throt = 0;
                }
                Robot.driveTrain.Drive(Controls.getX(), Controls.getY(), Throt);
                break;
        }
    }

}
