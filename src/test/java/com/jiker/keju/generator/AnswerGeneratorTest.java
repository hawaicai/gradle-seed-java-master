package com.jiker.keju.generator;

import com.jiker.keju.domain.Answer;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AnswerGeneratorTest {

    @Test
    public void should_generator_answer() {
        // given
        RandomIntGenerator randomIntGenerator = mock(RandomIntGenerator.class);
        when(randomIntGenerator.nextInt()).thenReturn(1, 2, 3, 4);
        final AnswerGenerator answerGenerator = new AnswerGenerator(randomIntGenerator);

        // when
        Answer answer = answerGenerator.generate();

        // then
        assertThat(answer.getValue()).isEqualTo("1 2 3 4");
    }
}
