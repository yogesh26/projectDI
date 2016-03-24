package spc.appgeom;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by YogeshK on 2015-10-14.
 */
@Setter
@Getter
public class SPCPoint2D extends SPCBaseObject {
    private float fX;
    private float fY;
    SPCPoint2D(){
        super.setOBJECT_TYPE(SPCEnums.POINT2D);
    }
    public boolean isThisPointMoreThan(SPCPoint2D thisPoint){
        if(fX< thisPoint.getFX() && fY < thisPoint.getFY()){
            return true;
        }
        return false;
    }
    public boolean isThisPointLessThan(SPCPoint2D thisPoint){
        if(fX > thisPoint.getFX() && fY > thisPoint.getFY()){
            return true;
        }
        return false;
    }
    public boolean isThisPointEqualTo(SPCPoint2D thisPoint){
        if(fX == thisPoint.getFX() && fY == thisPoint.getFY()){
            return true;
        }
        return false;
    }
    public SPCPoint2D(float x, float y){
        super.setOBJECT_TYPE(SPCEnums.POINT2D);
        fX = x;
        fY = y;
    }
    public SPCRect2D getBoundingRect(){
        return ( new SPCRect2D(fX,fY,0,0));

    }
}
