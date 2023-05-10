# ERANYACLOUD TEST
## Install Docker & Database
Recommended for using PC with Linux Environment

``` sudo apt install docker docker-compose ```

Check Version docker & docker-compose

``` docker -v ```

``` docker-compose -v ```

Fill or change variable on the application.properties

**Build Database**

``` sudo docker-compose -f docker-compose-mysql.yml up --build ```

Check if it can be connected from an external application

**Build and Detach**

``` sudo docker-compose -f docker-compose-mysql.yml up --build -d ```

## install JDK
download [oracle java](https://www.oracle.com/java/technologies/downloads/)
```sh
sudo apt install ~/Downloads/jdk-20_linux-x64_bin.deb
sudo update-alternatives --install /usr/bin/java java /usr/lib/jvm/jdk-20/bin/java 1
sudo update-alternatives --install /usr/bin/javac javac /usr/lib/jvm/jdk-20/bin/javac 1
sudo update-alternatives --install /usr/bin/jar jar /usr/lib/jvm/jdk-20/bin/jar 1
sudo update-alternatives --install /usr/bin/jar jar /usr/lib/jvm/jdk-20/bin/jarsigner 1
sudo update-alternatives --install /usr/bin/jar jar /usr/lib/jvm/jdk-20/bin/jlink 1
sudo update-alternatives --install /usr/bin/jar jar /usr/lib/jvm/jdk-20/bin/javadoc 1
sudo update-alternatives --config java
sudo update-alternatives --config javac
sudo update-alternatives --config jar
export JAVA_HOME=/usr/lib/jvm/jdk-20
```
## build project
```sh
./mvnw package
java -jar target/demo-0.0.1-SNAPSHOT.jar
```

## Postman API TEST

You can import collection from _postman_ folder 


