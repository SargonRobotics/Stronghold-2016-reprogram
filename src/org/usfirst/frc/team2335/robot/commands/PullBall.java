package org.usfirst.frc.team2335.robot.commands;

import org.usfirst.frc.team2335.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class PullBall extends Command
{

    public PullBall()
    {
        requires(Robot.shooter);
        setTimeout(0.5);
    }

    protected void initialize() { }

    protected void execute()
    {
    	Robot.shooter.pullBall();
    }

    protected boolean isFinished()
    {
        return isTimedOut();
    }

    protected void end() 
    {
    	Robot.shooter.stopBall();
    }

    protected void interrupted()
    {
    	end();
    }
}
