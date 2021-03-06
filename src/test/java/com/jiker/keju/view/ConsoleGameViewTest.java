package com.jiker.keju.view;

import com.jiker.keju.domain.GuessResult;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class ConsoleGameViewTest {

    private ConsoleGameView consoleGameView;

    @Before
    public void setUp() throws Exception {
        consoleGameView = new ConsoleGameView();
    }

    @Test
    public void should_be_able_to_show_message() throws Exception {
        // when
        consoleGameView.showMessage("message");
    }

    @Test
    public void should_be_able_to_show_current_result() throws Exception {
        // when
        GuessResult guessResult = new GuessResult();
        guessResult.setInputAnswer("1 2 3 4");
        guessResult.setResult("successful");
        consoleGameView.showCurrentResult(guessResult);
    }

    @Test
    public void should_be_able_to_show_guess_results() throws Exception {
        // when
        GuessResult guessResult = new GuessResult();
        guessResult.setInputAnswer("1 2 3 4");
        guessResult.setResult("successful");
        consoleGameView.showGuessHistory(Arrays.asList(guessResult));
    }
}
