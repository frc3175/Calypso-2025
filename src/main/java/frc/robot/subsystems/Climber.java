// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.PositionDutyCycle;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.networktables.GenericEntry;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class Climber extends SubsystemBase {
  

PositionDutyCycle m_motmag;

PositionDutyCycle m_PositionDutyCyle;
TalonFX m_motor;
public Servo m_servo;
GenericEntry slider;


public Climber() {
    m_motor = new TalonFX(Constants.ClimberConstants.MOTORID , Constants.RIO);
   
    m_motmag = new PositionDutyCycle(0);

    m_servo = new Servo(Constants.ClimberConstants.SERVOPORT);

    var talonFXConfigs = new TalonFXConfiguration();
    
    var slot0Configs = talonFXConfigs.Slot0;
    slot0Configs.kS = 6.59; //6.59
    slot0Configs.kV = 0.12; //0.12
    slot0Configs.kA = 0.11; //0.11

    slot0Configs.kP = 1; //-1
    slot0Configs.kI = 0; //0
    slot0Configs.kD = 0; //0 
    
    m_motor.getConfigurator().apply(talonFXConfigs, 0.050);
    m_motor.setNeutralMode(NeutralModeValue.Brake);
    // periodic, run Motion Magic with slot 0 configs,
  }
  
  @Override
  public void periodic() {
    m_motmag.Slot = 0;
    SmartDashboard.putNumber("climber pose", getpose());
    SmartDashboard.putNumber("servoangle", m_servo.get());
    
  }

  public Double getpose(){ // if you need negative pos, you need to change this
  return  m_motor.getPosition().getValueAsDouble();

 

  }

  public void setpose(double pose){

    m_motor.setControl(m_motmag.withPosition(pose));


  }


  public void setservo(double angle){

    m_servo.setAngle(angle);

  }



}




