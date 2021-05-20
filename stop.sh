cd app && mvn clean && cd ..
docker stop app
docker rm app
docker rmi dac/app
docker stop banco
docker rm banco
docker rmi dac/banco