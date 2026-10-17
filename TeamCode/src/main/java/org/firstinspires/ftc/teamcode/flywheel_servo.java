package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.CRServo; //imports servo cmmds
import com.qualcomm.robotcore.eventloop.opmode.TeleOp; //imports teleop
@TeleOp
public class flywheel_servo extends OpMode {
    private CRServo flywheel;
    @Override
    public void init(){
        flywheel = hardwareMap.get(CRServo.class, "flywheel");
    }
    @Override
    public void loop(){
        while (gamepad1.b){
            flywheel.setPower(0.5);
        }
        flywheel.setPower(0);
    }







}
