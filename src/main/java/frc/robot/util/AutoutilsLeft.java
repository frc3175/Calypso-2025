package frc.robot.util;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;

@SuppressWarnings("all")

public class AutoutilsLeft {

    public AutoutilsLeft() {
        // Constructor
        
    }

    public static double getAngle(double input) {
        if (input == 1) return 10;
        else if (input == 2) return 20;
        else if (input == 3) return 30;
        else if (input == 4) return 40;
        else if (input == 5) return 50;
        else if (input == 6) return 0;
        else if (input == 7) return 70;
        else if (input == 8) return 80;
        else if (input == 9) return 90;
        else if (input == 10) return 100;
        else if (input == 11) return 110;
        else if (input == 12) return 120;
        else if (input == 13) return 130;
        else if (input == 14) return 140;
        else if (input == 15) return 150;
        else if (input == 16) return 160;
        else if (input == 17) return 170;
        else if (input == 18) return 180;
        else if (input == 19) return 190;
        else if (input == 20) return 200;
        else if (input == 21) return 210;
        else if (input == 22) return 220;
        else return -1; // Default case if input is not in the range
    }
    
    public static Pose2d getnewpose(double input) {
        Double doubleInput = new Double(input);
        int intInput = doubleInput.intValue();
        Pose2d goalpose = new Pose2d();
       
        switch(intInput) {
            case 6:
                goalpose = new Pose2d(13.048 ,2.913,Rotation2d.fromDegrees(120)); //done
                break;

            case 7:
                goalpose = new Pose2d(13.846 ,3.973 ,Rotation2d.fromDegrees(180)); //done
                break; 

            case 8:
                goalpose = new Pose2d(13.374,5.123 ,Rotation2d.fromDegrees(-120)); //done
                break; 

            case 9:
                goalpose = new Pose2d(12.050 ,5.294 ,Rotation2d.fromDegrees(-60)); //done
                break;

            case 10:
                goalpose = new Pose2d(11.272 ,4.236 ,Rotation2d.fromDegrees(0)); //done
                break;

            case 11:
                goalpose = new Pose2d(11.769 ,3.077 ,Rotation2d.fromDegrees(60)); //done 
                break;

            case 17:
                goalpose = new Pose2d(3.182 ,3.085 ,Rotation2d.fromDegrees(60)); //done
                break;

            case 18:
                goalpose = new Pose2d(2.691 ,4.289 ,Rotation2d.fromDegrees(0)); //done
                break;

            case 19:
                goalpose = new Pose2d(3.484 ,5.289 ,Rotation2d.fromDegrees(-60)); //done
                break;

            case 20:
                goalpose = new Pose2d(4.770 ,5.128 ,Rotation2d.fromDegrees(-120)); //done
                break;

            case 21:
                goalpose = new Pose2d(5.267 ,3.949 ,Rotation2d.fromDegrees(180)); //done
                break;

            case 22:
                goalpose = new Pose2d(4.485 ,2.927 ,Rotation2d.fromDegrees(120)); //done
                break;

            case -1:
                goalpose = new Pose2d(); // Default case if input is not in the range
                break;
        }

        return goalpose;
    }

}

