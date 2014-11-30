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
import org.glassfish.grizzly.spdy.SpdyAddOn;
import org.glassfish.grizzly.ssl.SSLEngineConfigurator;
import org.glassfish.grizzly.ssl.SSLContextConfigurator;


import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * Created by bpdp on 4/5/14.
 */

public class TurgoServer {

    private final int port;

    public TurgoServer(int port) { this.port = port; }

    public TurgoServer() { this.port = 1443; }

    public void runForHuman() throws Exception {

        HttpServer humanServer = new HttpServer();
        NetworkListener humanListener = new NetworkListener("turgo-human-http-listener", "localhost", this.port);

        humanServer.addListener(humanListener);
	    humanServer.getServerConfiguration().addHttpHandler(new HttpHandler() {
    
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
            humanServer.start();
            Thread.currentThread().join();
        } catch (Exception e) {
            System.err.println(e);
        }

    }

    public void runForAgent() throws Exception {

        HttpServer agentServer = new HttpServer();
        NetworkListener agentListener = new NetworkListener("turgo-agent-http-listener", "localhost", this.port);
        agentListener.setSecure(true);

        SSLContextConfigurator sslConf = new SSLContextConfigurator();
        sslConf.setKeyStoreFile("keys/keystore_server");
        sslConf.setKeyStorePass("asdfgh");
        sslConf.setTrustStoreFile("keys/truststore_server");
        sslConf.setTrustStorePass("asdfgh");

        agentListener.setSSLEngineConfig(new SSLEngineConfigurator(sslConf));

        SpdyAddOn spdyAddOn = new SpdyAddOn();
        agentListener.registerAddOn(spdyAddOn);

        agentServer.addListener(agentListener);
        agentServer.getServerConfiguration().addHttpHandler(new HttpHandler() {

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
            agentServer.start();
            Thread.currentThread().join();
        } catch (Exception e) {
            System.err.println(e);
        }

    }

}