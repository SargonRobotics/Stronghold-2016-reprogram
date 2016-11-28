package org.usfirst.frc.team2335.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Reset extends CommandGroup
{    
    public Reset()
    {
        addParallel(new ResetArm()); //Resets the arm
        addParallel(new ResetShooter());
    }
}
