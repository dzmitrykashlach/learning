docker run --name use-the-index --env POSTGRES_PASSWORD=root \
           --volume   postgres:/var/lib/postgresql/data \
           --publish 5432:5432 \
           --detach postgres

docker run --name use-the-index -e MYSQL_ROOT_PASSWORD=root --publish 3306:3306 --detach mysql