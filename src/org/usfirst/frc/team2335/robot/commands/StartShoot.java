package org.usfirst.frc.team2335.robot.commands;

import org.usfirst.frc.team2335.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class StartShoot extends Command
{

    public StartShoot()
    {
        requires(Robot.shooter);
        setTimeout(0.5);
    }

    protected void initialize() { }

    protected void execute()
    {
    	Robot.shooter.shootBall();
    }

    protected boolean isFinished()
    {
        return isTimedOut();
    }

    protected void end() { }

    protected void interrupted() { }
}
