### FoodDeliveryProject

## Frameworks and Language Used
    1. Framework: Spring Boot
    2. Language: Java
    3. Database: MySql
    
## Data flow

  # Controller
      1. AdminController: Handles admin operations (CRUD on food items, view order details).
          - Sign Up Admin
          - Sign In Admin
          - Sign Out Admin
          - Add Food Items
          - Update Food Items
          - Delete Fodd Items
          - View Food Items
          - View All Orders and Which order belongs to which food Item
          
      2. UserController: Manages user-related operations (Sorder food, view order history).
          - Sign Up User
          - Sign In User
          - Sign Out User
          - Order Food Items
          - View all Orders belogns to user's itself
          - View Food Items

      3. Services
          - UserService: Provides services related to user actions (order food, view order history).
          - AdminService: Manages services for admin actions (CRUD on food items, view order details).
          - Admin Authentication Services
          - User Authentication Services
          - Orders Services

      4. Repository
          - Admin Repository: Interacts with the database for admin-related data.
          - UserRepository: Interacts with the database for user-related data.
          - FoodItemRepository: Deals with database operations for food items.
      
  # Database Design
          - User Table: 
                UserID
                Username
                Password
                ... (other user details)

          - FoodItem Table:
                FoodItemID
                Name
                Description
                Price
                ... (other food item details)
          
           - Order Table:
                OrderID
                UserID (foreign key)
                FoodItemID (foreign key)
                OrderDate
                ... (other order details)


## Data Structure used in your project
    In this project List, Object Oriented datastruct has been used and Mysql database used for the permenant storage of data.

## Project Summary 
    This project creates on food devlivery API. In this there is Admin and User are the major roleplayer. Admin can Sing up and sign in and able to add, update, delete and view food items.
    The best part is only authorized admin can add, update, delete and view food items into restaurant menu list.
    And another one is User where user has permission to sign up and sign in and only signed in user can view and order food items.
    Also signed in user can see his/her ordered list and best part is user can only see his/her orders not other's.
    This MCT project tought me a lot things which can helped me for developing futher meaning for and very good level's projects which will have security and authentication for valid users.



















    


