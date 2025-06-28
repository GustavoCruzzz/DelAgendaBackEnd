CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE delivery(
   id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
   client_name VARCHAR(100),
   client_number BIGINT,
   address VARCHAR(250),
   status VARCHAR(30),
   date TIMESTAMP
);