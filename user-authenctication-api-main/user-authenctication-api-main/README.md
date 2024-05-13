User Authentication and Management API
This project is a RESTful API for user authentication and management, developed using Spring Boot and MongoDB. It provides endpoints for user registration, login,
logout, and retrieving user profiles. JWT (JSON Web Tokens) are used for authentication, and user data is securely stored in a Mysql database.

Functionalities

1) User Registration
Endpoint: POST /api/users/register
Allows users to sign up by providing username, email, and password.
Validates input data and stores user details securely in the database.

2) User Login
Endpoint: POST /api/users/login
Allows registered users to log in using their credentials (username/email and password).
Validates user credentials and issues a JWT token upon successful login.

3) User Logout
Endpoint: POST /api/users/logout
Logs out the authenticated user by invalidating the JWT token.

4) Get User Profile
Endpoint: GET /api/users/profile
Retrieves the profile information of the authenticated user.
Requires authentication via JWT token.

Technologies Used
Java
Spring Boot
Mysql
JWT (JSON Web Tokens)
OpenAPI Specification (OAS) version 3.0 for API documentation
