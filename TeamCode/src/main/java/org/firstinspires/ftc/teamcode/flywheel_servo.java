package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo; //imports servo cmmds
import com.qualcomm.robotcore.eventloop.opmode.TeleOp; //imports teleop
@TeleOp
public class flywheel_servo extends LinearOpMode {
    private CRServo flywheel;
    private boolean shouldFly = false; //if true, wheel runs
    private boolean checkFly = false; //if b is alr pressed (false)

    public void runOpMode(){

        flywheel = hardwareMap.get(CRServo.class, "flywheel");
        waitForStart(); //wait until robot starts

        if (isStopRequested()) return; //if stop is requested, end the program

        while (opModeIsActive()) { //while button is pressed
            if (gamepad1.b && checkFly) { //if b pressed and checkFly is true (aka it hasn't been pressed to close the gate yet)
                shouldFly = !shouldFly; //gate should not be open
                if (!shouldFly) { //if gate should be open
                    flywheel.setPower(0.5); //not running
                } else { //if flywheel should fly
                    flywheel.setPower(0); //flywheel starts
                }

            }
            checkFly = gamepad1.b;
            idle();

        }//the servo for the flywheel called flywheel is called flywheel in this code
    }
}