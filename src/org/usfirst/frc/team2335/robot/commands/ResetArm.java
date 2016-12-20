package org.usfirst.frc.team2335.robot.commands;

import org.usfirst.frc.team2335.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ResetArm extends Command
{
    public ResetArm()
    {
    	//Uses arm subsystem
        requires(Robot.arm);
    }

    protected void initialize() { }

    protected void execute()
    {
    	Robot.arm.up();
    }

    protected boolean isFinished()
    {
    	//If the encoder value shows the arm is at max height, then it stops the motor
        return Robot.arm.encoderAt0();
    }

    protected void end()
    {
    	Robot.arm.stop();
    }

    //This is called when the command is interrupted (duh)
    //So incase something crashes it still stops the drive train
    protected void interrupted()
    {
    	end();
    }
}
