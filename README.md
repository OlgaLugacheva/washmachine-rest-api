# washmachine-rest-api

data source  is located in directory washing-service/src/main/java/los/washmachine 
use pom.xml in washmachine-rest-api/washing-service/ for building
after run (e.g. by tomcat7) you will be redirected to http://localhost:8080/#/viewPrograms 
you also can see  samples of using by queries in tests: washmachine-rest-api/washing-service/src/test/java/
sample curl 
curl -X POST \
  http://localhost:8080/api/wash/ \
  -H 'Content-Type: application/json' \
  -d '{"name":"Gentle","wheels":"1000","temperature":"60"}'
