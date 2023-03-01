DROP TABLE IF EXISTS student;


CREATE TABLE student
(
    id         BIGSERIAL PRIMARY KEY,
    name       VARCHAR(255),
    mark       REAL,

    created_at TIMESTAMP DEFAULT current_timestamp,
    updated_at TIMESTAMP DEFAULT current_timestamp
);