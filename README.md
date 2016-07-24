# Kotlin Extensions for Android

[![CircleCI](https://circleci.com/gh/jmatsu/android-extensions/tree/master.svg?style=svg)](https://circleci.com/gh/jmatsu/android-extensions/tree/master)

## Usage

See [samples](https://github.com/jmatsu/android-extensions/blob/master/sample/src/main/kotlin/com/fatdaruma/extensionsample/MainFragment.kt).

*From Java*, you can use this as utilities.  
If `FooExtensions` exists, *Java* treats it as `FooUtils`.

## Existing extensions

+ Bundle extensions. : Some operators will be added to Bundle.
+ Fragment extensions. : Easy to manage arguments.
+ View extensions. : Safe cast without specifying type

## Download

To add this to your project, append the following to your `build.gradle`

```groovy
repositories {
    maven { url 'https://jitpack.io' }
}
```

```groovy
dependencies {
  compile 'com.github.jmatsu:android-extensions:${version}'
}
```

## License

```

 Copyright 2016 Jumpei Matsuda

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.

```
