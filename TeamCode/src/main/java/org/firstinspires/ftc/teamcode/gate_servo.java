package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode; //sets to linearOp mode
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo; //imports servo cmmds
@TeleOp

public class gate_servo extends LinearOpMode {
 //creates ServoGate class and imports button commands
        private Servo gate;//varible setup
        private boolean gateOpen = true; //if gate is open (shooter mode)
        private boolean prevPos = false; //used to check if a button is already pressed
        private static final double CLOSED = 0.45; //anlges for closed (must be aligned w angles of gate)
        private static final double OPEN = 0.55; //angles for open

        public void runOpMode(){
            gate = hardwareMap.get(Servo.class, "gate"); //goes into our app and assigns the servo named gate to variable called gate| connects to private servo gate
            telemetry.addLine("press A to close- if closed, press A to open!"); //messages what button a is and what button b is
            telemetry.update(); //actually brodcasts the message for the driver

            waitForStart(); //wait until A is pressed
            if (isStopRequested()) return; //if stop is requested, end the program
            gate.setPosition(OPEN); //goes into hive shooter mode again

            while (opModeIsActive()){ //while button is pressed
                if (gamepad1.a && !prevPos){ //if a pressed and prevpos is true (aka it hasn't been pressed to close the gate yet)
                    gateOpen = !gateOpen; //gate should not be open
                    if (gateOpen){ //if gate should be open
                        gate.setPosition(OPEN); //open
                    }
                    else{ //if gate should be closed
                        gate.setPosition(CLOSED); //close the gate
                    }
                }
                prevPos = gamepad1.a; //if a
                idle();
            }
    }


}