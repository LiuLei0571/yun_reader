package com.yun.reader.product.book.manager;

public class ChapterResponse {
    private String chapterId;
    private String duration;
    private String fileSize;
    private String hasBought;
    private int index;
    private String md5;
    private String price;
    private String thirdBookId;
    private String thirdChapterId;
    private String title;
    private String updateTime;
    private int words;

    public String getMd5() {
        return this.md5;
    }

    public void setMd5(String str) {
        this.md5 = str;
    }

    public String getDuration() {
        return this.duration;
    }

    public void setDuration(String str) {
        this.duration = str;
    }

    public String getFileSize() {
        return this.fileSize;
    }

    public void setFileSize(String str) {
        this.fileSize = str;
    }

    public int getIndex() {
        return this.index;
    }

    public void setIndex(int i) {
        this.index = i;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getPrice() {
        return this.price;
    }

    public void setPrice(String str) {
        this.price = str;
    }

    public int getWords() {
        return this.words;
    }

    public void setWords(int i) {
        this.words = i;
    }

    public String getThirdBookId() {
        return this.thirdBookId;
    }

    public void setThirdBookId(String str) {
        this.thirdBookId = str;
    }

    public String getThirdChapterId() {
        return this.thirdChapterId;
    }

    public void setThirdChapterId(String str) {
        this.thirdChapterId = str;
    }

    public String getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(String str) {
        this.updateTime = str;
    }

    public String getChapterId() {
        return this.chapterId;
    }

    public void setChapterId(String str) {
        this.chapterId = str;
    }

    public String getHasBought() {
        return this.hasBought;
    }

    public void setHasBought(String str) {
        this.hasBought = str;
    }
}
