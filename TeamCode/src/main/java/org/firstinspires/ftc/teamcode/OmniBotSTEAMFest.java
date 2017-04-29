package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;



/**
 * Created by Chris Campos and Justin Vicente on 9/19/2015.
 * Edited by Laura Rhodes for Redwood City STEAM Fest 2.0, 4/28/2017
 */
@TeleOp(name = "OmniBotSTEAMFest", group = "")
public class OmniBotSTEAMFest extends OpMode {
    DcMotor motorBackLeft;
    DcMotor motorFrontLeft;
    DcMotor motorBackRight;
    DcMotor motorFrontRight;


    float joystick1ToMotor(float y){
        double dead_zone = 0.1;
        if(y > dead_zone){
            y -= dead_zone;
        }else if(y < -dead_zone){
            y += dead_zone;
        }else{
            y = 0;
        }
        return(float) (y/(1.0-dead_zone));
    }

    float limitOutput(float in) {
        if (in < -1.0) {
            return -1.0f;
        } else {
            if (in > 1.0) {
                return 1.0f;
            }
            else {
                return in;
            }
        }
    }

    public void init() {
        motorBackRight = hardwareMap.dcMotor.get("RightBack");
        motorFrontRight = hardwareMap.dcMotor.get("RightFront");
        motorBackLeft = hardwareMap.dcMotor.get("LeftBack");
        motorFrontLeft = hardwareMap.dcMotor.get("LeftFront");
    }


    public void loop() {
        float rotation = -joystick1ToMotor(gamepad1.right_stick_x);
        float forward = -joystick1ToMotor(gamepad1.left_stick_y);
        float side = joystick1ToMotor(gamepad1.left_stick_x);

        float bl = rotation - forward + side;
        float fl = rotation - forward - side;
        float br = rotation + forward + side;
        float fr = rotation + forward - side;

        motorBackLeft.setPower(limitOutput(bl));
        motorFrontLeft.setPower(limitOutput(fl));
        motorBackRight.setPower(limitOutput(br));
        motorFrontRight.setPower(limitOutput(fr));
        telemetry.addData("rotation", rotation);
        telemetry.addData("forward", forward);
        telemetry.addData("S2S", side);
        telemetry.addData("BackLeft", bl);
        telemetry.addData("FrontLeft", fl);
        telemetry.addData("BackRight", br);
        telemetry.addData("FrontRight", fr);
        telemetry.update();
    }
}

