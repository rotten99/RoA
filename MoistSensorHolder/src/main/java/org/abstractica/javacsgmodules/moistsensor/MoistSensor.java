package org.abstractica.javacsgmodules.moistsensor;

import org.abstractica.javacsg.Geometry3D;
import org.abstractica.javacsg.JavaCSG;
import org.abstractica.javacsg.JavaCSGFactory;
import org.abstractica.javacsgmodules.roundclicker.RoundClickerHoleTest;
import org.abstractica.javacsgmodules.roundclicker.RoundClickerTest;

public class MoistSensor
{

    public void createMoistSensorHolder (){

        JavaCSG csg = JavaCSGFactory.createDefault();
        // Boxes
        Geometry3D box1 = csg.box3D(60, 10, 5, false);
        Geometry3D box2 = csg.box3D(10, 10, 30, false);
        // Clicker
        Geometry3D clicker = new RoundClickerTest().getClicker(csg, 1.0);

        // Get clickeholer
        Geometry3D clickerhole = new RoundClickerHoleTest().getHole(csg, 1.0);

        // Move clicker
        clicker = csg.translate3D(30, 0, 2.5).transform(clicker);

        // Move box2
        box2 = csg.translate3D(-30, 0, 0).transform(box2);

        // Add clickerhole to box2
        clickerhole = csg.translate3D(-30, 0, 25).transform(clickerhole);
        box2 = csg.difference3D(box2, clickerhole);


        Geometry3D boxWithClicker = csg.union3D(box1, clicker, box2);
        csg.view(boxWithClicker);
    }

    public static void main(String[] args)
    {
        new MoistSensor().createMoistSensorHolder();
        
    }
}

