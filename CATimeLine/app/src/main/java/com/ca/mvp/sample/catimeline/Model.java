package com.ca.mvp.sample.catimeline;

public class Model {

    String title,description;
    boolean isComplete;

    public Model() {
    }

    public Model(String title, String description, boolean isComplete) {
        this.title = title;
        this.description = description;
        this.isComplete = isComplete;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void setComplete(boolean complete) {
        isComplete = complete;
    }
}
