package org.firstinspires.ftc.teamcode.drivers;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
/*
 MainOp 2017 Edition

 Made with:
 * MovementDriver 1.x.x
 * FiringMechanism 1.0.0
*/

@TeleOp(name="Auto Main Op", group="2017")
public class AutoMainOp extends LinearOpMode {
    private MovementDriver drive;
    private DcMotor gun;
    DcMotor lift;
    DcMotor clct;
    Servo rl;
    Servo ll;
    Servo rr;
    Servo lr;
    static final float FORWARD_SPEED = -0.6f;
    private ElapsedTime     runtime = new ElapsedTime();
    public void runOpMode(){
        try {
            DcMotor[] tmp={hardwareMap.dcMotor.get("fl"),hardwareMap.dcMotor.get("fr")};
            drive=new MovementDriver();
            drive.init(tmp, false);
            gun=hardwareMap.dcMotor.get("g");
            lift=hardwareMap.dcMotor.get("lift");
            clct=hardwareMap.dcMotor.get("clct");
            ll=hardwareMap.servo.get("ll");
            rl=hardwareMap.servo.get("rl");
            lr=hardwareMap.servo.get("lr");
            rr=hardwareMap.servo.get("rr");
            rl.setPosition(0.5);
            ll.setPosition(0.5);
            rr.setPosition(0);
            lr.setPosition(1);
        }catch (Exception e){
            System.out.println("\n------    HARDWARE ERROR IN INIT!   ------\n");
            e.printStackTrace();
        }
        try {
            waitForStart();
        }catch (Exception e) {
            e.printStackTrace();
        }
           sleep(2000);
            //drive.setSpeed(FORWARD_SPEED);
            runtime.reset();
            while (opModeIsActive() && (runtime.seconds() < 1.6)) {
                telemetry.addData("Path", "Leg 1: %2.5f S Elapsed", runtime.seconds());
                telemetry.update();

            }
            drive.setSpeed(0);

            while (opModeIsActive() && (runtime.seconds() < 10.0)) {
                System.out.println("Firing mode");
                gun.setPower(.6);
                sleep(300);
                gun.setPower(0);
                sleep(300);

            }

            //gun.setPower(0);
           /* drive.setRotspeed(gamepad1.left_stick_x);

            drive.setSpeed(-gamepad1.right_stick_y);
            //if(gamepad2.right_bumper)//open
                //flapright.setPosition(0.7);
            if(gamepad1.left_trigger>0.2) {//close
                rr.setPosition(255);
                lr.setPosition(0);
            }
            if(gamepad1.right_trigger>0.2) {//close
                rl.setPosition(1);
                ll.setPosition(0);
            }else{
                rl.setPosition(0.5);
                ll.setPosition(0.5);
            }
            if(gamepad2.right_trigger>0.2) {//close
                lift.setPower(1);
                clct.setPower(1);
            }else{
                lift.setPower(0);
                clct.setPower(0);
            }
            gun.setPower(gamepad2.left_stick_y);*/
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
    void moveArm0(float value){
        float power=0.1f;

    }
    private void manwait(long i, long end, long end2) {
        long start=System.currentTimeMillis();
        while(opModeIsActive()&&start+i>System.currentTimeMillis()&&end>System.currentTimeMillis()&&end2>System.currentTimeMillis());
    }
}
