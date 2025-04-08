// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.Constants;
import frc.robot.subsystems.Climber;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class ClimbBack extends Command {

  public Climber m_climber;
  public Timer m_timer;
  public Timer m_holdTimer;
  
  public Trigger velocityTrigger;

  /** Creates a new ClimbBack. */
  public ClimbBack(Climber climber) {

    m_climber = climber;
    m_timer = new Timer();
    m_holdTimer = new Timer();

    velocityTrigger = new Trigger(()-> { return Math.abs(m_climber.getClimbMotor().getVelocity().getValueAsDouble()) < 5; }).
                          debounce(1);
    
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() { 

    m_timer.reset();
    m_timer.start();

    m_climber.setpose(25, true, false);
    m_holdTimer.stop();
    m_holdTimer.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //if (velocityTrigger.getAsBoolean()) {
      //m_climber.setservo(90);
      m_holdTimer.start();
    //}

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {

    m_climber.setservo(90);

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    // if (Math.abs(m_climber.getpose() - 25) <= 0.1) {
    //   return true;
    
    // } else 
    if (m_timer.get()>=1.5) {
      return true;

    } else {
      return false;

    }
  }
}
