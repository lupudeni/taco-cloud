#!/bin/bash

# Define Cassandra Docker container name and network
CONTAINER_NAME="my-cassandra"
NETWORK_NAME="cassandra-net"
KEYSPACE_NAME="tacocloud"
SCHEMA_ACTION="recreate"  # Options: recreate, update, or none
LOCAL_DATACENTER="datacenter1"
TIMEOUT="10s"

# Create a Docker network (if it doesn't exist)
echo "Creating Docker network: $NETWORK_NAME"
docker network create $NETWORK_NAME

# Run Cassandra container
echo "Running Cassandra container: $CONTAINER_NAME"
docker run --name $CONTAINER_NAME \
  --network $NETWORK_NAME \
  -p 9042:9042 \
  -d cassandra:latest

# Wait for Cassandra to initialize
echo "Waiting for Cassandra to initialize..."
sleep 30  # You may want to adjust the sleep time based on your environment

# Connect to Cassandra and configure the keyspace and schema action
echo "Configuring keyspace and schema settings..."

# Create the keyspace and set schema action
docker exec -it $CONTAINER_NAME cqlsh -e "
  CREATE KEYSPACE IF NOT EXISTS $KEYSPACE_NAME
  WITH replication = {'class': 'SimpleStrategy', 'replication_factor': 1};
  USE $KEYSPACE_NAME;

  # Schema action: Recreate or Update based on YAML
  -- Drop and recreate tables if schema-action is 'recreate'
  IF '$SCHEMA_ACTION' = 'recreate' THEN
    TRUNCATE all; -- This could be expanded with actual drop/create logic for tables
  END IF;
"

# Adjust the request timeout using CQL command
echo "Setting request timeout to $TIMEOUT"
docker exec -it $CONTAINER_NAME cqlsh -e "
  ALTER SYSTEM SET request_timeout = '$TIMEOUT';
"

# Show the status of Cassandra container
docker ps

# Connect to Cassandra using cqlsh (Cassandra's CLI)
echo "Connecting to Cassandra using cqlsh..."
docker exec -it $CONTAINER_NAME cqlsh
