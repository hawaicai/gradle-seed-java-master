package com.jiker.keju.view;

import com.jiker.keju.domain.GuessResult;

import java.util.List;

public interface GameView {
    void showGuessHistory(List<GuessResult> guessResults);

    void showMessage(String message);

    void showCurrentResult(GuessResult guessResult);
}
