package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.DeviceInterfaceModule;
/**
 * Created by FTC Team 4799-4800 on 10/13/2016.
 */

@Autonomous(name = "FollowerOfLines", group = "")
public class LineFollowerDerek extends OpMode {
    //DcMotorController wheelControllerLeft;
    DcMotor motorBackLeft;
    //DcMotorController wheelControllerRight;
    DcMotor motorBackRight;
    DeviceInterfaceModule interfaceModule;
    double cs1;
    double cs2;
    double cs3;
    public void init() {
        interfaceModule = hardwareMap.deviceInterfaceModule.get("CDI");
        motorBackLeft = hardwareMap.dcMotor.get("Left");
        motorBackRight = hardwareMap.dcMotor.get("Right");
    }
    public void loop() {
        cs1 = interfaceModule.getAnalogInputVoltage(0);
        cs2 = interfaceModule.getAnalogInputVoltage(1);
        cs3 = interfaceModule.getAnalogInputVoltage(2);
        telemetry.addData("vex1:", cs1);
        telemetry.addData("vex2:", cs2);
        telemetry.addData("vex3:", cs3);
        telemetry.update();
        motorBackLeft.setPower(.2);
        motorBackRight.setPower(.2);


    }
}

