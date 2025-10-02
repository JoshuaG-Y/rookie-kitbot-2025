// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems.Drive;

import java.util.function.DoubleSupplier;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.TalonSRXConfiguration;
import com.ctre.phoenix6.controls.VoltageOut;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DrivetrainSubsystem extends SubsystemBase {

  TalonSRX leftFrontTalon = new TalonSRX(Constants.DriveConstants.frontLeftID);
  TalonSRX rightFrontTalon = new TalonSRX(Constants.DriveConstants.frontRightID);
  TalonSRX leftBackTalon = new TalonSRX(Constants.DriveConstants.backLeftID);
  TalonSRX rightBackTalon = new TalonSRX(Constants.DriveConstants.backRightID);
  TalonSRXConfiguration config = new TalonSRXConfiguration();
  VoltageOut leftVoltage = new VoltageOut(0);
  VoltageOut rightVoltage = new VoltageOut(0);

  private void setVoltages(double left, double right) {
    leftFrontTalon.set(ControlMode.PercentOutput, left);
    rightFrontTalon.set(ControlMode.PercentOutput, right);
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

  /** Creates a new DrivetrainSubsystem. */
  public DrivetrainSubsystem() {
    leftBackTalon.follow(leftFrontTalon);
    rightBackTalon.follow(rightFrontTalon);
    rightFrontTalon.setInverted(true);
    rightBackTalon.setInverted(true);

    leftBackTalon.configPeakCurrentLimit(80, 2);
    leftFrontTalon.configPeakCurrentLimit(80, 2);
    rightBackTalon.configPeakCurrentLimit(80, 2);
    rightFrontTalon.configPeakCurrentLimit(80, 2);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
