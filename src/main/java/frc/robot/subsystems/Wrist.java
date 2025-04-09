// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.DynamicMotionMagicDutyCycle;
import com.ctre.phoenix6.controls.PositionDutyCycle;
import com.ctre.phoenix6.hardware.CANcoder;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class Wrist extends SubsystemBase {
  

DynamicMotionMagicDutyCycle m_motmag;

PositionDutyCycle m_PositionDutyCycle;
TalonFX m_motor;
CANcoder m_canCoder;
double nudge = 0;
double cancoderzero = 0.5;
double cancoderoffset = 0;


public Wrist() {
    m_motor = new TalonFX(Constants.WristConstants.MOTORID , Constants.CANIVORE);
    m_canCoder = new CANcoder(Constants.WristConstants.CANCODERID, Constants.CANIVORE);

    cancoderoffset = m_canCoder.getAbsolutePosition().getValueAsDouble() - cancoderoffset;


    

    m_motmag = new DynamicMotionMagicDutyCycle(0, 0, 0, 0);

    var talonFXConfigs = new TalonFXConfiguration();
    
    // var canCoderConfigs = new CANcoderConfiguration();

    var slot0Configs = talonFXConfigs.Slot0;
    

    slot0Configs.kP = Constants.WristConstants.kP; // change as needed
    slot0Configs.kI = Constants.WristConstants.kI;
    slot0Configs.kD = Constants.WristConstants.kD;

    m_motmag.EnableFOC = true;



    // talonFXConfigs.Feedback.FeedbackRemoteSensorID = m_canCoder.getDeviceID();
    // talonFXConfigs.Feedback.FeedbackSensorSource = FeedbackSensorSourceValue.SyncCANcoder;
    // talonFXConfigs.Feedback.SensorToMechanismRatio = 1.0;
    // talonFXConfigs.Feedback.RotorToSensorRatio = -60.7639;

    // canCoderConfigs.MagnetSensor.withAbsoluteSensorDiscontinuityPoint(1);
    // canCoderConfigs.MagnetSensor.withSensorDirection(SensorDirectionValue.CounterClockwise_Positive);
    // canCoderConfigs.MagnetSensor.withMagnetOffset(Rotations.of(0.1));

    
    m_motor.getConfigurator().apply(talonFXConfigs, 0.050);
    // m_canCoder.getConfigurator().apply(canCoderConfigs, 0.050);
    m_motor.setNeutralMode(NeutralModeValue.Brake);
    // periodic, run Motion Magic with slot 0 configs,
  }
  
  @Override
  public void periodic() {
    m_motmag.Slot = 0;
    SmartDashboard.putNumber("wrist angle", getpose());
  }

  public Double getpose(){ // if you need negative pos, you need to change this
  return  m_motor.getPosition().getValueAsDouble();

 

  }

  public void setangle(double angle, double velocity, double accleration, double jerk){

    m_motor.setControl(m_motmag.withPosition(angle+nudge).withVelocity(velocity).withAcceleration(accleration).withJerk(jerk));


  }
  public void setnudge(double change){
    nudge = nudge + change;
  }

  public enum WristState {

    HOME(Constants.WristConstants.HOME, Constants.WristConstants.DEFUALTVELOCITY, Constants.WristConstants.DEFAULTACCELERATION, Constants.WristConstants.DEFAULTJERK),
    L1(Constants.WristConstants.L1, Constants.WristConstants.DEFUALTVELOCITY, Constants.WristConstants.DEFAULTACCELERATION, Constants.WristConstants.DEFAULTJERK),
    L2(Constants.WristConstants.L2, Constants.WristConstants.DEFUALTVELOCITY, Constants.WristConstants.DEFAULTACCELERATION, Constants.WristConstants.DEFAULTJERK),
    L3(Constants.WristConstants.L3, Constants.WristConstants.DEFUALTVELOCITY, Constants.WristConstants.DEFAULTACCELERATION, Constants.WristConstants.DEFAULTJERK),
    L4(Constants.WristConstants.L4, Constants.WristConstants.L4VELOCITY, Constants.WristConstants.L4ACCELERATION, Constants.WristConstants.L4JERK),
    BARGE(Constants.WristConstants.BARGE, Constants.WristConstants.DEFUALTVELOCITY, Constants.WristConstants.DEFAULTACCELERATION, Constants.WristConstants.DEFAULTJERK),
    ALGAET2(Constants.WristConstants.ALGAET2, Constants.WristConstants.DEFUALTVELOCITY, Constants.WristConstants.DEFAULTACCELERATION, Constants.WristConstants.DEFAULTJERK),
    ALGAET3(Constants.WristConstants.ALGAET3, Constants.WristConstants.DEFUALTVELOCITY, Constants.WristConstants.DEFAULTACCELERATION, Constants.WristConstants.DEFAULTJERK),
    INTAKE(Constants.WristConstants.INTAKE, Constants.WristConstants.DEFUALTVELOCITY, Constants.WristConstants.DEFAULTACCELERATION, Constants.WristConstants.DEFAULTJERK),
    CLIMB(Constants.WristConstants.CLIMB, Constants.WristConstants.DEFUALTVELOCITY, Constants.WristConstants.DEFAULTACCELERATION, Constants.WristConstants.DEFAULTJERK),
    PROCESSOR(Constants.WristConstants.PROCESSOR, Constants.WristConstants.DEFUALTVELOCITY, Constants.WristConstants.DEFAULTACCELERATION, Constants.WristConstants.DEFAULTJERK),
    L1INTAKE(Constants.WristConstants.L1INTAKE, Constants.WristConstants.DEFUALTVELOCITY, Constants.WristConstants.DEFAULTACCELERATION, Constants.WristConstants.DEFAULTJERK),
    ALGAEHOME(Constants.WristConstants.ALGAEHOME, Constants.WristConstants.DEFUALTVELOCITY, Constants.WristConstants.DEFAULTACCELERATION, Constants.WristConstants.DEFAULTJERK);

    public final double wristSetpoint;
    public final double wristVelocity;
    public final double wristAcceleration;
    public final double wristJerk;
    private WristState (double wristSetpoint, double wristVelocity, double wristAcceleration, double wristJerk) {
      this.wristSetpoint = wristSetpoint;
      this.wristVelocity = wristVelocity;
      this.wristAcceleration = wristAcceleration;
      this.wristJerk = wristJerk;

    }

  }

}




