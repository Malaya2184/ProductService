-- added categories --
INSERT INTO categories (title, created_at, updated_at) VALUES ('Electronics', NOW(), NOW());
INSERT INTO categories (title, created_at, updated_at) VALUES ('Books', NOW(), NOW());
INSERT INTO categories (title, created_at, updated_at) VALUES ('Clothing', NOW(), NOW());
INSERT INTO categories (title, created_at, updated_at) VALUES ('Furniture', NOW(), NOW());
INSERT INTO categories (title, created_at, updated_at) VALUES ('Groceries', NOW(), NOW());
INSERT INTO categories (title, created_at, updated_at) VALUES ('Toys', NOW(), NOW());
INSERT INTO categories (title, created_at, updated_at) VALUES ('Automotive', NOW(), NOW());
INSERT INTO categories (title, created_at, updated_at) VALUES ('Sports', NOW(), NOW());
INSERT INTO categories (title, created_at, updated_at) VALUES ('Home Decor', NOW(), NOW());
INSERT INTO categories (title, created_at, updated_at) VALUES ('Health & Beauty', NOW(), NOW());

-- added products --
INSERT INTO products (title, price, category_id, description, image, created_at, updated_at) VALUES ('Laptop', 1200.00, 1, 'High-performance laptop', 'https://example.com/laptop.jpg', NOW(), NOW());
INSERT INTO products (title, price, category_id, description, image, created_at, updated_at) VALUES ('Smartphone', 800.00, 1, 'Latest smartphone model', 'https://example.com/smartphone.jpg', NOW(), NOW());
INSERT INTO products (title, price, category_id, description, image, created_at, updated_at) VALUES ('Headphones', 150.00, 1, 'High-quality headphones', 'https://example.com/headphones.jpg', NOW(), NOW());
INSERT INTO products (title, price, category_id, description, image, created_at, updated_at) VALUES ('Camera', 500.00, 1, 'Advanced digital camera', 'https://example.com/camera.jpg', NOW(), NOW());
INSERT INTO products (title, price, category_id, description, image, created_at, updated_at) VALUES ('Book - Java Programming', 25.00, 2, 'Comprehensive guide to Java programming', 'https://example.com/java_book.jpg', NOW(), NOW());
INSERT INTO products (title, price, category_id, description, image, created_at, updated_at) VALUES ('Book - Python for Beginners', 20.00, 2, 'Introductory guide to Python', 'https://example.com/python_book.jpg', NOW(), NOW());
INSERT INTO products (title, price, category_id, description, image, created_at, updated_at) VALUES ('T-Shirt - Spring Boot', 15.00, 3, 'Spring Boot themed t-shirt', 'https://example.com/tshirt_springboot.jpg', NOW(), NOW());
INSERT INTO products (title, price, category_id, description, image, created_at, updated_at) VALUES ('Jeans - Denim', 30.00, 3, 'Classic denim jeans', 'https://example.com/jeans_denim.jpg', NOW(), NOW());
INSERT INTO products (title, price, category_id, description, image, created_at, updated_at) VALUES ('Sofa - Leather', 200.00, 4, 'Luxurious leather sofa', 'https://example.com/sofa_leather.jpg', NOW(), NOW());
INSERT INTO products (title, price, category_id, description, image, created_at, updated_at) VALUES ('Table - Wooden', 100.00, 4, 'Sturdy wooden table', 'https://example.com/table_wooden.jpg', NOW(), NOW());
INSERT INTO products (title, price, category_id, description, image, created_at, updated_at) VALUES ('Bread - Whole Wheat', 2.00, 5, 'Nutritious whole wheat bread', 'https://example.com/bread_wholewheat.jpg', NOW(), NOW());
INSERT INTO products (title, price, category_id, description, image, created_at, updated_at) VALUES ('Milk - Organic', 3.00, 5, 'Pure organic milk', 'https://example.com/milk_organic.jpg', NOW(), NOW());
INSERT INTO products (title, price, category_id, description, image, created_at, updated_at) VALUES ('Toy Car - Red', 10.00, 6, 'Fun toy car', 'https://example.com/toy_car_red.jpg', NOW(), NOW());
INSERT INTO products (title, price, category_id, description, image, created_at, updated_at) VALUES ('Toy Robot - Blue', 15.00, 6, 'Interactive toy robot', 'https://example.com/toy_robot_blue.jpg', NOW(), NOW());
INSERT INTO products (title, price, category_id, description, image, created_at, updated_at) VALUES ('Car - Compact', 25000.00, 7, 'Efficient compact car', 'https://example.com/car_compact.jpg', NOW(), NOW());
INSERT INTO products (title, price, category_id, description, image, created_at, updated_at) VALUES ('Bike - Mountain', 1500.00, 7, 'Sturdy mountain bike', 'https://example.com/bike_mountain.jpg', NOW(), NOW());
INSERT INTO products (title, price, category_id, description, image, created_at, updated_at) VALUES ('Sports Equipment - Basketball', 100.00, 8, 'High-quality basketball', 'https://example.com/sports_equipment_basketball.jpg', NOW(), NOW());
INSERT INTO products (title, price, category_id, description, image, created_at, updated_at) VALUES ('Sports Equipment - Tennis Racket', 50.00, 8, 'Professional tennis racket', 'https://example.com/sports_equipment_tennis_racket.jpg', NOW(), NOW());
INSERT INTO products (title, price, category_id, description, image, created_at, updated_at) VALUES ('Home Decor - Painting', 20.00, 9, 'Beautiful painting', 'https://example.com/home_decor_painting.jpg', NOW(), NOW());
INSERT INTO products (title, price, category_id, description, image, created_at, updated_at) VALUES ('Health & Beauty - Face Mask', 5.00, 10, 'Comfortable face mask', 'https://example.com/health_beauty_face_mask.jpg', NOW(), NOW());
