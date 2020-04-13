package com.jiker.keju.controller;

import com.jiker.keju.command.InputCommand;
import com.jiker.keju.domain.Answer;
import static com.jiker.keju.domain.AnswerConstant.MAX_TIMES;
import com.jiker.keju.domain.GuessResult;
import com.jiker.keju.service.Game;
import com.jiker.keju.view.GameView;
import com.google.inject.Inject;

public class GameController {
    private Game game;
    private GameView gameView;
    private InputCommand inputCommand;

    @Inject
    public GameController(Game game, GameView gameView, InputCommand inputCommand) {
        this.game = game;
        this.gameView = gameView;
        this.inputCommand = inputCommand;
    }

    public void play() {
        GuessResult guessResult;
        do {
            Answer input = inputCommand.input();
            guessResult = game.guess(input);
            gameView.showCurrentResult(guessResult);
            gameView.showGuessHistory(game.getHistory());
        } while (!guessResult.correct() && game.getHistory().size() < MAX_TIMES);
        gameView.showMessage(guessResult.correct() ? "successful" : "failure");
        gameView.showMessage("The correct number is: " + game.actualAnswer());
    }
}
