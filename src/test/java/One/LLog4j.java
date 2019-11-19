package One;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class LLog4j {
    private static Logger logger = Logger.getLogger(UsingLog4j.class);

    public static void main(String[] args) {
        BasicConfigurator.configure();

        /* 改變 Root Logger 的等級為 INFO */
        //Logger.getRootLogger().setLevel(Level.INFO);

        /* 鴨子類別庫的 client 只做 INFO 等級的 log;類別庫裡才使用 DEBUG 等級的 log. */
        logger.info("Create a Redhead Duck.");
        RedheadDuck rhd = new RedheadDuck(new FlyWithWings(), new Quack());
        logger.info("Play with the duck.");
        rhd.display();
        rhd.performFly();
        rhd.performQuack();

        logger.info("Create a RubberDuck.");
        RubberDuck rbd = new RubberDuck(new FlyWithRocket(), new Squeak());
        logger.info("Play with the duck.");
        rbd.display();
        rbd.performFly();
        rbd.performQuack();
    }
}

interface FlyBehavior {
    public void fly();
}

class FlyWithWings implements FlyBehavior {
    private static Logger logger = Logger.getLogger(FlyWithWings.class);

    public void fly() {
        logger.debug("Fly with wings...");
    }
}

class FlyWithRocket implements FlyBehavior {
    private static Logger logger = Logger.getLogger(FlyWithRocket.class);

    public void fly() {
        logger.debug("Fly with a rocket...");
    }
}

interface QuackBehavior {
    public void quack();
}

class Quack implements QuackBehavior {
    private static Logger logger = Logger.getLogger(Quack.class);

    public void quack() {
        logger.debug("Quack...");
    }
}

class Squeak implements QuackBehavior {
    private static Logger logger = Logger.getLogger(Squeak.class);

    public void quack() {
        logger.debug("Squeak...");
    }
}

abstract class Duck {
    private FlyBehavior flyBehavior;

    private QuackBehavior quackBehavior;

    public Duck(FlyBehavior flyBehavior, QuackBehavior quackBehavior) {
        this.flyBehavior = flyBehavior;
        this.quackBehavior = quackBehavior;
    }

    public void performQuack() {
        this.quackBehavior.quack();
    }

    public void performFly() {
        this.flyBehavior.fly();
    }

    public abstract void display();
}

class RedheadDuck extends Duck {
    private static Logger logger = Logger.getLogger(RedheadDuck.class);

    public RedheadDuck(FlyBehavior flyBehavior, QuackBehavior quackBehavior) {
        super(flyBehavior, quackBehavior);
    }

    @Override
    public void display() {
        logger.debug("A RedheadDuck is showing up...");
    }
}

class RubberDuck extends Duck {
    private static Logger logger = Logger.getLogger(RubberDuck.class);

    public RubberDuck(FlyBehavior flyBehavior, QuackBehavior quackBehavior) {
        super(flyBehavior, quackBehavior);
    }

    @Override
    public void display() {
        logger.debug("A RubberDuck is showing up...");
    }
}
