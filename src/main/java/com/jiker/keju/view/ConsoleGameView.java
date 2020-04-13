package com.jiker.keju.view;

import com.jiker.keju.domain.GuessResult;
import com.google.inject.Inject;

import java.util.List;

public class ConsoleGameView implements GameView {
    @Inject
    public ConsoleGameView() {
    }

    @Override
    public void showGuessHistory(List<GuessResult> guessResults) {
        System.out.println("History: ");
        guessResults.forEach(this::showCurrentResult);
    }

    @Override
    public void showMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void showCurrentResult(GuessResult guessResult) {
        System.out.println(guessResult.getInputAnswer() + ":" + guessResult.getResult());
    }
}
