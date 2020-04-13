package com.jiker.keju.domain;

public class GuessResult {
    private String result;
    private String inputAnswer;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getInputAnswer() {
        return inputAnswer;
    }

    public void setInputAnswer(String inputAnswer) {
        this.inputAnswer = inputAnswer;
    }

    public Boolean correct() {
        return result.equals(AnswerConstant.CORRECT_ANSWER);
    }
}
