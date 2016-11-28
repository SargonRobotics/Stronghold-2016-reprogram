package org.usfirst.frc.team2335.robot.commands;

import org.usfirst.frc.team2335.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class StopShoot extends Command {

	public StopShoot()
    {
        requires(Robot.shooter);
        setTimeout(0.5);
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
    	Robot.shooter.stopBall();
    }

    protected void interrupted()
    {
    	end();
    }
}
