/**
 * Turgo server
 * <p>
 *     @author bpdp
 *     @version 0.0.1-BETA
 */

package name.bpdp.turgo.core;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.grizzly.http.server.Request;
import org.glassfish.grizzly.http.server.Response;
import org.glassfish.grizzly.http.server.NetworkListener;
import org.glassfish.grizzly.http.server.HttpHandler;

import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * Created by bpdp on 4/5/14.
 */

public class TurgoServer {

    private final int port;

    public TurgoServer(int port) {
        this.port = port;
    }

    public void run() throws Exception {

        HttpServer httpServer = new HttpServer();
        NetworkListener networkListener = new NetworkListener("turgo-http-listener", "localhost", this.port);
        httpServer.addListener(networkListener);
	    httpServer.getServerConfiguration().addHttpHandler(new HttpHandler() {
    
            final SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
            @Override
            public void service(Request request, Response response) throws Exception {

                final Date now = new Date();
                final String formattedTime;
                
                synchronized (formatter) {
                    formattedTime = formatter.format(now);
                }

		        response.setContentType("text/plain");
		        response.getWriter().write(formattedTime);
	
            }
	
        }, "/time");

        try {
            httpServer.start();
            Thread.currentThread().join();
        } catch (Exception e) {
            System.err.println(e);
        }

    }

}