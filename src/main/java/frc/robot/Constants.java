package frc.robot;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.util.Units;

public class Constants {
    public static final double TRACK_WIDTH = Units.inchesToMeters(22.875);
    public static final double WHEEL_BASE = Units.inchesToMeters(22.875);

     public static final Translation2d[] moduleTranslations = new Translation2d[]{
            new Translation2d(WHEEL_BASE / 2.0, TRACK_WIDTH / 2.0),
            new Translation2d(WHEEL_BASE / 2.0, -TRACK_WIDTH / 2.0),
            new Translation2d(-WHEEL_BASE / 2.0, TRACK_WIDTH / 2.0),
            new Translation2d(-WHEEL_BASE / 2.0, -TRACK_WIDTH / 2.0)};

            public static final double stickDeadband = 0.1;


    public static final String CANIVORE = "elevatoryiboi";
    public static final String RIO = "rio";

    public static final int DRIVER_CONTROLER = 0;
    public static final int OPERATOR_CONTROLER = 1;
  

    

    public class ElevatorConstants {

        public static final int BACKID = 19;
        public static final int FRONTID = 3;

        //set points
        public static final double HOME = 0.4;  //0.4
        public static final double L1 = 4.3;
        public static final double L2 = 2.2      ; //4
        public static final double L3 = 7.7; //10
        public static final double L4 = 17;
        public static final double BARGE = 18;
        public static final double ALGAET2 = 2.33;
        public static final double ALGAET3 = 7.83;
        public static final double INTAKE = 0;
        public static final double CLIMB = 0;
        public static final double PROCESSOR = 0.4;
        public static final double ALGAEHOME = 0.4;
        

        //configs
        public static final double kp = 1; //1
        public static final double kI = 0; //0
        public static final double kD = 0; //0.05
        public static final double kV = 0.05; //0.05
        public static final double kS = 0.08; //0.08
        public static final double kG = 0.12; //0.16

        public static final double  MotionMagicCruiseVelocity = 90;
        public static final double  MotionMagicAcceleration = 300;
        public static final double  MotionMagicJerk = 1200;
        public static final boolean EnableFOC = true;

        public static final boolean CurrentLimitEnable = true;
        public static final double  CurrentLimit = 80;

}


public class WristConstants {

    public static final int MOTORID = 2;
    public static final int CANCODERID = 56;

    public static final double kP = 2;
    public static final double kI = 0;
    public static final double kD = 0;

    public static final double HOME = -37; //working
    public static final double L1 = -34.3;
    public static final double L2 = -31.3;
    public static final double L3 = -31.3;//-8.8
    public static final double L4 = -27.3;
    public static final double BARGE = -23;
    public static final double ALGAET2 = -9.12;
    public static final double ALGAET3 = -9.12;
    public static final double INTAKE = 0;
    public static final double CLIMB = -9.4;
    public static final double PROCESSOR = 0;
    public static final double ALGAEHOME = -15;

    public static final double DEFUALTVELOCITY = 160;
    public static final double DEFAULTACCELERATION = 600;
    public static final double DEFAULTJERK = 1750;

    public static final double L4VELOCITY = 25;
    public static final double L4ACCELERATION = 50;
    public static final double L4JERK = 100;
   

         
    }
    public class CoralIntakeConstants{

        public static final int MOTORID = 46;
        public static final int CANRANGEID = 1;

        public static final double INTAKE = 12;
        public static final double OUTTAKE = -3.5;
        public static final double STOP = 0;
        public static final double L1 = -5;
        public static final double HOLD = 1;

        public static final boolean ISCORALOUTTAKE = true;
    
    }
    public class AlgaeIntakeConstants{

        public static final int MOTORID = 53;
        public static final int CANRANGEID = 29;

        public static final double INTAKE = 12;
        public static final double OUTTAKE = -12;
        public static final double HOLD = 3;
        public static final double STOP = 0;

        public static final boolean ISALGAEOUTTAKE = false;
    
    }    
    public class ClimberConstants{

