package frc.robot.Subsystems.Drive;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class DrivetrainInputReal implements DrivetrainInput{
    TalonSRX frontRight;
    TalonSRX frontLeft;
    TalonSRX backRight;
    TalonSRX backLeft;

    public DrivetrainInputReal(int fr, int fl, int br, int bl){
        frontRight = new TalonSRX(fr);
        frontLeft = new TalonSRX(fl);
        backRight = new TalonSRX(br);
        backLeft = new TalonSRX(bl);

        backLeft.follow(frontLeft);
        backRight.follow(frontRight);
    }

    @Override
    public void updateInputs(DriveTrainIOInputs inputs) {
        inputs.rightOutputV = frontRight.getMotorOutputVoltage();
        inputs.leftOutputV = frontLeft.getMotorOutputVoltage();
    }
    @Override
    public void arcadeDrive(double left, double right) {
        frontLeft.set(TalonSRXControlMode.PercentOutput, left);
        frontRight.set(TalonSRXControlMode.PercentOutput, right);
    }
}