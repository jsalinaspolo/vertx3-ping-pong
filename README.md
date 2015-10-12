# Vertx3 ping-pong cluster example

## I've created 3 configurations to be able to test different configurations

1. Local (uses default-cluster.xml config multicast)
2. Development (uses cluster.xml overwriting only some properties)
3. Test (uses cluster.xml with all properties from default-cluster.xml and overwrite some of them)


## Build by environment

1. Local:
```mvn clean install -Plocal```

2. Dev:
```mvn clean install -Pdev```

3. Test:
```mvn clean install -Ptest```

## Upload jars to different machines

1. Copy pong/target/pong-1.0-SNAPSHOT-fat.jar in one machine
2. Copy ping/target/ping-1.0-SNAPSHOT-fat.jar in a different machine

## Run the jars

1. Pong:
```java -jar pong-1.0-SNAPSHOT-fat.jar -cluster -cluster-host 192.168.112.10```

2. Ping:
```java -jar ping-1.0-SNAPSHOT-fat.jar -cluster -cluster-host 192.168.112.9```

