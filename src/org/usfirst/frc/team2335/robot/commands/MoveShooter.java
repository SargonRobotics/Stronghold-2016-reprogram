package org.usfirst.frc.team2335.robot.commands;

import org.usfirst.frc.team2335.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class MoveShooter extends Command
{

    public MoveShooter()
    {
        requires(Robot.shooter);
    }

    protected void initialize() { }

    protected void execute()
    {
    	Robot.shooter.moveShooter(Robot.oi.getAxis(Robot.AIMSHOOTER, 1));
    }

    protected boolean isFinished()
    {
        return false;
    }

    protected void end()
    {
    	Robot.shooter.stopShooter();
    }

    protected void interrupted() 
    {
    	end();
    }
}
