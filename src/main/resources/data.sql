INSERT INTO BANK (code, name, country, swift_code, is_active, created_at, updated_at)
VALUES
    ('AR-SANT', 'Banco Santander Argentina',     'AR', 'BSCHARBA', TRUE, NOW(), NOW()),
    ('AR-BNA',  'Banco de la Nación Argentina',  'AR', 'NACNARBA', TRUE, NOW(), NOW()),
    ('ES-SANT', 'Banco Santander España',        'ES', 'BSCHESMM', TRUE, NOW(), NOW()),
    ('BR-ITAU', 'Banco Itaú Unibanco',           'BR', 'ITAUBRSP', TRUE, NOW(), NOW()),
    ('US-CITI', 'Citibank N.A.',                 'US', 'CITIUS33', TRUE, NOW(), NOW());