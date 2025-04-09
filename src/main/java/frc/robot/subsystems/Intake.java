// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.controls.DutyCycleOut;
import com.ctre.phoenix6.controls.VelocityDutyCycle;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import com.ctre.phoenix6.hardware.CANrange;

public class  Intake extends SubsystemBase {
  


TalonFX m_coralMotor;
TalonFX m_algaeMotor;
VelocityDutyCycle intakeVelocity; 

DutyCycleOut intakePercentOutput;
CANrange m_coralCanrange;
CANrange m_algaeCanrange;


public Intake() {
    m_coralMotor = new TalonFX(Constants.CoralIntakeConstants.MOTORID , Constants.CANIVORE);
    m_algaeMotor = new TalonFX(Constants.AlgaeIntakeConstants.MOTORID , Constants.CANIVORE);

    m_coralCanrange = new CANrange(Constants.CoralIntakeConstants.CANRANGEID, Constants.CANIVORE);
    m_algaeCanrange = new CANrange(Constants.AlgaeIntakeConstants.CANRANGEID, Constants.CANIVORE);

    final TalonFXConfiguration coralConfiguration = new TalonFXConfiguration();
    coralConfiguration.CurrentLimits.withStatorCurrentLimitEnable(true);
    coralConfiguration.CurrentLimits.withStatorCurrentLimit(40);

    final TalonFXConfiguration algaeConfiguration = new TalonFXConfiguration();
    algaeConfiguration.CurrentLimits.withStatorCurrentLimitEnable(true);
    algaeConfiguration.CurrentLimits.withStatorCurrentLimit(40);
   

    m_coralMotor.getConfigurator().apply(coralConfiguration, 0.050);
    m_algaeMotor.getConfigurator().apply(algaeConfiguration, 0.050);

    intakeVelocity = new VelocityDutyCycle(0);

    // periodic, run Motion Magic with slot 0 configs,
  }
  
  @Override
  public void periodic() {
    
    SmartDashboard.putNumber("intake height", 0);
    SmartDashboard.putBoolean("Has Coral", HasCoral());
    SmartDashboard.putBoolean("Has Algae", HasAlgae());
  }

  public void intakerun(double velocity){
    intakeVelocity.Velocity = velocity * 5;
        m_coralMotor.setControl(intakeVelocity);

    // m_motor.set(velocity);

    
  }

  public void coralintakerunvoltage(double velocity){
        m_coralMotor.setVoltage(velocity);

    // m_motor.set(velocity);

    
  }

  public void algaeintakerunvoltage(double velocity){
        m_algaeMotor.setVoltage(velocity);

    // m_motor.set(velocity);

    
  }

  public void CORALOUTTAKE(double velocity){
    // intakeVelocity.Velocity = velocity;
    //     m_motor.setControl(intakeVelocity);

    m_coralMotor.set(velocity);

    if(SmartDashboard.getNumber("coral intake speed", 1) > 0.1 ){
      m_coralMotor.set(velocity);
    } else {
      m_coralMotor.set(Constants.CoralIntakeConstants.L1);
    }
  }

  public void ALGAEOUTTAKE(double velocity){
    // intakeVelocity.Velocity = velocity;
    //     m_motor.setControl(intakeVelocity);

    m_algaeMotor.set(velocity);

    // if(SmartDashboard.getNumber("algae intake speed", 1) > 0.1 ){
    //   m_algaeMotor.set(velocity);
    // } else {
    //   m_algaeMotor.set(Constants.AlgaeIntakeConstants.L1);
    // }
  }

  public void coralIntakePercentOutput(double percentOutput) {

    intakePercentOutput.Output = percentOutput;
    m_coralMotor.setControl(intakePercentOutput);

}

public void algaeIntakePercentOutput(double percentOutput) {

  intakePercentOutput.Output = percentOutput;
  m_algaeMotor.setControl(intakePercentOutput);


}

public boolean HasCoral(){
  return m_coralCanrange.getDistance().getValueAsDouble() <= 0.051;

}

public boolean HasAlgae(){
  return m_algaeCanrange.getDistance().getValueAsDouble() <= 0.1; //0.051
}

public enum IntakeState {

  HOME(Constants.CoralIntakeConstants.HOLD, Constants.AlgaeIntakeConstants.HOLD, Constants.CoralIntakeConstants.ISCORALOUTTAKE),
  L1(Constants.CoralIntakeConstants.HOLD, Constants.AlgaeIntakeConstants.HOLD, Constants.CoralIntakeConstants.ISCORALOUTTAKE),
  L2(Constants.CoralIntakeConstants.HOLD, Constants.AlgaeIntakeConstants.HOLD, Constants.CoralIntakeConstants.ISCORALOUTTAKE),
  L3(Constants.CoralIntakeConstants.HOLD, Constants.AlgaeIntakeConstants.HOLD, Constants.CoralIntakeConstants.ISCORALOUTTAKE),
  L4(Constants.CoralIntakeConstants.HOLD, Constants.AlgaeIntakeConstants.HOLD, Constants.CoralIntakeConstants.ISCORALOUTTAKE),
  BARGE(Constants.CoralIntakeConstants.HOLD, Constants.AlgaeIntakeConstants.HOLD, Constants.AlgaeIntakeConstants.ISALGAEOUTTAKE),
  ALGAET2(Constants.CoralIntakeConstants.HOLD, Constants.AlgaeIntakeConstants.INTAKE, Constants.AlgaeIntakeConstants.ISALGAEOUTTAKE),
  ALGAET3(Constants.CoralIntakeConstants.HOLD, Constants.AlgaeIntakeConstants.INTAKE, Constants.AlgaeIntakeConstants.ISALGAEOUTTAKE),
  INTAKE(Constants.CoralIntakeConstants.INTAKE, Constants.AlgaeIntakeConstants.OUTTAKE, Constants.CoralIntakeConstants.ISCORALOUTTAKE),
  CLIMB(Constants.CoralIntakeConstants.HOLD, Constants.AlgaeIntakeConstants.HOLD, Constants.AlgaeIntakeConstants.ISALGAEOUTTAKE),
  PROCESSOR(Constants.CoralIntakeConstants.HOLD, Constants.AlgaeIntakeConstants.HOLD, Constants.AlgaeIntakeConstants.ISALGAEOUTTAKE),
  L1INTAKE(Constants.CoralIntakeConstants.OUTTAKE, Constants.AlgaeIntakeConstants.INTAKE, Constants.AlgaeIntakeConstants.ISALGAEOUTTAKE),
  ALGAEHOME(Constants.CoralIntakeConstants.HOLD, Constants.AlgaeIntakeConstants.HOLD, Constants.AlgaeIntakeConstants.ISALGAEOUTTAKE);

  public double coralIntakeSpeed;
  public double algaeIntakeSpeed;
  public boolean isCoralOuttake;
  private IntakeState(double coralIntakeSpeed, double algaeIntakeSpeed, boolean isCoralOuttake) {
    this.coralIntakeSpeed = coralIntakeSpeed;
    this.algaeIntakeSpeed = algaeIntakeSpeed;
    this.isCoralOuttake = isCoralOuttake;

  }

}

}




