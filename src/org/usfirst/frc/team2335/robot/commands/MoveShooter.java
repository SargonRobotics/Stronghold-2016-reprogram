package org.usfirst.frc.team2335.robot.commands;

import org.usfirst.frc.team2335.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class MoveShooter extends Command
{
    public MoveShooter()
    {
    	//Uses shooter subsystem
        requires(Robot.shooter);
    }

    protected void initialize() { }

    protected void execute()
    {
    	Robot.shooter.moveShooter(Robot.oi.getAxis(Robot.AIMSHOOTER, 1));
    }

    protected boolean isFinished()
    {
    	//The return false means that once the axis stops being active it will run end()
        return false;
    }

    protected void end()
    {
    	Robot.shooter.stopShooter();
    }

    //This is called when the command is interrupted (duh)
    //So incase something crashes it still stops the drive train
    protected void interrupted() 
    {
    	end();
    }
}
