package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {
  private final CANSparkMax intakeMotor = new CANSparkMax(14, MotorType.kBrushless);
  private final  CANSparkMax intakePivot = new CANSparkMax(15, MotorType.kBrushless);


  public void intakeIn(){
    //intakePivot.set(-0.2);
  }

  public void intakeOut(){
    //intakePivot.set(0.3);
  }

  public void rollIn(){
    //intakemMotor.set(-0.3);
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
}
