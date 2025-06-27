CREATE TABLE item (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    quantity INTEGER,
    delivered BOOLEAN,
    delivery_id INTEGER,
    CONSTRAINT fk_delivery
        FOREIGN KEY (delivery_id)
        REFERENCES delivery(id)
        ON DELETE CASCADE
);