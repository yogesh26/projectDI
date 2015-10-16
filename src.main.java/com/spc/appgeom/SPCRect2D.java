package com.spc.appgeom;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by YogeshK on 2015-10-14.
 */
@Setter
@Getter
public class SPCRect2D extends SPCBaseObject {
    private SPCPoint2D origin;
    private float width;
    private float height;
    public boolean containsObject(SPCBaseObject obj){
        if(obj.getOBJECT_TYPE()==SPCEnums.POINT2D){
            if((origin.isThisPointMoreThan((SPCPoint2D) obj) || origin.isThisPointEqualTo((SPCPoint2D) obj))&&
                    (origin.isThisPointLessThan((SPCPoint2D) obj) || origin.isThisPointEqualTo((SPCPoint2D) obj)))  {
                return true;
            }
        }else if(obj.getOBJECT_TYPE()==SPCEnums.LINE2D){
            SPCPoint2D diag=new SPCPoint2D(origin.getFX()+width, origin.getFY()+height);
            if(((origin.isThisPointMoreThan(((SPCLine2D) obj).getPtStart()) || origin.isThisPointEqualTo(((SPCLine2D) obj).getPtStart()))&&
                    (diag.isThisPointLessThan(((SPCLine2D) obj).getPtEnd()) || diag.isThisPointEqualTo(((SPCLine2D) obj).getPtEnd()))))  {
                return true;
            }
        }
        return false;
    }
    public SPCRect2D(float x, float y, float w, float h){
        origin= new SPCPoint2D(x,y);
        width = w;
        height = h;
    }

    @Override
    public SPCRect2D getBoundingRect() {
        return this;
    }
}
