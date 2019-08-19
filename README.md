# gallery

## 프로젝트 요구사항

- spring boot
- mongoDB
- nodejs
- npm
- vue.js

## 로컬 환경 실행

1. 몽고 DB 실행

```bash
> cd src/docker
> pwd
/Users/ganghong-gu/Documents/study/gallery/src/docker
> ./mongo-run
c0b28ea19748
c0b28ea19748
2759e85381c3ef24891e8552c4ea5bcae41071b6ce0b35799b92f937151a9b7e


```


2. 스프링 어플리케이션 실행

```bash
...
2019-08-20 08:37:54.176  INFO 8292 --- [           main] org.mongodb.driver.cluster               : Cluster created with settings {hosts=[localhost:27017], mode=SINGLE, requiredClusterType=UNKNOWN, serverSelectionTimeout='30000 ms', maxWaitQueueSize=500}
2019-08-20 08:37:54.253  INFO 8292 --- [localhost:27017] org.mongodb.driver.connection            : Opened connection [connectionId{localValue:1, serverValue:1}] to localhost:27017
2019-08-20 08:37:54.257  INFO 8292 --- [localhost:27017] org.mongodb.driver.cluster               : Monitor thread successfully connected to server with description ServerDescription{address=localhost:27017, type=STANDALONE, state=CONNECTED, ok=true, version=ServerVersion{versionList=[4, 0, 11]}, minWireVersion=0, maxWireVersion=7, maxDocumentSize=16777216, logicalSessionTimeoutMinutes=30, roundTripTimeNanos=2821994}
2019-08-20 08:37:54.508  INFO 8292 --- [           main] o.s.s.concurrent.ThreadPoolTaskExecutor  : Initializing ExecutorService 'applicationTaskExecutor'
2019-08-20 08:37:54.584  WARN 8292 --- [           main] o.s.b.a.m.MustacheAutoConfiguration      : Cannot find template location: classpath:/static/ (please add some templates, check your Mustache configuration, or set spring.mustache.check-template-location=false)
2019-08-20 08:37:54.704  INFO 8292 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
2019-08-20 08:37:54.707  INFO 8292 --- [           main] com.guppy.gallery.GalleryApplication     : Started GalleryApplication in 2.272 seconds (JVM running for 2.917)

```


3. 프론트앤드 dev-server 실행

3.1 node 설치 (MAC OS)
```bash
> brew install nvm 
> mkdir ~/.nvm
> vim ~/.zshrc

export NVM_DIR="$HOME/.nvm"
[ -s "/usr/local/opt/nvm/nvm.sh" ] && . "/usr/local/opt/nvm/nvm.sh"  # This loads nvm
[ -s "/usr/local/opt/nvm/etc/bash_completion" ] && . "/usr/local/opt/nvm/etc/bash_completion"  # This loads nvm bash_completion
:wq!

> source ~/.zshrc
> nvm install --lts
Installing latest LTS version.
Downloading and installing node v10.16.3...
Downloading https://nodejs.org/dist/v10.16.3/node-v10.16.3-darwin-x64.tar.gz...
######################################################################## 100.0%
Computing checksum with shasum -a 256
Checksums matched!
Now using node v10.16.3 (npm v6.9.0)
Creating default alias: default -> lts/* (-> v10.16.3)

> nvm list
->     v10.16.3
         system
default -> lts/* (-> v10.16.3)
node -> stable (-> v10.16.3) (default)
stable -> 10.16 (-> v10.16.3) (default)
iojs -> N/A (default)
unstable -> N/A (default)

lts/* -> lts/dubnium (-> v10.16.3)
lts/argon -> v4.9.1 (-> N/A)
lts/boron -> v6.17.1 (-> N/A)
lts/carbon -> v8.16.1 (-> N/A)
lts/dubnium -> v10.16.3

> nvm use v10.16.3
Now using node v10.16.3 (npm v6.9.0)
```

3.2 Node Modules 의존성 설치
```bash
> cd src/front
> pwd
/Users/ganghong-gu/Documents/study/gallery/src/front
> npm install
```

3.3 webpack-dev-server 실행
```bash
> cd src/front
> pwd
/Users/ganghong-gu/Documents/study/gallery/src/front
> npm run serve

 DONE  Compiled successfully in 3081ms                                                                                                                                                             
  App running at:
  - Local:   http://localhost:8081/ 
  - Network: http://172.17.120.246:8081/

  Note that the development build is not optimized.
  To create a production build, run npm run build.
```

## 프로젝트 빌드

