package org.usfirst.frc.team4571.robot.subsystems.archive;
//package org.usfirst.frc.team4571.robot.subsystems;
//
//import org.usfirst.frc.team4571.robot.RobotMap;
//import org.usfirst.frc.team4571.robot.subsystems.DriveSystem.TransmissionState;
//
//import edu.wpi.first.wpilibj.Compressor;
//import edu.wpi.first.wpilibj.DoubleSolenoid;
//import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
//import edu.wpi.first.wpilibj.command.Subsystem;
//
///**
// * This subsystem contains all the pneumatic components of the robot.
// * 
// * @author Mahim
// */
//public class Pneumatics extends Subsystem {
//	private Compressor 	     compressor;
//	private DoubleSolenoid   transmissionShifter,
//						   	 testSolenoid;
//	public TransmissionState transmissionState;
//	
//	
//	public Pneumatics() {
//		this.compressor 		 = new Compressor(RobotMap.COMPRESSOR_MODULE);
//		this.transmissionShifter = new DoubleSolenoid(RobotMap.TRANSMISSION_SHIFTER_FORWARD, 
//													  RobotMap.TRANSMISSION_SHIFTER_REVERSE);
//		this.testSolenoid		 = new DoubleSolenoid(RobotMap.TEST_SOLENOID_FORWARD,
//													  RobotMap.TEST_SOLENOID_REVERSE);
//	}
//
//    public void initDefaultCommand() {}
//    
//    public void startCompressor() {
//		compressor.setClosedLoopControl(true);
//	}
//    
//    public void stopCompressor() {
//    	compressor.setClosedLoopControl(false);
//    }
//    
//    public void pushInShifter() {
//    	this.transmissionShifter.set(Value.kReverse);
//    	this.transmissionState.setTransmissionState(TransmissionState.LowGear);
//    }
//    
//    public void pushOutShifter() {
//    	this.transmissionShifter.set(Value.kForward);
//    	this.transmissionState.setTransmissionState(TransmissionState.HighGear);
//    }
//    
//    public void pushInTestSolenoid() {
//    	this.testSolenoid.set(Value.kReverse);
//    }
//    
//    public void pushOutTestSolenoid() {
//    	this.testSolenoid.set(Value.kForward);
//    }
//}