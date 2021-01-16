package com.example.rackoribs;

public class Binary {
    private final long id;
    private int numerical;
    private String binary;

    public Binary(long id){
        this.id = id;
    }

    public void setNumerical(int numerical){
        this.numerical = numerical;
    }

    public int getNumerical() { return numerical; }

    public void setBinary(String binary){
        this.binary = binary;
    }

    public String getBinary() { return binary; }

    public long getId() { return id; }
}
