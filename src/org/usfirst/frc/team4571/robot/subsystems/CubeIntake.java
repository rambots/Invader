package org.usfirst.frc.team4571.robot.subsystems;

import org.usfirst.frc.team4571.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.ctre.phoenix.motorcontrol.NeutralMode;


import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.SpeedControllerGroup;


public class CubeIntake extends Subsystem{
	private WPI_VictorSPX   leftCubeMotor,
							rightCubeMotor;
	
	private DoubleSolenoid ArmUpandDown;
	
	
	
	public CubeIntake() {
		this.leftCubeMotor = new WPI_VictorSPX(RobotMap.LEFT_CUBE_MOTOR);
		this.rightCubeMotor = new WPI_VictorSPX(RobotMap.RIGHT_CUBE_MOTOR);
		this.ArmUpandDown = new DoubleSolenoid(RobotMap.ARM_UP, RobotMap.ARM_DOWN);
		//SpeedControllerGroup left = new SpeedControllerGroup(leftCubeMotor);
		//SpeedControllerGroup right = new SpeedControllerGroup(rightCubeMotor);
		
	}
	public double getleftCubeMotorSpeed() {
		return this.leftCubeMotor.get();
	}
	public double getrightCubeMotorSpeed() {
		return this.rightCubeMotor.get();
	}
	public void up() {
		this.ArmUpandDown.set(DoubleSolenoid.Value.kReverse);
	}
	public void down() {
		this.ArmUpandDown.set(DoubleSolenoid.Value.kForward);
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
}
