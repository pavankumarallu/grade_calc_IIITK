package com.android.iiitkalyanigradecalculators.Credit_page_work;

public class CreditDisplayModel {
    private String subject;
    private String lecturer;
    private long credits;

    public CreditDisplayModel() {

    }

    public CreditDisplayModel(String subject, String lecturer, long credits) {
        this.subject = subject;
        this.lecturer = lecturer;
        this.credits = credits;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getLecturer() {
        return lecturer;
    }

    public void setLecturer(String lecturer) {
        this.lecturer = lecturer;
    }

    public long getCredits() {
        return credits;
    }

    public void setCredits(long credits) {
        this.credits = credits;
    }
}
