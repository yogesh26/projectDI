package com.spc.appgeom;

import com.spc.utils.CommonResponseDTO;
import com.spc.utils.CommonResponseHeader;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.spc.appgeom.SPCLine2D;
import com.spc.appgeom.SPCPoint2D;
import com.spc.appgeom.SPCQuadTree;
import com.spc.appgeom.SPCRect2D;
/**
 * Created by YogeshK on 2015-10-16.
 */
@RestController
@RequestMapping("/geom")
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

    @RequestMapping("/Ver")
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
