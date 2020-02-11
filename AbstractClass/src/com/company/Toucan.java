package com.company;

public class Toucan extends Bird
{
    public Toucan(String name)
    {
        super(name);
    }

    @Override
    public void fly()
    {
        System.out.println("Toucan Flying");
    }
}
