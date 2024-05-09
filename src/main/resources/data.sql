CREATE TABLE IF NOT EXISTS area_table (
    area_id SERIAL PRIMARY KEY,
    area_name VARCHAR(255) NOT NULL,
    area_code BIGINT,
    is_archive BOOLEAN
);