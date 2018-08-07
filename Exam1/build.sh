mvn clean
#mvn assembly:assembly
#cp  target/app-jar-with-dependencies.jar ../docker/java/app.jar
mvn package
cp target/app.jar ../docker/java/app.jar
docker-compose build
#docker-compose up -d
