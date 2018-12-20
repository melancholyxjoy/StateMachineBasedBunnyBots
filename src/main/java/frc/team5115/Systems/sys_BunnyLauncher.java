package frc.team5115.Systems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import frc.team5115.robot.Constants;

public class BunnyLauncher {

    public DoubleSolenoid launchBunny;

    public BunnyLauncher() {
        launchBunny = new DoubleSolenoid(Constants.PCMIDBunny, Constants.BunnyForward, Constants.BunnyReverse);
    }
    public void launch() {
        launchBunny.set(DoubleSolenoid.Value.kForward);
    }
    public void retract() {
        launchBunny.set(DoubleSolenoid.Value.kReverse);
    }
    public void nolaunch() {
        launchBunny.set(DoubleSolenoid.Value.kOff);
    }

}
