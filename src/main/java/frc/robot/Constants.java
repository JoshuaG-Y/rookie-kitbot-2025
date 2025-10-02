package frc.robot;

public final class Constants {
    public static class DriveConstants{
        // Sets the id for each Talon thingy in the kitbot
        public static final int frontLeftID = 1;
        public static final int frontRightID = 2;
        public static final int backLeftID = 3;
        public static final int backRightID = 4;
        
        // How many rotations a each motor can do to do one full rotation in gearbox or smth? it might be another way around idk
        public static final double gearing = 34;
        // Max rotations per minute
        public static final int maxRPM = 100;
    }
}
