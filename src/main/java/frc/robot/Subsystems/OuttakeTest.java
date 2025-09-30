// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import java.util.function.DoubleSupplier;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkBaseConfig;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.config.SparkBaseConfig;
import com.revrobotics.config.BaseConfig;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkBaseConfig; 
import com.revrobotics.spark.SparkBase.ResetMode; 

import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import com.ctre.phoenix6.controls.VoltageOut;

import edu.wpi.first.wpilibj2.command.Command; 
import edu.wpi.first.wpilibj2.command.Commands; 



import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class OuttakeTest extends SubsystemBase {
  /** Creates a new OuttakeTest. */

  public static final int DROPPER_ID = 1; 

  SparkMax dropper = new SparkMax(DROPPER_ID, SparkMax.MotorType.kBrushed); 

  private void setVoltage(double power) {
    dropper.setVoltage(power); 
    
  }

  public Command setVoltagesCommand(DoubleSupplier power) {
    return this.run (() -> this.setVoltage(power.getAsDouble())); 
  }



  public OuttakeTest() {
    SparkMaxConfig config = new SparkMaxConfig();
    config.idleMode(IdleMode.kCoast);
    dropper.configure(config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters); 


  }

  public Command setOuttakeVoltagesArcadeCommand(Double active) {
    System.out.println("Command: setOuttakeVoltagesArcadeCommand: Running. ");
    return this.run(() -> {
      System.out.println("Command: setOuttakeVoltagesArcadeCommand 2: Running. ");
      double score = active;
      this.setVoltage(score * 12);
    } ); 
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
