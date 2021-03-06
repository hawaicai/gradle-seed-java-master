package com.jiker.keju.generator;

import com.jiker.keju.domain.Answer;
import static com.jiker.keju.domain.AnswerConstant.ANSWER_SIZE;
import com.google.common.collect.Sets;

import java.util.Set;
import java.util.stream.Collectors;

public class AnswerGenerator {
    private final RandomIntGenerator randomIntGenerator;

    public AnswerGenerator(RandomIntGenerator randomIntGenerator) {
        this.randomIntGenerator = randomIntGenerator;
    }

    public Answer generate() {
        Set<String> numbers = Sets.newHashSet();
        while (numbers.size() < ANSWER_SIZE) {
            numbers.add(randomIntGenerator.nextInt() + "");
        }
        String answerString = numbers.stream().collect(Collectors.joining(" "));
        return new Answer(answerString);
    }

}
