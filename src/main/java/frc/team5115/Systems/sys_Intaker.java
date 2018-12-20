package frc.team5115.Systems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import frc.team5115.robot.Constants;

public class Intaker {

    private TalonSRX intake;

    public Intaker() {

        intake = new TalonSRX(Constants.IntakeTalon);
        intake.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 5);
    }
    public void takein(double IntakeSpeed) {
        intake.set(ControlMode.PercentOutput, IntakeSpeed);
    }
}
