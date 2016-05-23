#!/bin/bash
kill $(pgrep -f "/usr/bin/java -classpath /usr/share/maven/boot/plexus-classworlds-2.x.jar -Dclassworlds")

mvn exec:java -Dexec.mainClass="server.ServerExecutor" > output.txt &