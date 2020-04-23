package com.davidlapadula;

import com.davidlapadula.model.*;

public class Music {

    public static void main(String[] args) {
        DataSource dataSource = new DataSource();

        if (!dataSource.open()) {
            System.out.println("Cant open");
            return;
        }



        dataSource.close();
    }
}
