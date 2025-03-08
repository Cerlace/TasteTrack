DELETE FROM meal
    WHERE true;

ALTER TABLE meal
    AUTO_INCREMENT = 1;

DELETE FROM user_role
    WHERE true;

DELETE FROM user
    WHERE true;

ALTER TABLE user
    AUTO_INCREMENT = 1;

DELETE FROM dish_ingredient
    WHERE true;

ALTER TABLE dish_ingredient
    AUTO_INCREMENT = 1;

DELETE FROM dish
    WHERE true;

ALTER TABLE dish
    AUTO_INCREMENT = 1;

DELETE FROM ingredient
    WHERE true;

ALTER TABLE ingredient
    AUTO_INCREMENT = 1;

INSERT IGNORE INTO ingredient (name, product_type)
VALUES ('Мука', 6),                 -- GRAINS (6)
       ('Сахар', 12),               -- SWEETS (12)
       ('Яйцо', 9),                 -- DAIRY (9)
       ('Молоко', 9),               -- DAIRY (9)
       ('Соль', 0),                 -- OTHER (0)
       ('Перец черный', 10),        -- SPICES (10)
       ('Масло подсолнечное', 11),  -- OILS (11)
       ('Куриная грудка', 1),       -- MEAT (1)
       ('Помидор', 3),              -- VEGETABLES (3)
       ('Огурец', 3),               -- VEGETABLES (3)
       ('Лук репчатый', 3),         -- VEGETABLES (3)
       ('Чеснок', 3),               -- VEGETABLES (3)
       ('Сыр Чеддер', 9),           -- DAIRY (9)
       ('Макароны', 6),             -- GRAINS (6)
       ('Фарш говяжий', 1),         -- MEAT (1)
       ('Томатная паста', 3),       -- VEGETABLES (3)
       ('Петрушка', 3),             -- VEGETABLES (3)
       ('Лимон', 4),                -- FRUITS (4)
       ('Масло оливковое', 11),     -- OILS (11)
       ('Уксус бальзамический', 0), -- OTHER (0)
       ('Лосось', 2),               -- FISH (2)
       ('Шпинат', 3),               -- VEGETABLES (3)
       ('Грецкий орех', 8),         -- NUTS (8)
       ('Мед', 12),                 -- SWEETS (12)
       ('Рис', 6),                  -- GRAINS (6)
       ('Авокадо', 4),              -- FRUITS (4)
       ('Корица', 10),              -- SPICES (10)
       ('Творог', 9),               -- DAIRY (9)
       ('Креветки', 2),             -- FISH (2)
       ('Черника', 5),              -- BERRIES (5)
       ('Гречка', 6),               -- GRAINS (6)
       ('Тыква', 3),                -- VEGETABLES (3)
       ('Овсянка', 6),              -- GRAINS (6)
       ('Миндаль', 8),              -- NUTS (8)
       ('Кешью', 8),                -- NUTS (8)
       ('Батон', 6);                -- GRAINS (6)

INSERT IGNORE INTO dish (name, dish_type, calories, proteins, fats, carbohydrates, recipe)
VALUES ('Классический омлет', 2, 250, 16.5, 18.2, 3.1, '...'),       -- BREAKFAST (2)
       ('Греческий салат', 4, 180, 4.2, 12.5, 9.8, '...'),           -- SALAD (4)
       ('Спагетти', 0, 450, 20.1, 25.7, 35.4, '...'),                -- MAIN (0)
       ('Запеченная курица', 0, 320, 40.3, 15.8, 2.1, '...'),        -- MAIN (0)
       ('Овощной суп', 1, 150, 5.6, 4.3, 20.7, '...'),               -- SOUP (1)
       ('Лосось на гриле', 0, 280, 34.0, 15.0, 2.0, '...'),          -- MAIN (0)
       ('Рис с овощами', 0, 220, 5.5, 3.2, 45.0, '...'),             -- MAIN (0)
       ('Креветки в чесночном соусе', 0, 190, 22.0, 9.5, 4.0, '...'),-- MAIN (0)
       ('Говяжий стейк', 0, 400, 40.0, 25.0, 0.0, '...'),            -- MAIN (0)
       ('Овощное рагу', 0, 180, 6.0, 7.0, 25.0, '...'),              -- MAIN (0)
       ('Гречневая каша', 0, 150, 5.5, 3.0, 27.0, '...'),            -- MAIN (0)
       ('Куриный суп', 1, 170, 12.0, 6.0, 15.0, '...'),              -- SOUP (1)
       ('Тыквенный суп-пюре', 1, 130, 3.0, 7.0, 14.0, '...'),        -- SOUP (1)
       ('Творожная запеканка', 2, 210, 18.0, 8.0, 20.0, '...'),      -- BREAKFAST (2)
       ('Овсяная каша', 2, 150, 5.0, 3.5, 25.0, '...'),              -- BREAKFAST (2)
       ('Салат Цезарь', 4, 320, 15.0, 25.0, 10.0, '...'),            -- SALAD (4)
       ('Салат с авокадо', 4, 250, 6.0, 20.0, 8.0, '...'),           -- SALAD (4)
       ('Ореховый микс', 3, 450, 12.0, 35.0, 20.0, '...'),           -- SNACK (3)
       ('Гренки с чесноком', 3, 280, 5.0, 12.0, 35.0, '...'),        -- SNACK (3)
       ('Фруктовый салат', 5, 120, 1.5, 0.5, 28.0, '...');           -- DESSERT (5)

