package turgo.examples.hello;

import name.bpdp.turgo.config.TurgoConfig;
import name.bpdp.turgo.core.*;
import name.bpdp.turgo.config.*;

import alice.tuprolog.*;
import name.bpdp.turgo.core.TurgoServer;

/**
 * Created by bpdp on 4/12/14.
 */
public class HelloTurgo {

	public static void main(String[] args) throws Exception {

 		int port;

		Prolog engine = new Prolog();

		SolveInfo info = engine.solve("append([1],[2,3],X).");

		TurgoConfig turgoConf = new TurgoConfig();

		if (args.length > 0) {

			port = Integer.parseInt(args[0]);

		} else {

			port = Integer.parseInt(turgoConf.getValue("port"));

		}

		System.out.println("result = " + info.getSolution());

		if (turgoConf.isConfigExists()) {
			System.out.println("There is a conf file: conf/turgo.json");
		} else {
			System.out.println("There is no conf file: conf/turgo.json");
		}

		new TurgoServer(port).runForHuman();
		new TurgoServer().runForAgent();

	}

}
