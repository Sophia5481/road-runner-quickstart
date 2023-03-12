package org.firstinspires.ftc.teamcode.drive;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous (group = "drive")
public class MyOpModeTest extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap);

        Pose2d startPose = new Pose2d();
        drive.setPoseEstimate(startPose);

        Trajectory trajectory1 = drive.trajectoryBuilder(new Pose2d())
                .strafeLeft(48)
                .build();

        Trajectory trajectory2 = drive.trajectoryBuilder(trajectory1.end())
                .forward(48)
                .build();

        Trajectory trajectory3 = drive.trajectoryBuilder(trajectory2.end())
                .strafeLeft(48)
                .build();

        Trajectory trajectory4 = drive.trajectoryBuilder(trajectory3.end())
                .forward(72)
                .build();

        Trajectory trajectory5 = drive.trajectoryBuilder(trajectory4.end())
                .strafeLeft(24)
                .build();

        //coming back
        Trajectory trajectory6 = drive.trajectoryBuilder(trajectory5.end())
                .back(120)
                .build();
        Trajectory trajectory7 = drive.trajectoryBuilder(trajectory6.end())
                .strafeRight(120)
                .build();

        waitForStart();

        if (isStopRequested()) return;
        drive.followTrajectory(trajectory1);
        drive.followTrajectory(trajectory2);
        drive.followTrajectory(trajectory3);
        drive.followTrajectory(trajectory4);
        drive.followTrajectory(trajectory5);
        drive.followTrajectory(trajectory6);
        drive.followTrajectory(trajectory7);
    }
}
