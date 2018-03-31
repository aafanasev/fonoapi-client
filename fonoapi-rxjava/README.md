# FonoApi RxJava Client

[ ![Download](https://api.bintray.com/packages/aafanasev/maven/fonoapi-rxjava/images/download.svg) ](https://bintray.com/aafanasev/maven/fonoapi-rxjava/_latestVersion)

## Usage

Kotlin

```kotlin
val fonoApi = ReactiveFonoApiFactory().create()

fonoApi.getDevice("<token>", "pixel").subscribe { devices ->
    devices.forEach {
        println(it.deviceName)
    }
}
```

More samples in Kotlin and Java you can find [here](/sample/)

## Install

Maven

```xml
<dependency>
  <groupId>com.aafanasev</groupId>
  <artifactId>fonoapi-rxjava</artifactId>
  <version>1.0</version>
  <type>pom</type>
</dependency>
```

Gradle

```groovy
compile 'com.aafanasev:fonoapi-rxjava:1.0'
```
