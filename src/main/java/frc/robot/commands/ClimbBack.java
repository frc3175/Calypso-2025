// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.subsystems.Climber;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class ClimbBack extends Command {

  public Climber m_climber;
  public Timer m_timer;
  
  /** Creates a new ClimbBack. */
  public ClimbBack(Climber climber) {

    m_climber = climber;
    
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() { 

    m_timer.reset();
    m_timer.start();

    m_climber.setservo(90);
    m_climber.setpose(25);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {

    m_climber.stopClimber();

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if (Math.abs(m_climber.getpose() - 25) <= 1) {
      return true;
    
    } else if (m_timer.get() >= 2) {
      return true;

    } else {
      return false;

    }
  }
}
