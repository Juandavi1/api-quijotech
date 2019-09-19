#!/bin/bash
mvn clean package
docker build -t sumasaas/api:1.0 -f .docker/Dockerfile .