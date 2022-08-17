# linux安装docker
## centos 安装docker
```bash
# 设置存储库 (在新主机上首次安装 Docker Engine 之前，您需要设置 Docker 存储库。之后，您可以从存储库安装和更新 Docker。)
sudo yum install -y yum-utils
sudo yum-config-manager \
    --add-repo \
    https://download.docker.com/linux/centos/docker-ce.repo

# 安装Docker引擎
sudo yum install docker-ce docker-ce-cli containerd.io docker-compose-plugin

# 列出可用的 Docker Engine 版本
yum list docker-ce --showduplicates | sort -r

# 安装指定版本
# sudo yum install docker-ce-<VERSION_STRING> docker-ce-cli-<VERSION_STRING> containerd.io docker-compose-plugin
sudo yum install docker-ce-20.10.0 docker-ce-cli-20.10.0 containerd.io docker-compose-plugin

# 启动docker
sudo systemctl start docker

# 卸载docker
# 1. 卸载 Docker Engine、CLI、Containerd 和 Docker Compose 软件包：
sudo yum remove docker-ce docker-ce-cli containerd.io docker-compose-plugin
# 2. 主机上的映像、容器、卷或自定义配置文件不会自动删除。要删除所有映像、容器和卷：
sudo rm -rf /var/lib/docker
sudo rm -rf /var/lib/containerd
```

## mysql镜像安装
```bash
docker run -d --name shopping-data \
-p 3306:3306 \
# -v /Users/xiaoyang/Documents/volume-data/mysql-data:/var/lib/mysql \
-e MYSQL_ROOT_PASSWORD=123456 \
mysql:5.7
```

docker run -d --name shopping-data \
-p 3306:3306 \
-e MYSQL_ROOT_PASSWORD=123456 \
mysql:5.7