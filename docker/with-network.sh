
# TERMINAL 1
docker network create -d "bridge" my-net

docker run  -it --name ub1 --network my-net ubuntu

# TERMINAL 2
docker run  -it --name ub2 --network my-net ubuntu
apt-get update
apt-get install -y iputils-ping
ping ub1