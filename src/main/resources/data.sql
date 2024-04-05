-- added categoies --
INSERT INTO categories (id, title, created_at, updated_at) VALUES (1, 'Electronics', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO categories (id, title, created_at, updated_at) VALUES (2, 'Books', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO categories (id, title, created_at, updated_at) VALUES (3, 'Clothing', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO categories (id, title, created_at, updated_at) VALUES (4, 'Furniture', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO categories (id, title, created_at, updated_at) VALUES (5, 'Groceries', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO categories (id, title, created_at, updated_at) VALUES (6, 'Toys', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO categories (id, title, created_at, updated_at) VALUES (7, 'Automotive', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO categories (id, title, created_at, updated_at) VALUES (8, 'Sports', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO categories (id, title, created_at, updated_at) VALUES (9, 'Home Decor', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO categories (id, title, created_at, updated_at) VALUES (10, 'Health & Beauty', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- added products --
INSERT INTO products (id, title, created_at, updated_at, price, category_id, description, image) VALUES (1, 'Laptop', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 1200.00, 1, 'High-performance laptop', 'laptop.jpg');
INSERT INTO products (id, title, created_at, updated_at, price, category_id, description, image) VALUES (2, 'Smartphone', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 800.00, 1, 'Latest smartphone model', 'smartphone.jpg');
INSERT INTO products (id, title, created_at, updated_at, price, category_id, description, image) VALUES (3, 'Headphones', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 150.00, 1, 'High-quality headphones', 'headphones.jpg');
INSERT INTO products (id, title, created_at, updated_at, price, category_id, description, image) VALUES (4, 'Camera', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 500.00, 1, 'Advanced digital camera', 'camera.jpg');
INSERT INTO products (id, title, created_at, updated_at, price, category_id, description, image) VALUES (5, 'Book - Java Programming', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 25.00, 2, 'Comprehensive guide to Java programming', 'java_book.jpg');
INSERT INTO products (id, title, created_at, updated_at, price, category_id, description, image) VALUES (6, 'Book - Python for Beginners', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 20.00, 2, 'Introductory guide to Python', 'python_book.jpg');
INSERT INTO products (id, title, created_at, updated_at, price, category_id, description, image) VALUES (7, 'T-Shirt - Spring Boot', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 15.00, 3, 'Spring Boot themed t-shirt', 'tshirt_springboot.jpg');
INSERT INTO products (id, title, created_at, updated_at, price, category_id, description, image) VALUES (8, 'Jeans - Denim', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 30.00, 3, 'Classic denim jeans', 'jeans_denim.jpg');
INSERT INTO products (id, title, created_at, updated_at, price, category_id, description, image) VALUES (9, 'Sofa - Leather', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 200.00, 4, 'Luxurious leather sofa', 'sofa_leather.jpg');
INSERT INTO products (id, title, created_at, updated_at, price, category_id, description, image) VALUES (10, 'Table - Wooden', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 100.00, 4, 'Sturdy wooden table', 'table_wooden.jpg');
INSERT INTO products (id, title, created_at, updated_at, price, category_id, description, image) VALUES (11, 'Bread - Whole Wheat', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 2.00, 5, 'Nutritious whole wheat bread', 'bread_wholewheat.jpg');
INSERT INTO products (id, title, created_at, updated_at, price, category_id, description, image) VALUES (12, 'Milk - Organic', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 3.00, 5, 'Pure organic milk', 'milk_organic.jpg');
INSERT INTO products (id, title, created_at, updated_at, price, category_id, description, image) VALUES (13, 'Toy Car - Red', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 10.00, 6, 'Fun toy car', 'toy_car_red.jpg');
INSERT INTO products (id, title, created_at, updated_at, price, category_id, description, image) VALUES (14, 'Toy Robot - Blue', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 15.00, 6, 'Interactive toy robot', 'toy_robot_blue.jpg');
INSERT INTO products (id, title, created_at, updated_at, price, category_id, description, image) VALUES (15, 'Car - Compact', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 25000.00, 7, 'Efficient compact car', 'car_compact.jpg');
INSERT INTO products (id, title, created_at, updated_at, price, category_id, description, image) VALUES (16, 'Bike - Mountain', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 1500.00, 7, 'Sturdy mountain bike', 'bike_mountain.jpg');
INSERT INTO products (id, title, created_at, updated_at, price, category_id, description, image) VALUES (17, 'Sports Equipment - Basketball', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 100.00, 8, 'High-quality basketball', 'sports_equipment_basketball.jpg');
INSERT INTO products (id, title, created_at, updated_at, price, category_id, description, image) VALUES (18, 'Sports Equipment - Tennis Racket', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 50.00, 8, 'Professional tennis racket', 'sports_equipment_tennis_racket.jpg');
INSERT INTO products (id, title, created_at, updated_at, price, category_id, description, image) VALUES (19, 'Home Decor - Painting', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 20.00, 9, 'Beautiful painting', 'home_decor_painting.jpg');
INSERT INTO products (id, title, created_at, updated_at, price, category_id, description, image) VALUES (20, 'Health & Beauty - Face Mask', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 5.00, 10, 'Comfortable face mask', 'health_beauty_face_mask.jpg');
