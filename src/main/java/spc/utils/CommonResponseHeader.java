package spc.utils;

import org.springframework.http.HttpHeaders;

/**
 * Created by YogeshK on 2015-09-17.
 */
public class CommonResponseHeader {
    private CommonResponseHeader(){

    }
    public static HttpHeaders getNoCacheHeader() {
        HttpHeaders resp = new HttpHeaders();
        resp.setCacheControl("no-cache, no-store, must-revalidate");
        resp.setPragma("Pragma");
        resp.setExpires(-1);
        return resp;
    }
}
