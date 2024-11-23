# Insurance Policy Management System  

## Project Overview  
The **Insurance Policy Management System** is a Java-based console application designed to efficiently manage insurance policies and track sales. This system utilizes **JDBC** for database connectivity and integrates with a **MySQL database** for secure and robust data management. It is a comprehensive solution for administrators to oversee policies and for customers to make purchases conveniently.  

## Features  
### Admin Functionality  
- **Add Policy**: Add new insurance policies with premium and coverage details.  
- **View Policies**: Display a list of all available policies.  
- **Delete Policy**: Remove policies, ensuring no orphan sales records via cascading actions.  
- **View Sales Report**: Generate real-time reports of policy sales.  

### Customer Functionality  
- **View Policies**: Browse all available insurance policies.  
- **Purchase Policy**: Select policies to buy with customer details and record the transaction.  

## Tech Stack  
- **Java**: Core development language.  
- **MySQL**: Database for storing policies and sales data.  
- **JDBC**: For database connectivity and CRUD operations.  
- **File Handling**: For generating sales reports.  

## Database Schema  
### Tables  
1. **Policies**  
   - `id` (INT): Unique identifier for each policy.  
   - `name` (VARCHAR): Name of the policy.  
   - `premium` (DOUBLE): Premium amount.  
   - `coverage` (DOUBLE): Coverage amount.  

2. **Sales**  
   - `id` (AUTO_INCREMENT): Unique identifier for each sale.  
   - `customer_name` (VARCHAR): Name of the customer.  
   - `policy_id` (INT): Foreign key referencing policies.  
   - `amount` (DOUBLE): Purchase amount.  
   - `date` (DATE): Date of purchase.  

### Constraints  
- **Foreign Key**: Policies in the sales table are referenced with `ON DELETE CASCADE` to maintain referential integrity.  

## How to Run  
1. Clone this repository.  
2. Set up the **MySQL database** using the provided schema.  
3. Configure the database connection in the `DatabaseUtil` class with your credentials.  
4. Compile and run the project using any Java IDE or command line.  

## Future Scope  
- Add customer registration and login.  
- Include advanced policy search and filtering.  
- Implement a GUI-based interface for better usability.  

This project highlights proficiency in **Java programming**, **database management**, and **problem-solving skills**, making it a strong addition to your portfolio.
