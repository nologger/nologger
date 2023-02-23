INSERT INTO CATEGORY
VALUES(
    NEXT VALUE FOR CATEGORY_SEQUENCE,
    NULL,
    0,
    TRUE,
    '/',
    'Home',
    NOW(),
    NOW()
);

INSERT INTO CATEGORY
VALUES(
    NEXT VALUE FOR CATEGORY_SEQUENCE,
    NULL,
    1,
    TRUE,
    '/about',
    'About',
    NOW(),
    NOW()
);

INSERT INTO CATEGORY
VALUES(
    NEXT VALUE FOR CATEGORY_SEQUENCE,
    NULL,
    2,
    TRUE,
    NULL,
    'Category',
    NOW(),
    NOW()
);

INSERT INTO CATEGORY
VALUES(
    NEXT VALUE FOR CATEGORY_SEQUENCE,
    '3',
    3,
    FALSE,
    '/board/ps-code',
    'ps-code',
    NOW(),
    NOW()
);

INSERT INTO PAGE
VALUES (
    NEXT VALUE FOR PAGE_SEQUENCE,
    '4',
    'test page1',
    'test content1',
    NOW(),
    NOW()
);

INSERT INTO PAGE
VALUES (
    NEXT VALUE FOR PAGE_SEQUENCE,
    '4',
    'test page2',
    'test content2',
    NOW(),
    NOW()
);