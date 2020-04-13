package com.jiker.keju.controller;

import com.jiker.keju.command.InputCommand;
import com.jiker.keju.domain.Answer;
import com.jiker.keju.generator.AnswerGenerator;
import com.jiker.keju.validator.AnswerValidator;
import com.jiker.keju.service.Game;
import com.jiker.keju.view.GameView;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import static org.mockito.Matchers.anyList;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class GameControllerTest {

    @InjectMocks
    private GameController gameController;
    @Mock
    private InputCommand inputCommand;
    @Mock
    private GameView gameView;
    @Mock
    private AnswerGenerator answerGenerator;

    @Before
    public void setUp() {
        when(answerGenerator.generate()).thenReturn(Answer.createAnswer("1 2 3 4"));
        Game game = new Game(answerGenerator, new AnswerValidator());
        gameController = new GameController(game, gameView, inputCommand);
    }

    @Test
    public void should_be_able_to_show_history_message() {
        // given
        when(inputCommand.input()).thenReturn(Answer.createAnswer("5 6 7 8"));

        // when
        gameController.play();

        // then
        verify(gameView, times(6)).showGuessHistory(anyList());
    }

    @Test
    public void should_end_game_and_show_successful_message_when_first_round() {
        // given
        when(inputCommand.input()).thenReturn(Answer.createAnswer("1 2 3 4"));

        // when
        gameController.play();

        // then
        verify(inputCommand, times(1)).input();
        verify(gameView).showMessage("successful");
    }

    @Test
    public void should_end_game_and_show_failure_message_when_reach_maximum_times() {
        // given
        when(inputCommand.input()).thenReturn(Answer.createAnswer("5 6 7 8"));

        // when
        gameController.play();

        // then
        verify(inputCommand, times(6)).input();
        verify(gameView).showMessage("failure");
    }
}
