-- Check if user exists, create it if not
DO
$$
BEGIN
   IF NOT EXISTS (SELECT 1 FROM pg_roles WHERE rolname = 'audiobook_user') THEN
      CREATE USER audiobook_user WITH PASSWORD 'secretpassword';
END IF;
END
$$;

-- Check if database exists, create it if not
DO
$$
BEGIN
   IF NOT EXISTS (SELECT 1 FROM pg_database WHERE datname = 'audiobook_db') THEN
      CREATE DATABASE audiobook_db;
END IF;
END
$$;

-- Grant privileges
GRANT ALL PRIVILEGES ON DATABASE audiobook_db TO audiobook_user;
