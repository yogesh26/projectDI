package spc.appgeom;

import spc.utils.CommonResponseHeader;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YogeshK on 2015-10-16.
 */
@Api(description = "CRUD for object container",
        value = "CRUD for object container to access the geometrical objects")
@RestController
@RequestMapping(value = "/geom", produces = MediaType.APPLICATION_JSON_VALUE)
//@EnableAutoConfiguration(exclude=org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration.class)
public class QuadTreeController {

    SPCQuadTree tree=null;


    private SPCQuadTree getTreeInit(){
        SPCQuadTree tree=new SPCQuadTree(0, new SPCRect2D(0,0,600,600));
        SPCLine2D ln=new SPCLine2D();
        ln.setPtStart(new SPCPoint2D(10, 50));
        ln.setPtEnd(new SPCPoint2D(20, 75));

        tree.insert(ln);

        ln=new SPCLine2D();
        ln.setPtStart(new SPCPoint2D(20, 30));
        ln.setPtEnd(new SPCPoint2D(20, 75));
        tree.insert(ln);

        ln=new SPCLine2D();
        ln.setPtStart(new SPCPoint2D(15, 20));
        ln.setPtEnd(new SPCPoint2D(200, 75));

        tree.insert(ln);

        ln=new SPCLine2D();
        ln.setPtStart(new SPCPoint2D(100, 300));
        ln.setPtEnd(new SPCPoint2D(120, 200));
        tree.insert(ln);

        ln=new SPCLine2D();
        ln.setPtStart(new SPCPoint2D(123, 150));
        ln.setPtEnd(new SPCPoint2D(200, 175));

        tree.insert(ln);

        ln=new SPCLine2D();
        ln.setPtStart(new SPCPoint2D(205, 305));
        ln.setPtEnd(new SPCPoint2D(200, 375));
        tree.insert(ln);

        ln=new SPCLine2D();
        ln.setPtStart(new SPCPoint2D(310, 350));
        ln.setPtEnd(new SPCPoint2D(320, 375));

        tree.insert(ln);

        ln=new SPCLine2D();
        ln.setPtStart(new SPCPoint2D(220, 230));
        ln.setPtEnd(new SPCPoint2D(220, 275));
        tree.insert(ln);
        return tree;
    }
    @ApiOperation(response = ApiResponse.class,
            value = "version of the api",
            notes = "current version of the api")
    @RequestMapping(value = "/Ver",
            method = RequestMethod.GET)
    public ResponseEntity<String> version() {
        System.out.println("Ver1.0");
        HttpHeaders headers = CommonResponseHeader.getNoCacheHeader();
        headers.set("Access-Control-Allow-Origin", "*");
        return new ResponseEntity<>("ver1.0", headers, HttpStatus.OK);

    }


    @RequestMapping(value = "/getAllObjects",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseStatus(HttpStatus.OK)
    public  ResponseEntity<List<SPCBaseObjectDTO>> getAllObjects() {

        SPCQuadTree tree = this.getTreeInit();

        HttpHeaders headers = CommonResponseHeader.getNoCacheHeader();
        headers.set("Access-Control-Allow-Origin","*");
        SPCRectDTO rect=new SPCRectDTO();
        SPCPoint2DDTO start=new SPCPoint2DDTO();
        start.setFX(0f);
        start.setFY(0f);
        SPCPoint2DDTO end = new SPCPoint2DDTO();
        end.setFX(600f);
        end.setFY(600f);
        rect.setDiag(end);
        rect.setOrigin(start);
        List<SPCBaseObjectDTO> resp=new ArrayList<SPCBaseObjectDTO>();
        resp.add(rect);

        return new ResponseEntity<>(resp, headers, HttpStatus.OK);

    }

}
