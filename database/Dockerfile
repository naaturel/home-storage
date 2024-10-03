FROM mariadb:latest

COPY ./init.sh /docker-entrypoint-initdb.d/

RUN chmod -R 755 /docker-entrypoint-initdb.d/ && \
    chmod +x /docker-entrypoint-initdb.d/init.sh