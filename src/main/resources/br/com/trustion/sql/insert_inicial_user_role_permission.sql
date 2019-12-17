-- BCrypt
-- User: admin_trustion
-- Password: Trustion@admin2019 ($2a$10$G0IAaWpBN2n9upK/6o1E..oav9mgfqsAv/myQMUhFIoLuuz6gcsqW)

-- User: bpo_trustion
-- Password: Trustion@bpo2019 ($2a$10$XT4lNjHMmaYHC/8yZG3W1e0/Slxl7Yf21mES9z.6/SomgEKvhHUG.)

-- User: aux
-- Password: 1234 ($2a$10$Ui91L7As0DQzgHiYwTsmv.BrnF9iBY2N3qPpbf/vR6cDAXUPAlqOK)



-- Role
INSERT INTO sch_superdigital.tbl_role (role_id, "name") VALUES(1, 'ADMIN');
INSERT INTO sch_superdigital.tbl_role (role_id, "name") VALUES(2, 'BPO');
INSERT INTO sch_superdigital.tbl_role (role_id, "name") VALUES(3, 'AUX');



-- Permission
INSERT INTO sch_superdigital.tbl_permission (permission_id, "name") VALUES(1, 'user_create');
INSERT INTO sch_superdigital.tbl_permission (permission_id, "name") VALUES(2, 'user_read');
INSERT INTO sch_superdigital.tbl_permission (permission_id, "name") VALUES(3, 'user_update');
INSERT INTO sch_superdigital.tbl_permission (permission_id, "name") VALUES(4, 'user_delete');
INSERT INTO sch_superdigital.tbl_permission (permission_id, "name") VALUES(5, 'abcd');
INSERT INTO sch_superdigital.tbl_permission (permission_id, "name") VALUES(6, 'efgh');



-- Role + Permission
INSERT INTO sch_superdigital.tbl_role_permissions (role_id, permission_id) VALUES(1, 1);
INSERT INTO sch_superdigital.tbl_role_permissions (role_id, permission_id) VALUES(1, 2);
INSERT INTO sch_superdigital.tbl_role_permissions (role_id, permission_id) VALUES(1, 3);
INSERT INTO sch_superdigital.tbl_role_permissions (role_id, permission_id) VALUES(1, 4);
INSERT INTO sch_superdigital.tbl_role_permissions (role_id, permission_id) VALUES(2, 2);
INSERT INTO sch_superdigital.tbl_role_permissions (role_id, permission_id) values(2, 3);
INSERT INTO sch_superdigital.tbl_role_permissions (role_id, permission_id) VALUES(3, 5);
INSERT INTO sch_superdigital.tbl_role_permissions (role_id, permission_id) values(3, 6);



-- Company
INSERT INTO sch_superdigital.tbl_company
(company_id, cnpj, address, city, complement, neighbourhood, number_address, 
state, zip_code, corporate_name, date_create, market_segment, register_status)
VALUES(1, '26.649.086/0001-71', 'Rua José Guilherme Pagnani', 'Suzano', 'Ap 108 Bl 05',
'Vila Figueira', '809', 'São Paulo', '02476200', 'Gambiarra Company LTDA', '2014-08-20', 'Vendas Online', true);

INSERT INTO sch_superdigital.tbl_company
(company_id, cnpj, address, city, complement, neighbourhood, number_address, 
state, zip_code, corporate_name, date_create, market_segment, register_status)
VALUES(2, '45.649.075/0001-v1', 'Rua Nao Sei', 'Mogi das Cruzes', '',
'Vila Morim', '1101', 'São Paulo', '12676200', 'Somos Juntos LTDA', '2015-08-20', 'Mercado Online', true);

INSERT INTO sch_superdigital.tbl_company
(company_id, cnpj, address, city, complement, neighbourhood, number_address, 
state, zip_code, corporate_name, date_create, market_segment, register_status)
VALUES(3, '44.444.086/0003-71', 'Av. Almeida Lima', 'Timbaia', 'prox ao mercado',
'Jupitrans', '4433', 'Rio de Janeiro', '14576200', 'Praia Love S/A', '2010-08-20', 'Mercadinho', true);



-- User
INSERT INTO sch_superdigital.tbl_user
(user_id, cell_phone_number, email, phone_number, 
date_inclusion, login, "name", password_user, register_status, uuid, company_id)
VALUES(1, '1147474848', 'admin@trustion.com.br', '11988115473', 
'2019-11-25', 'admin_trustion', 'Trustion Administrador', 
'$2a$10$G0IAaWpBN2n9upK/6o1E..oav9mgfqsAv/myQMUhFIoLuuz6gcsqW', true, '85205603-3f7a-4b64-b1e2-b34e1774a52e', 1);

INSERT INTO sch_superdigital.tbl_user
(user_id, cell_phone_number, email, phone_number, 
date_inclusion, login, "name", password_user, register_status, uuid, company_id)
VALUES(2, '1147474848', 'bpo@trustion.com.br', '11934345656', 
'2019-11-24', 'bpo_trustion', 'Trustion BPO', 
'$2a$10$XT4lNjHMmaYHC/8yZG3W1e0/Slxl7Yf21mES9z.6/SomgEKvhHUG.', true, 'de499c3b-12ca-432f-a849-960dd9d5889d', 2);

INSERT INTO sch_superdigital.tbl_user
(user_id, cell_phone_number, email, phone_number, 
date_inclusion, login, "name", password_user, register_status, uuid, company_id)
VALUES(3, '1190909090', 'aux@trustion.com.br', '11901010101', 
'2019-11-23', 'aux', 'Teste Test', 
'$2a$10$Ui91L7As0DQzgHiYwTsmv.BrnF9iBY2N3qPpbf/vR6cDAXUPAlqOK', true, 'd91f4088-db3a-4346-a692-f3e4828aff2e', 3);

INSERT INTO sch_superdigital.tbl_user
(user_id, cell_phone_number, email, phone_number, 
date_inclusion, login, "name", password_user, register_status, uuid, company_id)
VALUES(4, '1111111111', 'teste2@trustion.com.br', '1199990000', 
'2019-11-23', 'test', 'Teste2 Test', 
'$2a$10$Ui91L7As0DQzgHiYwTsmv.BrnF9iBY2N3qPpbf/vR6cDAXUPAlqOK', true, '5412f8e0-09fc-4dba-bc89-11b2598dffdc', 3);



-- User + Role
INSERT INTO sch_superdigital.tbl_user_roles (user_id, role_id) VALUES(1, 1);
INSERT INTO sch_superdigital.tbl_user_roles (user_id, role_id) VALUES(2, 2);
INSERT INTO sch_superdigital.tbl_user_roles (user_id, role_id) VALUES(3, 3);
INSERT INTO sch_superdigital.tbl_user_roles (user_id, role_id) VALUES(4, 3);

