package com.android.iiitkalyanigradecalculators;

public class CreditDisplayModel {
    private String subject;
    private String lecturer;
    private String credits;

    public CreditDisplayModel() {

    }

    public CreditDisplayModel(String subject, String lecturer, String credits) {
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

    public String getCredits() {
        return credits;
    }

    public void setCredits(String credits) {
        this.credits = credits;
    }
}
