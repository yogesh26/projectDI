package spc.appgeom;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Created by YogeshK on 2015-10-14.
 */
@Setter
@Getter
public class SPCPoly2D extends SPCBaseObject {
    List<SPCPoint2D> listPoints;
    SPCPoly2D(){
        super.setOBJECT_TYPE(SPCEnums.POLY2D);
    }
    private float minx=9999999999f;
    private float miny=9999999999f;
    private float maxx=-9999999999f;
    private float maxy=-9999999999f;

    public SPCRect2D getBoundingRect(){
        computeMinMax();
        return ( new SPCRect2D(minx,miny,maxx,maxy));
    }
    private void computeMinMax(){

        for(int i =0;i<listPoints.size();i++){
            SPCPoint2D pnt = listPoints.get(i);
            if(pnt.getFX()< minx){
                minx = pnt.getFX();
            }
            if(pnt.getFX()>maxx){
                maxx = pnt.getFX();
            }
            if(pnt.getFY()< miny){
                miny = pnt.getFY();
            }
            if(pnt.getFY()>maxy){
                maxy = pnt.getFY();
            }
        }
    }
    public void addObject(SPCPoint2D pnt){
        listPoints.add(pnt);

    }

}
