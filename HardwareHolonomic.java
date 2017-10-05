package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

/**
 * Created by Codewolf on 10/3/2017.
 */

public class HardwareHolonomic {

    public DcMotor dnw, dne, dsw, dse;

    public HardwareHolonomic(HardwareMap hardwareMap) {
        dnw = hardwareMap.dcMotor.get("NorthWest");
        dne = hardwareMap.dcMotor.get("NorthEast");
        dsw = hardwareMap.dcMotor.get("SouthWest");
        dse = hardwareMap.dcMotor.get("SouthEast");
    }
}
