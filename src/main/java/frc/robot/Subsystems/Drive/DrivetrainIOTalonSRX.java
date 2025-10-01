package frc.robot.subsystems.Drive;


import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class DrivetrainIOTalonSRX implements DrivetrainIO {

    TalonSRX backLeft;
    TalonSRX backRight;
    TalonSRX frontLeft;
    TalonSRX frontRight;

    public DrivetrainIOTalonSRX(int frontLeftID, int frontRightID, int backLeftID, int backRightID) {

        frontLeft = new TalonSRX(frontLeftID);
        frontRight = new TalonSRX(frontRightID);
        backLeft = new TalonSRX(backLeftID);
        backRight = new TalonSRX(backRightID);

        frontLeft.setInverted(false);
        frontLeft.setNeutralMode(NeutralMode.Coast);

        frontRight.setInverted(false);
        frontRight.setNeutralMode(NeutralMode.Coast);

        backLeft.setInverted(true);
        backLeft.setNeutralMode(NeutralMode.Coast);
        backLeft.follow(frontLeft);

        backRight.setInverted(true);
        backRight.setNeutralMode(NeutralMode.Coast);
        backRight.follow(frontRight);
    }

    @Override
    public void updateInputs(DrivetrainIOInputs inputs) {
        inputs.leftOutputVolts = frontLeft.getMotorOutputVoltage();
        inputs.rightOutputVolts = frontRight.getMotorOutputVoltage();
    }

    @Override
    public void arcadeDrive(double left, double right) {
        frontLeft.set(ControlMode.PercentOutput, left);
        frontRight.set(ControlMode.PercentOutput, right);
    }
}