package org.usfirst.frc.team2335.robot.commands;

import org.usfirst.frc.team2335.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ResetShooter extends Command
{
    public ResetShooter()
    {
    	//Uses shooter subsystem
        requires(Robot.shooter);
    }

    protected void initialize() { }

    protected void execute()
    {
    	Robot.shooter.shooterUp();
    }

    protected boolean isFinished()
    {
    	//If the encoder value shows the arm is at max height, then it stops the motor
        return Robot.shooter.encoderAt0();
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
