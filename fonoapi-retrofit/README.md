# FonoApi Java Client

[ ![Download](https://api.bintray.com/packages/aafanasev/maven/fonoapi-retrofit/images/download.svg) ](https://bintray.com/aafanasev/maven/fonoapi-retrofit/_latestVersion)

## Usage

Java

```java
FonoApiService api = new FonoApiFactory().create();
        
api.getLatest("<token>", "samsung", 10).enqueue(new Callback<List<DeviceEntity>>() {

    @Override
    public void onResponse(Call<List<DeviceEntity>> call, Response<List<DeviceEntity>> response) {
        response.body().forEach(device -> {
            System.out.println(device.getDeviceName());
        });
    }

    @Override
    public void onFailure(Call<List<DeviceEntity>> call, Throwable t) {}

});
```

More samples in Kotlin and Java you can find [here](/sample/)

## Install

Maven

```xml
<dependency>
  <groupId>com.aafanasev</groupId>
  <artifactId>fonoapi-retrofit</artifactId>
  <version>1.0</version>
  <type>pom</type>
</dependency>
```

Gradle

```groovy
// add repository
repositories {
    maven {
        url 'https://dl.bintray.com/aafanasev/maven'
    }
}

// add dependency
compile 'com.aafanasev:fonoapi-retrofit:1.0'
```
