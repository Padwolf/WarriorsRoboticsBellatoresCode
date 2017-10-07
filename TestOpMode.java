package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

/**
 * Created by Codewolf on 10/3/2017.
 */

@TeleOp(name="Test Op")
public class TestOpMode extends OpMode {
    HardwareHolonomic hardware;
    private final double maxSpeed = 0.5;
    @Override
    public void init() {
        hardware = new HardwareHolonomic(hardwareMap);
    }

    @Override
    public void loop() {
        double speed = Math.sqrt(Math.pow(gamepad1.right_stick_x, 2) +
                Math.pow(gamepad1.right_stick_y, 2));
        double[] powers = calcWheelPowers(GenFuncs.constrain(gamepad1.right_stick_x, 1, -1),
                GenFuncs.constrain(gamepad1.right_stick_y, 1, -1), gamepad1.left_stick_x, speed);
        telemetry.addData("W0", powers[0]);
        telemetry.addData("W1", powers[1]);
        telemetry.addData("W2", powers[2]);
        telemetry.addData("W3", powers[3]);


        for (int i = 0; i < powers.length; i++) {
            powers[i] *= maxSpeed;
        }

        hardware.dnw.setPower(powers[0]);
        hardware.dne.setPower(powers[1]);
        hardware.dsw.setPower(powers[2]);
        hardware.dse.setPower(powers[3]);
    }

    static double[] calcWheelPowers (double x, double y, double turn, double speed) {

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
        powers[2] = -Math.sin(angle);
        powers[3] = -Math.cos(angle);

        for (int i = 0; i < powers.length; i++) {
            powers[i] *= speed;
        }

        for (int i = 0; i < powers.length; i++) {
            powers[i] = GenFuncs.constrain(powers[i] + (turn * 0.5), 1, -1);
        }

        return powers;
    }
}
