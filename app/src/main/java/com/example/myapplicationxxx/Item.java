package com.example.myapplicationxxx;

public class Item {
    public String category;
    public String type;
    public String difficulty;
    public String question;
    public String correct;
    public String[] mal;

    public Item(){

    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getCorrect() {
        return correct;
    }

    public void setCorrect(String correct) {
        this.correct = correct;
    }

    public String[] getMal() {
        return mal;
    }

    public void setMal(String[] mal) {
        this.mal = mal;
    }

    public  Item(String category,
                 String type,
                 String difficulty,
                 String question,
                 String correct,
                 String[] mal){

        this.category = category;
        this.type = type;
        this.difficulty = difficulty;
        this.question = question;
        this.correct = correct;
        this.mal = mal;
    }
}

