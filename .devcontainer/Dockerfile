FROM quay.io/rhdevelopers/quarkus-maven-repo-cache:0.21.2 as cachier


FROM quay.io/rhdevelopers/tutorial-tools:0.0.1 

USER developer

COPY --from=cachier /data/m2/repository/ $DEVELOPER_HOME/.m2/repository

RUN /usr/local/bin/run.sh 

CMD [ "mvn" ]