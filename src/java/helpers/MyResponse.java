/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import javax.ws.rs.core.Response;

/**
 *
 * @author tomek.buslowski
 */
public class MyResponse {

    public static Response Unauthorized(String message) {
        return Response
                .status(Response.Status.UNAUTHORIZED)
                .entity(MyJson.Error(
                        Response.Status.UNAUTHORIZED.getStatusCode(),
                        Response.Status.UNAUTHORIZED.getReasonPhrase(),
                        message))
                .build();
    }

}
