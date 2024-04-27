# Food Ordering System

## Problem Statement

The Food Ordering System is a web application that allows users to browse and order food items online. The system provides functionality for both regular users and administrators.

## User Stories

1. **User Authentication**:
    - Users can register for a new account or log in with their existing credentials.
    - Administrators can log in with special admin credentials to access additional features.

2. **Ordering Process**:
    - After logging in, users are directed to a design page where they can select food items from various categories.
    - The total price of the selected items is dynamically updated as users make their selections.
    - Once users have finished selecting items, they can confirm their order.
    - After confirming the order, users are redirected to an order form page where they can provide additional details such as delivery address and payment information.
    - Upon submission of the order form, the order is completed, and a confirmation page is displayed.

## Tech Stack

- **Backend**:
    - Java Spring Boot framework for building RESTful APIs.
    - Spring Security for user authentication and authorization.
    - Spring Data JPA for interacting with the database.
    - MySQL database for storing user data, order history, and menu items.

- **Frontend**:
    - Thymeleaf templating engine for server-side HTML rendering.
    - HTML, CSS, and JavaScript for frontend development.

- **Database**:
    - MySQL relational database for storing user data and order history.

## Process Flow

1. **User Authentication**:
    - Users can register for a new account by providing their details (username, password, etc.).
    - Existing users can log in with their credentials to access the ordering system.
    - Administrators can log in with special admin credentials to access admin features.

2. **Ordering Process**:
    - After logging in, users are redirected to the design page where they can select food items from various categories (Asian cuisine, fast foods, etc.).
    - As users make their selections, the total price is dynamically updated on the page.
    - Once users have finished selecting items, they can confirm their order.
    - After confirming the order, users are redirected to an order form page where they can provide additional details such as delivery address and payment information.
    - Upon submission of the order form, the order is completed, and a confirmation page is displayed, confirming the successful placement of the order.

## Conclusion

The Food Ordering System provides a seamless experience for users to browse, select, and order food items online. With its user-friendly interface and efficient backend processing, users can easily navigate through the ordering process and enjoy their favorite meals hassle-free.
