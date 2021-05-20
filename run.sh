cd app && mvn clean package && cd ..
docker build -t dac/banco ./postgres
docker build -t dac/app ./app
docker run -p 5433:5432 --name banco -d dac/banco
docker run -p 8081:8080 --name app --link banco:host-banco dac/app