        public static final int MOTORID = 22;

        public static final int SERVOPORT = 0;

        public static final double kP = 1;
        public static final double kI = 0;
        public static final double kD = 0;
        public static final double kV = 0.12;
        public static final double kS = 6.59;
        public static final double kA = 0.11;
        
        public static final double CLIMBIN = -25;
        public static final double CLIMBOUT = 110;

        public static final double SERVOIN = 90;
        public static final double SERVOOUT = 0;
    }
    public class AutoAlignConstants{

        public static final Pose2d TAG6L = new Pose2d(13.048, 2.913, Rotation2d.fromDegrees(120));
        public static final Pose2d TAG6R = new Pose2d(13.353, 3.079, Rotation2d.fromDegrees(120));

        public static final Pose2d TAG7L = new Pose2d(13.846, 3.973, Rotation2d.fromDegrees(180));
        public static final Pose2d TAG7R = new Pose2d(13.856, 4.303, Rotation2d.fromDegrees(180));

        public static final Pose2d TAG8L = new Pose2d(13.374, 5.123, Rotation2d.fromDegrees(-120));
        public static final Pose2d TAG8R = new Pose2d(13.009, 5.317, Rotation2d.fromDegrees(-120));

        public static final Pose2d TAG9L = new Pose2d(12.050, 5.294, Rotation2d.fromDegrees(-60));
        public static final Pose2d TAG9R = new Pose2d(11.752, 5.126, Rotation2d.fromDegrees(-60));

        public static final Pose2d TAG10L = new Pose2d(11.262, 4.236, Rotation2d.fromDegrees(0));
        public static final Pose2d TAG10R = new Pose2d(11.259, 3.946, Rotation2d.fromDegrees(0));

        public static final Pose2d TAG11L = new Pose2d(11.769, 3.077, Rotation2d.fromDegrees(60));
        public static final Pose2d TAG11R = new Pose2d(12.050, 2.908, Rotation2d.fromDegrees(60));



        public static final Pose2d TAG17L = new Pose2d(3.216, 3.060, Rotation2d.fromDegrees(60));
        public static final Pose2d TAG17R = new Pose2d(3.507, 2.877, Rotation2d.fromDegrees(60));

        public static final Pose2d TAG18L = new Pose2d(2.692, 4.227, Rotation2d.fromDegrees(0));
        public static final Pose2d TAG18R = new Pose2d(2.696, 3.906, Rotation2d.fromDegrees(0));

        public static final Pose2d TAG19L = new Pose2d(3.484, 5.289, Rotation2d.fromDegrees(-60));
        public static final Pose2d TAG19R = new Pose2d(3.191, 5.129, Rotation2d.fromDegrees(-60));

        public static final Pose2d TAG20L = new Pose2d(4.770, 5.128, Rotation2d.fromDegrees(-120));
        public static final Pose2d TAG20R = new Pose2d(4.479, 5.314, Rotation2d.fromDegrees(-120));

        public static final Pose2d TAG21L = new Pose2d(5.267, 3.949, Rotation2d.fromDegrees(180));
        public static final Pose2d TAG21R = new Pose2d(5.281, 4.257, Rotation2d.fromDegrees(180));

        public static final Pose2d TAG22L = new Pose2d(4.485, 2.927, Rotation2d.fromDegrees(120));
        public static final Pose2d TAG22R = new Pose2d(4.786, 3.080, Rotation2d.fromDegrees(120));

        
        public static final Pose2d REDNETLEFT = new Pose2d(0, 0, Rotation2d.fromDegrees(0));
        public static final Pose2d REDNETRIGHT = new Pose2d(0, 0, Rotation2d.fromDegrees(0));

        public static final Pose2d BLUENETLEFT = new Pose2d(0, 0, Rotation2d.fromDegrees(180));
        public static final Pose2d BLUENETRIGHT = new Pose2d(0, 0, Rotation2d.fromDegrees(180));
    }
}
