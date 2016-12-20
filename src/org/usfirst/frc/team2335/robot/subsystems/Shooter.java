package org.usfirst.frc.team2335.robot.subsystems;

import org.usfirst.frc.team2335.robot.Robot;

import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Shooter extends Subsystem
{
	//Motors for the shooter
	Victor leftShoot;
	Victor rightShoot;
	Victor shooterAim;
	
	//Servo
	Servo shootServo;
	
	//Limit switch
	DigitalInput shooterLimit, shooterChannelA, shooterChannelB;	
	
	//Encoder
	Encoder shootEncoder;
	
	public Shooter()
	{
		super();
		
		//Motors
		leftShoot = new Victor(Robot.LEFTSHOOT);
		rightShoot = new Victor(Robot.RIGHTSHOOT);
		shooterAim = new Victor(Robot.MOVESHOOTER);
		
		//Servo
		shootServo = new Servo(Robot.SHOOTSERVO);
		
		//Digial inputs
    	shooterChannelA = new DigitalInput(Robot.SHOOTERCHANNELA);
    	shooterChannelB = new DigitalInput(Robot.SHOOTERCHANNELB);
		
    	//Encoder
		shootEncoder = new Encoder(shooterChannelA, shooterChannelB, true, EncodingType.k4X);
	}
	
	//Shooting commands
	public void shootBall()
	{
		leftShoot.set(0.6);
		rightShoot.set(0.6);
	}
	
	public void pullBall()
	{
		leftShoot.set(-0.5);
		rightShoot.set(-0.5);
	}
	
	public void stopBall()
	{
		leftShoot.set(0);
		rightShoot.set(0);
	}
	
	//Servo commands
	public void servoForward()
	{
		shootServo.set(0);
	}
	
	public void servoBackwards()
	{
		shootServo.set(100);
	}
	
	//Shooter move commands
	public void moveShooter(double value)
	{
		//If the shooter is trying to be moved up and the shooter isn't at max value, print a warning
		if(encoderAt0() && value > 0)
		{
			stopShooter();
			DriverStation.reportWarning("Can't move shooter up more", true);
		}
		//If not then move the shooter
		else
		{
			shooterAim.set(value);
			SmartDashboard.putString("DB/String 2", "Shooter: " + Double.toString(value));
		} 
		
		printEncoder();
	}
	
	public void stopShooter()
	{
		shooterAim.set(0);
	}
	
	//Encoder commands
	public void shooterUp()
	{
		shooterAim.set(1);
	}
	
	public boolean encoderAt0()
	{
		if(shootEncoder.get() <= 20)
    	{
    		return true;
    	}
    	else
    	{
    		return false;
    	}
	}
	
	private void printEncoder()
    {
    	//Prints to dash
    	SmartDashboard.putString("DB/String 3", "eShooter: " + Integer.toString(shootEncoder.get()));
    }
	
    public void initDefaultCommand() { }
}