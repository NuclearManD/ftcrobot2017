package org.firstinspires.ftc.teamcode;

import org.firstinspires.ftc.teamcode.drivers.*;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
/*
 MainOp 2017 Edition

 Made with:
 * MovementDriver 1.x.x
 * FiringMechanism 1.0.0
*/

@TeleOp(name="Main Op", group="2017")
public class MainOp extends LinearOpMode {
    private MovementDriver drive;
    private FiringMechanism gun;
    public void runOpMode(){
        try {
            DcMotor[] tmp={hardwareMap.dcMotor.get("fl"),hardwareMap.dcMotor.get("fr")};
            drive=new MovementDriver();
            drive.init(tmp, false);
            gun=new FiringMechanism(hardwareMap.dcMotor.get("gl"),hardwareMap.dcMotor.get("gr"),hardwareMap.servo.get("gun"));
        }catch (Exception e){
            System.out.println("\n------    HARDWARE ERROR IN INIT!   ------\n");
            e.printStackTrace();
        }
        try {
            waitForStart();
        }catch (Exception e) {
            e.printStackTrace();
        }
        while (opModeIsActive()) {
            drive.setRotspeed(gamepad1.left_stick_x);

            drive.setSpeed(-gamepad1.right_stick_y);
            if (gamepad2.dpad_down)
                moveArm0(-1);
            else if (gamepad2.dpad_up)
                moveArm0(1);
            else
                moveArm0(0);
            //if(gamepad2.right_bumper)//open
                //flapright.setPosition(0.7);
            //if(gamepad2.right_trigger>0.2)//close
              //  gun.Fire();
            /*if(gamepad2.left_bumper)//open
                flapleft.setPosition(0.25);
            if(gamepad2.left_trigger>0.2)//close
                flapleft.setPosition(0.82);
            if (gamepad2.b)
                armup.setPower(0.5);
            else if (gamepad2.y)
                armup.setPower(-0.5);
            else
                armup.setPower(0);
            if(gamepad2.x)
                dropper.setPosition(0.99f);
            if(gamepad1.dpad_down)
                drive.sluff();
            if(gamepad1.dpad_up)
                drive.nosluff();*/
        }
    }
    void moveArm0(float value){
        float power=0.1f;

    }
    private void manwait(long i, long end, long end2) {
        long start=System.currentTimeMillis();
        while(opModeIsActive()&&start+i>System.currentTimeMillis()&&end>System.currentTimeMillis()&&end2>System.currentTimeMillis());
    }
}

