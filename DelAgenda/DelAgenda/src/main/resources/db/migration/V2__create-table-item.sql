CREATE TABLE item(
   id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
   name VARCHAR(100),
   quantity BIGINT,
   delivered BOOLEAN NOT NULL,
   delivery_id UUID,
   FOREIGN KEY (delivery_id) REFERENCES delivery(id) ON DELETE CASCADE
);