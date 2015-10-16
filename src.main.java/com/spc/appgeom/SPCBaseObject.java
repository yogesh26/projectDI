package com.spc.appgeom;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by YogeshK on 2015-10-14.
 */
@Setter
@Getter
public abstract class SPCBaseObject {
    private SPCEnums OBJECT_TYPE;
    public abstract SPCRect2D getBoundingRect();
}
