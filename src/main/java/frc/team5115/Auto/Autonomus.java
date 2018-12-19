package frc.team5115.Auto;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Timer;
import frc.team5115.Base;
import frc.team5115.StateMachines.Outtake;
import frc.team5115.StateMachines.Sift;
import frc.team5115.robot.Constants;
import frc.team5115.robot.Robot;

public class Autonomus extends Base {

    private double time = Timer.getFPGATimestamp();

    public void update(){
        switch(state) {
            case Stop:
                Robot.driveTrain.Drive(0, 0, 0);
                if (DriverStation.getInstance().isAutonomous()) {
                    setState(BBRoutine);
                }
            case BBRoutine:
                if (!DriverStation.getInstance().isAutonomous()) {
                    setState(Stop);
                }
                if (Timer.getFPGATimestamp() < time + 1) {
                    Robot.outtake.setState (Base.FullDump);
                    Robot.sift.setState(Base.On);
                }
                else if (Timer.getFPGATimestamp() < time + 2 && Timer.getFPGATimestamp() > 1) {
                    Robot.driveTrain.StartTurn(90, Constants.AutoTurnSpeed);
                }
                else if (Timer.getFPGATimestamp() <  time + 6 && Timer.getFPGATimestamp() > time + 2) {
                    Robot.driveTrain.Drive(0, 1, 0.5);
                }
                else {
                    setState(Stop);
                }
        }

    }
}
