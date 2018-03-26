//package org.usfirst.frc.team4571.robot.commands.teleop.testing;
//
//import org.usfirst.frc.team4571.robot.Robot;
//import org.usfirst.frc.team4571.robot.LogitechExtreme3DPro;
//
//import edu.wpi.first.wpilibj.buttons.Button;
//import edu.wpi.first.wpilibj.command.Command;
//
///**
// * This Command toggles the solenoid from forward and reverse using
// * the same button
// * <p>
// * This command will only work if it is assigned to execute when a button 
// * is pressed, please check this method how to assign it
// * {@link LogitechExtreme3DPro#button1WhenPressed(Command)}. Make sure it is the same
// * button that is used when instantiating the class.
// * 
// * @author Mahim
// */
//public class ToggleTestSolenoid extends Command {
//	private Button 	button;
//	private boolean isAction1Activated,
//					isAction2Activated;
//
//    public ToggleTestSolenoid(Button button) {
//    	requires(Robot.PNEUMATICS);
//    	this.button = button;
//    }
//
//    protected void initialize() {
//    	Robot.PNEUMATICS.pushInTestSolenoid();
//    }
//
//    protected void execute() {
//    	if(isAction2Activated) {
//    		Robot.PNEUMATICS.pushOutTestSolenoid();
//    	} else if(isAction1Activated) {
//    		Robot.PNEUMATICS.pushInTestSolenoid();
//    	}
//    	if (button.get() && isAction1Activated == false) {
//    		this.isAction2Activated =! isAction2Activated;
//    	} else if (button.get() == false) {
//    		this.isAction1Activated =! isAction1Activated;
//    	}
//    }
//
//    protected boolean isFinished() {
//        return true;
//    }
//
//    protected void end() {
//    }
//
//    protected void interrupted() {
//    }
//}
