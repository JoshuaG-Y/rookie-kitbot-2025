// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems.Drive;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Subsystems.Drive.DrivetrainInput.DriveTrainIOInputs;

public class DrivetrainSubsystem extends SubsystemBase {

  private DriveTrainIOInputs inputs;
  private DrivetrainInput in;

  public DrivetrainSubsystem(DrivetrainInput _in){
    in = _in;
    inputs = new DriveTrainIOInputs();
  }

  private void setVoltages(double left, double right) {
    System.out.println(right);
    System.out.println(left);
  }

  public Command setVoltagesCommand(DoubleSupplier left, DoubleSupplier right) {
    return this.run(() -> this.setVoltages(left.getAsDouble(), right.getAsDouble()));
  }

  public Command setVoltagesArcadeCommand(DoubleSupplier drive, DoubleSupplier steer) {
    System.out.println("Command: SetVoltagesArcadeCommand Running.");
    return this.run(() -> {
      System.out.println("Command: setVoltagesArcadeCommand 2 Running.");
      var speeds = DifferentialDrive.arcadeDriveIK(drive.getAsDouble(), steer.getAsDouble(), false);
      this.setVoltages(speeds.left * 10, speeds.right * 10);
    });
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run

    // Update inputs
    in.updateInputs(inputs);
  }
}
