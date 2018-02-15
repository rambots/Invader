package org.usfirst.frc.team4571.robot.subsystems;

import org.usfirst.frc.team4571.robot.RobotMap;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Pneumatics extends Subsystem {
	Compressor 		compressor;
	DoubleSolenoid 	transmissionShifter;
	
	public Pneumatics() {
		this.compressor 		 = new Compressor(RobotMap.COMPRESSOR_MODULE);
		this.transmissionShifter = new DoubleSolenoid(RobotMap.TRANSMISSION_SHIFTER_FORWARD, 
													  RobotMap.TRANSMISSION_SHIFTER_REVERSE);
	}

    public void initDefaultCommand() {}
    
    public void startCompressor() {
		compressor.setClosedLoopControl(true);
	}
    
    public void pushInShifter() {
    	this.transmissionShifter.set(Value.kReverse);
    }
    
    public void pushOutShifter() {
    	this.transmissionShifter.set(Value.kForward);
    }
}