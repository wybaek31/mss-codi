INSERT INTO MSS_CATEGORY (CATEGORY_TYPE, CATEGORY_NAME, REG_USER, UPD_USER, REG_DATE, UPD_DATE)
VALUES ('TOP', '상의', 'admin', 'admin', NOW(), NOW()),
       ('OUTER', '아우터', 'admin', 'admin', NOW(), NOW()),
       ('BOTTOM', '하의', 'admin', 'admin', NOW(), NOW()),
       ('SNEAKERS', '스니커즈', 'admin', 'admin', NOW(), NOW()),
       ('BAG', '가방', 'admin', 'admin', NOW(), NOW()),
       ('HAT', '모자', 'admin', 'admin', NOW(), NOW()),
       ('SOCKS', '양말', 'admin', 'admin', NOW(), NOW()),
       ('ACCESSORY', '악세러리', 'admin', 'admin', NOW(), NOW());


INSERT INTO MSS_BRAND (BRAND_NAME, REG_USER, UPD_USER, REG_DATE, UPD_DATE)
VALUES
    ('A', 'admin', 'admin', NOW(), NOW()),
    ('B', 'admin', 'admin', NOW(), NOW()),
    ('C', 'admin', 'admin', NOW(), NOW()),
    ('D', 'admin', 'admin', NOW(), NOW()),
    ('E', 'admin', 'admin', NOW(), NOW()),
    ('F', 'admin', 'admin', NOW(), NOW()),
    ('G', 'admin', 'admin', NOW(), NOW()),
    ('H', 'admin', 'admin', NOW(), NOW()),
    ('I', 'admin', 'admin', NOW(), NOW());


