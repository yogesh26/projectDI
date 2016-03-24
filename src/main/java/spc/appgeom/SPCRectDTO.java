package spc.appgeom;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by YogeshK on 2015-10-16.
 */
@Setter
@Getter
public class SPCRectDTO extends SPCBaseObjectDTO{
    private SPCPoint2DDTO origin;
    private SPCPoint2DDTO diag;
}
