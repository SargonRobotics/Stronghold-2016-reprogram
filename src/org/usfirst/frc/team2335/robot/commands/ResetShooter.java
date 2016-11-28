package org.usfirst.frc.team2335.robot.commands;

import org.usfirst.frc.team2335.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ResetShooter extends Command
{

    public ResetShooter()
    {
        requires(Robot.shooter);
    }

    protected void initialize() { }

    protected void execute()
    {
    	Robot.shooter.shooterUp();
    }

    protected boolean isFinished()
    {
        return Robot.shooter.encoderAt0();
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
