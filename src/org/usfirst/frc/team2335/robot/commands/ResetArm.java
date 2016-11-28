package org.usfirst.frc.team2335.robot.commands;

import org.usfirst.frc.team2335.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ResetArm extends Command
{
    public ResetArm()
    {
        requires(Robot.arm);
    }

    protected void initialize() { }

    protected void execute()
    {
    	Robot.arm.up();
    }

    protected boolean isFinished()
    {
        return Robot.arm.encoderAt0();
    }

    protected void end()
    {
    	Robot.arm.stop();
    }

    protected void interrupted()
    {
    	end();
    }
}
