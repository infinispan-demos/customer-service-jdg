# Infinispan (RDG) Demo of a Customer Cache

This repository contains an example of a microservice implemented in SpringBoot, that implements CRUD for a sample Customer class. It is built only to show how to use Infinispan/Red Hat DataGrid on some usual cases, like Spring Cache and JSR-107, and to show some configuration on remote/embedded way.

It is also meant to provide some guidance on how it can be used on Kubernetes/OpenShift.

## Components

This repo consists of three maven modules:

- customer-service-bom: module that provides the common object model for other modules
- customer-service-jdg: sample CRUD microservice
- customer-service-browser: sample REST browser for getting indexes and values from the indexes

## Initial set up

I need 