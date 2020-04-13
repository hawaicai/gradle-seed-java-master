package com.jiker.keju.validator;

import com.jiker.keju.domain.Answer;
import com.jiker.keju.exception.AnswerNotFourDigitException;
import com.jiker.keju.exception.AnswerNumberDuplicatedException;
import static org.junit.Assert.assertThrows;
import org.junit.Before;
import org.junit.Test;

public class AnswerValidatorTest {

    private AnswerValidator answerValidator;

    @Before
    public void setUp() {
        answerValidator = new AnswerValidator();
    }

    @Test
    public void should_raise_error_out_of_range_answer_exception_which_is_not_between_0_and_9() throws Exception {
        // given
        Answer answer = Answer.createAnswer("1 2 3 11");

        // when
        assertThrows(AnswerNotFourDigitException.class, () -> answerValidator.validate(answer));
    }

    @Test
    public void should_raise_error_which_size_is_not_4() throws Exception {
        // given
        Answer answer = Answer.createAnswer("1 2");

        // when
        assertThrows(AnswerNotFourDigitException.class, () -> answerValidator.validate(answer));
    }

    @Test
    public void should_raise_error_which_contains_duplication() throws Exception {
        // given
        Answer answer = Answer.createAnswer("1 2 2 3");

        // when
        assertThrows(AnswerNumberDuplicatedException.class, () -> answerValidator.validate(answer));
    }
}
