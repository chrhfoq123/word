package org.techtown.word;

public class Word {
    private String category, comment, content;

    public void setContent(String content) {
        this.content = content;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getContent() {
        return content;
    }

    public String getComment() {
        return comment;
    }

    public String getCategory() {
        return category;
    }
}
