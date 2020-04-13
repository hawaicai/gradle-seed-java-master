package com.jiker.keju.service;

import com.jiker.keju.domain.Answer;
import com.jiker.keju.domain.GuessResult;
import com.jiker.keju.generator.AnswerGenerator;
import com.jiker.keju.validator.AnswerValidator;
import static com.google.common.collect.Lists.newArrayList;
import com.google.inject.Inject;

import java.util.List;

public class Game {
    private Answer answer;
    private List<GuessResult> guessResults;
    private AnswerValidator answerValidator;

    @Inject
    public Game(AnswerGenerator answerGenerator, final AnswerValidator answerValidator) {
        this.answer = answerGenerator.generate();
        this.answerValidator = answerValidator;
        this.guessResults = newArrayList();
    }

    public GuessResult guess(Answer answer) {
        answerValidator.validate(answer);
        String result = this.answer.compare(answer);
        GuessResult guessResult = createGuessResult(answer, result);
        guessResults.add(guessResult);
        return guessResult;
    }

    private GuessResult createGuessResult(Answer answer, String result) {
        GuessResult guessResult = new GuessResult();
        guessResult.setInputAnswer(answer.getValue());
        guessResult.setResult(result);
        return guessResult;
    }

    public List<GuessResult> getHistory() {
        return guessResults;
    }

    public String actualAnswer() {
        return answer.getValue();
    }
}
