package com.company;

public abstract class Bird extends Animal
{
    public Bird(String name)
    {
        super(name);
    }

    @Override
    public void eat()
    {
        System.out.println("Bird eating");
    }

    @Override
    public void breathe()
    {
        System.out.println("Bird breathing");
    }

    public abstract void fly();
}
