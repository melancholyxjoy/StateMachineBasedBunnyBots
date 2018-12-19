package frc.team5115.Systems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team5115.PID;
import frc.team5115.StateMachines.Drive;
import frc.team5115.robot.Constants;
import frc.team5115.robot.Robot;

public class DriveTrain {

    private TalonSRX backLeft;
    private TalonSRX backRight;
    private TalonSRX frontLeft;
    private TalonSRX frontRight;

    private AHRS navx;

    private boolean line = false;
    private double targetDistance;
    private double targetAngle;

    private PID forwardController;
    private PID turnController;

    public DriveTrain(){
        backLeft = new TalonSRX(Constants.BackLeftTalonID);
        backRight = new TalonSRX(Constants.BackRightTalonID);
        frontLeft = new TalonSRX(Constants.FrontLeftTalonID);
        frontRight= new TalonSRX(Constants.FrontRightTalonID);

        frontLeft.set(ControlMode.Follower, Constants.BackLeftTalonID);
        frontRight.set(ControlMode.Follower, Constants.BackRightTalonID);

        backRight.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 5);
        backLeft.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 5);

        navx = new AHRS(SPI.Port.kMXP);
    }
    public void Drive(double xaxis, double  yaxis, double throttle) {
        double leftspeed = (yaxis + (xaxis * Constants.XSensitivity)) * throttle;
        double rightspeed = (yaxis - (xaxis * Constants.XSensitivity)) * throttle;

        backLeft.set(ControlMode.PercentOutput, leftspeed);
        backRight.set(ControlMode.PercentOutput, rightspeed);
    }
    public double distanceTraveledRight() {
        return ((backRight.getSelectedSensorPosition(0) * 6 * Math.PI * 10) / (1440 * 12));
    }
    public double distanceTraveledLeft() {
        return ((backLeft.getSelectedSensorPosition(0) * 6 * Math.PI * 10)  / (1440 * 12));
    }
    private double leftSpeed() {
        return ((backLeft.getSelectedSensorVelocity(0) * 6 * Math.PI * 10)  / (1440 * 12));
    }
    private double rightSpeed() {
        return ((backRight.getSelectedSensorVelocity(0) * 6 * Math.PI * 10)  / (1440 * 12));
    }
    private double averageSpeed() {
        return (leftSpeed() + rightSpeed()) / 2;
    }
    private double turnVelocity() {
        return navx.getRate();
    }
    private double yaw() {
        return navx.getYaw();
    }
    private void resetEncoders() {
        backRight.setSelectedSensorPosition(0,0,5);
        backLeft.setSelectedSensorPosition(0,0,5);
    }
    private void resetNavx() {
        navx.reset();
    }

    public void StartLine(double distance, double speed) {
        line = true;
        resetEncoders();
        targetDistance = distanceTraveledRight() + distance;
        targetAngle = yaw();

        forwardController = new PID(Constants.AutoForwardKP, Constants.AutoForwardKI, Constants.AutoForwardKD, speed);
        turnController = new PID(Constants.AutoTurnKP, Constants.AutoTurnKI,Constants.AutoTurnKD);
        Auto();
    }
    public void StartTurn(double angle, double speed) {
        line = false;
        resetNavx();
        targetDistance = distanceTraveledRight();
        targetAngle = yaw() + angle;

        forwardController = new PID(Constants.AutoForwardKP, Constants.AutoForwardKI, Constants.AutoForwardKD);
        turnController = new PID(Constants.TurnKP, Constants.TurnKI,Constants.TurnKD, speed);
        Auto();
    }
    private void Auto() {
        double clearYaw = clearSteer(yaw(), targetAngle);
        double Forward = forwardController.getPID(targetDistance, distanceTraveledRight(), averageSpeed());
        double Turn = turnController.getPID(targetAngle, clearYaw, turnVelocity());

        if (!line && Math.abs(turnController.getError()) > 4 * Constants.TurnTolerance) {
            Turn += 0.15 * Math.signum(Turn);
        }
        Drive(Forward, Turn, Constants.AutoForwardSpeed);
    }
    private double clearSteer(double yaw, double target) {
        if (Math.abs(target - yaw) > 180) {
            if (target < 180) {
                yaw -= 360;
            } else {
                yaw += 360;
            }
        }
        return yaw;
    }
}

