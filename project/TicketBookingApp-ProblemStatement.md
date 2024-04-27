# Online Ticket Booking System for Tay's Concerts and Shows

## Overview

Tay is a popular music artist who wants to develop an online ticket booking system for her concerts and shows. The system aims to allow users to purchase tickets either as a guest or as a registered Tay Fanclub member. Tay Fanclub members will enjoy a 10% discount on ticket prices.

## Components

### 1. User Authentication and Management

- Guests can purchase tickets without creating an account.
- Tay Fanclub members will have a dedicated database to store their information, including:
    - `memberID` (long)
    - `firstName`
    - `lastName`
    - `password`
    - `phone`
    - `email`
    - `dateRegistered`
    - `bookingHistory`: A list linking to another database table containing the booking details of both guests and Tay Fanclub members.

### 2. Concert and Ticket Management

- A database table will store information about upcoming concerts, including:
    - `showID`
    - `date`
    - `seatAvailable` (initially set to a fixed number, e.g., 5).
- When a user books a ticket, the `seatAvailable` count will be decremented accordingly.
- The `bookingHistory` database table will store:
    - `historyID`
    - `dateShow`
    - `firstName`
    - `lastName`
    - `role` (Tay Fanclub member or guest) for each booking.

## Ticket Booking Process

1. Users can log in as a guest or a Tay Fanclub member.
2. Users can browse available shows and select the desired date(s).
3. For each selected show, users will provide their:
    - `firstName`
    - `lastName`
    - Credit card information (`number`, `CVV`).
4. The system will calculate the total cost based on the number of tickets booked and apply a 10% discount for Tay Fanclub members.
5. Upon successful payment, the booking details will be recorded in the `bookingHistory` database table.
    - For guests, only the `firstName`, `lastName`, `dateShow`, and `role` will be recorded.
    - For Tay Fanclub members, the `memberID` will also be recorded along with the other details.
