package com.davidlapadula;

import java.util.*;

public class Theatre {
    private final String theatreName;
    private List<Seat> seats = new ArrayList<>();

    /*
        - Anonymous inner class implementing comparator. Inner class without name for which SINGLE OBJECT created
        - Make instance of object and overload methods without having to subclass a class
     */
    static final Comparator<Seat> PRICE_ORDER = new Comparator<Seat>() {
        @Override
        public int compare(Seat s1, Seat s2) {
            if (s1.getPrice() < s2.getPrice()) {
                return -1;
            } else if(s1.getPrice() > s2.getPrice()) {
                return 1;
            } else {
                return 0;
            }
        }
    };

    public Theatre(String theatreName, int numRows, int seatsPerRow) {
        this.theatreName = theatreName;

        int lastRow = 'A' + (numRows - 1);
        for (char row = 'A'; row <= lastRow; row++) {
            for (int seatNum = 1; seatNum <= seatsPerRow; seatNum++){
                double price = 12;
                if (row < 'D' && seatNum >= 4 && seatNum <=9) {
                    price = 14;
                } else if ((row > 'F') || (seatNum < 4 || seatNum > 9)) {
                    price = 7;
                }
                // Allow for formatting with a leading zero in front of string
                Seat seat = new Seat(row + String.format("%02d", seatNum), price);
                seats.add(seat);
            }
        }
    }

    public String getTheatreName() {
        return theatreName;
    }

    public boolean reserveSeat(String seatNumber) {
        Seat  requestedSeat = new Seat(seatNumber, 6);
        // Because pass in a seat, which implements Comparable and overrides compareTo, it will use this in its binary search
        int foundSeat = Collections.binarySearch(seats, requestedSeat, null);

        if (foundSeat >= 0) {
            return seats.get(foundSeat).reserve();
        } else {
            System.out.println("No seat number");
            return false;
        }
    }

    public Collection<Seat> getSeats() {
        return seats;
    }

    public class Seat implements Comparable<Seat> {
        private final String seatNumber;
        private boolean reserved = false;
        private double price;

        public Seat(String seatNumber,  double price) {
            this.seatNumber = seatNumber;
            this.price = price;
        }

        @Override
        public int compareTo(Seat seat) {
            // Compare to will return either -1, 0, 1 which is required by overriden method
            return this.seatNumber.compareToIgnoreCase(seat.getSeatNumber());
        }

        public boolean reserve() {
            if(!this.reserved) {
                this.reserved = true;
                System.out.println("Seat reserved");
                return true;
            } else {
                return false;
            }
        }

        public boolean cancel() {
            if (this.reserved) {
                this.reserved = false;
                System.out.println("Seat is free");
                return true;
            } else {
                return false;
            }
        }

        public String getSeatNumber() {
            return seatNumber;
        }

        public double getPrice() {
            return price;
        }
    }
}
