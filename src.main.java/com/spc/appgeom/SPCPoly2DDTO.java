package com.spc.appgeom;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Created by YogeshK on 2015-10-16.
 */
@Setter
@Getter
public class SPCPoly2DDTO extends SPCBaseObjectDTO {
    List<SPCPoint2DDTO> listPoints;
}
