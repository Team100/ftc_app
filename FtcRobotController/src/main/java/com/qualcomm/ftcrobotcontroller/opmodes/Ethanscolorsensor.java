/* Copyright (c) 2015 Qualcomm Technologies Inc

All rights reserved.

Redistribution and use in source and binary forms, with or without modification,
are permitted (subject to the limitations in the disclaimer below) provided that
the following conditions are met:

Redistributions of source code must retain the above copyright notice, this list
of conditions and the following disclaimer.

Redistributions in binary form must reproduce the above copyright notice, this
list of conditions and the following disclaimer in the documentation and/or
other materials provided with the distribution.

Neither the name of Qualcomm Technologies Inc nor the names of its contributors
may be used to endorse or promote products derived from this software without
specific prior written permission.

NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
"AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE. */

package com.qualcomm.ftcrobotcontroller.opmodes;

import android.app.Activity;
import android.graphics.Color;
import android.view.View;

import com.qualcomm.ftcrobotcontroller.R;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;


public class Ethanscolorsensor extends OpMode {

  public enum ColorSensorDevice {ADAFRUIT, HITECHNIC_NXT, MODERN_ROBOTICS_I2C};

  public ColorSensorDevice device = ColorSensorDevice.HITECHNIC_NXT;

  ColorSensor colorSensor;

  float hsvValues[] = {0,0,0};
  final float values[] = hsvValues;
  View relativeLayout;

  @Override
  public void init() {
    hardwareMap.logDevices();

    colorSensor = hardwareMap.colorSensor.get("nxt");

    relativeLayout = ((Activity) hardwareMap.appContext).findViewById(R.id.RelativeLayout);
  }

  @Override
  public void loop() {


    Color.RGBToHSV(colorSensor.red(), colorSensor.green(), colorSensor.blue(), hsvValues);

    telemetry.addData("Clear", colorSensor.alpha());
    telemetry.addData("Red  ", colorSensor.red());
    telemetry.addData("Green", colorSensor.green());
    telemetry.addData("Blue ", colorSensor.blue());
    telemetry.addData("Hue", hsvValues[0]);

    relativeLayout.post(new Runnable() {
      public void run() {
        relativeLayout.setBackgroundColor(Color.HSVToColor(0xff, values));
      }
    });
  }

  private void enableLed(boolean value) {
    colorSensor.enableLed(value);
  }
}