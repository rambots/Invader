package org.usfirst.frc.team4571.robot.commands.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class GetSwitchRight extends CommandGroup {

    public GetSwitchRight() {
    	setName("right");
    	addSequential(new RunMotors(4.5, 0.5));
    	addParallel(new SetElevatorTimed(1.5, 0.8));
    	addSequential(new TurnCommand(-90));
    	addSequential(new SetPulleyTimed(2));
    	addSequential(new RunMotors(1.5, 0.5));
    	addSequential(new TimedOuttake(0.5));
    }
}
