union()
{
    linear_extrude(height = 5.0, twist = 0.0, scale = 1.0, slices = 1, center = false)
    {
        scale([60.0, 10.0])
        {
            M8();
        }
    }
    translate([30.0, 0.0, 2.5])
    {
        rotate([0.0, 90.0, 0.0])
        {
            intersection()
            {
                difference()
                {
                    rotate_extrude(angle = 360.0, $fn = 128)
                    {
                        M66();
                    }
                    translate([0.0, 0.0, 2.0])
                    {
                        linear_extrude(height = 10.0, twist = 0.0, scale = 1.0, slices = 1, center = false)
                        {
                            scale([10.0, 1.6])
                            {
                                M8();
                            }
                        }
                    }
                }
                linear_extrude(height = 10.0, twist = 0.0, scale = 1.0, slices = 1, center = false)
                {
                    scale([5.0, 10.0])
                    {
                        M8();
                    }
                }
            }
        }
    }
    difference()
    {
        translate([-30.0, 0.0, 0.0])
        {
            linear_extrude(height = 30.0, twist = 0.0, scale = 1.0, slices = 1, center = false)
            {
                scale([10.0, 10.0])
                {
                    M8();
                }
            }
        }
        translate([-30.0, 0.0, 25.0])
        {
            rotate_extrude(angle = 360.0, $fn = 128)
            {
                M60();
            }
        }
    }
}

module M66()
{
    polygon
    (
        points =
        [
            [0.0, 0.0], 
            [3.9, 0.0], 
            [3.9, 1.0], 
            [2.9, 2.0], 
            [2.9, 7.7], 
            [3.9, 8.7], 
            [2.9, 10.0], 
            [0.0, 10.0], 
            [0.0, 2.0]
        ],
        paths =
        [
            [0, 1, 2, 3, 4, 5, 6, 7, 8]
        ]
    );
}

module M8()
{
    polygon
    (
        points =
        [
            [-0.5, -0.5], 
            [0.5, -0.5], 
            [0.5, 0.5], 
            [-0.5, 0.5]
        ],
        paths =
        [
            [0, 1, 2, 3]
        ]
    );
}

module M60()
{
    polygon
    (
        points =
        [
            [0.0, 0.0], 
            [4.1, 0.0], 
            [4.1, 1.0], 
            [3.1, 2.0], 
            [3.1, 3.0], 
            [4.1, 4.0], 
            [4.1, 5.0], 
            [0.0, 5.0]
        ],
        paths =
        [
            [0, 1, 2, 3, 4, 5, 6, 7]
        ]
    );
}
