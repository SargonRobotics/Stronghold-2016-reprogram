package org.usfirst.frc.team2335.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Reset extends CommandGroup
{    
    public Reset()
    {
    	//Runs ResetArm and ResetShooter at the same time (or in parallel)
        addParallel(new ResetArm());
        addParallel(new ResetShooter());
    }
}
