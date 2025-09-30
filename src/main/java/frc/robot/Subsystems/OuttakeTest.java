// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

<<<<<<< HEAD
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
=======
import java.io.ObjectInputFilter.Config;
import java.util.function.DoubleSupplier;
import com.revrobotics.spark.SparkBase.PersistMode; 
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.config.SparkBaseConfig;
import com.revrobotics.spark.config.SparkMaxConfig;
>>>>>>> 3b914968f074d5b90b064fd7bf72c2c7945c37d6

import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import com.ctre.phoenix6.controls.VoltageOut;

import edu.wpi.first.wpilibj2.command.Command; 
import edu.wpi.first.wpilibj2.command.Commands; 



import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import com.ctre.phoenix6.controls.VoltageOut;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;

public class OuttakeTest extends SubsystemBase {
<<<<<<< HEAD
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
=======
  public static final int SPARKMAX_OUTTAKE_ID = 1;

  SparkMax outtakeMotor = new SparkMax(SPARKMAX_OUTTAKE_ID, SparkMax.MotorType.kBrushed);

  private void setVoltages(double volt) {
    outtakeMotor.setVoltage(volt);
    System.out.println(volt);
  }

  public Command setVoltagesCommand(DoubleSupplier volt) {
    return this.run(() -> this.setVoltages(volt.getAsDouble()));
  }
  public OuttakeTest() {
    SparkMaxConfig config = new SparkMaxConfig();
    config.idleMode(IdleMode.kCoast);
    outtakeMotor.configure(config, ResetMode.kResetSafeParameters, PersistMode.kNoPersistParameters);
  
  }
   public Command setOuttakeVoltagesArcadeCommand(Double drop) {
    System.out.println("Command: setOuttakeVoltagesArcadeCommand: Running. ");
    return this.run(() -> {
      System.out.println("Command: setVoltagesArcadeCommand 2: Running.");
      double score = drop;
      this.setVoltages(score * 12);
  }); 

>>>>>>> 3b914968f074d5b90b064fd7bf72c2c7945c37d6
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
