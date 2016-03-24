package spc.appgeom;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by YogeshK on 2015-10-16.
 */
@Setter
@Getter
public class SPCLine2DDTO extends SPCBaseObjectDTO {
    SPCPoint2DDTO startPt;
    SPCPoint2D endPt;
}
