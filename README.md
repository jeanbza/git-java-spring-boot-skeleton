# git-java-spring-boot-skeleton
Spring boot skeleton with thymeleaf and integration tests.

[![Build Status](https://travis-ci.org/jadekler/git-java-spring-boot-skeleton.svg?branch=master)](https://travis-ci.org/jadekler/git-java-spring-boot-skeleton)

## Installation and running

1. Install jdk8
1. `git clone https://github.com/jadekler/git-java-spring-boot-skeleton.git ~/workspace/git-java-spring-boot-skeleton`
1. `cd ~/workspace/git-java-spring-boot-skeleton`
1. `./gradlew bootRun`

## Running tests

1. [Install PhantomJS](http://phantomjs.org/download.html) (for headless browser testing)
    1. Download the [phantomjs binary](https://github.com/eugene1g/phantomjs/releases/tag/2.0.0-bin)
    1. `cp -r ~/Downloads/phantomjs ~/dev/` (or wherever you prefer)
    1. `echo "export PATH:$PATH:~/dev/phantomjs" >> ~/.bash_profile"`
    1. Ensure `which phantomjs` works

    OR

    1. Download the [phantomjs binary](https://github.com/eugene1g/phantomjs/releases/tag/2.0.0-bin)
    1. Alter `components/users/src/test/java/acceptance/fluentlenium/UsersTest.java` and directly point to your binary with
     `capabilities.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "/path/to/phantomjs");`
1. `./gradle test`