CREATE TABLE delivery (
    id SERIAL PRIMARY KEY,
    client_name VARCHAR(255),
    client_number VARCHAR(255),
    adress VARCHAR(255),
    status BOOLEAN
);