-- Омлет (id = 1)
INSERT IGNORE INTO dish_ingredient (dish_id, ingredient_id, amount, measure_unit)
VALUES (1, 3, 3, 6),  -- Яйца (PIECE)
       (1, 4, 50, 1), -- Молоко (MILLILITER)
       (1, 5, 3, 0),  -- Соль (GRAM)
       (1, 6, 1, 0);  -- Перец (GRAM)

-- Греческий салат (id = 2)
INSERT IGNORE INTO dish_ingredient (dish_id, ingredient_id, amount, measure_unit)
VALUES (2, 9, 200, 0),  -- Помидоры (GRAM)
       (2, 10, 150, 0), -- Огурцы (GRAM)
       (2, 11, 50, 0),  -- Лук (GRAM)
       (2, 19, 30, 1),  -- Оливковое масло (MILLILITER)
       (2, 5, 5, 0);    -- Соль (GRAM)

-- Спагетти (id = 3)
INSERT IGNORE INTO dish_ingredient (dish_id, ingredient_id, amount, measure_unit)
VALUES (3, 13, 100, 0), -- Сыр (GRAM)
       (3, 14, 250, 0), -- Макароны (GRAM)
       (3, 16, 50, 0),  -- Томатная паста (GRAM)
       (3, 7, 20, 1),   -- Масло (MILLILITER)
       (3, 12, 10, 0);  -- Чеснок (GRAM)

-- Запеченная курица (id = 4)
INSERT IGNORE INTO dish_ingredient (dish_id, ingredient_id, amount, measure_unit)
VALUES (4, 8, 500, 0), -- Курица (GRAM)
       (4, 19, 20, 1), -- Оливковое масло (MILLILITER)
       (4, 12, 10, 0), -- Чеснок (GRAM)
       (4, 6, 2, 0);   -- Перец (GRAM)

-- Овощной суп (id = 5)
INSERT IGNORE INTO dish_ingredient (dish_id, ingredient_id, amount, measure_unit)
VALUES (5, 9, 150, 0),  -- Помидоры (GRAM)
       (5, 10, 100, 0), -- Огурцы (GRAM)
       (5, 11, 70, 0),  -- Лук (GRAM)
       (5, 17, 10, 0),  -- Петрушка (GRAM)
       (5, 5, 7, 0);    -- Соль (GRAM)
-- Лосось на гриле (id = 6)
INSERT IGNORE INTO dish_ingredient (dish_id, ingredient_id, amount, measure_unit)
VALUES (6, 21, 300, 0), -- Лосось (GRAM)
       (6, 19, 20, 1),  -- Оливковое масло (MILLILITER)
       (6, 5, 5, 0);    -- Соль (GRAM)

-- Рис с овощами (id = 7)
INSERT IGNORE INTO dish_ingredient (dish_id, ingredient_id, amount, measure_unit)
VALUES (7, 25, 200, 0), -- Рис (GRAM)
       (7, 9, 150, 0),  -- Помидор (GRAM)
       (7, 10, 100, 0), -- Огурец (GRAM)
       (7, 5, 5, 0);    -- Соль (GRAM)

-- Креветки в чесночном соусе (id = 8)
INSERT IGNORE INTO dish_ingredient (dish_id, ingredient_id, amount, measure_unit)
VALUES (8, 29, 400, 0), -- Креветки (GRAM)
       (8, 12, 15, 0),  -- Чеснок (GRAM)
       (8, 19, 30, 1),  -- Оливковое масло (MILLILITER)
       (8, 6, 2, 0);    -- Перец (GRAM)

-- Говяжий стейк (id = 9)
INSERT IGNORE INTO dish_ingredient (dish_id, ingredient_id, amount, measure_unit)
VALUES (9, 15, 500, 0), -- Говяжий фарш (GRAM)
       (9, 19, 15, 1),  -- Оливковое масло (MILLILITER)
       (9, 12, 10, 0);  -- Чеснок (GRAM)

