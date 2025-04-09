package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.subsystems.Elevator.ElevatorState;
import frc.robot.subsystems.Intake.IntakeState;
import frc.robot.subsystems.Wrist.WristState;

public class BotState extends SubsystemBase {

    private BobotState m_bobotState = BobotState.HOME;

    public BobotState getCurrentBotState() {
        return m_bobotState;
    }

    public void setBotState(BobotState state) {
        m_bobotState = state;
    }
 
    public enum BobotState {

        HOME(ElevatorState.HOME, WristState.HOME, IntakeState.HOME),
        L1(ElevatorState.L1, WristState.L1, IntakeState.L1),
        L2(ElevatorState.L2, WristState.L2, IntakeState.L2),
        L3(ElevatorState.L3, WristState.L3, IntakeState.L3),
        L4(ElevatorState.L4, WristState.L4, IntakeState.L4),
        BARGE(ElevatorState.BARGE, WristState.BARGE, IntakeState.BARGE),
        ALGAET2(ElevatorState.ALGAET2, WristState.ALGAET2, IntakeState.ALGAET2),
        ALGAET3(ElevatorState.ALGAET3, WristState.ALGAET3, IntakeState.ALGAET3),
        INTAKE(ElevatorState.INTAKE, WristState.INTAKE, IntakeState.INTAKE),
        CLIMB(ElevatorState.CLIMB, WristState.CLIMB, IntakeState.CLIMB),
        PROCESSOR(ElevatorState.PROCESSOR, WristState.PROCESSOR, IntakeState.PROCESSOR),
        L1INTAKE(ElevatorState.L1INTAKE, WristState.L1INTAKE, IntakeState.L1INTAKE),
        ALGAEHOME(ElevatorState.ALGAEHOME, WristState.ALGAEHOME, IntakeState.ALGAEHOME);

        public ElevatorState elevatorState;
        public WristState wristState;
        public IntakeState intakeState;
        private BobotState(ElevatorState elevatorState, WristState wristState, IntakeState intakeState) {
            this.elevatorState = elevatorState;
            this.wristState = wristState;
            this.intakeState = intakeState;

        }

    }

}
