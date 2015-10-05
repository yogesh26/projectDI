package com.spc.userEntities;

import com.google.gson.Gson;
import com.spc.access.role.UserRolesDTO;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by YogeshK on 2015-10-05.
 */
public class UserRolesTest {

    public static void main(String[] args) throws Exception {
        UserRolesTest test=new UserRolesTest();
        test.createRoleType("PARTNER");

    }

    public void createRoleType(String roleType) throws Exception{
        URL url = new URL("http://localhost:5000/createUserRole");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setDoOutput(true);
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json");
        UserRolesDTO dto=new UserRolesDTO();
        dto.setUserType(roleType);
        dto.setIdUserRoles(0);
        Gson gson = new Gson();
        String json = gson.toJson(dto);
        System.out.println(json);
        OutputStream os = conn.getOutputStream();
        os.write(json.getBytes());
        os.flush();

        System.out.println("REST responseCode is =>" + conn.getResponseCode());
        System.out.println("REST responseMessage is =>" + conn.getResponseMessage());

        if (conn.getResponseCode() == (HttpURLConnection.HTTP_OK | HttpURLConnection.HTTP_CREATED)) {
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("dumping response....");
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String output;
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        }

        conn.disconnect();
        Thread.sleep(10);
    }
}
