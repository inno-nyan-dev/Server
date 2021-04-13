FROM ubuntu:xenial
MAINTAINER you [your@email.com]
ARG VERSION=latest
LABEL version=$VERSION

RUN echo "version:" $VERSION

RUN apt-get update && apt-get install -y --no-install-recommends \
    software-properties-common \
    python-software-properties \
  && add-apt-repository ppa:webupd8team/java \
  && (echo debconf shared/accepted-oracle-license-controllers.v1-1 select true | debconf-set-selections) \
  && apt-get update && apt-get install -y --no-install-recommends \
     openjdk-8-jre-headless \
  && (echo "JAVA_HOME=/usr/lib/jvm/java-8-oracle" >> /etc/environment) \
  && (echo "JRE_HOME=/usr/lib/jvm/java-8-oracle/jre" >> /etc/environment) \
  && (apt-get install  -y --no-install-recommends nginx) \
  && mkdir -p /opt/dauth

ENV LANG=C.UTF-8
WORKDIR "/opt/dauth"
COPY rabbit_backend-$VERSION.jar /opt/dauth/server.jar

#don't forget to fix permissions
#VOLUME ["/home/backend/images/"]

EXPOSE 8080
EXPOSE 80

#Limit heap size, 'cause java love to eat all it can grab to
ENTRYPOINT ["java", "-Xmx150m", "-jar", "server.jar"]
#Default config. Ctually it's harcoded
#CMD ["/etc/dauth/config.conf"]
