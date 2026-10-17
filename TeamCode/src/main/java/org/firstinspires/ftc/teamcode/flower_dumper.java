package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode; //sets to linearOp mode
import com.qualcomm.robotcore.eventloop.opmode.TeleOp; //labels as driver-controlled
import com.qualcomm.robotcore.hardware.Servo; //imports servo cmmds


public class flower_dumper extends LinearOpMode {

        private Servo gate;//variable setup
        private boolean gateOpen = true; //if gate is open (shooter mode)
        private boolean prevPos = false; //used to check if a button is pressed in the future while loop
        private static final double CLOSED = 0.45; //angles for closed (must be aligned w angles of gate)
        private static final double OPEN = 0.55; //angles for open

        public void runOpMode(){
            gate = hardwareMap.get(Servo.class, "gate"); //goes into our app and assigns the servo named gate to variable called gate| connects to private servo gate
            telemetry.addLine("press A to close- if closed, press A to open!"); //messages what button a is and what button b is
            telemetry.update(); //actually brodcasts the message for the driver

            waitForStart(); //wait until A is pressed
            if (isStopRequested()) return; //if stop is requested, end the program
            gate.setPosition(OPEN); //goes into hive shooter mode again

            while (opModeIsActive()){ //while button is pressed
                if (gamepad1.a && !prevPos){ //basically opens and closes the gate
                    gateOpen = !gateOpen;
                    if (gateOpen){
                        gate.setPosition(OPEN);
                    }
                    else{
                        gate.setPosition(CLOSED);
                    }
                }
                prevPos = gamepad1.a;
                idle();
            }

        }

   }
