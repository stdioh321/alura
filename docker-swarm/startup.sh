#!/bin/bash

# Course: https://www.alura.com.br/curso-online-docker-swarm-cluster-container

# Install Virtualbox
# https://www.virtualbox.org/wiki/Downloads

# Install Docker Machine
# https://docs.docker.com/machine/


docker-machine create -d virtualbox vm1
docker-machine create -d virtualbox vm2
docker-machine create -d virtualbox vm3

docker-machine ssh vm1
    docker swarm init --advertise-addr=[IP_VM]
    # Execute the following command and copy the output
    docker swarm join-token worker
    ctrl+d
docker-machine ssh vm2
    # Paste and execute the command you just copied, it will add this node as a worker
    ctrl+d
docker-machine ssh vm3
    # Paste and execute the command you just copied, it will add this node as a worker
    ctrl+d

docker-machine ssh vm1
    docker node ls
        # ID                            HOSTNAME            STATUS              AVAILABILITY        MANAGER STATUS      ENGINE VERSION
        # emtvvxrnzi9galr6yvvg705hd *   vm1                 Ready               Active              Reachable           19.03.12
        # keeucn0a3k3m1gbgs3ckqzj6i     vm2                 Ready               Active              Leader              19.03.12
        # 1azkz3wba5g83g8vvyont6bd0     vm3                 Ready               Active              Reachable           19.03.12
        # cr0wdre58t7ngcj7dslngzqy9     vm4                 Ready               Active                                  19.03.12
        # vxt80fp1i5mjawz78ery5543u     vm5                 Ready               Active                                  19.03.12
        # 9p2cfqrmp4o1hg3my3w1nkbgc     vm6                 Ready               Active                                  19.03.12
    docker service create --name nginx -p8081:80 --replicas 3 nginx

    docker service ls
        # ID                  NAME                MODE                REPLICAS            IMAGE                          PORTS
        # m8shikw1mp6g        barbearia           global              3/3                 aluracursos/barbearia:latest   *:80->3000/tcp
    docker service ps m8shikw1mp6g
    docker node inspect vm1
        # Get the ip
        #  "ManagerStatus": {
        #    "Reachability": "reachable",
        #    "Addr": "192.168.99.113:2377"
        # }


        # Open the ip on your browser or execute with curl
        curl 192.168.99.113:8081



