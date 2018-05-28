/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filters;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.util.Base64;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import jdk.nashorn.api.scripting.JSObject;
import helpers.MyJson;
import helpers.MyResponse;

/**
 *
 * @author tomek.buslowski
 */
@Provider
@Logowanie
public class SecurityFilter implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {

        final String authorization = requestContext.getHeaderString("Authorization");
        if (authorization != null && authorization.startsWith("Basic")) {

            // Authorization: Basic base64credentials
            String base64Credentials = authorization.substring("Basic".length()).trim();
            String credentials = new String(Base64.getDecoder().decode(base64Credentials), Charset.forName("UTF-8"));

            // credentials = username:password
            final String[] values = credentials.split(":", 2);
            String login = values[0];
            String password = values[1];
            System.out.println(login + " " + password);

            if (login.equals("peter") && password.equals("qwerty")) {
                System.out.println("Good");
                return;
            } else {
                requestContext.abortWith(MyResponse.Unauthorized("incorrenct login or password"));
                return;
            }
        }

        requestContext.abortWith(MyResponse.Unauthorized("AUTHORIZATION header not found"));
    }
}
