package frc.robot.subsystems;

import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.commands.IntakePivot;

public class Intake extends SubsystemBase {
  private final CANSparkMax intakeMotor;
  private final CANSparkMax intakePivotMotor;
  private final RelativeEncoder intakePivotEncoder;

  public Intake() {
    intakeMotor = new CANSparkMax(15, MotorType.kBrushless);
    intakePivotMotor = new CANSparkMax(14, MotorType.kBrushless);
    intakePivotEncoder = intakePivotMotor.getEncoder();
  }

  public void initDefaultCommand() {
    // setDefaultCommand(new IntakeCommand(this, intakeMotor));
    setDefaultCommand(new IntakePivot(this, intakePivotMotor));
  }

  public void intakeIn() {
    // intakePivot.set(-0.2);
  }

  public void intakeOut() {
    // intakePivot.set(0.3);
  }

  public void rollIn() {
    // intakemMotor.set(-0.3);
  }

  @Override
  public void periodic() {}

  /*public void setPeriodicStatus() {
    IntakeMotor.setPeriodicFramePeriod(PeriodicFrame.kStatus0, 500);
    IntakeMotor.setPeriodicFramePeriod(PeriodicFrame.kStatus1, 500);
    IntakeMotor.setPeriodicFramePeriod(PeriodicFrame.kStatus2, 500);
    IntakeMotor.setPeriodicFramePeriod(PeriodicFrame.kStatus3, 500);
    IntakeMotor.setPeriodicFramePeriod(PeriodicFrame.kStatus4, 500);
    IntakeMotor.setPeriodicFramePeriod(PeriodicFrame.kStatus5, 500);
    IntakeMotor.setPeriodicFramePeriod(PeriodicFrame.kStatus6, 500);
    IntakeMotor.setPeriodicFramePeriod(PeriodicFrame.kStatus7, 500);
    ;
  }*/

  public CANSparkMax getintakeMotor() {

    return this.intakeMotor;
  }
}