-- Овощное рагу (id = 10)
INSERT IGNORE INTO dish_ingredient (dish_id, ingredient_id, amount, measure_unit)
VALUES (10, 9, 200, 0),  -- Помидор (GRAM)
       (10, 11, 100, 0), -- Лук (GRAM)
       (10, 10, 150, 0), -- Огурец (GRAM)
       (10, 5, 7, 0);    -- Соль (GRAM)

-- Гречневая каша (id = 11)
INSERT IGNORE INTO dish_ingredient (dish_id, ingredient_id, amount, measure_unit)
VALUES (11, 31, 150, 0), -- Гречка (GRAM)
       (11, 7, 20, 1),   -- Подсолнечное масло (MILLILITER)
       (11, 5, 3, 0);    -- Соль (GRAM)

-- Куриный суп (id = 12)
INSERT IGNORE INTO dish_ingredient (dish_id, ingredient_id, amount, measure_unit)
VALUES (12, 8, 300, 0),  -- Курица (GRAM)
       (12, 14, 100, 0), -- Макароны (GRAM)
       (12, 11, 50, 0),  -- Лук (GRAM)
       (12, 5, 5, 0);    -- Соль (GRAM)

-- Тыквенный суп-пюре (id = 13)
INSERT IGNORE INTO dish_ingredient (dish_id, ingredient_id, amount, measure_unit)
VALUES (13, 32, 500, 0), -- Тыква (GRAM)
       (13, 4, 200, 1),  -- Молоко (MILLILITER)
       (13, 27, 2, 0);   -- Корица (GRAM)

-- Творожная запеканка (id = 14)
INSERT IGNORE INTO dish_ingredient (dish_id, ingredient_id, amount, measure_unit)
VALUES (14, 28, 300, 0), -- Творог (GRAM)
       (14, 3, 3, 6),    -- Яйцо (PIECE)
       (14, 2, 50, 0);   -- Сахар (GRAM)

-- Овсяная каша (id = 15)
INSERT IGNORE INTO dish_ingredient (dish_id, ingredient_id, amount, measure_unit)
VALUES (15, 33, 80, 0), -- Овсянка (GRAM)
       (15, 4, 200, 1), -- Молоко (MILLILITER)
       (15, 24, 20, 0);  -- Мед (GRAM)

-- Салат Цезарь (id = 16)
INSERT IGNORE INTO dish_ingredient (dish_id, ingredient_id, amount, measure_unit)
VALUES (16, 8, 200, 0),  -- Курица (GRAM)
       (16, 36, 100, 0), -- Батон (GRAM)
       (16, 13, 50, 0),  -- Сыр (GRAM)
       (16, 22, 30, 0);  -- Шпинат (GRAM)

-- Салат с авокадо (id = 17)
INSERT IGNORE INTO dish_ingredient (dish_id, ingredient_id, amount, measure_unit)
VALUES (17, 26, 150, 0), -- Авокадо (GRAM)
       (17, 9, 100, 0),  -- Помидор (GRAM)
       (17, 19, 20, 1),  -- Оливковое масло (MILLILITER)
       (17, 5, 3, 0);    -- Соль (GRAM)

-- Ореховый микс (id = 18)
INSERT IGNORE INTO dish_ingredient (dish_id, ingredient_id, amount, measure_unit)
VALUES (18, 23, 100, 0), -- Грецкий орех (GRAM)
       (18, 34, 50, 0),  -- Миндаль (GRAM)
       (18, 35, 50, 0);  -- Кешью (GRAM)

-- Гренки с чесноком (id = 19)
INSERT IGNORE INTO dish_ingredient (dish_id, ingredient_id, amount, measure_unit)
VALUES (19, 36, 200, 0), -- Батон (GRAM)
       (19, 12, 10, 0),  -- Чеснок (GRAM)
       (19, 7, 30, 1);   -- Подсолнечное масло (MILLILITER)

-- Фруктовый салат (id = 20)
INSERT IGNORE INTO dish_ingredient (dish_id, ingredient_id, amount, measure_unit)
VALUES (20, 26, 100, 0), -- Авокадо (GRAM)
       (20, 18, 50, 0),  -- Лимон (GRAM)
       (20, 30, 70, 0),  -- Черника (GRAM)
       (20, 24, 20, 0); -- Мед (GRAM)

INSERT IGNORE INTO `user`
    (
       username,
       encoded_password,
       full_name,
       birth_date,
       gender, height,
       weight, activity,
       goal
    )
