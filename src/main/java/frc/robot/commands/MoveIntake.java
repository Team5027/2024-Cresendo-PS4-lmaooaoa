// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Intake;

public class MoveIntake extends Command {
  private Intake i;
  /** Creates a new MoveIntake. */
  public MoveIntake(Intake i) {
    this.i = i;
    i.setspeed(0.2);
    SmartDashboard.putNumber("help", 1);
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(i);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    i.setspeed(0.2);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
