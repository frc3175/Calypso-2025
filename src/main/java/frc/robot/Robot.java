// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;


import com.pathplanner.lib.commands.PathfindingCommand;

import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;


public class Robot extends TimedRobot {
  private Command m_autonomousCommand;

  private final RobotContainer m_robotContainer;

  private final boolean kUseLimelight = true;

  public Robot() {
    m_robotContainer = new RobotContainer();
  }

  @Override
    public void robotInit() 
    {
        // Make sure you only configure port forwarding once in your robot code.
        // Do not place these function calls in any periodic functions
        // for (int port = 5800;  port <= 5809; port++) {
        //     PortForwarder.add(port, "limelight.local", port);
        //     PortForwarder.add(port+10, "limelight1.local", port);
        // }
        PathfindingCommand.warmupCommand().schedule();
    }

  @Override
  public void robotPeriodic() {
    CommandScheduler.getInstance().run();

    /*
     * This example of adding Limelight is very simple and may not be sufficient for on-field use.
     * Users typically need to provide a standard deviation that scales with the distance to target
     * and changes with number of tags available.
     *
     * This example is sufficient to show that vision integration is possible, though exact implementation
     * of how to use vision should be tuned per-robot and to the team's specification.
     */
    if (kUseLimelight) {
      var driveState = m_robotContainer.drivetrain.getState();
      
      double omegaRps = Units.radiansToRotations(driveState.Speeds.omegaRadiansPerSecond);
      
     
  
      LimelightHelpers.SetRobotOrientation("limelight",m_robotContainer.drivetrain.getgyroyaw().getDegrees(), 0, 0, 0, 0, 0);
      var llMeasurement = LimelightHelpers.getBotPoseEstimate_wpiBlue("limelight");
      var algaeLLMeasurement = LimelightHelpers.getBotPoseEstimate_wpiBlue("limelight-algae");
      if (llMeasurement != null && llMeasurement.tagCount > 0 && Math.abs(omegaRps) < 2.0) {

          m_robotContainer.drivetrain.addVisionMeasurement(llMeasurement.pose, llMeasurement.timestampSeconds);

      } else if (algaeLLMeasurement != null && algaeLLMeasurement.tagCount > 0 && Math.abs(omegaRps) < 2.0) {

          m_robotContainer.drivetrain.addVisionMeasurement(algaeLLMeasurement.pose, algaeLLMeasurement.timestampSeconds);

      }
      
      SmartDashboard.putNumber("111 drive pose X", m_robotContainer.drivetrain.getState().Pose.getX());
      SmartDashboard.putNumber("111 drive pose Y",  m_robotContainer.drivetrain.getState().Pose.getY());
    } 
      
  }
    

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void disabledExit() {}

  @Override
  public void autonomousInit() {
    m_autonomousCommand = m_robotContainer.getAutonomousCommand();

    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
  }

  @Override
  public void autonomousPeriodic() {}

  @Override
  public void autonomousExit() {}

  @Override
  public void teleopInit() {
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  @Override
  public void teleopPeriodic() {}

  @Override
  public void teleopExit() {}

  @Override
  public void testInit() {
    CommandScheduler.getInstance().cancelAll();
  }

  @Override
  public void testPeriodic() {}

  @Override
  public void testExit() {}

  @Override
  public void simulationPeriodic() {}
}
