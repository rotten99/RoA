package org.abstractica.javacsgmodules.moistsensor;

import org.abstractica.javacsg.Geometry3D;
import org.abstractica.javacsg.JavaCSG;
import org.abstractica.javacsg.JavaCSGFactory;
import org.abstractica.javacsgmodules.roundclicker.RoundClickerTest;

public class sensorholder {

    public void createMoistSensorHolder (){

        // 3,5 og 11,5, 5,5 mellem de to pinde på sensor, 7 mellem bottomcone og andre cones
        // Selve sensor er 20 bred
        JavaCSG csg = JavaCSGFactory.createDefault();
        // Boxes
        //Geometry3D box1 = csg.box3D(10, 15, 5, false);
        Geometry3D box2 = csg.box3D(15, 28, 10, false);
        Geometry3D boxside1 = csg.box3D(15, 2, 5, false);
        Geometry3D boxside2 = csg.box3D(15, 2, 5, false);
        Geometry3D boxBack = csg.box3D(15, 28, 5, false);

        // Clicker
        Geometry3D clicker = new RoundClickerTest().getClicker(csg, 1.0);


        // Holder for sensor
        Geometry3D bottomCone = csg.cone3D(5.5,5.5,10,128,false);

        // Move clicker
        clicker = csg.translate3D(0,0, 5).transform(clicker);
        clicker = csg.rotate3DY(csg.degrees(90)).transform(clicker);

        // Move box2
        box2 = csg.translate3D(0, 0, 0).transform(box2);
        boxside1 = csg.translate3D(0, 13, 10).transform(boxside1);
        boxside2 = csg.translate3D(0, -13, 10).transform(boxside2);
        boxBack = csg.translate3D(0, 0, 15).transform(boxBack);

        // Move cone
        bottomCone = csg.translate3D(-4.8, 0, 5).transform(bottomCone);



        Geometry3D boxWithClicker = csg.union3D(clicker, box2, bottomCone, boxside1, boxside2, boxBack);
        boxWithClicker = csg.rotate3DY(csg.degrees(-90)).transform(boxWithClicker);
        csg.view(boxWithClicker);

    }

    public static void main(String[] args)
    {
        new sensorholder().createMoistSensorHolder();

    }
}
