package frc.robot.command.drive;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystem.Drive;
import frc.robot.subsystem.DriveImpl;

public class TeleopDriveCommand extends CommandBase {
    private DriveImpl drive;
    private Joystick joystick;

    public TeleopDriveCommand(DriveImpl drive, Joystick joystick) {
        this.drive = drive;
        this.joystick = joystick;
        addRequirements(drive);
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void execute() {
        double x, y, z;
        x = joystick.getX();
        y = joystick.getY();
        z = joystick.getZ();

        drive.differentialDrive.arcadeDrive(-z, y);
    }
}