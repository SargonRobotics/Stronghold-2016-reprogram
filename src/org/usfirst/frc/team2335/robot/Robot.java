package org.usfirst.frc.team2335.robot;

import org.usfirst.frc.team2335.robot.commands.AutoShort;
import org.usfirst.frc.team2335.robot.subsystems.Arm;
import org.usfirst.frc.team2335.robot.subsystems.DriveTrain;
import org.usfirst.frc.team2335.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.vision.USBCamera;

public class Robot extends IterativeRobot
{
	//Constants
	public static final double DEADZONE = 0.1;
	
	//Axes
	public static final int MOVE = 1, ROTATE = 0, SHOOTBALL = 3, PULLBALL = 2, AIMSHOOTER = 5;
	
	//Motors
	public static final int LEFTDRIVE = 1, RIGHTDRIVE = 0,
			LEFTSHOOT = 2, RIGHTSHOOT = 3, SHOOTSERVO = 7, MOVESHOOTER = 9,
			ARM = 8;
	
	//Buttons
	public static final int ARMDOWN = 5, ARMUP = 6, RESET = 1;
	
	//Digital input
	public static final int SHOOTLIMIT = 8, SHOOTERCHANNELA = 0, SHOOTERCHANNELB = 1, ARMCHANNELA = 3, ARMCHANNELB = 4;

	//Autonomous
    Command autoCommand;
    SendableChooser chooser;
    
    //Subsystems
    public static Arm arm;
	public static DriveTrain driveTrain;
	public static Shooter shooter;
	
	public static OI oi;
	
	//Camera
    USBCamera camera;
    
    //GRIP
    private NetworkTable grip;

    public void robotInit()
    { 
    	//Defines subsystems
		arm = new Arm();
		driveTrain = new DriveTrain();
		shooter = new Shooter();
		
		//Define this last, or you'll break everything
		oi = new OI();
		
        chooser = new SendableChooser();
//        chooser.addDefault("Default Auto", new ExampleCommand());
//        chooser.addObject("My Auto", new MyAutoCommand());
        SmartDashboard.putData("Auto mode", chooser);
        
        camera = new USBCamera("cam0");
        CameraServer.getInstance().startAutomaticCapture(camera);
        
        //GRIP Code
        double defaultVal[] = new double[0];
        
        grip = NetworkTable.getTable("GRIP/target");
        
        while(true)
        {
        	double[] areas = grip.getNumberArray("area", defaultVal);
        	System.out.println("Areas: ");
        	
        	for(double area : areas)
        	{
        		System.out.println(area + " ");
        	}
        	
        	System.out.println();
        	Timer.delay(1);
        }
    }
	
    public void disabledInit() { }
	
	public void disabledPeriodic()
	{
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select between different autonomous modes
	 * using the dashboard. The sendable chooser code works with the Java SmartDashboard. If you prefer the LabVIEW
	 * Dashboard, remove all of the chooser code and uncomment the getString code to get the auto name from the text box
	 * below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the chooser code above (like the commented example)
	 * or additional comparisons to the switch structure below with additional strings & commands.
	 */
	
    public void autonomousInit()
    {
        autoCommand = (Command) chooser.getSelected();
        
		/* String autoSelected = SmartDashboard.getString("Auto Selector", "Default");
		switch(autoSelected) {
		case "My Auto":
			autonomousCommand = new MyAutoCommand();
			break;
		case "Default Auto":
		default:
			autonomousCommand = new ExampleCommand();
			break;
		} */
        
       if(SmartDashboard.getBoolean("DB/Button 0", true))
        {
        	DriverStation.reportWarning("Starting autonomous", true);
        	autoCommand = new AutoShort();
        }  
    	
    	// schedule the autonomous command (example)
        if (autoCommand != null) autoCommand.start();
    }
    
    public void autonomousPeriodic()
    {
        Scheduler.getInstance().run();
    }

    public void teleopInit()
    {
		// This makes sure that the autonomous stops running when teleop starts running.
        if (autoCommand != null) autoCommand.cancel();
    }

    public void teleopPeriodic()
    {
        Scheduler.getInstance().run();
    }

    public void testPeriodic()
    {
        LiveWindow.run();
    }
    
    public static double deadzone(double amount, double max) //Creates a deadzone for the axes of the controller
	{
		amount = -(Math.abs(amount) <= Robot.DEADZONE ? 0 :
			(amount = (amount < 0) ? (amount += Robot.DEADZONE) : (amount -= Robot.DEADZONE)));
		
		return ((max - 0) / ((1 - Robot.DEADZONE) - 0) * (amount - 0));
	}
}