package frc.robot.commands;

import com.revrobotics.CANSparkMax;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Shooter;

public class ShooterCommand extends Command {

  private final Encoder e;
  private final CANSparkMax m;
  private final Double targetAngle = 120.0;

  public ShooterCommand(Shooter s, Encoder e, CANSparkMax m) {
    this.e = e;
    this.m = m;
    m.getEncoder().setPositionConversionFactor(360.0);
    addRequirements(s);
  }


  @Override
  public void initialize() {
    System.out.println("starting angle: " + m.getEncoder().getPositionConversionFactor());
  }

  @Override
  public void execute() {
    System.out.println("current angle: " + m.getEncoder().getPositionConversionFactor());

    if (m.getEncoder().getPosition() <= targetAngle) {
      System.out.println("go up");
    } else {
      System.out.println("go down");
    }
  }

  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
