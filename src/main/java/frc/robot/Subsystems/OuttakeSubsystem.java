// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import java.util.function.DoubleSupplier;
import com.revrobotics.spark.SparkBase.PersistMode; 
import com.revrobotics.spark.SparkBase.ResetMode; 
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.config.SparkMaxConfig;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import com.ctre.phoenix6.controls.VoltageOut;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;





public class OuttakeSubsystem extends SubsystemBase {
  
  SparkMax Dropper;
  public static final int dropperID = 1; 
  

    SparkMax = new SparkMax(dropperID, MotorType.kBrushed); 

    SparkMaxConfig config = new SparkMaxConfig(); 

    config.idleMode(IdleMode.kCoast);

  SparkMax frontDropper = new SparkMax(D);

  VoltageOut dropVoltage = new VoltageOut(0); 

  private void setOuttakeVoltages(double active) {
    frontDropper.set(active);
    System.out.println("Private Void setVoltages: Running");
  }

  public Command setOuttakeVoltagesCommand(DoubleSupplier active) {
    return this.run(() -> this.setOuttakeVoltages(active.getAsDouble())); 
  }

  public Command setOuttakeVoltagesArcadeCommand(DoubleSupplier drop) {
    System.out.println("Command: setOuttakeVoltagesArcadeCommand: Running. ");
    return this.run(() -> {
      System.out.println("Command: setVoltagesArcadeCommand 2: Running.");
      var score =  
      this.setOuttakeVoltages(score.active * 10);
  }); 
  }


  /** Creates a new OuttakeSubsystem. */
  public OuttakeSubsystem() {

    

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
