package frc.robot.subsystems;

import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj.CounterBase;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase {
  private final CANSparkMax leftShooterMotor = new CANSparkMax(16, MotorType.kBrushless);
  private final CANSparkMax shooterPivot = new CANSparkMax(17, MotorType.kBrushless);
  private final Encoder pivotEncoder = new Encoder(0,1, false, CounterBase.EncodingType.k4X);
  double motorPosition = 180; //integer between 0-360
  double rate = pivotEncoder.getRate();
  //pivotEncoder.reset();

  public void storage(){
  //leftShooterMotor.set(-0.2);
  }

  public void goUp(){
    //shooterPivot.set(-0.3);
  }

  public void shoot(){
    //leftShooterMotor.set(0.3);
  }


  public void setPoint(){
   /*pivotEncoder.reset();
    if(rate==motorPosition){
      shooterPivot.set(0);
    }else{
      shooterPivot.set(-0.3);
    }*/
  }

  @Override
  public void periodic() {}

  public void setPeriodicStatus() {
    /*leftShooterMotor.setPeriodicFramePeriod(PeriodicFrame.kStatus0, 500);
    leftShooterMotor.setPeriodicFramePeriod(PeriodicFrame.kStatus1, 500);
    LeftShooterMotor.setPeriodicFramePeriod(PeriodicFrame.kStatus2, 500);
    LeftShooterMotor.setPeriodicFramePeriod(PeriodicFrame.kStatus3, 500);
    LeftShooterMotor.setPeriodicFramePeriod(PeriodicFrame.kStatus4, 500);
    LeftShooterMotor.setPeriodicFramePeriod(PeriodicFrame.kStatus5, 500);
    LeftShooterMotor.setPeriodicFramePeriod(PeriodicFrame.kStatus6, 500);
    LeftShooterMotor.setPeriodicFramePeriod(PeriodicFrame.kStatus7, 500);

    RightShooterMotor.setPeriodicFramePeriod(PeriodicFrame.kStatus0, 500);
    RightShooterMotor.setPeriodicFramePeriod(PeriodicFrame.kStatus1, 500);
    RightShooterMotor.setPeriodicFramePeriod(PeriodicFrame.kStatus2, 500);
    RightShooterMotor.setPeriodicFramePeriod(PeriodicFrame.kStatus3, 500);
    RightShooterMotor.setPeriodicFramePeriod(PeriodicFrame.kStatus4, 500);
    RightShooterMotor.setPeriodicFramePeriod(PeriodicFrame.kStatus5, 500);
    RightShooterMotor.setPeriodicFramePeriod(PeriodicFrame.kStatus6, 500);
    RightShooterMotor.setPeriodicFramePeriod(PeriodicFrame.kStatus7, 500);
  }*/
}
}