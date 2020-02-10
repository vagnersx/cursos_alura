# cursos_alura


cd calculadora

javac src/Calculadora.java

cd calculadora/src
java Calculadora

javac -sourcepath src -d target src/Calculadora.java
javac -d target src/Calculadora.java

http://repo1.maven.org/maven2/com/thoughtworks/xstream/xstream-distribution/1.4.11.1/xstream-distribution-1.4.11.1-bin.zip

#class-path (cp) -sourcepath src/main
javac -sourcepath src/main -d target/main -cp lib/xstream-1.4.11.1.jar src/main/Calculadora.java


mvn archetype:generate -DartifactId=produtos -DgroupId=br.com.alura.maven -DinteractiveMode=false -DarchetypeArtifactId=maven-archetype-quickstart

mvn package

java -cp produtos-1.0-SNAPSHOT.jar br.com.alura.maven.App