VALUES
    (
        'masha',
        '$2a$10$cM8xQCLjohoRFZBnZgTCWez.W51FH/yhEBegBzY6pfbjmbNeRt8HG',
        'Мария',
        '2004-06-22',
        1,
        172,
        51.2,
        0,
        1
    ),
    (
        'user',
        '$2a$10$Kwbf5/IifGrthbNWpEF0k.oUXp40v0qVD0OL92gwNojqQByHwRPNW',
        'Алексей',
        '1992-11-01',
        0,
        176,
        75.1,
        2,
        2
    ),
    (
        'admin',
        '$2a$10$st9Ud2D7w0WLe47I35rpS.ErP9W2WRvySnksL3aY2Lep7rW9lSfS2',
        'Даниил',
        '2000-05-13',
        0,
        179,
        59,
        1,
        1
    );

INSERT INTO user_role
    (user_id, role_id)
VALUES
    (1, 2),
    (2, 2),
    (3, 1);


INSERT IGNORE INTO meal (date, meal_time, user_id, dish_id) VALUES
-- ### День 1: 2025-03-03 ###
-- Пользователь 1 (сумма: 2540)
('2025-03-03', 0, 1, 1),   -- BREAKFAST: Омлет (250)
('2025-03-03', 0, 1, 14),  -- BREAKFAST: Творожная запеканка (210)
('2025-03-03', 1, 1, 3),   -- LUNCH: Спагетти Карбонара (450)
('2025-03-03', 2, 1, 9),   -- DINNER: Говяжий стейк (400)
('2025-03-03', 2, 1, 20),  -- DINNER: Фруктовый салат (120)

-- ### День 2: 2025-03-04 ###
-- Пользователь 1 (сумма: 3110)
('2025-03-04', 0, 1, 15),  -- BREAKFAST: Овсянка (150)
('2025-03-04', 1, 1, 6),   -- LUNCH: Лосось на гриле (280)
('2025-03-04', 1, 1, 16),  -- LUNCH: Салат Цезарь (320)
('2025-03-04', 2, 1, 8),   -- DINNER: Креветки (190)
('2025-03-04', 2, 1, 17),  -- DINNER: Салат с авокадо (250)

-- ### День 3: 2025-03-05 ###
-- Пользователь 1 (сумма: 1980)
('2025-03-05', 0, 1, 14),  -- BREAKFAST: Творожная запеканка (210)
('2025-03-05', 1, 1, 5),   -- LUNCH: Овощной суп (150)
('2025-03-05', 2, 1, 4),   -- DINNER: Курица (320)
('2025-03-05', 2, 1, 10),  -- DINNER: Овощное рагу (180)

-- ### День 4: 2025-03-06 ###
-- Пользователь 1 (сумма: 3650)
('2025-03-06', 0, 1, 18),  -- BREAKFAST: Ореховый микс (450)
('2025-03-06', 1, 1, 3),   -- LUNCH: Спагетти Карбонара (450)
('2025-03-06', 1, 1, 19),  -- LUNCH: Гренки (280)
('2025-03-06', 2, 1, 9),   -- DINNER: Говяжий стейк (400)

-- ### День 5: 2025-03-07 ###
-- Пользователь 1 (сумма: 1220)
('2025-03-07', 0, 1, 1),   -- BREAKFAST: Омлет (250)
('2025-03-07', 1, 1, 2),   -- LUNCH: Греческий салат (180)
('2025-03-07', 2, 1, 5),   -- DINNER: Овощной суп (150)

-- ### День 6: 2025-03-08 ###
-- Пользователь 1 (сумма: 2890)
('2025-03-08', 0, 1, 14),  -- BREAKFAST: Творожная запеканка (210)
('2025-03-08', 0, 1, 15),  -- BREAKFAST: Овсянка (150)
('2025-03-08', 1, 1, 7),   -- LUNCH: Рис с овощами (220)
('2025-03-08', 2, 1, 6),   -- DINNER: Лосось (280)
('2025-03-08', 2, 1, 20),  -- DINNER: Фруктовый салат (120),

-- ### День 7: 2025-03-09 ###
-- Пользователь 1 (сумма: 4030)
('2025-03-09', 0, 1, 18),  -- BREAKFAST: Ореховый микс (450)
('2025-03-09', 0, 1, 1),   -- BREAKFAST: Омлет (250)
('2025-03-09', 0, 1, 20),  -- DINNER: Фруктовый салат (120),
('2025-03-09', 1, 1, 3),   -- LUNCH: Спагетти Карбонара (450)
('2025-03-09', 1, 1, 4),   -- LUNCH: Курица (320)
('2025-03-09', 1, 1, 19),  -- LUNCH: Гренки (280)
('2025-03-09', 2, 1, 8),   -- DINNER: Креветки (190)
('2025-03-09', 2, 1, 9),   -- DINNER: Говяжий стейк (400)
('2025-03-09', 2, 1, 13);  -- DINNER: Тыквенный суп (130);