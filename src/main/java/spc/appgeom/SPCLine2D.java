package spc.appgeom;

import lombok.Getter;
import lombok.Setter;
import java.lang.Math;

/**
 * Created by YogeshK on 2015-10-14.
 */
@Setter
@Getter
public class SPCLine2D extends SPCBaseObject {
    private SPCPoint2D ptStart;
    private SPCPoint2D ptEnd;
    public SPCLine2D(){
        super.setOBJECT_TYPE(SPCEnums.LINE2D);
    }
    public SPCRect2D getBoundingRect(){
        return ( new SPCRect2D(ptStart.getFX(),ptStart.getFY(),Math.abs((ptStart.getFX() - ptEnd.getFX())),Math.abs(ptStart.getFY()-ptEnd.getFY()) ));

    }
}
