package org.usfirst.frc.team4571.robot.commands.archive;
//package org.usfirst.frc.team4571.robot.commands;
//
//import org.usfirst.frc.team4571.robot.Robot;
//
//import edu.wpi.first.wpilibj.DriverStation;
//import edu.wpi.first.wpilibj.DriverStation.Alliance;
//import edu.wpi.first.wpilibj.command.Command;
//
///**
// *
// */
//public class LEDCommand extends Command {
//	Alliance alliance;
//
//    public LEDCommand() {
//    	requires(Robot.LEDS_SUBSYSTEM);
//    	alliance = DriverStation.getInstance().getAlliance();
//    }
//
//    protected void initialize() {}
//
//    protected void execute() {
//    	if(alliance == Alliance.Blue) {
//    		Robot.LEDS_SUBSYSTEM.twinklesOcean();
//    	} else if (alliance == Alliance.Red) {
//    		Robot.LEDS_SUBSYSTEM.twinklesLava();
//    	} else {
//    		Robot.LEDS_SUBSYSTEM.rainbowPartyPalette();
//    	}
//    }
//
//    protected boolean isFinished() {
//        return false;
//    }
//
//    protected void end() {}
//
//    protected void interrupted() {
//    }
//}
