package frc.robot.Subsystems.Drive;

import org.littletonrobotics.junction.AutoLog;

import edu.wpi.first.math.geometry.Pose2d;

public interface DrivetrainInput {
    @AutoLog
    public static class DriveTrainIOInputs{
        public Pose2d pose = new Pose2d();
        public double leftOutputV = 0.0;
        public double rightOutputV = 0.0;

        // Both in meters per second
        public double leftMaxVelocity = 0.0;
        public double rightMaxVelocity = 0.0;

        // Both in meters
        public double leftPosM = 0.0;
        public double rightPosM = 0.0;

        public double[] leftCurrentAmps = new double[0];
        public double[] rightCurrentAmps = new double[0];
    }

    // Function to poll and update inputs in periodic() function
    public void updateInputs(DriveTrainIOInputs inputs);
    public void arcadeDrive(double left, double right);
}
