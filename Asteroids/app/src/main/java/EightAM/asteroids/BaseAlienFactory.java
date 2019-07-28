package EightAM.asteroids;

import java.util.HashMap;
import java.util.Map;

import EightAM.asteroids.interfaces.AlienFactory;
import EightAM.asteroids.specs.BaseAlienSpec;
import EightAM.asteroids.specs.BigAlienSpec;

class BaseAlienFactory implements AlienFactory {
    static BaseAlienFactory instance;
    private Map<BaseAlienSpec, Alien> prototypes;

    private BaseAlienFactory() {
        prototypes = new HashMap<>();
    }

    static void init() {
        if (instance == null) instance = new BaseAlienFactory();
    }

    static BaseAlienFactory getInstance() {
        if (instance == null) init();
        return instance;
    }

    @Override
    public Alien createAlien(BaseAlienSpec spec) {
        Alien alien;
        alien = prototypes.get(spec);
        if (alien == null) {
            if (spec instanceof BigAlienSpec) {
                alien = new BigAlien((BigAlienSpec) spec);
            }
            prototypes.put(spec, alien);
        }
        return alien;
    }
}
