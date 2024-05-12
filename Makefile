run:
	mvn package
	java -jar target/RuralRegistry-1.0-SNAPSHOT.jar

run_docker:
	mvn package
	docker-compose up

stop_docker:
	docker-compose down --remove-orphans

clean_docker:
	docker images -q | xargs docker rmi
	mvn clean

test:
	mvn test


clean:
	mvn clean