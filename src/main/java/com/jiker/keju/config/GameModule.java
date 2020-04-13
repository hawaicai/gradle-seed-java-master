package com.jiker.keju.config;

import com.jiker.keju.command.ConsoleInputCommand;
import com.jiker.keju.command.InputCommand;
import com.jiker.keju.generator.AnswerGenerator;
import com.jiker.keju.generator.RandomIntGenerator;
import com.jiker.keju.validator.AnswerValidator;
import com.jiker.keju.view.ConsoleGameView;
import com.jiker.keju.view.GameView;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import static java.nio.charset.Charset.forName;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class GameModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(InputCommand.class).to(ConsoleInputCommand.class).in(Singleton.class);
        bind(GameView.class).to(ConsoleGameView.class).in(Singleton.class);
        bind(AnswerGenerator.class).in(Singleton.class);
        bind(RandomIntGenerator.class).in(Singleton.class);
        bind(Random.class).in(Singleton.class);
        bind(AnswerValidator.class).in(Singleton.class);
    }

    @Provides
    BufferedReader provideBufferedReader() {
        return new BufferedReader(new InputStreamReader(System.in, forName("UTF-8")));
    }
}
