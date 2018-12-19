package frc.team5115.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import frc.team5115.Auto.Autonomus;
import frc.team5115.Base;
import frc.team5115.StateMachines.*;
import frc.team5115.Systems.*;
import frc.team5115.UDPClient;

public class Robot extends TimedRobot {

    public static Autonomus autonomus;

    public static DriveTrain driveTrain;
    public static BunnyLauncher bunnyLauncher;
    public static Intaker intaker;
    public static Outtaker outtaker;
    public static Sifter sifter;
    public static Sorter sorter;

    public static Drive drive;
    public static Launch launch;
    public static Intake intake;
    public static Outtake outtake;
    public static Sift sift;
    public static Sort sort;

    public static UDPClient udpClient;

    public static String response;

    public void robotInit() {

        autonomus = new Autonomus();

        driveTrain = new DriveTrain();
        bunnyLauncher = new BunnyLauncher();
        intaker = new Intaker();
        outtaker = new Outtaker();
        sifter = new Sifter();
        sorter = new Sorter();

        drive = new Drive();
        launch = new Launch();
        intake = new Intake();
        outtake = new Outtake();
        sift = new Sift();
        sort = new Sort();

        udpClient = new UDPClient("10.51.15.2", 8005);
    }
    public void autonomousInit() {
        autonomus.setState(Base.BBRoutine);
    }
    public void teleopInit() {
        autonomus.setState(Base.Stop);

        drive.setState(Base.Driving);
        launch.setState(Base.On);
        intake.setState(Base.On);
        outtake.setState(Base.On);
        sift.setState(Base.On);
        sort.setState(Base.Sorting);
    }
    public void robotPeriodic() {
        response = udpClient.getLastResponse();
    }
    public void autonomousPeriodic () {
        autonomus.update();
    }
    public void teleopPeriodic () {
        drive.update();
        launch.update();
        intake.update();
        outtake.update();
        sift.update();
        sort.update();
    }

}
