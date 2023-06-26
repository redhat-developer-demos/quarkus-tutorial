FROM quay.io/rhdevelopers/quarkus-maven-repo-cache as cachier


FROM quay.io/rhdevelopers/tutorial-tools:0.0.6 

COPY --from=cachier /work/m2repo $DEVELOPER_HOME/.m2/repository

RUN /usr/local/bin/run.sh 

CMD [ "mvn" ]