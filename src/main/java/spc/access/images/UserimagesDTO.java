package spc.access.images;

import spc.access.details.Userdetails;

import java.util.List;

/**
 * Created by YogeshK on 2015-07-22.
 */

public class UserimagesDTO {
    private static final long serialVersionUID = 1L;
    private Integer iduserimage;
    private byte[] userimage;
    private String type;
     private Integer sizeWidth;
    private Integer sizeHeight;
    private String imagename;
    private List<Userdetails> userdetailsList;

}