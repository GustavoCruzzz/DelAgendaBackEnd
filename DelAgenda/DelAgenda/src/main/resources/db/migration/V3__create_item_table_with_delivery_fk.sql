CREATE TABLE item (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    quantity INTEGER NOT NULL,
    delivered BOOLEAN NOT NULL DEFAULT false,
    delivery_id INTEGER NOT NULL,

    CONSTRAINT fk_item_delivery
        FOREIGN KEY (delivery_id)
        REFERENCES delivery(id)
        ON DELETE CASCADE
);