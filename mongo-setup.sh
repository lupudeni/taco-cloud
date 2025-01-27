#!/bin/bash

# Step 1: Pull MongoDB Docker image
echo "Pulling MongoDB Docker image..."
docker pull mongo:latest

# Step 2: Run MongoDB container with a custom name
echo "Starting MongoDB container..."
docker run -d --name my-mongo -p 27017:27017 mongo:latest

# Step 3: Wait for MongoDB to fully start up
echo "Waiting for MongoDB to start..."
sleep 10

echo "MongoDB container is up and running."
