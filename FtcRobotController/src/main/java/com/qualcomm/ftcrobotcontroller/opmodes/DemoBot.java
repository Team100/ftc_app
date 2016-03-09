package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;


/**
 * Created by Ian Ramsey on 9/19/2015.
 */
public class DemoBot extends OpMode {
    DcMotorController wheelControllerLeft;
    DcMotor motorBackLeft;
    DcMotor motorFrontLeft;
    DcMotorController wheelControllerRight;
    DcMotor motorBackRight;
    DcMotor motorFrontRight;

    public void init() {
        motorBackRight = hardwareMap.dcMotor.get("RightBack");
        motorFrontRight = hardwareMap.dcMotor.get("RightFront");
        motorBackLeft = hardwareMap.dcMotor.get("LeftBack");
        motorFrontLeft = hardwareMap.dcMotor.get("LeftFront");
        wheelControllerRight = hardwareMap.dcMotorController.get("Right");
        wheelControllerLeft = hardwareMap.dcMotorController.get("Left");

    }

    public void loop() {
        float leftthrottle = -gamepad1.left_stick_y;
        float rightthrottle = -gamepad1.right_stick_y;

        if (gamepad1.right_bumper) {
            leftthrottle = 1/2*leftthrottle;
            rightthrottle = 1/2*rightthrottle;
        }

        motorBackLeft.setPower(-leftthrottle);
        motorFrontLeft.setPower(-leftthrottle);
        motorBackRight.setPower(rightthrottle);
        motorFrontRight.setPower(rightthrottle);
    }
}
