#!/bin/bash


# Check if required environment variables are set
: "${DB_NAME:?Environment variable DB_NAME is required}"
: "${DB_USER:?Environment variable DB_USER is required}"
: "${DB_PASSWORD:?Environment variable DB_PASSWORD is required}"

# Generate the SQL file using environment variables
echo "Initializing the database with the following details:"
echo "Database Name: $DB_NAME"
echo "User: $DB_USER"
echo "Password: $DB_PASSWORD"

cat << EOF > /tmp/init-db.sql
CREATE DATABASE IF NOT EXISTS \`$DB_NAME\`;
CREATE USER IF NOT EXISTS '$DB_USER'@'%' IDENTIFIED BY '$DB_PASSWORD';
GRANT ALL PRIVILEGES ON \`$DB_NAME\`.* TO '$DB_USER'@'%';
FLUSH PRIVILEGES;
EOF

mariadb -uroot -p$MARIADB_ROOT_PASSWORD < /tmp/init-db.sql