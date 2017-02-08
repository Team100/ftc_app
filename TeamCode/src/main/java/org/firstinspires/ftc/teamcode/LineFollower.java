
package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cColorSensor;
import com.qualcomm.hardware.modernrobotics.ModernRoboticsUsbDeviceInterfaceModule;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.AnalogInput;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.DeviceInterfaceModule;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.ServoController;


import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.ServoController;
/**
 * Created by FTC Team 4799-4800 on 10/13/2016.
 */

@Autonomous(name = "Meme.jpeg", group = "")
public class  LineFollower extends OpMode {
    //DcMotorController wheelControllerLeft;
    DcMotor motorBackLeft;
    DcMotor motorFrontLeft;
    //DcMotorController wheelControllerRight;
    DcMotor motorBackRight;
    DcMotor motorFrontRight;
    ModernRoboticsUsbDeviceInterfaceModule interfaceModule;
    DeviceInterfaceModule dim;                  // Device Object
    AnalogInput cs1;
    AnalogInput cs2;
    AnalogInput cs3;
    public void init() {
                DigitalChannel digIn;                // Device Object
        DigitalChannel        digOut;               // Device Object

        // get a reference to a Modern Robotics DIM, and IO channels.
        dim = hardwareMap.get(DeviceInterfaceModule.class, "CDI");   //  Use generic form of device mapping
        cs1  = hardwareMap.get(AnalogInput.class, "cs1");     //  Use generic form of device mapping
        cs2 = hardwareMap.get(AnalogInput.class, "cs2");    //  Use generic form of device mapping
        cs3 = hardwareMap.get(AnalogInput.class, "cs3");    //  Use generic form of device mapping
    }
    public void loop() {
        telemetry.addData("vex1:", cs1.getVoltage());
        telemetry.addData("vex2:", cs2.getVoltage());
        telemetry.addData("vex3:", cs3.getVoltage());
        telemetry.update();
    }
}

