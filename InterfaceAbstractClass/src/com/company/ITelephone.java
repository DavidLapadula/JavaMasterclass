package com.company;

public interface ITelephone {
    /*
        Define signatures that define interface
     */
     void powerOn();
     void dial(int phoneNumber);
     void answer();
     boolean callPhone(int phoneNumber);
     boolean isRinging();
}
