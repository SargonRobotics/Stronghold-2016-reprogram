package org.usfirst.frc.team2335.robot.commands;

import org.usfirst.frc.team2335.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class MoveServo extends Command
{

    public MoveServo()
    {
        requires(Robot.shooter);
        setTimeout(0.4);
    }

    protected void initialize() { }

    protected void execute()
    {
    	Robot.shooter.servoForward();
    }

    protected boolean isFinished()
    {
        return isTimedOut();
    }

    protected void end()
    {
    	Robot.shooter.servoBackwards();
    }

    protected void interrupted()
    {
    	end();
    }
}
