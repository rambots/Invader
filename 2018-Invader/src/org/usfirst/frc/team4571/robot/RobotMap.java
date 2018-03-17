/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4571.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
	/** Joystick ports */
	public static final int LEFT_JOYSTICK  = 0,
							RIGHT_JOYSTICK = 1;
	
	/** Drive system motor channels */
	public static final int TOP_LEFT_MOTOR 	   = 6,
							BOTTOM_LEFT_MOTOR  = 7,
							TOP_RIGHT_MOTOR	   = 1,
							BOTTOM_RIGHT_MOTOR = 2;
	
	/** Pneumatic component channels */
	public static final int COMPRESSOR_MODULE 		 	 = 0,
							TRANSMISSION_SHIFTER_FORWARD = 0,
							TRANSMISSION_SHIFTER_REVERSE = 1,
							TEST_SOLENOID_FORWARD 		 = 2,
							TEST_SOLENOID_REVERSE		 = 3;
	
	/** Arm system motor channels */
	public static final int LEFT_ARM_MOTOR     = 10,
							RIGHT_ARM_MOTOR    = 5,
							ELEVATOR_MOTOR	   = 8,
							LEFT_PULLEY_MOTOR  = 3,
							RIGHT_PULLEY_MOTOR = 4;
	
	/** Climber system motor channels */
	public static final int CLIMBER_MOTOR = 9;
	
	/** REV Blinkin PWM channel */
	public static final int REV_BLINKIN_CHANNEL = 0;
}