package frc.robot.commands;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.filter.SlewRateLimiter;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Transform2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStation.Alliance;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.subsystems.drive.Drive;
import java.util.function.Supplier;

public class DriveCommands {
  private static final double DEADBAND = 0.1;
  // controllers for slew rate
  static final SlewRateLimiter xLim = new SlewRateLimiter(0.7, -0.7, 0);
  static final SlewRateLimiter yLim = new SlewRateLimiter(0.7, -0.7, 0);
  static final SlewRateLimiter rotLim = new SlewRateLimiter(1, -1, 0);

  private DriveCommands() {}

  /**
   * Field relative drive command using two joysticks (controlling linear and angular velocities).
   */
  public static Command joystickDrive(
      Drive drive,
      Supplier<Double> leftX,
      Supplier<Double> leftY,
      Supplier<Double> rightX) { // Horizontal right joystick for rotation axis 4
    return Commands.run(
        () -> {
          double linearMagnitude =
              MathUtil.applyDeadband(Math.hypot(leftX.get(), leftY.get()), DEADBAND);
          Rotation2d linearDirection = new Rotation2d(leftX.get(), leftY.get());
          double angle = MathUtil.applyDeadband(rightX.get(), DEADBAND);

          // Square values
          linearMagnitude = linearMagnitude * linearMagnitude;
          angle = Math.copySign(angle * angle, angle);

          // calculate linear velocity drive whatever lololol
          Translation2d linearVelocity =
              new Pose2d(new Translation2d(), linearDirection)
                  .transformBy(new Transform2d(linearMagnitude, 0.0, new Rotation2d()))
                  .getTranslation();

          // convert to field relative
          // flips the field when you become reeeddd
          boolean isFlipped =
              DriverStation.getAlliance().isPresent()
                  && DriverStation.getAlliance().get() == Alliance.Red;

          drive.runVelocity(
              ChassisSpeeds.fromFieldRelativeSpeeds(
                  xLim.calculate(linearVelocity.getX()) * drive.getMaxLinearSpeedMetersPerSec(),
                  yLim.calculate(linearVelocity.getY()) * drive.getMaxLinearSpeedMetersPerSec(),
                  rotLim.calculate(angle) * drive.getMaxAngularSpeedRadPerSec(),
                  isFlipped
                      ? drive.getRotation().plus(new Rotation2d(Math.PI))
                      : drive.getRotation()));
        },
        drive);
  }
}
