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

The MIT License (MIT)

Copyright (c) 2016 Jumpei Matsuda

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.

```