INSERT INTO MSS_PRODUCT (STATUS_TYPE, PRODUCT_NAME, BRAND_ID, CATEGORY_TYPE, PRICE, REG_USER, UPD_USER, REG_DATE, UPD_DATE)
VALUES ('USE', 'A Brand Top', 1, 'TOP', 11200, 'admin', 'admin', NOW(), NOW()),
       ('USE', 'A Brand Outer', 1, 'OUTER', 5500, 'admin', 'admin', NOW(), NOW()),
       ('USE', 'A Brand Bottom', 1, 'BOTTOM', 4200, 'admin', 'admin', NOW(), NOW()),
       ('USE', 'A Brand Sneakers', 1, 'SNEAKERS', 9000, 'admin', 'admin', NOW(), NOW()),
       ('USE', 'A Brand Bag', 1, 'BAG', 2000, 'admin', 'admin', NOW(), NOW()),
       ('USE', 'A Brand Hat', 1, 'HAT', 1700, 'admin', 'admin', NOW(), NOW()),
       ('USE', 'A Brand Socks', 1, 'SOCKS', 1800, 'admin', 'admin', NOW(), NOW()),
       ('USE', 'A Brand Accessory', 1, 'ACCESSORY', 2300, 'admin', 'admin', NOW(), NOW()),

       ('USE', 'B Brand Top', 2, 'TOP', 10500, 'admin', 'admin', NOW(), NOW()),
       ('USE', 'B Brand Outer', 2, 'OUTER', 5900, 'admin', 'admin', NOW(), NOW()),
       ('USE', 'B Brand Bottom', 2, 'BOTTOM', 3800, 'admin', 'admin', NOW(), NOW()),
       ('USE', 'B Brand Sneakers', 2, 'SNEAKERS', 9100, 'admin', 'admin', NOW(), NOW()),
       ('USE', 'B Brand Bag', 2, 'BAG', 2100, 'admin', 'admin', NOW(), NOW()),
       ('USE', 'B Brand Hat', 2, 'HAT', 2000, 'admin', 'admin', NOW(), NOW()),
       ('USE', 'B Brand Socks', 2, 'SOCKS', 2000, 'admin', 'admin', NOW(), NOW()),
       ('USE', 'B Brand Accessory', 2, 'ACCESSORY', 2200, 'admin', 'admin', NOW(), NOW()),

       ('USE', 'C Brand Top', 3, 'TOP', 10000, 'admin', 'admin', NOW(), NOW()),
       ('USE', 'C Brand Outer', 3, 'OUTER', 6200, 'admin', 'admin', NOW(), NOW()),
       ('USE', 'C Brand Bottom', 3, 'BOTTOM', 3300, 'admin', 'admin', NOW(), NOW()),
       ('USE', 'C Brand Sneakers', 3, 'SNEAKERS', 9200, 'admin', 'admin', NOW(), NOW()),
       ('USE', 'C Brand Bag', 3, 'BAG', 2200, 'admin', 'admin', NOW(), NOW()),
       ('USE', 'C Brand Hat', 3, 'HAT', 1900, 'admin', 'admin', NOW(), NOW()),
       ('USE', 'C Brand Socks', 3, 'SOCKS', 2200, 'admin', 'admin', NOW(), NOW()),
       ('USE', 'C Brand Accessory', 3, 'ACCESSORY', 2100, 'admin', 'admin', NOW(), NOW()),

       ('USE', 'D Brand Top', 4, 'TOP', 10100, 'admin', 'admin', NOW(), NOW()),
       ('USE', 'D Brand Outer', 4, 'OUTER', 5100, 'admin', 'admin', NOW(), NOW()),
       ('USE', 'D Brand Bottom', 4, 'BOTTOM', 3000, 'admin', 'admin', NOW(), NOW()),
       ('USE', 'D Brand Sneakers', 4, 'SNEAKERS', 9500, 'admin', 'admin', NOW(), NOW()),
       ('USE', 'D Brand Bag', 4, 'BAG', 2500, 'admin', 'admin', NOW(), NOW()),
       ('USE', 'D Brand Hat', 4, 'HAT', 1500, 'admin', 'admin', NOW(), NOW()),
       ('USE', 'D Brand Socks', 4, 'SOCKS', 2400, 'admin', 'admin', NOW(), NOW()),
       ('USE', 'D Brand Accessory', 4, 'ACCESSORY', 2000, 'admin', 'admin', NOW(), NOW()),

       ('USE', 'E Brand Top', 5, 'TOP', 10700, 'admin', 'admin', NOW(), NOW()),
       ('USE', 'E Brand Outer', 5, 'OUTER', 5000, 'admin', 'admin', NOW(), NOW()),
       ('USE', 'E Brand Bottom', 5, 'BOTTOM', 3800, 'admin', 'admin', NOW(), NOW()),
       ('USE', 'E Brand Sneakers', 5, 'SNEAKERS', 9900, 'admin', 'admin', NOW(), NOW()),
       ('USE', 'E Brand Bag', 5, 'BAG', 2300, 'admin', 'admin', NOW(), NOW()),
       ('USE', 'E Brand Hat', 5, 'HAT', 1800, 'admin', 'admin', NOW(), NOW()),
       ('USE', 'E Brand Socks', 5, 'SOCKS', 2100, 'admin', 'admin', NOW(), NOW()),
       ('USE', 'E Brand Accessory', 5, 'ACCESSORY', 2100, 'admin', 'admin', NOW(), NOW()),

       ('USE', 'F Brand Top', 6, 'TOP', 11200, 'admin', 'admin', NOW(), NOW()),
       ('USE', 'F Brand Outer', 6, 'OUTER', 7200, 'admin', 'admin', NOW(), NOW()),
       ('USE', 'F Brand Bottom', 6, 'BOTTOM', 4000, 'admin', 'admin', NOW(), NOW()),
       ('USE', 'F Brand Sneakers', 6, 'SNEAKERS', 9300, 'admin', 'admin', NOW(), NOW()),
       ('USE', 'F Brand Bag', 6, 'BAG', 2100, 'admin', 'admin', NOW(), NOW()),
       ('USE', 'F Brand Hat', 6, 'HAT', 1600, 'admin', 'admin', NOW(), NOW()),
       ('USE', 'F Brand Socks', 6, 'SOCKS', 2300, 'admin', 'admin', NOW(), NOW()),
       ('USE', 'F Brand Accessory', 6, 'ACCESSORY', 1900, 'admin', 'admin', NOW(), NOW()),

       ('USE', 'G Brand Top', 7, 'TOP', 10500, 'admin', 'admin', NOW(), NOW()),
       ('USE', 'G Brand Outer', 7, 'OUTER', 5800, 'admin', 'admin', NOW(), NOW()),
       ('USE', 'G Brand Bottom', 7, 'BOTTOM', 3900, 'admin', 'admin', NOW(), NOW()),
       ('USE', 'G Brand Sneakers', 7, 'SNEAKERS', 9000, 'admin', 'admin', NOW(), NOW()),
       ('USE', 'G Brand Bag', 7, 'BAG', 2200, 'admin', 'admin', NOW(), NOW()),
       ('USE', 'G Brand Hat', 7, 'HAT', 1700, 'admin', 'admin', NOW(), NOW()),
       ('USE', 'G Brand Socks', 7, 'SOCKS', 2100, 'admin', 'admin', NOW(), NOW()),
       ('USE', 'G Brand Accessory', 7, 'ACCESSORY', 2000, 'admin', 'admin', NOW(), NOW()),

       ('USE', 'H Brand Top', 8, 'TOP', 10800, 'admin', 'admin', NOW(), NOW()),
       ('USE', 'H Brand Outer', 8, 'OUTER', 6300, 'admin', 'admin', NOW(), NOW()),
       ('USE', 'H Brand Bottom', 8, 'BOTTOM', 3100, 'admin', 'admin', NOW(), NOW()),
       ('USE', 'H Brand Sneakers', 8, 'SNEAKERS', 9700, 'admin', 'admin', NOW(), NOW()),
       ('USE', 'H Brand Bag', 8, 'BAG', 2100, 'admin', 'admin', NOW(), NOW()),
       ('USE', 'H Brand Hat', 8, 'HAT', 1600, 'admin', 'admin', NOW(), NOW()),
       ('USE', 'H Brand Socks', 8, 'SOCKS', 2000, 'admin', 'admin', NOW(), NOW()),
       ('USE', 'H Brand Accessory', 8, 'ACCESSORY', 2000, 'admin', 'admin', NOW(), NOW()),

       ('USE', 'I Brand Top', 9, 'TOP', 11400, 'admin', 'admin', NOW(), NOW()),
       ('USE', 'I Brand Outer', 9, 'OUTER', 6700, 'admin', 'admin', NOW(), NOW()),
       ('USE', 'I Brand Bottom', 9, 'BOTTOM', 3200, 'admin', 'admin', NOW(), NOW()),
       ('USE', 'I Brand Sneakers', 9, 'SNEAKERS', 9700, 'admin', 'admin', NOW(), NOW()),
       ('USE', 'I Brand Bag', 9, 'BAG', 2400, 'admin', 'admin', NOW(), NOW()),
       ('USE', 'I Brand Hat', 9, 'HAT', 1700, 'admin', 'admin', NOW(), NOW()),
       ('USE', 'I Brand Socks', 9, 'SOCKS', 1700, 'admin', 'admin', NOW(), NOW()),
       ('USE', 'I Brand Accessory', 9, 'ACCESSORY', 2400, 'admin', 'admin', NOW(), NOW());


