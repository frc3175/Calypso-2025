// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Wrist;
import frc.robot.subsystems.BotState;
import frc.robot.subsystems.BotState.BobotState;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class AlgaBoom extends Command {
  public Intake m_intake;
  public Wrist m_wrist;
  public Elevator m_elevator;
  public BotState m_botState;
  public Timer m_timer;

  /** Creates a new IntakeAndReset. */
  public AlgaBoom(Intake intake, Wrist wrist, Elevator elevator, BotState botState) {

    m_intake = intake;
    m_wrist = wrist;
    m_elevator = elevator;
    m_botState = botState;

    addRequirements(m_intake, m_wrist, m_elevator, m_botState);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

    new SetBotState(m_botState, m_elevator, m_wrist, m_intake, BobotState.BARGE).schedule();
    Timer.delay(0.6);
    new Outtake(m_intake, m_botState).schedule();
    Timer.delay(1);
    new SetBotState(m_botState, m_elevator, m_wrist, m_intake, BobotState.HOME).schedule();

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}
  
  

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }
}
