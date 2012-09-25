#!/bin/bash
BUKKIT=craftbukkit.jar
javac -classpath $BUKKIT org/hanford/minecraft/SignLogger.java && \
	rm -f SignLogger.jar && \
	jar cf SignLogger.jar plugin.yml org/hanford/minecraft/SignLogger.class
