package com.jiker.keju.runner;

import com.jiker.keju.config.GameModule;
import com.jiker.keju.controller.GameController;
import com.google.inject.Guice;
import com.google.inject.Injector;

public final class Application {
    private Application() {
    }

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new GameModule());
        GameController gameController = injector.getInstance(GameController.class);

        gameController.play();
    }
}
