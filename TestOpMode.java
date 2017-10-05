package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

/**
 * Created by Codewolf on 10/3/2017.
 */

@TeleOp(name="Test Op")
public class TestOpMode extends OpMode {
    HardwareHolonomic hardware;
    @Override
    public void init() {
        hardware = new HardwareHolonomic(hardwareMap);
    }

    @Override
    public void loop() {
        double[] powers = calcWheelPowers(gamepad1.right_stick_x, gamepad1.right_stick_y);
        hardware.dnw.setPower(powers[0]);
        hardware.dne.setPower(powers[1]);
        hardware.dsw.setPower(powers[2]);
        hardware.dse.setPower(powers[3]);
    }

    static double[] calcWheelPowers (double x, double y) {

	/*
	  Holonomic Wheel Layout
	     Looking at the wheel from in front of it,
		 all wheels rotate counterclockwise

	  w0 /    \ w1

	  w3 \    / w2

	*/

        double[] powers = new double[4];

        double angle = Math.atan2(y,x) + (Math.PI/4);

        powers[0] = Math.cos(angle);
        powers[1] = Math.sin(angle);
        powers[2] = -Math.cos(angle);
        powers[3] = -Math.sin(angle);

        return powers;
    }
}
