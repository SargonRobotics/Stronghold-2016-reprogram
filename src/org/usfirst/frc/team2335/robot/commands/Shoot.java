package org.usfirst.frc.team2335.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Shoot extends CommandGroup
{
    public Shoot()
    {
    	//Runs StartShoot, MoveServo, and StopShoot commands one after another
        addSequential(new StartShoot());
        addSequential(new MoveServo());
        addSequential(new StopShoot());
    }
}
