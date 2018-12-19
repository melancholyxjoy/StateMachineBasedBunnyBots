package frc.team5115;

import frc.team5115.robot.Constants;

public class PID {

    double kp, ki, kd, maxOutput;

    double error, errorAccum = 0, dError, output;

    public PID(double p, double i, double d, double max) {
        kp = p;
        ki = i;
        kd = d;
        maxOutput = max;
    }
    public PID(double p, double i, double d) {
        this(p, i, d, 1);
    }
    public double getPID(double setpoint, double reading, double dReading) {
        error = setpoint - reading;
        dError = -dReading;
        output = kp * error + ki * errorAccum + kd * dError;
        if (Math.abs(output) <= maxOutput) {
            errorAccum += error * Constants.Delay;
        }
        if (Math.abs(output) > maxOutput) {
            output = maxOutput * Math.signum(output);
        }
        return output;
    }
    public double getPID(double setpoint, double reading) {
        return getPID(setpoint, reading, 0);
    }
    public boolean isFinished(double tolerance, double dErrorTolerance) {
        return (Math.abs(error) < tolerance && Math.abs(dError) < dErrorTolerance);
    }
    public double getError() {
        return error;
    }
}