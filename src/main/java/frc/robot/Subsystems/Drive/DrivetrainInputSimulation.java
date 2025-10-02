package frc.robot.Subsystems.Drive;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.math.system.plant.LinearSystemId;
import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj.simulation.DCMotorSim;
import frc.robot.Constants.DriveConstants;

public class DrivetrainInputSimulation implements DrivetrainInput{

    DCMotorSim leftMotor = new DCMotorSim(LinearSystemId.createDCMotorSystem(DCMotor.getNEO(1), 1, DriveConstants.gearing), DCMotor.getNEO(1));
    DCMotorSim rightMotor = new DCMotorSim(LinearSystemId.createDCMotorSystem(DCMotor.getNEO(1), 1, DriveConstants.gearing), DCMotor.getNEO(1));

    @Override
    public void updateInputs(DriveTrainIOInputs inputs) {
        // Sets the time between input updates to 0.02 seconds
        leftMotor.update(0.02);
        rightMotor.update(0.02);
        
        // Sets the current amps to the respective motor amp draw
        inputs.leftCurrentAmps = new double[]{ leftMotor.getCurrentDrawAmps()};
        inputs.rightCurrentAmps = new double[] {rightMotor.getCurrentDrawAmps()};

        // Sets the position to the current position of motor in rotations so it matches the correct type?  
        inputs.leftPosM = leftMotor.getAngularPositionRotations();
        inputs.rightPosM = rightMotor.getAngularPositionRotations();

        // Sets the output volts to and tries to limit it I think to avoid too much or smth
        inputs.leftOutputV = leftMotor.getAngularVelocityRPM() / DriveConstants.maxRPM * leftMotor.getInputVoltage();
        inputs.rightOutputV = rightMotor.getAngularVelocityRPM() / DriveConstants.maxRPM * rightMotor.getInputVoltage();
        
        // Set the velocity
        inputs.leftVelocity = Units.radiansPerSecondToRotationsPerMinute(leftMotor.getAngularVelocityRPM() * DriveConstants.gearing) * Units.inchesToMeters(2);
        inputs.rightVelocity = Units.radiansPerSecondToRotationsPerMinute(rightMotor.getAngularVelocityRPM() * DriveConstants.gearing) * Units.inchesToMeters(2);
    }

    @Override
    public void arcadeDrive(double left, double right) {
        // Clamp the input voltage to make sure we dont do too much to the battery
        leftMotor.setInputVoltage(MathUtil.clamp(left, -12, 12));
        rightMotor.setInputVoltage(MathUtil.clamp(right, -12, 12));
    }

}