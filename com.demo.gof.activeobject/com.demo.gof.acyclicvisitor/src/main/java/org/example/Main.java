package org.example;
import org.apache.log4j.Logger;


public class ConfigureForDosVisitor implements AllModemVisitor {
    @Override
    public void visit(Hayes hayes) {
        logger.info(hayes + " used with Dos configurator.");
    }
    @Override
    public void visit(Zoom zoom) {
        LOGGER.info(zoom + " used with Dos configurator.");
    }
}

public class ConfigureForUnixVisitor implements ZoomVisitor {

    @Override
    public void visit(Zoom zoom) {
        LOGGER.info(zoom + " used with Unix configurator.");
    }
}

public class Zoom extends Modem {
    @Override
    public void accept(ModemVisitor modemVisitor) {
        if (modemVisitor instanceof ZoomVisitor) {
            ((ZoomVisitor) modemVisitor).visit(this);
        } else {
            LOGGER.info("Only ZoomVisitor is allowed to visit Zoom modem");
        }
    }
}

public class Hayes extends Modem {

    @Override
    public void accept(ModemVisitor modemVisitor) {
        if (modemVisitor instanceof HayesVisitor) {
            ((HayesVisitor) modemVisitor).visit(this);
        } else {
            LOGGER.info("Only HayesVisitor is allowed to visit Hayes modem");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    private static Logger LOGGER = Logger.getLogger(vincent_player_framt.class);
}