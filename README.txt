To create a flashing shape, the line in the file would be as follows:

<shape> <px> <py> <vx> <vy> <filled?> <width> <height> <r> <g> <b> <flash?> <fr> <fg> <fb> <insertion time>
or
<shape> <px> <py> <vx> <vy> <filled?> <diameter> <r> <g> <b> <flash?> <fr> <fg> <fb> <insertion time>
or
<shape> <px> <py> <vx> <vy> <filled?> <side> <r> <g> <b> <flash?> <fr> <fg> <fb> <insertion time>

<px> <py> - The starting position of the shape in the plane
<vx> <vy> - The velocity of the shape as a vector
<filled?> - True if the shape is filled and false otherwise
<width> <height> - the width and height of the triangle or rectangle or oval(only required when <shape> is triangle or rectangle or oval).
<diameter> - the diameter of the circle(only required when <shape> is circle).
<side> - the side of the square(only required when <shape> is square).
<r> <g> <b> - The colour of the shape
<flash?> - True
<fr> <fg> <fb> - The colour of the shape will flash to
<insertion time> - time in milliseconds since the start of the program after which the shape is inserted


To create a shape which is not flashing, the line in the file would be as follows:

<shape> <px> <py> <vx> <vy> <filled?> <width> <height> <r> <g> <b> <flash?> <insertion time>
or
<shape> <px> <py> <vx> <vy> <filled?> <diameter> <r> <g> <b> <flash?> <insertion time>
or
<shape> <px> <py> <vx> <vy> <filled?> <side> <r> <g> <b> <flash?> <insertion time>

<px> <py> - The starting position of the shape in the plane
<vx> <vy> - The velocity of the shape as a vector
<filled?> - True if the shape is filled and false otherwise
<width> <height> - the width and height of the triangle or rectangle or oval(only required when <shape> is triangle or rectangle or oval).
<diameter> - the diameter of the circle(only required when <shape> is circle).
<side> - the side of the square(only required when <shape> is square).
<r> <g> <b> - The colour of the shape
<flash?> - False
<insertion time> - time in milliseconds since the start of the program after which the shape is inserted


To create a triangle, the line in the file would be as follows:

triangle <px> <py> <vx> <vy> <filled?> <width> <height> <r> <g> <b> <flash?> <fr> <fg> <fb> <insertion time>
or
triangle <px> <py> <vx> <vy> <filled?> <width> <height> <r> <g> <b> <flash?> <insertion time>

<px> <py> - The starting position of the shape in the plane
<vx> <vy> - The velocity of the shape as a vector
<filled?> - True if the shape is filled and false otherwise
<width> <height> - the width and height of the triangle.
<r> <g> <b> - The colour of the shape
<flash?> - True if the shape will flash and false otherwise
<fr> <fg> <fb> - The colour of the shape will flash to (only required when <flash?> is true)
<insertion time> - time in milliseconds since the start of the program after which the shape is inserted